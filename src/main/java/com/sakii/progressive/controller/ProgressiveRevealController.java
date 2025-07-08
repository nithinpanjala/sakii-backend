package com.sakii.progressive.controller;

import com.sakii.progressive.dto.ProgressiveRevealRequest;
import com.sakii.progressive.dto.ProgressiveRevealResponse;
import com.sakii.progressive.model.ProgressiveReveal;
import com.sakii.progressive.service.ProgressiveRevealService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/progressive-reveals")
@RequiredArgsConstructor
public class ProgressiveRevealController {
    private final ProgressiveRevealService progressiveRevealService;

    @PostMapping
    public ResponseEntity<ProgressiveRevealResponse> createReveal(@RequestBody ProgressiveRevealRequest req) {
        ProgressiveReveal reveal = progressiveRevealService.createReveal(req.getSessionId(), req.getRevealType());
        return ResponseEntity.ok(toResponse(reveal));
    }

    @GetMapping("/session/{sessionId}")
    public ResponseEntity<List<ProgressiveRevealResponse>> getRevealsForSession(@PathVariable Long sessionId) {
        List<ProgressiveReveal> reveals = progressiveRevealService.getRevealsForSession(sessionId);
        List<ProgressiveRevealResponse> responses = reveals.stream().map(this::toResponse).collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    private ProgressiveRevealResponse toResponse(ProgressiveReveal reveal) {
        ProgressiveRevealResponse resp = new ProgressiveRevealResponse();
        resp.setRevealId(reveal.getRevealId());
        resp.setRevealType(reveal.getRevealType());
        resp.setRevealTime(reveal.getRevealTime());
        resp.setUser1Approved(reveal.isUser1Approved());
        resp.setUser2Approved(reveal.isUser2Approved());
        return resp;
    }
} 