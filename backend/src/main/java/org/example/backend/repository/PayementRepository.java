package org.example.backend.repository;

import org.example.backend.entities.Payement;
import org.example.backend.entities.PayementStatus;
import org.example.backend.entities.PayementType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PayementRepository extends JpaRepository<Payement, Long> {
    List<Payement> findByStudentCode(String code);
    List<Payement> findByStatus(PayementStatus status);
    List<Payement> findByType(PayementType type);
}
