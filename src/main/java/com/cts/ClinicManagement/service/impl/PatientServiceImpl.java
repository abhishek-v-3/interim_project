package com.cts.ClinicManagement.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.ClinicManagement.dto.PatientDTO;
import com.cts.ClinicManagement.entity.Patient;
import com.cts.ClinicManagement.exceptions.ResourceNotFoundException;
import com.cts.ClinicManagement.repository.PatientRepository;
import com.cts.ClinicManagement.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    // method to view all the patients 
    @Override
    public List<PatientDTO> viewAllPatients() {

        return patientRepository.findAll().stream().map(post-> mapToDto(post)).collect(Collectors.toList());
        // return null;
    }

    // method to view patients by their id
    @Override
    public PatientDTO viewPatientById(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Patient", "id", id));
        return mapToDto(patient);
    }

    // method to add a new patient
    @Override
    public PatientDTO addPatient(PatientDTO patientDto) {
        Patient patient = mapToEntity(patientDto);
        Patient tempPatient = patientRepository.save(patient);
        PatientDTO response = mapToDto(tempPatient);
        return response;
    }

    // method to update a patient
    @Override
    public PatientDTO updatePatient(PatientDTO patientDto,Long id) {
        Patient updatedPatient = mapToEntity(patientDto);
        Patient existingPatient = patientRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Patient", "id", id));

        // Update only the provided fields
        if (updatedPatient.getFirstName() != null) {
            existingPatient.setFirstName(updatedPatient.getFirstName());
        }
        if (updatedPatient.getLastName() != null) {
            existingPatient.setLastName(updatedPatient.getLastName());
        }
        if (updatedPatient.getAge() != 0) { // Assuming age is not null but can be zero
            existingPatient.setAge(updatedPatient.getAge());
        }
        if (updatedPatient.getGender() != null) {
            existingPatient.setGender(updatedPatient.getGender());
        }
        if (updatedPatient.getPhoneNumber() != null) {
            existingPatient.setPhoneNumber(updatedPatient.getPhoneNumber());
        }

        // Save the updated patient entity
        PatientDTO savedPatientDto = mapToDto(patientRepository.save(existingPatient));

        return savedPatientDto;

    }

    // method to delete the patient
    @Override
    public void deletePatient(Long id) {
        Patient patientToDelete = patientRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Patient", "id", id));
        patientRepository.delete(patientToDelete);
    }

    // to convert dto into entity
    public Patient mapToEntity(PatientDTO patientDto) {
        Patient patient = new Patient();
        patient.setFirstName(patientDto.getFirstName());
        patient.setLastName(patientDto.getLastName());
        patient.setAge(patientDto.getAge());
        patient.setGender(patientDto.getGender());
        return patient;
    }

    // to convert entity into dto
    public PatientDTO mapToDto(Patient patient) {
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setFirstName(patient.getFirstName());
        patientDTO.setLastName(patient.getLastName());
        patientDTO.setAge(patient.getAge());
        patientDTO.setGender(patient.getGender());
        return patientDTO;
    }


}