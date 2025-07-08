package com.sakii.chat.dto;

import lombok.Data;

@Data
public class ChatMessageRequest {
    private Long sessionId;
    private Long senderUserId;
    private String messageText;
} 