package com.example.foodcollector.service;

import com.example.foodcollector.domain.task.Task;

import java.util.List;

public interface TaskService {
    Task getById(Long id);
    List<Task> getAllByUserId(Long id);
    void assignToUserById(Long taskId, Long userId);
    void update(Task task);
    void create(Task task);
    void delete(Task task);
}
