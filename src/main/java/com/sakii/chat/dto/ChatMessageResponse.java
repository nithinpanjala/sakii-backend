package com.sakii.chat.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ChatMessageResponse {
    private String id;
    private Long sessionId;
    private Long senderUserId;
    private String messageText;
    private LocalDateTime sentAt;
} 