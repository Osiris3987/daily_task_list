package com.example.foodcollector.service.Impl;

import com.example.foodcollector.domain.task.Task;
import com.example.foodcollector.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServerImpl implements TaskService {
    @Override
    public Task getById(Long id) {
        return null;
    }

    @Override
    public List<Task> getAllByUserId(Long id) {
        return null;
    }

    @Override
    public void assignToUserById(Long taskId, Long userId) {

    }

    @Override
    public Task update(Task task) {
        return null;
    }

    @Override
    public Task create(Task task, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
