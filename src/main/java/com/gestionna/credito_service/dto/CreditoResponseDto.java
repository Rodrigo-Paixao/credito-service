package com.gestionna.credito_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreditoResponseDto {

    private Long id;
    private String numeroCredito;
    private String numeroNfse;
    private LocalDate dataConstituicao;
    private BigDecimal valorIssqn;
    private String tipoCredito;
    private boolean simplesNacional;
    private BigDecimal aliquota;
    private BigDecimal valorFaturado;
    private BigDecimal valorDeducao;
    private BigDecimal baseCalculo;

    public CreditoResponseDto(Long id, String numeroCredito, String numeroNfse, LocalDate dataConstituicao, BigDecimal valorIssqn, String tipoCredito, String s, BigDecimal aliquota, BigDecimal valorFaturado, BigDecimal valorDeducao, BigDecimal baseCalculo) {
    }

}
