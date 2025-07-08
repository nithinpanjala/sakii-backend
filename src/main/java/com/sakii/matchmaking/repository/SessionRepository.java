package com.sakii.matchmaking.repository;

import com.sakii.matchmaking.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
} 