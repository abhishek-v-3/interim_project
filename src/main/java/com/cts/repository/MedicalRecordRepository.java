package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.entity.MedicalRecord;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord,Integer>{

}
