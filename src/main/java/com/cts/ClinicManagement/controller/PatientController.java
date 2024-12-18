package com.cts.ClinicManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ClinicManagement.entity.Patient;
import com.cts.ClinicManagement.service.impl.PatientServiceImpl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {

	@Autowired
	private PatientServiceImpl patientService;
	
	@GetMapping("/")
	public ResponseEntity<List<Patient>> getAllPatientDetails() {
		
		return new ResponseEntity<>(patientService.viewAllPatients(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public Patient getPatientDetailsById(@PathVariable("id") Long id) {
		
		return patientService.viewPatientById(id);
	}

	@PostMapping("/create")
	// @ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Patient> createNewPatient(@RequestBody Patient patient) {
		patientService.addPatient(patient);
		return new ResponseEntity<>(patient,HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public String updatePatientById(@PathVariable("id") int id,@RequestBody Patient patient){

		patientService.updatePatient(patient);
		return "The patient details of patient : " +id+"  has been updated";

	}

	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable("id") Long id){
		patientService.deletePatient(id);
		return "The patient with id : "+id + " has been deleted";
	}
	
    @GetMapping("/doctor/{id}")
    public String getPatientByDoctorId(@PathVariable("id") int id){
        return "This is the details of the patient: "+id;
    }

}
