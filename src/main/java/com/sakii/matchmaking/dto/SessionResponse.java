package com.sakii.matchmaking.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class SessionResponse {
    private Long sessionId;
    private String randomNameUser1;
    private String randomNameUser2;
    private String status;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
} 