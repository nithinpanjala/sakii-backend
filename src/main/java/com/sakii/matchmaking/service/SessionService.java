package com.sakii.matchmaking.service;

import com.sakii.matchmaking.model.Session;
import com.sakii.matchmaking.repository.SessionRepository;
import com.sakii.user.model.User;
import com.sakii.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SessionService {
    private final SessionRepository sessionRepository;
    private final UserRepository userRepository;

    public Session createSession(Long user1Id, Long user2Id, String randomNameUser1, String randomNameUser2) {
        User user1 = userRepository.findById(user1Id).orElseThrow();
        User user2 = userRepository.findById(user2Id).orElseThrow();
        Session session = Session.builder()
                .user1(user1)
                .user2(user2)
                .randomNameUser1(randomNameUser1)
                .randomNameUser2(randomNameUser2)
                .status("active")
                .startedAt(LocalDateTime.now())
                .build();
        return sessionRepository.save(session);
    }

    public Optional<Session> getSessionById(Long sessionId) {
        return sessionRepository.findById(sessionId);
    }
} 