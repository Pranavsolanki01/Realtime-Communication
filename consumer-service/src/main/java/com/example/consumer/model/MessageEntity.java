package com.example.consumer.model;

import lombok.Data;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "messages")
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Kolkata")
    private ZonedDateTime timestamp;

    @PrePersist
    protected void onCreate() {
        this.timestamp = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
    }
}
