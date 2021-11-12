package com.rabbitmq.demo.lagou.dl;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * 死信队列示例
 * @author Jie Zhao
 * @date 2021/11/12 11:06
 */
public class DeadLetter {

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            // 定义一个死信交换器（也是一个普通的交换器）
            channel.exchangeDeclare("exchange.dlx", "direct", true);
            // 定义一个正常业务的交换器
            channel.exchangeDeclare("exchange.biz", "fanout", true);
            Map<String, Object> arguments = new HashMap<>();
            // 设置队列TTL
            arguments.put("x-message-ttl", 10000);
            // 设置该队列所关联的死信交换器（当队列消息TTL到期后依然没有消费，则加入死信队列）
            arguments.put("x-dead-letter-exchange", "exchange.dlx");
            // 设置该队列所关联的死信交换器的routingKey，如果没有特殊指定，使用原队列的routingKey
            arguments.put("x-dead-letter-routing-key", "routing.key.dlx.test");
            channel.queueDeclare("queue.biz", true, false, false, arguments);
            channel.queueBind("queue.biz", "exchange.biz", "");
            channel.queueDeclare("queue.dlx", true, false, false, null);
            // 死信队列和死信交换器
            channel.queueBind("queue.dlx", "exchange.dlx", "routing.key.dlx.test");
            channel.basicPublish("exchange.biz", "",
                    MessageProperties.PERSISTENT_TEXT_PLAIN,
                    "dlx.test".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
