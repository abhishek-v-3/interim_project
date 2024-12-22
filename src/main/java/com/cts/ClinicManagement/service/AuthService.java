package com.cts.ClinicManagement.service;

import com.cts.ClinicManagement.dto.SignInDto;
import com.cts.ClinicManagement.dto.SignUpDto;

public interface AuthService {

    String login(SignInDto signInDto);
    String register(SignUpDto signUpDto);

}
