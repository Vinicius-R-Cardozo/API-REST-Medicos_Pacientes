package com.cp1.java.repository;

import com.cp1.java.models.DoctorModels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<DoctorModels, Long> {
}
