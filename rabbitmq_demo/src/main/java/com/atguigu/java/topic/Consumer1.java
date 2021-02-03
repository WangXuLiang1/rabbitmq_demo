package com.atguigu.java.topic;

import com.atguigu.java.untils.RabbitmqUntil;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer1 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitmqUntil.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("topic_exchange","topic");
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName,"topic_exchange","atguigu.*");
        channel.basicConsume(queueName,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者1："+new String(body));
            }
        });
    }
}
