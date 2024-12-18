package com.cts.ClinicManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.ClinicManagement.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

}
