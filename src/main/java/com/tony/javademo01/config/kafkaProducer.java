package com.tony.javademo01.config;

import com.tony.javademo01.entity.product;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class kafkaProducer {
    @Value("${spring.kafka.producer.bootstrap-servers}")
    private String bootstrap;

    @Value("${spring.kafka.producer.key-serializer}")
    private String keySerializer;

    @Value("${spring.kafka.producer.value-serializer}")
    private String valueSerializer;

    @Bean
    public ProducerFactory<String, product> producerFactory() {
        Map<String,Object> props= new HashMap<>();
        /*
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"172.18.0.115:9092,172.18.0.116:9092,172.18.0.138:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.springframework.kafka.support.serializer.JsonSerializer");
         */
        props.put("bootstrap.servers",bootstrap);
        props.put( "key.serializer",keySerializer);
        props.put("value.serializer",valueSerializer);

        return new DefaultKafkaProducerFactory<>(props);

    }

    @Bean
    public KafkaTemplate<String,product> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
