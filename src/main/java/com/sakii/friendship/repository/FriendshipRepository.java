package com.sakii.friendship.repository;

import com.sakii.friendship.model.Friendship;
import com.sakii.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FriendshipRepository extends JpaRepository<Friendship, Long> {
    List<Friendship> findByUser1OrUser2(User user1, User user2);
} 