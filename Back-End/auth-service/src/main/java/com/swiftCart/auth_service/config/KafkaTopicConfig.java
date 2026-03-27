package com.swiftCart.auth_service.config;

import jakarta.annotation.PostConstruct;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Value("${spring.kafka.producer.bootstrap-servers}")
    private String kafkaServer;


    // creamos un bean para kafka topic
    @Bean
    public NewTopic topic(){
        return TopicBuilder.name(topicName)
                .build();
    }

    @PostConstruct
    public void print() {
        System.out.println("Kafka server => " + kafkaServer);
    }
}
