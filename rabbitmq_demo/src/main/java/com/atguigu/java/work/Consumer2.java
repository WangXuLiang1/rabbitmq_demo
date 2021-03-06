package com.atguigu.java.work;


import com.atguigu.java.untils.RabbitmqUntil;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer2 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitmqUntil.getConnection();
        Channel channel = connection.createChannel();
        channel.basicQos(1);
        channel.queueDeclare("work",true,false,false,null);
        channel.basicConsume("work",false,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("message2:"+new String(body));
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        });

    }
}
