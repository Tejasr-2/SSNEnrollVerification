package com.raj.enrollandverification.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name= "Citizen_Details")
public class CitizenEntity {
	
	@Id
	@GenericGenerator(name="ssn_generator", strategy = "com.raj.enrollandverification.generators.SSNGenerator")
	@GeneratedValue(generator="ssn_generator")
	private String ssn;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String gender;
	@Column
	@Temporal(TemporalType.DATE)
	private Date dob;
	@Column
	private String stateName;
	@Lob
	private byte[] photo;

}
