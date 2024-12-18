package com.cts.ClinicManagement.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.ClinicManagement.entity.Patient;
import com.cts.ClinicManagement.repository.PatientRepository;
import com.cts.ClinicManagement.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    PatientRepository patientRepository;

    public List<Patient> viewAllPatients(){
        
        return patientRepository.findAll();
    }

    public Patient viewPatientById(Long id){
        Patient patient=  patientRepository.findById(id).get();
        return patient;
    }

    public void addPatient(Patient patient) {

        patientRepository.save(patient);
    }

    public void updatePatient(Patient patient) {
        // Optional<Patient> patientToUpdate = patientRepository.findById(id);

        patientRepository.save(patient);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

}
