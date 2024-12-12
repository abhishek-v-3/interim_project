package com.cts.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.entity.Patient;
import com.cts.repository.PatientRepository;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public void addPatient(Patient patient) {

        patientRepository.save(patient);
    }

    public void updatePatient(Patient patient) {
        // Optional<Patient> patientToUpdate = patientRepository.findById(id);

        patientRepository.save(patient);
    }

    public void deletePatient(int id) {
        patientRepository.deleteById(id);
    }

}
