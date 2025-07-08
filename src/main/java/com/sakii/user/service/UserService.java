package com.sakii.user.service;

import com.sakii.user.model.User;
import com.sakii.user.model.Interest;
import com.sakii.user.repository.UserRepository;
import com.sakii.user.repository.InterestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final InterestRepository interestRepository;
    private final PasswordEncoder passwordEncoder;

    public User registerUser(User user, Set<Long> interestIds) {
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        Set<Interest> interests = interestRepository.findAllById(interestIds).stream().collect(java.util.stream.Collectors.toSet());
        user.setInterests(interests);
        return userRepository.save(user);
    }

    public Optional<User> login(String emailOrPhone, String password) {
        Optional<User> userOpt = userRepository.findByEmail(emailOrPhone);
        if (userOpt.isEmpty()) {
            userOpt = userRepository.findByPhone(emailOrPhone);
        }
        if (userOpt.isPresent() && passwordEncoder.matches(password, userOpt.get().getPasswordHash())) {
            return userOpt;
        }
        return Optional.empty();
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }
} 