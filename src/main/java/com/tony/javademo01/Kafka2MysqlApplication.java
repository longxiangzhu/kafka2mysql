package com.tony.javademo01;

import com.tony.javademo01.entity.product;
import com.tony.javademo01.service.productService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class Kafka2MysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(Kafka2MysqlApplication.class,args);
    }

    @Autowired
    private productService productService;

    @KafkaListener(topics = "kafka2mysql")
    public void Lisenter(product prod) throws InterruptedException {

        productService.saveProduct(prod);
        System.out.println("----------------"+prod);

    }

}
