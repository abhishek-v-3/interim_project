package com.cts.ClinicManagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PatientDTO {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Size(min=1, max=110, message="Age should be be between 1 and 110")
    @NotBlank
    private int age;

    @NotBlank
    private String gender;
    
}
