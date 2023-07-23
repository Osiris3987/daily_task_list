package com.example.foodcollector.web.dto.task;

import com.example.foodcollector.domain.task.Status;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private Status status;
    private LocalDateTime expirationTime;
}
