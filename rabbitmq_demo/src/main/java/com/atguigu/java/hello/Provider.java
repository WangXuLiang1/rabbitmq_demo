package com.atguigu.java.hello;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Provider {
    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.214.130");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("atguigu");
        connectionFactory.setPassword("atguigu");
        connectionFactory.setVirtualHost("/mes");
        Connection connection = connectionFactory.newConnection();
        //获得通道
        Channel channel = connection.createChannel();
        channel.queueDeclare("hello",true,false,false,null);
        channel.basicPublish("","hello",null,"hello模型发送消息".getBytes());
        //关闭连接
        channel.close();
        connection.close();
    }

}
