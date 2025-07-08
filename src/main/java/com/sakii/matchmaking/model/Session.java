package com.sakii.matchmaking.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sessionId;
    @ManyToOne
    @JoinColumn(name = "user1_id")
    private com.sakii.user.model.User user1;
    @ManyToOne
    @JoinColumn(name = "user2_id")
    private com.sakii.user.model.User user2;
    private String randomNameUser1;
    private String randomNameUser2;
    private String status;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
} 