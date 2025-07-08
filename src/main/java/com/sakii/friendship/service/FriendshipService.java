package com.sakii.friendship.service;

import com.sakii.friendship.model.Friendship;
import com.sakii.friendship.repository.FriendshipRepository;
import com.sakii.user.model.User;
import com.sakii.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FriendshipService {
    private final FriendshipRepository friendshipRepository;
    private final UserRepository userRepository;

    public Friendship createFriendship(Long user1Id, Long user2Id) {
        User user1 = userRepository.findById(user1Id).orElseThrow();
        User user2 = userRepository.findById(user2Id).orElseThrow();
        Friendship friendship = Friendship.builder()
                .user1(user1)
                .user2(user2)
                .status("pending")
                .createdAt(LocalDateTime.now())
                .build();
        return friendshipRepository.save(friendship);
    }

    public List<Friendship> getFriendshipsForUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return friendshipRepository.findByUser1OrUser2(user, user);
    }
} 