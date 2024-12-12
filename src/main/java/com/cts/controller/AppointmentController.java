package com.cts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    @GetMapping("/patient/{id}")
    public String viewAppointmentsByPatientId(@PathVariable("id") int id) {
        return "These are the appointments for patient: "+id;
    }
    @GetMapping("/doctor/{id}")
    public String viewAppointmentsByDoctorId(@PathVariable("id") int id){
        return "These are the appointments scheduled for doctor: "+id;
    }
}
