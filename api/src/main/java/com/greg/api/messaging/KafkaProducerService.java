package com.greg.api.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private static final String TOPIC = "consulta-notifications";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendConsultaNotification(String message) {
        kafkaTemplate.send(TOPIC, message);
    }
}
