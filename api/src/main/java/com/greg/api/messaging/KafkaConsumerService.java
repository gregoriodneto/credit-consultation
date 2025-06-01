package com.greg.api.messaging;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @KafkaListener(topics = "consulta-notifications", groupId = "groupo-consulta")
    public void consumirMensagem(String mensagem) {
        System.out.println("Notificação Recebida: " + mensagem);
    }
}
