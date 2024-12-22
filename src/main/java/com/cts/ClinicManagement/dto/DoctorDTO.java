package com.cts.ClinicManagement.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DoctorDTO {
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Min(value = 25, message = "Age should be at least 25")
    @Max(value = 70, message = "Age should not be more than 70")
    private int age;

    @NotBlank(message = "Department is mandatory")
    private String dept;

    @NotBlank(message = "Specialization is mandatory")
    private String specialization;
}
