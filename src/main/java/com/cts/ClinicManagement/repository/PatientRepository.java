package com.cts.ClinicManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.ClinicManagement.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    public boolean existsByPhoneNumber(Long phoneNumber);

    
    
}
