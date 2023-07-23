package com.example.foodcollector.service;

import com.example.foodcollector.web.dto.auth.JwtResponse;
import com.example.foodcollector.web.dto.auth.JwtRequest;

public interface AuthService {
    JwtResponse login(JwtRequest loginRequest);
    JwtResponse refresh(String RefreshToken);
}
