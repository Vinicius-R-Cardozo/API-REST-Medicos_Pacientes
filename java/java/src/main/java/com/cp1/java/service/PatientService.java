package com.cp1.java.service;

import com.cp1.java.models.PatientModels;
import com.cp1.java.repository.PatientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    public PatientService(PatientRepository pacienteRepository) {
        this.patientRepository = pacienteRepository;
    }

    public List<PatientModels> listPatients() {
        return patientRepository.findAll();
    }

    public Optional<PatientModels> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    public PatientModels addPatient(PatientModels patientModel) {
        return patientRepository.save(patientModel);
    }

    public void deletePatient(Long id) {
        var optionalPatient = getPatientById(id);
        if (optionalPatient.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found");
        }
        patientRepository.deleteById(id);
    }

    public PatientModels updatePatient(Long id, PatientModels newPatient) {
        var optionalPatient  = getPatientById(id);
        if (optionalPatient.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found");
        }
        newPatient.setId(id);
        return patientRepository.save(newPatient);

    }
}
