package com.gestionna.credito_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventoCreditoKafkaDto {
    private String evento;
    private String numeroCredito;
    private LocalDateTime dataConsulta;
    private String ipSolicitante;
    private String userAgent;
}