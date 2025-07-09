package com.example.consumer.controller;

import com.example.consumer.model.MessageEntity;
import com.example.consumer.repository.MessageRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consumer")
public class MessageController {

    private final MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping("/messages")
    public List<MessageEntity> getAllMessages() {
        return messageRepository.findAll();
    }
}
