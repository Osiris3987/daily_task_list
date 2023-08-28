package com.example.foodcollector.service.Impl;

import com.example.foodcollector.domain.exception.ResourceNotFoundException;
import com.example.foodcollector.domain.task.Status;
import com.example.foodcollector.domain.task.Task;
import com.example.foodcollector.repository.TaskRepository;
import com.example.foodcollector.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Override
    @Transactional(readOnly = true)
    public Task getById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found."));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Task> getAllByUserId(Long id) {
        return taskRepository.findAllByUserId(id);
    }

    @Override
    @Transactional
    public Task update(Task task) {
        if (task.getStatus() == null) {
            task.setStatus(Status.TODO);
        }
        taskRepository.save(task);
        return task;
    }

    @Override
    @Transactional
    public Task create(final Task task, final Long userId) {
        task.setStatus(Status.TODO);
        taskRepository.save(task);
        taskRepository.assignTask(userId, task.getId());
        return task;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Task> getAllSoonTasks(Duration duration) {
        LocalDateTime now = LocalDateTime.now();
        return taskRepository.findAllSoonTasks(Timestamp.valueOf(now), Timestamp.valueOf(now.plus(duration)));
    }
}
