package com.sakii.progressive.service;

import com.sakii.progressive.model.ProgressiveReveal;
import com.sakii.progressive.repository.ProgressiveRevealRepository;
import com.sakii.matchmaking.model.Session;
import com.sakii.matchmaking.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProgressiveRevealService {
    private final ProgressiveRevealRepository progressiveRevealRepository;
    private final SessionRepository sessionRepository;

    public ProgressiveReveal createReveal(Long sessionId, String revealType) {
        Session session = sessionRepository.findById(sessionId).orElseThrow();
        ProgressiveReveal reveal = ProgressiveReveal.builder()
                .session(session)
                .revealType(revealType)
                .revealTime(LocalDateTime.now())
                .user1Approved(false)
                .user2Approved(false)
                .build();
        return progressiveRevealRepository.save(reveal);
    }

    public List<ProgressiveReveal> getRevealsForSession(Long sessionId) {
        return progressiveRevealRepository.findAll().stream()
            .filter(r -> r.getSession().getSessionId().equals(sessionId))
            .toList();
    }
} 