package com.example.foodcollector.service.Impl;

import com.example.foodcollector.domain.user.User;
import com.example.foodcollector.service.AuthService;
import com.example.foodcollector.service.UserService;
import com.example.foodcollector.web.dto.auth.JwtRequest;
import com.example.foodcollector.web.dto.auth.JwtResponse;
import com.example.foodcollector.web.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;
    @Override
    public JwtResponse login(JwtRequest loginRequest) {
        JwtResponse jwtResponse = new JwtResponse();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword()));
        User user = userService.getByUserName(loginRequest.getUserName());
        jwtResponse.setId(user.getId());
        jwtResponse.setUserName(user.getUserName());
        jwtResponse.setAccessToken(jwtTokenProvider.createAccessToken(user.getId(), user.getUserName(), user.getRoles()));
        jwtResponse.setRefreshToken(jwtTokenProvider.createRefreshToken(user.getId(), user.getUserName()));
        return jwtResponse;
    }

    @Override
    public JwtResponse refresh(String refreshToken) {
        return jwtTokenProvider.refreshUserTokens(refreshToken);
    }
}
