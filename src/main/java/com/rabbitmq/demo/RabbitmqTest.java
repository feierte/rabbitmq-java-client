package com.rabbitmq.demo;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Jie Zhao
 * @date 2021/11/10 13:32
 */
public class RabbitmqTest {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.159.135");
        connectionFactory.setVirtualHost("admin");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setPort(5672);

        connectionFactory.setAutomaticRecoveryEnabled(false);

        // 与 RabbitMQ 服务器，建立 TCP 连接
        Connection connection = connectionFactory.newConnection();

        // 获取通道
        Channel channel = connection.createChannel();

        // 声明消息队列
        channel.queueDeclare("queue.biz", false, false, true, null);
        // 声明交换机
        channel.exchangeDeclare("ex.biz", BuiltinExchangeType.DIRECT, false, false, null);
        // 队列绑定到交换机上
        channel.queueBind("queue.biz", "ex.biz", "rk.biz");

        for (int i = 0; i < 15; i++) {
            channel.basicPublish("ex.biz",
                    "rk.biz",
                    null,
                    ("工作队列" + i).getBytes("utf-8"));
        }


        channel.close();
        connection.close();
    }
}
