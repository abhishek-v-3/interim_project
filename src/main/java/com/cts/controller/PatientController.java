package com.cts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.entity.Patient;
import com.cts.service.PatientService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@GetMapping("/")
	public String getAllPatientDetails() {
		
		return "This is the details of all patients";
	}
	
	@GetMapping("/{id}")
	public String getPatientDetailsById(@PathVariable("id") int id) {
		
		return "This is the details of user: "+id;
	}

	@PostMapping("/create")
	public Patient createNewPatient(@RequestBody Patient patient) {
		
		return patient;
	}

	@PutMapping("/update/{id}")
	public String updatePatientById(@PathVariable("id") int id,@RequestBody Patient patient){

		patientService.updatePatient(patient);
		return "The patient details of patient : " +id+" has been updated";

	}

	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable("id") int id){
		patientService.deletePatient(id);
		return "The patient with id : "+id + "has been deleted";
	}
	

    @GetMapping("/doctor/{id}")
    public String getPatientByDoctorId(@PathVariable("id") int id){
        return "This is the details of the patient: "+id;
    }

	// @GetMapping("/showMedicalRecord/{id}")
	// public String getPatientMedicalRecord(@PathVariable("id") int id){
	// 	return "This is the medical records for the user :"+id;

	// }



}
