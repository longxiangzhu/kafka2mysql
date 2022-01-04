package com.tony.javademo01.service.impl;

import com.tony.javademo01.entity.product;
import com.tony.javademo01.repository.productRespository;
import com.tony.javademo01.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class productServiceImpl implements productService {

    @Autowired
    private productRespository productRespository;

    public void saveProduct(product product) throws InterruptedException {
        productRespository.save(product);

    }
}
