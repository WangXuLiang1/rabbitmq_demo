package com.atguigu.springboot.work;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Provider_work {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/work")
    public String send() {
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("boot_work", "我是boot中work模型生产者");
        }
        return "success";
    }
}