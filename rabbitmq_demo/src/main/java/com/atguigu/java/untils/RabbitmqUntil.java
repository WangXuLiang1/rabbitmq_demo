package com.atguigu.java.untils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitmqUntil {

    private static ConnectionFactory connectionFactory=new ConnectionFactory();
    static {
        connectionFactory.setVirtualHost("/mes");
        connectionFactory.setPort(5672);
        connectionFactory.setPassword("atguigu");
        connectionFactory.setUsername("atguigu");
        connectionFactory.setHost("192.168.214.130");
    }
    //获取连接的工具方法
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = connectionFactory.newConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return connection;
    }
    //释放资源工具方法
    public static void  release(Channel channel,Connection connection){
   if (channel!=null){
       try {
           channel.close();
       } catch (IOException e) {
           e.printStackTrace();
       } catch (TimeoutException e) {
           e.printStackTrace();
       }
   }
   if (connection!=null){
       try {
           connection.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
    }
}
