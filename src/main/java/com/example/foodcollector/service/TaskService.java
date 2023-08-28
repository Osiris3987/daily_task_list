package com.example.foodcollector.service;

import com.example.foodcollector.domain.task.Task;

import java.time.Duration;
import java.util.List;

public interface TaskService {
    Task getById(Long id);

    List<Task> getAllByUserId(Long id);

    Task update(Task task);

    Task create(Task task, Long id);

    List<Task> getAllSoonTasks(Duration duration);

    void delete(Long id);
}
