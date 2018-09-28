package com.example.storeorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StoreOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreOrderApplication.class, args);
    }

}
