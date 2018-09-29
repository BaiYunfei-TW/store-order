package com.example.storeorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableWebSecurity
public class StoreOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreOrderApplication.class, args);
    }

}
