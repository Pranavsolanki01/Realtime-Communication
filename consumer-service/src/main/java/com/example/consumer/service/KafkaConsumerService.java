package com.example.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.consumer.model.MessageEntity;
import com.example.consumer.repository.MessageRepository;

@Service
public class KafkaConsumerService {

    private final MessageRepository messageRepository;

    public KafkaConsumerService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @KafkaListener(topics = "hello-topic")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
        MessageEntity entity = new MessageEntity();
        entity.setContent(message);
        messageRepository.save(entity);
    }

}
