package com.cts.ClinicManagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignUpDto {

    @NotBlank(message = "user name cannot be blank")
    private String userName;

    @Email
    private String email;

    @NotBlank(message = "password cannot be blank")
    @Size(min = 8,max =32,message="Password should have minimum 8 and maximum 32 characters")
    private String password;
}
