package com.tony.javademo01.controller;


import com.tony.javademo01.entity.product;
import com.tony.javademo01.service.productKafkaService;
import com.tony.javademo01.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prod")
public class productContoller {
    @Autowired
    // private productService productService;
    private productKafkaService productKafkaService;

    @GetMapping("/test")
    public String TestMsg() {
        return "hello,this is a test message!";
    }

    @PostMapping("/insert")
    public String insertProduct(@RequestBody product product) throws InterruptedException {
        // productService.saveProduct(product);
        productKafkaService.sendToKafka(product);
        return "Insert into Product Table Successfull with data" + product ;
    }

}
