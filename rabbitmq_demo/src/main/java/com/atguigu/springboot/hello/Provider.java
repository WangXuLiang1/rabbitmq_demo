package com.atguigu.springboot.hello;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Provider {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/hello")
    public String  send() {
        rabbitTemplate.convertAndSend("boot_hello", "我是boot中的hello生产者");
        return "success";
    }

}
