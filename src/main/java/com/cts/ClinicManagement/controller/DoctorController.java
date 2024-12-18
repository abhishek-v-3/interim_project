package com.cts.ClinicManagement.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cts.ClinicManagement.entity.Doctor;
import com.cts.ClinicManagement.service.DoctorService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {

    @Autowired
	private DoctorService doctorService;
	
	@GetMapping("/")
	public List<Doctor> getAllPatientDetails() {
		
		return doctorService.viewAllDoctors();
	}
	
	@GetMapping("/{id}")
	public Doctor getPatientDetailsById(@PathVariable("id") int id) {
		
		return doctorService.viewDoctorsById(id);
	}

	@PostMapping("/create")
	public Doctor createNewDoctor(@RequestBody Doctor doctor) {
		doctorService.addDoctor(doctor);
		return doctor;
	}

	@PutMapping("/update/{id}")
	public String updateDoctorById(@PathVariable("id") int id,@RequestBody Doctor doctor){

		doctorService.updateDoctor(doctor);
		return "The details of doctor : " +id+"  has been updated";

	}

	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable("id") int id){
		doctorService.deleteDoctor(id);
		return "The doctor with id : "+id + " has been deleted";
	}
	
    @GetMapping("/doctor/patient/{id}")
    public String getPatientByDoctorId(@PathVariable("id") int id){
        return "This is the details of the patients associated with doctor : "+id;
    }

   
    
}
