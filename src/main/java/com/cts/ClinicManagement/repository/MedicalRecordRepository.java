package com.cts.ClinicManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.ClinicManagement.entity.MedicalRecord;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord,Integer>{

}
