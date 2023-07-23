package com.example.foodcollector.web.mapprs;

import com.example.foodcollector.domain.task.Task;
import com.example.foodcollector.web.dto.task.TaskDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskDto toDto(Task task);
    List<TaskDto> toDto(List<Task> tasks);
    Task toEntity(TaskDto dto);
}
