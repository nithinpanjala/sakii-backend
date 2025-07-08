package com.sakii.chat.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "messages")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatMessage {
    @Id
    private String id;
    private Long sessionId;
    private Long senderUserId;
    private String messageText;
    private LocalDateTime sentAt;
} 