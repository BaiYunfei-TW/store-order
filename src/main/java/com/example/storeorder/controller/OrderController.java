package com.example.storeorder.controller;

import com.example.storeorder.entity.Order;
import com.example.storeorder.entity.Product;
import com.example.storeorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/api/users/{userId}/orders")
    public ResponseEntity createOrder(@RequestBody Order order,
                                      @PathVariable String userId,
                                      UriComponentsBuilder builder) {
        order.setUserId(userId);
        Order orderSaved = orderService.save(order);
        return ResponseEntity.created(builder.path("/api/users/" + userId + "/orders/" + orderSaved.getId()).build().toUri()).build();
    }

    @GetMapping("/api/users/{userId}/orders")
    public Product testForGet(@PathVariable String userId) {
        return restTemplate.getForObject("http://STORE-PRODUCT/api/products/1", Product.class);
    }

    @GetMapping("/api/users/{userId}/orders/test")
    public String test(@PathVariable String userId) {
        return userId;
    }

}
