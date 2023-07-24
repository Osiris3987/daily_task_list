package com.example.foodcollector.web.controller;

import com.example.foodcollector.domain.task.Task;
import com.example.foodcollector.domain.user.User;
import com.example.foodcollector.service.TaskService;
import com.example.foodcollector.service.UserService;
import com.example.foodcollector.web.dto.task.TaskDto;
import com.example.foodcollector.web.dto.user.UserDto;
import com.example.foodcollector.web.dto.validation.OnCreate;
import com.example.foodcollector.web.dto.validation.OnUpdate;
import com.example.foodcollector.web.mapprs.TaskMapper;
import com.example.foodcollector.web.mapprs.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
@Validated
public class UserController {
    private final UserService userService;
    private final TaskService taskService;
    private final UserMapper userMapper;
    private final TaskMapper taskMapper;

    @PutMapping
    public UserDto update(@Validated(OnUpdate.class) @RequestBody UserDto userDto){
        User user = userMapper.toEntity(userDto);
        User updatedUser = userService.update(user);
        return userMapper.toDto(updatedUser);
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable Long id){
        User user = userService.getById(id);
        return userMapper.toDto(user);
    }
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id){
        userService.delete(id);
    }
    @GetMapping("/{id}/tasks")
    public List<TaskDto> getTasksByUserId(@PathVariable Long id){
        List<Task> tasks = taskService.getAllByUserId(id);
        return taskMapper.toDto(tasks);
    }
    @PostMapping("/{id}/tasks")
    public TaskDto createTask(@PathVariable Long id, @Validated(OnCreate.class) @RequestBody TaskDto dto){
        Task task = taskMapper.toEntity(dto);
        Task createdTask = taskService.create(task, id);
        return taskMapper.toDto(createdTask);
    }
}
