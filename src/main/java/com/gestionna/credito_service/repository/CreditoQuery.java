
package com.gestionna.credito_service.repository;

import com.gestionna.credito_service.entity.Credito;

import java.math.BigDecimal;
import java.util.List;

public interface CreditoQuery {
    List<Credito> buscarPorFiltros(String tipoCredito, Boolean simplesNacional, BigDecimal valorMinimo);
}
