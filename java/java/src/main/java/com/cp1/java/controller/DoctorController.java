package com.cp1.java.controller;


import com.cp1.java.models.DoctorModels;
import com.cp1.java.service.DoctorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("doctor")
public class DoctorController {

    private DoctorService doctorService;
    private final Logger log = LoggerFactory.getLogger(getClass());

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping()
    public List<DoctorModels> getAllDoctors(){
        log.info("List all doctors");
        return doctorService.getDoctors();
    }

    @GetMapping("{id}")
    public ResponseEntity<DoctorModels> getDoctorById(@PathVariable Long id){
        log.info("searching for doctor with {}", id);
        return doctorService.getDoctorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<DoctorModels> addDoctor(@RequestBody DoctorModels doctorModels){
        var doctor = doctorService.addDoctor(doctorModels);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(doctor);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id){
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<DoctorModels> updateDoctor(@PathVariable Long id, @RequestBody DoctorModels newDoctor){
        DoctorModels doctorModels = doctorService.updateDoctor(id, newDoctor);
        return ResponseEntity.ok(doctorModels);
    }


}
