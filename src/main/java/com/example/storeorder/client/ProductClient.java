package com.example.storeorder.client;

import com.example.storeorder.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "STORE-PRODUCT")
public interface ProductClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/products/{id}")
    Product findById(@PathVariable("id") Integer id);

}
