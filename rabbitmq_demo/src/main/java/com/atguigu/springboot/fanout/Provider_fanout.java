package com.atguigu.springboot.fanout;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Provider_fanout {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/fanout")
    public String send() {

        rabbitTemplate.convertAndSend("boot_fanout", "", "我是boot中fanout模型生产者");

        return "success";
    }
}