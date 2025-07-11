package com.gestionna.credito_service.kafka;

import com.gestionna.credito_service.dto.EventoCreditoKafkaDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class KafkaMessageStore {
    private final List<EventoCreditoKafkaDto> messageResponse = new CopyOnWriteArrayList<>();

    public void addMessage(EventoCreditoKafkaDto evento) {
        messageResponse.add(evento);
    }

    public List<EventoCreditoKafkaDto> getListMensage() {
        return messageResponse;
    }
}