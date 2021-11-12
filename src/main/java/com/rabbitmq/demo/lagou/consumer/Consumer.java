package com.rabbitmq.demo.lagou.consumer;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Jie Zhao
 * @date 2021/11/10 20:43
 */
public class Consumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.159.135");
        connectionFactory.setVirtualHost("admin");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setPort(5672);

        // 与 RabbitMQ 服务器，建立 TCP 连接
        Connection connection = connectionFactory.newConnection();

        // 获取通道
        Channel channel = connection.createChannel();
        channel.basicConsume("queue.biz", true, new com.rabbitmq.client.Consumer() {
            @Override
            public void handleConsumeOk(String consumerTag) {

            }

            @Override
            public void handleCancelOk(String consumerTag) {

            }

            @Override
            public void handleCancel(String consumerTag) throws IOException {

            }

            @Override
            public void handleShutdownSignal(String consumerTag, ShutdownSignalException sig) {

            }

            @Override
            public void handleRecoverOk(String consumerTag) {

            }

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body);
                System.out.println("接收到消息：" + message);
            }
        });

        channel.close();
        connection.close();
    }
}
