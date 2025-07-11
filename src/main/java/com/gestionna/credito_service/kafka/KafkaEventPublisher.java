package com.gestionna.credito_service.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaEventPublisher {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void publicarConsulta(String numeroNfse) {
        String mensagem = String.format("Consulta realizada para número NFS-e: %s", numeroNfse);
        kafkaTemplate.send("consulta-creditos-topic", mensagem);
        log.info("Mensagem Kafka enviada: {}", mensagem);
    }
}
