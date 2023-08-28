package com.example.foodcollector.service;

import com.example.foodcollector.web.dto.auth.JwtRequest;
import com.example.foodcollector.web.dto.auth.JwtResponse;

public interface AuthService {
    JwtResponse login(JwtRequest loginRequest);

    JwtResponse refresh(String RefreshToken);
}
