package com.cts.ClinicManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.ClinicManagement.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

}
