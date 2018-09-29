package com.example.storeorder.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.math.BigDecimal;

@Embeddable
public class OrderProduct {
    @Transient
    private Integer productId;
    @Column(name = "product_price")
    private BigDecimal price;
    @Column(name = "product_unit")
    private String unit;
    @Column(name = "product_imgUrl")
    private String imgUrl;
    @Column(name = "product_name")
    private String name;

    public static OrderProduct create(Product product) {
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setImgUrl(product.getImgUrl());
        orderProduct.setName(product.getName());
        orderProduct.setPrice(product.getPrice());
        orderProduct.setProductId(product.getId());
        orderProduct.setUnit(product.getUnit());

        return orderProduct;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
