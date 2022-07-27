package com.example.merchant.dto;

import com.example.merchant.document.Product;

public class ProductDto {
    private int id;
    private Product products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", products=" + products +
                '}';
    }

    public void setProducts(Product products) {
        this.products = products;
    }
}
