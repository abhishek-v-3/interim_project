package com.cts.ClinicManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    // view all appointments
    @GetMapping("/")
    public ResponseEntity<List<AppointmentDTO>> viewAllAppointments() {
        return new ResponseEntity<>(appointmentService.viewAllAppointments(),HttpStatus.OK);
    }
    // add a new appointment
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/patient/{patientid}/{doctorid}/add")
    public ResponseEntity<AppointmentDTO> addAppointmentForPatient(@PathVariable("patientid") Long patientId,@PathVariable("doctorid") Long doctorId,@RequestBody @Valid AppointmentDTO appointmentDto ) {
        return new ResponseEntity<>(appointmentService.addAppointment(patientId, doctorId, appointmentDto),HttpStatus.CREATED);
    }

     // update appointment
     @PreAuthorize("hasRole('ADMIN')")
     @PutMapping("/update/{id}")
     public ResponseEntity<AppointmentDTO> updateAppointment(@PathVariable("id") Long id,@RequestBody @Valid AppointmentDTO appointmentDto ) {
         return new ResponseEntity<>(appointmentService.updateAppointment( appointmentDto,id),HttpStatus.OK);
     }
    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteAppointmentById(@PathVariable("id") Long id) {
		appointmentService.deleteAppointment(id);
		return new ResponseEntity<>("Appointement with id : "+id +" deleted successfully",HttpStatus.OK);
	}

    // view appointments for a doctor
    @GetMapping("/doctor/{id}")
    public String viewAppointmentsByDoctorId(@PathVariable("id") int id){
        return "These are the appointments scheduled for doctor: "+id;
    }
}
