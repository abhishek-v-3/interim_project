package com.cts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Roles {

	@Id
	private int id;
	private String role;
	
	
}
