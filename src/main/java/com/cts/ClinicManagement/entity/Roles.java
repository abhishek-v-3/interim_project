package com.cts.ClinicManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Roles {

	@Id
	private int id;
	private String role;
	
	
}
