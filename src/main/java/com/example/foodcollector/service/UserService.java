package com.example.foodcollector.service;

import com.example.foodcollector.domain.user.User;

public interface UserService {
    User getUserById(Long id);
    User getByUserName(String userName);
    User create(User user);
    User update(User user);
    boolean isTaskOwner(Long userId, Long taskId);
    void delete(Long id);
}
