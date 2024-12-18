package com.cts.ClinicManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ClinicManagement.dto.SignInDto;
import com.cts.ClinicManagement.dto.SignUpDto;
import com.cts.ClinicManagement.repository.PatientRepository;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    PatientRepository patientRepository;

    @PostMapping("/signup")
    public String signup(@RequestBody(required = true) SignUpDto signUpDto){

        if(patientRepository.existsByPhoneNumber(2L)){
            return "Sign up fialed";
        }

        return "Sign Up successfull";
    }

    @PostMapping("/signin")
    public String signin(@RequestBody(required = true) SignInDto signInDto){
        return "Login is successful";
    }

    
    
}
