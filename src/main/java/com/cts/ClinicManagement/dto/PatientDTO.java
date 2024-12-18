package com.cts.ClinicManagement.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import lombok.Data;

@Data
public class PatientDTO {

    @NotBlank(message = "First name is mandatory")
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    @Min(value = 1, message = "Age should be at least 1")
    @Max(value = 110, message = "Age should not be more than 110")
    private int age;

    @NotBlank(message = "Gender is mandatory")
    @Pattern(regexp = "Male|Female|Other", message = "Gender should be Male, Female, or Other")
    private String gender;
}