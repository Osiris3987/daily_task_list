package com.example.foodcollector.web.dto.auth;

import lombok.Data;

@Data
public class JwtResponse {
    private Long id;
    private String name;
    private String userName;
    private String accessToken;
    private String refreshToken;
}
