package com.sakii.report.service;

import com.sakii.report.model.Report;
import com.sakii.report.repository.ReportRepository;
import com.sakii.user.model.User;
import com.sakii.user.repository.UserRepository;
import com.sakii.matchmaking.model.Session;
import com.sakii.matchmaking.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final ReportRepository reportRepository;
    private final UserRepository userRepository;
    private final SessionRepository sessionRepository;

    public Report createReport(Long reportedByUserId, Long reportedUserId, Long sessionId, String reason) {
        User reportedBy = userRepository.findById(reportedByUserId).orElseThrow();
        User reportedUser = userRepository.findById(reportedUserId).orElseThrow();
        Session session = sessionRepository.findById(sessionId).orElseThrow();
        Report report = Report.builder()
                .reportedBy(reportedBy)
                .reportedUser(reportedUser)
                .session(session)
                .reason(reason)
                .createdAt(LocalDateTime.now())
                .build();
        return reportRepository.save(report);
    }

    public List<Report> getReportsForUser(Long userId) {
        return reportRepository.findAll().stream()
            .filter(r -> r.getReportedUser().getUserId().equals(userId))
            .toList();
    }
} 