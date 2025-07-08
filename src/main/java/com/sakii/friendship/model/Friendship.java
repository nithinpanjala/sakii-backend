package com.sakii.friendship.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "friendships")
public class Friendship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long friendshipId;

    @ManyToOne
    @JoinColumn(name = "user1_id")
    private com.sakii.user.model.User user1;

    @ManyToOne
    @JoinColumn(name = "user2_id")
    private com.sakii.user.model.User user2;

    private String status; // pending, active, blocked
    private LocalDateTime createdAt;
} 