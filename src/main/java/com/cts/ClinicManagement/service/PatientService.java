package com.cts.ClinicManagement.service;

import java.util.List;

import com.cts.ClinicManagement.entity.Patient;

public interface PatientService {
    List<Patient> viewAllPatients();
    Patient viewPatientById(Long id);
    void addPatient(Patient patient);
    void updatePatient(Patient patient);
    void deletePatient(Long id);
}
