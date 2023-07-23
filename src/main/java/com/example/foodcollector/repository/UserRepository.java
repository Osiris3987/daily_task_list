package com.example.foodcollector.repository;

import com.example.foodcollector.domain.user.Role;
import com.example.foodcollector.domain.user.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findUserById(Long id);
    Optional<User> findUserByName(String userName);
    void update(User user);
    void create(User user);
    void insertUserRole(Long userId, Role role);
    boolean isTaskOwner(Long userId, Long taskId);
    void delete(Long id);
}
