package com.atguigu.springboot.hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queuesToDeclare = {@Queue("boot_hello")})
public class Conusmer {
    @RabbitHandler
    public void recieve(String message) {
        System.out.println(message);
    }
}
