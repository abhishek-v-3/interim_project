package com.cts.ClinicManagement.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ClinicManagement.entity.MedicalRecord;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/v1/medicalrecords")
public class MedicalRecordController {

    @GetMapping("/patient/{id}")
    public String getMedicalRecordByPatientId(@PathVariable("id") int id) {
        return "This is the medical record of patient : "+id;
    }

    @PostMapping
    public ResponseEntity<MedicalRecord>
    
    

}
