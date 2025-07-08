package com.gestionna.credito_service.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Validated
public class CreditoRequestDto {

    @NotBlank(message = "O número do crédito é obrigatório")
    @Size(max = 50)
    private String numeroCredito;

    @NotBlank(message = "O número da NFS-e é obrigatório")
    @Size(max = 50)
    private String numeroNfse;

    @NotNull(message = "A data de constituição é obrigatória")
    private LocalDate dataConstituicao;

    @NotNull(message = "O valor do ISSQN é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal valorIssqn;

    @NotBlank(message = "O tipo de crédito é obrigatório")
    @Size(max = 50)
    private String tipoCredito;

    @NotNull(message = "O campo Simples Nacional é obrigatório")
    private Boolean simplesNacional;

    @NotNull(message = "A alíquota é obrigatória")
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal aliquota;

    @NotNull(message = "O valor faturado é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal valorFaturado;

    @NotNull(message = "O valor da dedução é obrigatório")
    @DecimalMin(value = "0.0")
    private BigDecimal valorDeducao;

    @NotNull(message = "A base de cálculo é obrigatória")
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal baseCalculo;
}
