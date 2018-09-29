package com.example.storeorder.client;

import com.example.storeorder.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "STORE-PRODUCT")
public interface ProductClient {

    @GetMapping("/api/products/{id}")
    public Product findById(@PathVariable("id") Integer id);

}
