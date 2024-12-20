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

import com.cts.ClinicManagement.dto.PatientDTO;
import com.cts.ClinicManagement.service.impl.PatientServiceImpl;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {

	@Autowired
	private PatientServiceImpl patientService;

	@GetMapping("/")
	public ResponseEntity<List<PatientDTO>> getAllPatientDetails() {

		return new ResponseEntity<>(patientService.viewAllPatients(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PatientDTO> getPatientDetailsById(@PathVariable("id") Long id) {

		return new ResponseEntity<>(patientService.viewPatientById(id), HttpStatus.OK);
	}

	@PostMapping("/create")
	// @ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<PatientDTO> createNewPatient(@RequestBody @Valid PatientDTO patientDto) {

		return new ResponseEntity<>(patientService.addPatient(patientDto), HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<PatientDTO> updatePatientById(@PathVariable("id") Long id,@RequestBody @Valid PatientDTO patientDto){

		// patientService.updatePatient(patientDto);
		return new ResponseEntity<>(patientService.updatePatient(patientDto,id),HttpStatus.OK);

	}
	@PutMapping("/patch/{id}")
	public ResponseEntity<PatientDTO> patchPatientById(@PathVariable("id") Long id,@RequestBody @Valid PatientDTO patientDto){

		// patientService.updatePatient(patientDto);
		return new ResponseEntity<>(patientService.updatePatient(patientDto,id),HttpStatus.OK);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
		patientService.deletePatient(id);
		return new ResponseEntity<>("Patient with id : "+id +" deleted successfully",HttpStatus.OK);
	}

	@GetMapping("/doctor/{id}")
	public String getPatientByDoctorId(@PathVariable("id") int id) {
		return "This is the details of the patient: " + id;
	}

}
