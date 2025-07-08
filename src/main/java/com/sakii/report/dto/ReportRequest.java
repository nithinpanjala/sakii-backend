package com.sakii.report.dto;

import lombok.Data;

@Data
public class ReportRequest {
    private Long reportedByUserId;
    private Long reportedUserId;
    private Long sessionId;
    private String reason;
} 