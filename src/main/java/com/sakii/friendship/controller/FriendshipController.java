package com.sakii.friendship.controller;

import com.sakii.friendship.dto.FriendshipRequest;
import com.sakii.friendship.dto.FriendshipResponse;
import com.sakii.friendship.model.Friendship;
import com.sakii.friendship.service.FriendshipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/friendships")
@RequiredArgsConstructor
public class FriendshipController {
    private final FriendshipService friendshipService;

    @PostMapping
    public ResponseEntity<FriendshipResponse> createFriendship(@RequestBody FriendshipRequest req) {
        Friendship friendship = friendshipService.createFriendship(req.getUser1Id(), req.getUser2Id());
        return ResponseEntity.ok(toResponse(friendship));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<FriendshipResponse>> getFriendshipsForUser(@PathVariable Long userId) {
        List<Friendship> friendships = friendshipService.getFriendshipsForUser(userId);
        List<FriendshipResponse> responses = friendships.stream().map(this::toResponse).collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    private FriendshipResponse toResponse(Friendship friendship) {
        FriendshipResponse resp = new FriendshipResponse();
        resp.setFriendshipId(friendship.getFriendshipId());
        resp.setStatus(friendship.getStatus());
        resp.setCreatedAt(friendship.getCreatedAt());
        return resp;
    }
} 