package com.cts.ClinicManagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SignInDto {

    @NotBlank(message = "user name cannot be blank")
    private String userNameorEmail;

    @NotBlank(message = "password cannot be blank")
    private String password;
}
