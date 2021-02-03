package com.atguigu.java.work;

import com.atguigu.java.untils.RabbitmqUntil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;


import java.io.IOException;

public class Provider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitmqUntil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("work",true,false,false,null);
        for (int i = 0; i < 1000; i++) {
            channel.basicPublish("","work",null,("我是work模型生产者"+i).getBytes());
        }
        RabbitmqUntil.release(channel,connection);

    }
}
