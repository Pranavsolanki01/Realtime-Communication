package com.example.hello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hello.service.KafkaHelloProducerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

    private final KafkaHelloProducerService kafkaHelloProducerService;

    public HelloController(KafkaHelloProducerService kafkaHelloProducer) {
        this.kafkaHelloProducerService = kafkaHelloProducer;
    }

    @GetMapping
    public String sayHello(@RequestParam(defaultValue = "User") String name) {
        kafkaHelloProducerService.sendHelloMessage(name);
        return "Hello message sent for: " + name;
    }
}
