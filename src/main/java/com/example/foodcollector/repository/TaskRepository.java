package com.example.foodcollector.repository;

import com.example.foodcollector.domain.task.Task;
import com.example.foodcollector.domain.user.Role;
import com.example.foodcollector.domain.user.User;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    Optional<Task> findTaskById(Long id);
    List<Task> findAllByUserId(Long userId);
    void assignToUserById(Long taskId, Long userId);
    void update(Task task);
    void delete(Task task);
    void create(Task task);
}
