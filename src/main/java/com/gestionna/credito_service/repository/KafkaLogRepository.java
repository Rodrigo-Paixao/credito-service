package com.gestionna.credito_service.repository;

import com.gestionna.credito_service.entity.KafkaLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KafkaLogRepository extends JpaRepository<KafkaLog, Long> {

}
