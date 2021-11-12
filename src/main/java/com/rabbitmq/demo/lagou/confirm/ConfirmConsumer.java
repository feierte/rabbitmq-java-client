package com.rabbitmq.demo.lagou.confirm;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 消费端消息确认示例
 * @author Jie Zhao
 * @date 2021/11/12 9:15
 */
public class ConfirmConsumer {

    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setUri("amqp://admin:admin@192.168.159.135:5672/admin");

        final Connection connection = connectionFactory.newConnection();
        final Channel channel = connection.createChannel();

        channel.queueDeclare("queue.ca", false, false, false, null);
        /*channel.exchangeDeclare("exchange.ca", BuiltinExchangeType.DIRECT, false, false, null);
        channel.queueBind("queue.ca", "exchange.ca", "rk.ca");*/

        // 自动确认消息设置为false，使用手动确认消息
        channel.basicConsume("queue.ca", false, "myConsumer", new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("接收消息：" + new String(body));

                // 确认消息
                // channel.basicAck(envelope.getDeliveryTag(), false);
                // 第一个参数是消息的标签，第二个参数表示不确认多个消息还是第一个消息
                // 第三个参数表示不确认的消息是否需要重新入队，然后重发
                // 可以用于拒收多条消息
                // channel.basicNack(envelope.getDeliveryTag(), false, true);
                // 用于拒收一条消息
                // 对于不确认的消息，是否重新入队，然后重发
                channel.basicReject(envelope.getDeliveryTag(), true);
            }
        });

        channel.close();
        connection.close();
    }
}
