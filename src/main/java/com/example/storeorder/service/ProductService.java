package com.example.storeorder.service;

import com.example.storeorder.client.ProductClient;
import com.example.storeorder.entity.OrderItem;
import com.example.storeorder.entity.OrderProduct;
import com.example.storeorder.entity.Product;
import com.example.storeorder.exception.OutOfAmountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductClient productClient;

    public void checkOutOfAmount(List<OrderItem> orderItems) {
        orderItems.forEach(item -> {
            Integer productId = item.getOrderProduct().getProductId();
            Product product = productClient.findById(productId);
            if (product == null || product.isOutOfAmount(item.getAmount())) {
                throw new OutOfAmountException();
            }

            item.setOrderProduct(OrderProduct.create(product));
        });
    }
}
