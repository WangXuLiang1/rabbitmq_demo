package com.atguigu.java.topic;

import com.atguigu.java.untils.RabbitmqUntil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

public class Provider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitmqUntil.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("topic_exchange","topic");
        channel.basicPublish("topic_exchange","atguigu.wang.xu",null,"我是topic动态路由".getBytes());
        RabbitmqUntil.release(channel,connection);
    }
}
