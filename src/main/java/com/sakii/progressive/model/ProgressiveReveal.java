package com.sakii.progressive.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "progressive_reveals")
public class ProgressiveReveal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long revealId;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private com.sakii.matchmaking.model.Session session;

    private String revealType; // interests, photo, name
    private LocalDateTime revealTime;
    private boolean user1Approved;
    private boolean user2Approved;
} 