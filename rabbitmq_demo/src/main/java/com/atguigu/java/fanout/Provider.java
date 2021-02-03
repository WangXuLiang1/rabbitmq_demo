package com.atguigu.java.fanout;

import com.atguigu.java.untils.RabbitmqUntil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

public class Provider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitmqUntil.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("fanout_exchange","fanout");
        channel.basicPublish("fanout_exchange","",null,"fanout模型生产者发送消息".getBytes());
        RabbitmqUntil.release(channel,connection);
    }
}
