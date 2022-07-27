package com.example.merchant.service;

import com.example.merchant.document.Merchant;
import com.example.merchant.document.Product;
import com.example.merchant.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface MerchantService {
    Merchant save(Merchant merchant);
    List<Merchant> findAll();
    Optional<Merchant> findById(int id);
    void findByIdAndAdd(int id,Product product);
   // void save(Product product);
    void findByIdAndUpdate(int id,Product product);
}
