package com.raj.enrollandverification.domains;

import java.util.Date;

import lombok.Data;

@Data
public class Citizen {
	
	private String ssn;
	private String firstName;
	private String lastName;
	private String gender;
	private Date dob;
	private String stateName;
	private byte[] photo;
	
}
