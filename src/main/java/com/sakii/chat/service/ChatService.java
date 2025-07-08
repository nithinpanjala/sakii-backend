package com.sakii.chat.service;

import com.sakii.chat.model.ChatMessage;
import com.sakii.chat.repository.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatMessageRepository chatMessageRepository;

    public ChatMessage saveMessage(ChatMessage message) {
        return chatMessageRepository.save(message);
    }

    public List<ChatMessage> getMessagesBySessionId(Long sessionId) {
        return chatMessageRepository.findBySessionId(sessionId);
    }
} 