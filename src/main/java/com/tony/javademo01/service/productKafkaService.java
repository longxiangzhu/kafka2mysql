package com.tony.javademo01.service;

import com.tony.javademo01.entity.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class productKafkaService {
    @Autowired
    private KafkaTemplate<String, product> kafkaTemplate;

    public void sendToKafka(product product) {
        kafkaTemplate.send("kafka2mysql",product);

    }

}


