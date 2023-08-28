package com.example.foodcollector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories
@EnableScheduling
public class FoodCollectorApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodCollectorApplication.class, args);
    }

}
