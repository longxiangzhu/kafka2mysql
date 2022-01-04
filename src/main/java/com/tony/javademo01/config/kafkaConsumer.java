package com.tony.javademo01.config;

import com.tony.javademo01.entity.product;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class kafkaConsumer {

    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;

    @Value("${spring.kafka.consumer.bootstrap-servers}")
    private String bootstrap;

    @Value("${spring.kafka.consumer.auto-offset-reset}")
    private String autoOffReset;

    @Bean
    public ConsumerFactory<String, product> consumerFactory() {
        Map<String,Object> prop=new HashMap<>();

        /*
        prop.put(ConsumerConfig.GROUP_ID_CONFIG,"kafka2Mysql-group1");
        prop.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"172.18.0.115:9092,172.18.0.116:9092,172.18.0.138:9092");
        prop.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        */
        prop.put("group.id",groupId);
        prop.put("bootstrap.servers",bootstrap);
        prop.put("auto.offset.reset",autoOffReset);

        return new DefaultKafkaConsumerFactory<>(prop, new StringDeserializer(),new JsonDeserializer<>(product.class));

    }


    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,product> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, product> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

}
