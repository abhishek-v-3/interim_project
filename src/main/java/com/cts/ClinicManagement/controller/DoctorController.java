package com.cts.ClinicManagement.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cts.ClinicManagement.dto.DoctorDTO;
import com.cts.ClinicManagement.service.impl.DoctorServiceImpl;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {

    @Autowired
	private DoctorServiceImpl doctorService;
	
	@GetMapping("/")
	public ResponseEntity<List<DoctorDTO>> getAllDoctorDetails() {
		
		return new ResponseEntity<>(doctorService.viewAllDoctors(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DoctorDTO> getDoctorDetailsById(@PathVariable("id") Long id) {
		
		return new ResponseEntity<>(doctorService.viewDoctorById(id),HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<DoctorDTO> createNewDoctor(@RequestBody DoctorDTO doctorDto) {
		return new ResponseEntity<>(doctorService.addDoctor(doctorDto),HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<DoctorDTO> updateDoctorById(@PathVariable("id") Long id,@RequestBody DoctorDTO doctorDto){

		
		return new ResponseEntity<>(doctorService.updateDoctor(doctorDto,id),HttpStatus.OK);

	}

	@PatchMapping("/patch/{id}")
	public ResponseEntity<DoctorDTO> patchDoctorById(@PathVariable("id") Long id,@RequestBody @Valid DoctorDTO doctorDto){

	
		return new ResponseEntity<>(doctorService.updateDoctor(doctorDto,id),HttpStatus.OK);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") Long id){
		doctorService.deleteDoctor(id);
		return new ResponseEntity<>("The doctor with id : "+id + " has been deleted",HttpStatus.OK);
	}
	
    @GetMapping("/doctor/patient/{id}")
    public String getPatientByDoctorId(@PathVariable("id") int id){
        return "This is the details of the patients associated with doctor : "+id;
    }

   
    
}
