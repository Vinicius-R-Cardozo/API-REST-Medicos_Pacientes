package com.cp1.java.controller;

import com.cp1.java.models.PatientModels;
import com.cp1.java.repository.PatientRepository;
import com.cp1.java.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("patient")
public class PatientController {

    private PatientService patientService;
    private final Logger log = LoggerFactory.getLogger(getClass());

    public  PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping()
    public List<PatientModels> getPatients() {
        return patientService.listPatients();
    }

    @GetMapping("{id}")
    public ResponseEntity<PatientModels> getPatientById(@PathVariable Long id) {
        log.info("searching for doctor with {}", id);
        return patientService.getPatientById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<PatientModels> addPatient(@RequestBody PatientModels patientModel) {
        var patient = patientService.addPatient(patientModel);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(patient);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id){
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<PatientModels> updatePatient(@PathVariable Long id, @RequestBody PatientModels newPatient){
        PatientModels patientModels = patientService.updatePatient(id, newPatient);
        return ResponseEntity.ok(patientModels);
    }

}
