package com.sakii.friendship.repository;

import com.sakii.friendship.model.Friendship;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FriendshipRepository extends JpaRepository<Friendship, Long> {
    List<Friendship> findByUser1OrUser2(Long user1Id, Long user2Id);
} 