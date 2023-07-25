package com.example.foodcollector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class FoodCollectorApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodCollectorApplication.class, args);
    }

}
