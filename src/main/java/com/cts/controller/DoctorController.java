package com.cts.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {

    @GetMapping("/")
    public String getAllDoctors( int id){
        return "This is the details for all doctors";
    }

    @GetMapping("/{id}")
    public String getDoctorById(@PathVariable("id") int id){
        return "This is the details for the doctor :"+id;
    }

   
    
}
