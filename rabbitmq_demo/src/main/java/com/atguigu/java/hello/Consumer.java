package com.atguigu.java.hello;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setVirtualHost("/mes");
        connectionFactory.setPort(5672);
        connectionFactory.setPassword("atguigu");
        connectionFactory.setUsername("atguigu");
        connectionFactory.setHost("192.168.214.130");
        Connection connection = connectionFactory.newConnection();

        Channel channel = connection.createChannel();
        channel.queueDeclare("hello", true, false, false, null);
        channel.basicConsume("hello", true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者消费消息：" + new String(body));
            }
        });
    }

}
