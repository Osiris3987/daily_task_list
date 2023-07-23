package com.example.foodcollector.web.dto.user;

import com.example.foodcollector.domain.task.Task;
import com.example.foodcollector.domain.user.Role;
import com.example.foodcollector.web.dto.validation.OnUpdate;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class UserDto {
    @NotNull(message = "Id must be not null", groups = OnUpdate.class)
    private Long id;
    private String name;
    private String userName;
    private String password;
    private String passwordConfirmation;
}
