package com.example.foodcollector.web.controller;

import com.example.foodcollector.domain.user.User;
import com.example.foodcollector.service.AuthService;
import com.example.foodcollector.service.UserService;
import com.example.foodcollector.web.dto.auth.JwtRequest;
import com.example.foodcollector.web.dto.auth.JwtResponse;
import com.example.foodcollector.web.dto.user.UserDto;
import com.example.foodcollector.web.dto.validation.OnCreate;
import com.example.foodcollector.web.mapprs.UserMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Validated
@Tag(name = "Auth controller", description = "Auth API")
public class AuthController {
    private final AuthService authService;
    private final UserService userService;
    private final UserMapper userMapper;
    @PostMapping("/login")
    public JwtResponse login(@Validated @RequestBody JwtRequest loginRequest){
        return authService.login(loginRequest);
    }

    @PostMapping("/register")
    public UserDto register(@Validated(OnCreate.class)
                            @RequestBody final UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User createdUser = userService.create(user);
        return userMapper.toDto(createdUser);
    }

    @PostMapping("/refresh")
    public JwtResponse refresh(@RequestBody String refreshToken){
        return authService.refresh(refreshToken);
    }
}
