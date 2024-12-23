package com.cts.ClinicManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ClinicManagement.dto.AppointmentDTO;
import com.cts.ClinicManagement.service.AppointmentService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    // view all appointments of a patient
    @GetMapping("/patient/{id}")
    public String viewAppointmentsByPatientId(@PathVariable("id") Long id) {
        return "These are the appointments for patient: "+id;
    }
    // add a new appointment
    @PostMapping("/patient/{patientid}/{doctorid}/add")
    public ResponseEntity<AppointmentDTO> addAppointmentForPatient(@PathVariable("patientid") Long patientId,@PathVariable("doctorid") Long doctorId,@RequestBody @Valid AppointmentDTO appointmentDto ) {
        return new ResponseEntity<>(appointmentService.addAppointment(patientId, doctorId, appointmentDto),HttpStatus.CREATED);
    }

    // view appointments for a doctor
    @GetMapping("/doctor/{id}")
    public String viewAppointmentsByDoctorId(@PathVariable("id") int id){
        return "These are the appointments scheduled for doctor: "+id;
    }
}
