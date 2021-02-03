package com.atguigu.springboot.direct;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Provider_direct {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/direct")
    public String send() {

        rabbitTemplate.convertAndSend("boot_direct", "error", "我是boot中direct模型生产者");

        return "success";
    }
}