package com.cts.ClinicManagement.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.ClinicManagement.dto.SignInDto;
import com.cts.ClinicManagement.dto.SignUpDto;
import com.cts.ClinicManagement.entity.Roles;
import com.cts.ClinicManagement.entity.User;
import com.cts.ClinicManagement.exceptions.ResourceAlreadyExistsException;
import com.cts.ClinicManagement.repository.RolesRepository;
import com.cts.ClinicManagement.repository.UserRepository;
import com.cts.ClinicManagement.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RolesRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String login(SignInDto signInDto) {
        
        Authentication authenticate = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(signInDto.getPhoneNumber(),
         signInDto.getPassword()));
        SecurityContextHolder
        .getContext()
        .setAuthentication(authenticate);
        return "User logged in successfully !!!!";
    }

    @Override
    public String register(SignUpDto signUpDto) {
        // checking if phone number already used
        if(userRepository.existsByPhoneNumber(signUpDto.getPhoneNumber())){
            throw new ResourceAlreadyExistsException(HttpStatus.BAD_REQUEST, "Phone number already exists");
        }
        if(userRepository.existsByEmail(signUpDto.getEmail())){
            throw new ResourceAlreadyExistsException(HttpStatus.BAD_REQUEST, "Email id already exists");
        }

        User user = new User();
        user.setName(signUpDto.getName());
        user.setPhoneNumber(signUpDto.getPhoneNumber());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

        Set<Roles> roles = new HashSet<>();
        Roles userRoles = roleRepository.findByRole("ROLE_USER").get();
        roles.add(userRoles);
        user.setRoles(roles);
        userRepository.save(user);

        return "User registered successfully !!!";

    }


}
