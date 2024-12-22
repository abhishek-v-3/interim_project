package com.cts.ClinicManagement.service;

import com.cts.ClinicManagement.dto.SignInDto;

public interface AuthService {

    String login(SignInDto signInDto);

}
