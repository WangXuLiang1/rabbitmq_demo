package com.atguigu.java.direct;

import com.atguigu.java.untils.RabbitmqUntil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

public class Provider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitmqUntil.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("direct_exchange","direct");
        channel.basicPublish("direct_exchange","error",null,"我是direct静态路由".getBytes());
        RabbitmqUntil.release(channel,connection);
    }
}
