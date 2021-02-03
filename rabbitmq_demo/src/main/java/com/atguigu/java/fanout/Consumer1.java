package com.atguigu.java.fanout;

import com.atguigu.java.untils.RabbitmqUntil;
import com.rabbitmq.client.*;
import com.rabbitmq.tools.json.JSONUtil;

import java.io.IOException;

public class Consumer1 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitmqUntil.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("fanout_exchange","fanout");
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName,"fanout_exchange","");
        channel.basicConsume(queueName,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者1消费消息："+new String(body));
            }
        });
    }
}
