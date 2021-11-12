package com.rabbitmq.demo.lagou.persistent;

import com.rabbitmq.client.*;

/**
 * @author Jie Zhao
 * @date 2021/11/12 9:05
 */
public class MessagePersistent {

    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setUri("amqp://admin:admin@192.168.159.135:5672/admin");

        final Connection connection = connectionFactory.newConnection();
        final Channel channel = connection.createChannel();

        // 声明持久化消息队列
        channel.queueDeclare("queue.persistent", true, false, true, null);
        // 声明持久化交换机
        channel.exchangeDeclare("ex.persistent", BuiltinExchangeType.DIRECT, true, false, null);
        // 队列绑定到交换机上
        channel.queueBind("queue.persistent", "ex.persistent", "rk.persistent");


        AMQP.BasicProperties basicProperties = new AMQP.BasicProperties().builder()
                .deliveryMode(2) // 表示发送的是持久化消息
                .build();
        channel.basicPublish("ex.biz",
                "rk.biz",
                null,
                "Hello World!!!".getBytes("utf-8"));

        channel.close();
        connection.close();
    }
}
