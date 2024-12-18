package com.cts.ClinicManagement.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DoctorDTO {

    @NotNull
	private String name;
    @NotNull
	private int age;
    @NotNull
	private String dept;
    @NotNull
	private String specialization;
}
