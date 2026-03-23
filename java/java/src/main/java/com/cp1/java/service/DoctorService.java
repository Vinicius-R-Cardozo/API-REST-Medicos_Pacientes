package com.cp1.java.service;

import com.cp1.java.models.DoctorModels;
import com.cp1.java.models.PatientModels;
import com.cp1.java.repository.DoctorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private DoctorRepository doctorRepository;

    public  DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<DoctorModels> getDoctors() {
        return doctorRepository.findAll();
    }

    public Optional<DoctorModels> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    public DoctorModels addDoctor(DoctorModels doctorModels) {
        return doctorRepository.save(doctorModels);
    }

    public void deleteDoctor(Long id) {
        var optionalDoctor = getDoctorById(id);
        if (optionalDoctor.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor not found");
        }
        doctorRepository.deleteById(id);
    }

    public DoctorModels updateDoctor(Long id, DoctorModels newDoctor) {
        var optionalDoctor  = getDoctorById(id);
        if (optionalDoctor.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Doctor not found");
        }
        newDoctor.setId(id);
        return doctorRepository.save(newDoctor);

    }



}
