package com.gestionna.credito_service.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gestionna.credito_service.dto.EventoCreditoKafkaDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final KafkaMessageStore messageStore;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "consultas-credito", groupId = "credito-group")
    public void consumir(ConsumerRecord<String, String> record) {
        try {
            EventoCreditoKafkaDto evento = objectMapper.readValue(record.value(), EventoCreditoKafkaDto.class);
            log.info("[Kafka] Mensagem recebida: {}", evento);
            messageStore.addMessage(evento);
        } catch (Exception e) {
            log.error("[Kafka] Erro ao processar mensagem: {}", record.value(), e);
        }
    }

}