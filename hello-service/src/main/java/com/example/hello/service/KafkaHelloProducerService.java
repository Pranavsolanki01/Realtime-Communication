package com.example.hello.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaHelloProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "hello-topic";

    public KafkaHelloProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendHelloMessage(String name) {
        String message = "Hello, " + name + " From Hello !";
        kafkaTemplate.send(TOPIC, message);
    }
}
