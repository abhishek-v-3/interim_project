package com.cts.ClinicManagement.dto;

import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;

@Getter
public class MedicalRecordDTO {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Recorded date cannot be null")
    @PastOrPresent(message = "Recorded date must be in the past or present")
    private LocalDate recordedDate;

    @NotBlank(message = "Description cannot be blank")
    private String description;

}
