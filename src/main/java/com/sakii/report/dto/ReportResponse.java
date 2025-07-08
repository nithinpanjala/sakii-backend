package com.sakii.report.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ReportResponse {
    private Long reportId;
    private String reason;
    private LocalDateTime createdAt;
} 