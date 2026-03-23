package com.cp1.java.repository;

import com.cp1.java.models.PatientModels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientModels, Long> {
}
