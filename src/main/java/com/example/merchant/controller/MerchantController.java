package com.example.merchant.controller;


import com.example.merchant.document.Merchant;
import com.example.merchant.document.Product;
import com.example.merchant.dto.MerchantDto;
import com.example.merchant.dto.ProductDto;
import com.example.merchant.service.MerchantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/merchant")
public class MerchantController {

    @Autowired
    MerchantService merchantService;

    @PostMapping("/update")
    public void update(@RequestBody Merchant merchant){
       // int count = merchantService.findAll().size();
        //Merchant merchant = new Merchant();
        //BeanUtils.copyProperties(merchantDto,merchant);
        //merchant.setId(count);
        merchantService.save(merchant);
        //System.out.println(merchant);
    }

    @PostMapping("/add-product")
    public void addProduct(@RequestBody ProductDto productDto){
        merchantService.findByIdAndAdd(productDto.getId(),productDto.getProducts());

    }

    @PostMapping("/update-product")
    public void UpdateProfile(@RequestBody ProductDto productDto){
        merchantService.findByIdAndUpdate(productDto.getId(),productDto.getProducts());
    }
}
