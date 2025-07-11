package com.gestionna.credito_service.kafka;

import com.gestionna.credito_service.entity.KafkaLog;
import com.gestionna.credito_service.repository.KafkaLogRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class KafkaEventListener {

    private final KafkaLogRepository kafkaLogRepository;
    private final List<String> mensagens = new ArrayList<>();

    public KafkaEventListener(KafkaLogRepository kafkaLogRepository) {
        this.kafkaLogRepository = kafkaLogRepository;
    }

    @KafkaListener(topics = "consulta-creditos-topic", groupId = "credito-group")
    public void ouvir(String mensagem) {
        mensagens.add(mensagem);
        kafkaLogRepository.save(KafkaLog.builder()
                .mensagem(mensagem)
                .dataRegistro(LocalDateTime.now())
                .build());
    }

    public List<String> listarMensagens() {
        return mensagens;
    }
}
