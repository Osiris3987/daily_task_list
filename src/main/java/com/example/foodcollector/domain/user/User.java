package com.example.foodcollector.domain.user;

import com.example.foodcollector.domain.task.Task;
import com.example.foodcollector.web.dto.validation.OnCreate;
import com.example.foodcollector.web.dto.validation.OnUpdate;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import java.util.List;
import java.util.Set;

@Data
public class User {
    @NotNull(message = "Id must be not null", groups = OnUpdate.class)
    private Long id;
    @NotNull(message = "Name must be not null", groups = {OnUpdate.class, OnUpdate.class})
    @Length(max = 255, message = "Name must be smaller than 255 symbols", groups = {OnCreate.class, OnUpdate.class})
    private String name;
    @NotNull(message = "UserName must be not null", groups = {OnUpdate.class, OnUpdate.class})
    @Length(max = 255, message = "UserName must be smaller than 255 symbols", groups = {OnCreate.class, OnUpdate.class})
    private String userName;
    @NotNull(message = "Password must be not null", groups = {OnUpdate.class, OnCreate.class})
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @NotNull(message = "Confirmation must be not null", groups = {OnCreate.class})
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String passwordConfirmation;
    private Set<Role> roles;
    private List<Task> tasks;
}
