package com.atguigu.springboot.work;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer1 {
    @RabbitListener(queuesToDeclare = {@Queue("boot_work")})
    public void recieve1(String message) {
        System.out.println(message+"1");
    }

    @RabbitListener(queuesToDeclare = {@Queue("boot_work")})
    public void recieve2(String message) {
        System.out.println(message+2);
    }
}
