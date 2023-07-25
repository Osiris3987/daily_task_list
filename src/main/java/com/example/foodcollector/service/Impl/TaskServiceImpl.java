package com.example.foodcollector.service.Impl;

import com.example.foodcollector.domain.exception.ResourceNotFoundException;
import com.example.foodcollector.domain.task.Status;
import com.example.foodcollector.domain.task.Task;
import com.example.foodcollector.repository.TaskRepository;
import com.example.foodcollector.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    @Override
    @Transactional(readOnly = true)
    public Task getById(Long id) {
        return taskRepository.findTaskById(id)
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
        if(task.getStatus() == null){
            task.setStatus(Status.TODO);
        }
        taskRepository.update(task);
        return task;
    }

    @Override
    @Transactional
    public Task create(Task task, Long userId) {
        task.setStatus(Status.TODO);
        taskRepository.create(task);
        taskRepository.assignToUserById(task.getId(), userId);
        return task;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        taskRepository.delete(id);
    }
}
