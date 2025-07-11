package com.gestionna.credito_service.controller;

import com.gestionna.credito_service.entity.KafkaLog;
import com.gestionna.credito_service.repository.KafkaLogRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/logs")
public class KafkaLogController {

    private final KafkaLogRepository kafkaLogRepository;

    public KafkaLogController(KafkaLogRepository kafkaLogRepository) {
        this.kafkaLogRepository = kafkaLogRepository;
    }

    @GetMapping("/kafka")
    @Operation(summary = "Lista todas as mensagens Kafka persistidas.")
    public List<KafkaLog> listarLogsKafka() {
        return kafkaLogRepository.findAll();
    }
}