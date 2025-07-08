package com.sakii.friendship.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class FriendshipResponse {
    private Long friendshipId;
    private String status;
    private LocalDateTime createdAt;
} 