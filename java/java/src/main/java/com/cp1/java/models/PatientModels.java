package com.cp1.java.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class PatientModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private LocalDate dateOfBirth;
    private String problemDescription;

}
