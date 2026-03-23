package com.cp1.java.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Optional;

@Entity
@Data
public class DoctorModels {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String crm;
    private LocalDate dateOfBirth;
    private String specialty;


}
