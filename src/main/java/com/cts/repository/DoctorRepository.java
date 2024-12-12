package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

}
