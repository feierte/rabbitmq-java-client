package com.rabbitmq.demo.lagou.ttl;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @author Jie Zhao
 * @date 2021/11/12 10:51
 */
public class TTLProducer {

    private final static String QUEUE_NAME = "queue.ttl";

    public static void main(String[] args) {

        ConnectionFactory factory = new ConnectionFactory();

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            // 创建队列（实际上使用的是AMQP default这个direct类型的交换器）
            // 设置队列属性
            Map<String, Object> arguments = new HashMap<>();
            // 设置消息队列中消息的TTL
            arguments.put("x-message-ttl", 30000);
            // 设置队列的空闲存活时间（如该队列根本没有消费者，一直没有使用，队列可以存活多久）
            arguments.put("x-expires", 10000);
            channel.queueDeclare(QUEUE_NAME, false, false, false, arguments);
            for (int i = 0; i < 1000000; i++) {
                String message = "Hello World!" + i;
                channel.basicPublish(
                        "",
                        QUEUE_NAME,
                        new AMQP.BasicProperties().builder()
                                .expiration("30000") // 设置消息的超时时间
                                .build(),
                        message.getBytes()
                );
                System.out.println(" [X] Sent '" + message + "'");
            }
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
