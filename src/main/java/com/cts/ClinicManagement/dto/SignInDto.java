package com.cts.ClinicManagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class SignInDto {

    @NotNull(message = "Phone number cannot be null")
    @Pattern(regexp = "\\d{10}", message = "Phone number should be 10 digits")
    private Long phoneNumber;

    @NotBlank(message = "Password cannot be blank")
    private String password;
}
