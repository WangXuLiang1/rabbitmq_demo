package com.atguigu.springboot.direct;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer_direct {
    @RabbitListener(bindings = {@QueueBinding(value = @Queue, exchange = @Exchange(name = "boot_direct", type = "direct"), key = {"info", "error"})})
    public void receive1(String message) {
        System.out.println("消费者1" + message);
    }

    @RabbitListener(bindings = {@QueueBinding(value = @Queue, exchange = @Exchange(name = "boot_direct", type = "direct"), key = {"info"})})
    public void receive2(String message) {
        System.out.println("消费者2" + message);
    }
}
