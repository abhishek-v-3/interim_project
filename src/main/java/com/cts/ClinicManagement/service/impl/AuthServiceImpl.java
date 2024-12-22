package com.cts.ClinicManagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.cts.ClinicManagement.dto.SignInDto;
import com.cts.ClinicManagement.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public String login(SignInDto signInDto) {
        
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInDto.getPhoneNumber(), signInDto.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authenticate);
        return "User logged in successfully !!!!";
    }


}
