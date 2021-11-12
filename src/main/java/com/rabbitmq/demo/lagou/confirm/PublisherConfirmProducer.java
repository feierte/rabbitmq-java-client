package com.rabbitmq.demo.lagou.confirm;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 生产者发送消息确认示例
 * @author Jie Zhao
 * @date 2021/11/11 16:45
 */
public class PublisherConfirmProducer {

    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setUri("amqp://admin:admin@192.168.159.135:5672/admin");

        final Connection connection = connectionFactory.newConnection();
        final Channel channel = connection.createChannel();

        AMQP.Confirm.SelectOk selectOk = channel.confirmSelect();

        // 声明消息队列
        channel.queueDeclare("queue.biz", false, false, true, null);
        // 声明交换机
        channel.exchangeDeclare("ex.biz", BuiltinExchangeType.DIRECT, false, false, null);
        // 队列绑定到交换机上
        channel.queueBind("queue.biz", "ex.biz", "rk.biz");

        // confirmMessage(channel);
        // batchConfirmMessage(channel);
        batchAsyncConfirmMessage(channel);
        TimeUnit.SECONDS.sleep(2);


        channel.close();
        connection.close();
    }


    public static void confirmMessage(Channel channel) throws IOException {
            channel.basicPublish("ex.biz",
                    "rk.biz",
                    null,
                    ("Hello World!!!").getBytes("utf-8"));

            doConfirm(channel);
    }


    /**
     * 发送端批量确认
     * @param channel
     * @throws IOException
     */
    public static void batchConfirmMessage(Channel channel) throws IOException {
        int batchSize = 10;
        int outStandingConfirms = 0;

        for (int i = 0; i < 102; i++) {
            channel.basicPublish("ex.biz",
                    "rk.biz",
                    null,
                    ("Hello World!!! " + i).getBytes("utf-8"));
            outStandingConfirms++;
            if (outStandingConfirms == batchSize) {
                doConfirm(channel);
                outStandingConfirms = 0;
            }
        }

        if (outStandingConfirms > 0) {
            doConfirm(channel);
        }
    }


    public static void batchAsyncConfirmMessage(Channel channel) throws IOException {

        final ConcurrentNavigableMap<Long, String> outstandingConfirmsMap = new ConcurrentSkipListMap<>();

        ConfirmCallback clearOutstandingConfirms = (deliveryTag, multiple) -> {
            if (multiple) {
                System.out.println("编号小于" + deliveryTag + "的消息都已经被确认了");
                ConcurrentNavigableMap<Long, String> headMap = outstandingConfirmsMap.headMap(deliveryTag, true);
                headMap.clear();

            } else {
                outstandingConfirmsMap.remove(deliveryTag);
                System.out.println("编号为" + deliveryTag + "的消息被确认了");
            }
        };
        channel.addConfirmListener(clearOutstandingConfirms, (deliveryTag, multiple) -> {
            if (multiple) {
                // 将没有确认的消息记录到一个集合中
                // 此处省略实现
                System.out.println("编号小于" + deliveryTag + "的消息都没被确认了");
            } else {
                outstandingConfirmsMap.remove(deliveryTag);
                System.out.println("编号为" + deliveryTag + "的消息没被确认了");
            }
        });

        for (int i = 0; i < 1002; i++) {
            String message = "Hello World!!! " + i;
            // 获取下一条即将发送的消息ID
            long nextPublishSeqNo = channel.getNextPublishSeqNo();

            channel.basicPublish("ex.biz",
                    "rk.biz",
                    null,
                    message.getBytes("utf-8"));

            outstandingConfirmsMap.put(nextPublishSeqNo, message);
        }
    }

    public static void doConfirm(Channel channel) {
        try {
            // 同步的方式等待RabbitMQ的消息确认
            channel.waitForConfirmsOrDie(5_000);
            System.out.println("消息被确认了");
        } catch (IOException e) {
            System.out.println("消息被拒收");
        } catch (InterruptedException e) {
            System.out.println("发送消息通道不是需要消息confirm的通道");
        } catch (TimeoutException e) {
            System.out.println("等待消息确认超时");
        }

    }


}
