package com.cts.ClinicManagement.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Address {

	private String houseName;
	private String area;
	private String streetName;
	private String landMark;
	private String state;
	private String district;
	private String country;
	private String pincode;
	
}
