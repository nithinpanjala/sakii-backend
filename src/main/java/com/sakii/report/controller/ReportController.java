package com.sakii.report.controller;

import com.sakii.report.dto.ReportRequest;
import com.sakii.report.dto.ReportResponse;
import com.sakii.report.model.Report;
import com.sakii.report.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;

    @PostMapping
    public ResponseEntity<ReportResponse> createReport(@RequestBody ReportRequest req) {
        Report report = reportService.createReport(req.getReportedByUserId(), req.getReportedUserId(), req.getSessionId(), req.getReason());
        return ResponseEntity.ok(toResponse(report));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ReportResponse>> getReportsForUser(@PathVariable Long userId) {
        List<Report> reports = reportService.getReportsForUser(userId);
        List<ReportResponse> responses = reports.stream().map(this::toResponse).collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    private ReportResponse toResponse(Report report) {
        ReportResponse resp = new ReportResponse();
        resp.setReportId(report.getReportId());
        resp.setReason(report.getReason());
        resp.setCreatedAt(report.getCreatedAt());
        return resp;
    }
} 