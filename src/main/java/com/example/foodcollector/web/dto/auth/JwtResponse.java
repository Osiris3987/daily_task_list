package com.example.foodcollector.web.dto.auth;

import com.example.foodcollector.web.dto.validation.OnCreate;
import com.example.foodcollector.web.dto.validation.OnUpdate;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class JwtResponse {
    private Long id;
    private String name;
    private String userName;
    private String accessToken;
    private String refreshToken;
}
