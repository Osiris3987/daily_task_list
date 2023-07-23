package com.example.foodcollector.repository.implementation;

import com.example.foodcollector.domain.task.Task;
import com.example.foodcollector.repository.TaskRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class TaskRepositoryImpl implements TaskRepository {
    @Override
    public Optional<Task> findTaskById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Task> findAllByUserId(Long userId) {
        return null;
    }

    @Override
    public void assignToUserById(Long taskId, Long userId) {

    }

    @Override
    public void update(Task task) {

    }

    @Override
    public void delete(Task task) {

    }

    @Override
    public void create(Task task) {

    }
}
