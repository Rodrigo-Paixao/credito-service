package com.gestionna.credito_service.repository;

import com.gestionna.credito_service.entity.Credito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditoRepository extends JpaRepository<Credito, Long> {

    List<Credito> findByNumeroNfse(String numeroNfse);

}
