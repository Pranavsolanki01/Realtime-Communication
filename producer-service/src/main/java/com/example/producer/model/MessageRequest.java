package com.example.producer.model;

import lombok.Data;
import java.time.ZonedDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

@Data
public class MessageRequest {
    private String message;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Kolkata")
    private ZonedDateTime timestamp;

}
