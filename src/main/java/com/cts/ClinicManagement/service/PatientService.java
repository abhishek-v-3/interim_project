package com.cts.ClinicManagement.service;

import java.util.List;

import com.cts.ClinicManagement.dto.PatientDTO;

public interface PatientService {
    List<PatientDTO> viewAllPatients();
    PatientDTO viewPatientById(Long id);
    PatientDTO addPatient(PatientDTO patientDto);
    PatientDTO updatePatient(PatientDTO patientDto,Long id);
    void deletePatient(Long id);
}
