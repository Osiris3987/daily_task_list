package com.example.foodcollector.service.Impl;

import com.example.foodcollector.domain.MailType;
import com.example.foodcollector.domain.exception.ResourceNotFoundException;
import com.example.foodcollector.domain.user.Role;
import com.example.foodcollector.domain.user.User;
import com.example.foodcollector.repository.UserRepository;
import com.example.foodcollector.service.MailService;
import com.example.foodcollector.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Properties;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final MailService mailService;

    @Override
    @Transactional(readOnly = true)
    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found."));
    }

    @Override
    @Transactional(readOnly = true)
    public User getByUserName(String userName) {
        return userRepository.findByUsername(userName)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public User getTaskAuthor(Long taskId) {
        return userRepository.findTaskAuthor(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    @Transactional
    public User create(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalStateException("User already exists.");
        }
        if (!user.getPassword().equals(user.getPasswordConfirmation())) {
            throw new IllegalStateException(
                    "Password and password confirmation do not match."
            );
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Role> roles = Set.of(Role.ROLE_USER);
        user.setRoles(roles);
        userRepository.save(user);
        mailService.sendMail(user, MailType.REGISTRATION, new Properties());
        return user;
    }

    @Override
    @Transactional
    public User update(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return user;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isTaskOwner(Long userId, Long taskId) {
        return userRepository.isTaskOwner(userId, taskId);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
