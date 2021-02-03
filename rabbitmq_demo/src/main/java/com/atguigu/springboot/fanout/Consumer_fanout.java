package com.atguigu.springboot.fanout;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer_fanout {
    @RabbitListener(bindings = {@QueueBinding(value = @Queue, exchange = @Exchange(name = "boot_fanout", type = "fanout"))})
    public void recieve1(String message) {
        System.out.println("消费者1" + message);
    }

    @RabbitListener(bindings = {@QueueBinding(value = @Queue, exchange = @Exchange(name = "boot_fanout", type = "fanout"))})
    public void recieve2(String message) {
        System.out.println("消费者2" + message);
    }
}


