package com.example.foodcollector.service;

import com.example.foodcollector.domain.task.Task;

import java.util.List;

public interface TaskService {
    Task getById(Long id);
    List<Task> getAllByUserId(Long id);
    void assignToUserById(Long taskId, Long userId);
    Task update(Task task);
    Task create(Task task, Long id);
    void delete(Long id);
}
