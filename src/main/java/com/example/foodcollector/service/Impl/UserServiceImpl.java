package com.example.foodcollector.service.Impl;

import com.example.foodcollector.domain.user.User;
import com.example.foodcollector.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public User getByUserName(String userName) {
        return null;
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public boolean isTaskOwner(Long userId, Long taskId) {
        return false;
    }

    @Override
    public void delete(Long id) {

    }
}