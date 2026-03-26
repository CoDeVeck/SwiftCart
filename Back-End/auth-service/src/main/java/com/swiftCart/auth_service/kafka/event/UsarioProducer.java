package com.swiftCart.auth_service.kafka.event;

import com.swiftCart.auth_service.models.Usuario;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


@Service
public class UsarioProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsarioProducer.class);

    private NewTopic topic;
    private KafkaTemplate<String, UsuarioEvent> kafkaTemplate;

    public UsarioProducer(NewTopic topic, KafkaTemplate<String, UsuarioEvent> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessages(UsuarioEvent event){
        LOGGER.info(String.format("Usuario event => %s", event.toString()));

        //creamos el mensaje;

        Message<UsuarioEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();
        //En esta parte elegir siempre el que dice Message<?> message
        kafkaTemplate.send(message);
    }

}
