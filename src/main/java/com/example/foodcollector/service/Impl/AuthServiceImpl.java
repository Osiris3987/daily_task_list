package com.example.foodcollector.service.Impl;

import com.example.foodcollector.service.AuthService;
import com.example.foodcollector.web.dto.auth.JwtRequest;
import com.example.foodcollector.web.dto.auth.JwtResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public JwtResponse login(JwtRequest loginRequest) {
        return null;
    }

    @Override
    public JwtResponse refresh(String RefreshToken) {
        return null;
    }
}
