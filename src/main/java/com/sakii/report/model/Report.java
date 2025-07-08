package com.sakii.report.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "reports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    @ManyToOne
    @JoinColumn(name = "reported_by_user_id")
    private com.sakii.user.model.User reportedBy;

    @ManyToOne
    @JoinColumn(name = "reported_user_id")
    private com.sakii.user.model.User reportedUser;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private com.sakii.matchmaking.model.Session session;

    private String reason;
    private LocalDateTime createdAt;
} 