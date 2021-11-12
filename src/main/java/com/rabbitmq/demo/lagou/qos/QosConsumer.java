package com.rabbitmq.demo.lagou.qos;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * 消费端限流示例
 * @author Jie Zhao
 * @date 2021/11/12 10:07
 */
public class QosConsumer {

    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setUri("amqp://admin:admin@192.168.159.135:5672/admin");

        final Connection connection = connectionFactory.newConnection();
        final Channel channel = connection.createChannel();

        channel.queueDeclare("queue.qos", false, false, false, null);
        // 使用Qos做消费端限流，仅对推模式起作用

        // 表示qos是10个消息，最多有10个消息等待确认
        channel.basicQos(10);
        // 表示qos是10个消息等待确认。如果global设置为true，则表示只要是使用当前的channel的consumer，该设置都生效。
        // false表示仅限于当前Consumer
        channel.basicQos(10, false);
        // 第一个参数表示未确认消息的大小，RabbitMQ暂时还没有实现。
        channel.basicQos(1000, 10, true);

        channel.basicConsume("queue.ca", false, "myConsumer", new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("接收消息：" + new String(body));
                // 批量消息确认，减少每个消息都发生确认带来的网络流量负载
                channel.basicAck(envelope.getDeliveryTag(), true);
            }
        });
        channel.close();
        connection.close();
    }
}
