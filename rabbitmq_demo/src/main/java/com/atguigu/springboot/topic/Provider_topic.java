package com.atguigu.springboot.topic;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Provider_topic {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/topic")
    public String send() {

        rabbitTemplate.convertAndSend("boot_topic", "error.info.debug", "我是boot中topic模型生产者");

        return "success";
    }
}