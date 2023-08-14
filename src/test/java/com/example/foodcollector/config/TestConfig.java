package com.example.foodcollector.config;

import com.example.foodcollector.repository.TaskRepository;
import com.example.foodcollector.repository.UserRepository;
import com.example.foodcollector.service.Impl.AuthServiceImpl;
import com.example.foodcollector.service.Impl.TaskServiceImpl;
import com.example.foodcollector.service.Impl.UserServiceImpl;
import com.example.foodcollector.service.props.JwtProperties;
import com.example.foodcollector.web.security.JtwUsersDetailsService;
import com.example.foodcollector.web.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@TestConfiguration
@RequiredArgsConstructor
public class TestConfig {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;
    private final AuthenticationManager authenticationManager;

    @Bean
    @Primary
    public BCryptPasswordEncoder testPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtProperties jwtProperties() {
        JwtProperties jwtProperties = new JwtProperties();
        jwtProperties.setSecret(
                "dmdqYmhqbmttYmNhamNjZWhxa25hd2puY2xhZWtic3ZlaGtzYmJ1dg=="
        );
        return jwtProperties;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new JtwUsersDetailsService(userService());
    }

    @Bean
    public Configuration configuration() {
        return Mockito.mock(Configuration.class);
    }

    @Bean
    public JwtTokenProvider tokenProvider() {
        return new JwtTokenProvider(jwtProperties(),
                userDetailsService(),
                userService());
    }

    @Bean
    @Primary
    public UserServiceImpl userService() {
        return new UserServiceImpl(
                userRepository,
                testPasswordEncoder()
        );
    }

    @Bean
    @Primary
    public TaskServiceImpl taskService() {
        return new TaskServiceImpl(taskRepository);
    }

    @Bean
    @Primary
    public AuthServiceImpl authService() {
        return new AuthServiceImpl(authenticationManager,
                userService(),
                tokenProvider());
    }
}
