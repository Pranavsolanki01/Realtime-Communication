package com.example.producer.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.producer.model.MessageRequest;
import com.example.producer.service.KafkaProducerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/producer")
public class ProducerController {

    private final KafkaProducerService kafkaProducerService;

    public ProducerController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestBody MessageRequest request) {
        kafkaProducerService.sendMessage(request.getMessage());
        return "Message sent: " + request.getMessage();
    }
}
