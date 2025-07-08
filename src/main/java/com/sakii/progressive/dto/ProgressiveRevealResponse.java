package com.sakii.progressive.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ProgressiveRevealResponse {
    private Long revealId;
    private String revealType;
    private LocalDateTime revealTime;
    private boolean user1Approved;
    private boolean user2Approved;
} 