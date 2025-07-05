package com.example.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.consumer.model.MessageEntity;

public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
}
