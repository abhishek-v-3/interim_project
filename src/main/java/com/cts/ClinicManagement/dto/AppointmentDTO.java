package com.cts.ClinicManagement.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class AppointmentDTO {

    @NotNull(message = "Appointment date is mandatory")
    @FutureOrPresent(message = "Appointment date must be in the present or future")
    private LocalDateTime appointmentDate;

    @NotBlank(message = "Status is mandatory")
    private String status;

    private String notes;


}
