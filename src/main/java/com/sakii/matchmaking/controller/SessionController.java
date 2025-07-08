package com.sakii.matchmaking.controller;

import com.sakii.matchmaking.dto.SessionRequest;
import com.sakii.matchmaking.dto.SessionResponse;
import com.sakii.matchmaking.model.Session;
import com.sakii.matchmaking.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/sessions")
@RequiredArgsConstructor
public class SessionController {
    private final SessionService sessionService;

    @PostMapping
    public ResponseEntity<SessionResponse> createSession(@RequestBody SessionRequest req) {
        // For demo, generate random names
        String randomNameUser1 = "User1" + req.getUser1Id();
        String randomNameUser2 = "User2" + req.getUser2Id();
        Session session = sessionService.createSession(req.getUser1Id(), req.getUser2Id(), randomNameUser1, randomNameUser2);
        return ResponseEntity.ok(toResponse(session));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SessionResponse> getSession(@PathVariable Long id) {
        Optional<Session> sessionOpt = sessionService.getSessionById(id);
        return sessionOpt.map(session -> ResponseEntity.ok(toResponse(session)))
                .orElse(ResponseEntity.notFound().build());
    }

    private SessionResponse toResponse(Session session) {
        SessionResponse resp = new SessionResponse();
        resp.setSessionId(session.getSessionId());
        resp.setRandomNameUser1(session.getRandomNameUser1());
        resp.setRandomNameUser2(session.getRandomNameUser2());
        resp.setStatus(session.getStatus());
        resp.setStartedAt(session.getStartedAt());
        resp.setEndedAt(session.getEndedAt());
        return resp;
    }
} 