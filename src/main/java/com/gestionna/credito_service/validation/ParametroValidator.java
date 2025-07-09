package com.gestionna.credito_service.validation;

import com.gestionna.credito_service.service.exceptions.InvalidParameterException;

public class ParametroValidator {

    private ParametroValidator() {
    }

    public static void validarNumeroNfse(String numeroNfse) {

        if (!numeroNfse.matches("\\d{1,50}")) {
            throw new IllegalArgumentException("Número da Nota Fiscal deve conter apenas dígitos, a NFS-e deve conter até 50 caracteres.");
        }
    }

    public static void validarNumeroCredito(String numeroCredito) {
        if (numeroCredito == null || numeroCredito.isBlank()) {
            throw new InvalidParameterException("Número do crédito é obrigatório.");
        }
        if (!numeroCredito.matches("\\d{1,50}")) {
            throw new InvalidParameterException("Número do crédito deve conter apenas dígitos e no máximo até 50 caracteres.");
        }
    }

}
