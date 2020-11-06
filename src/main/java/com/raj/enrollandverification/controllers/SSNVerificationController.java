package com.raj.enrollandverification.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raj.enrollandverification.domains.Citizen;
import com.raj.enrollandverification.exceptionhandler.CitizenNotFoundException;
import com.raj.enrollandverification.services.CitizenService;

@RestController
@RequestMapping("/SSN")
public class SSNVerificationController {

	@Autowired
	CitizenService citizenService;
	
	@GetMapping("/citizens/{citizenSSN}")
	public Citizen verifySSN(@PathVariable("citizenSSN")String citizenSSN) {
		
		String ssn = ssnToString(citizenSSN);
		System.out.println(ssn);
		Citizen citizen = citizenService.findCitizenById(ssn);
		
		//Exception
		if(citizen.getFirstName()==null)
		{
			throw new CitizenNotFoundException();
		}
		
		return citizen;
	}

	private String ssnToString(String citizenSSN) {
		StringBuilder str = new StringBuilder(citizenSSN);
		try {
		str.deleteCharAt(4);
		str.deleteCharAt(6);
		}
		catch (Exception e) {
			throw new CitizenNotFoundException();
		}
		return str.toString();
	}
	
	
	
	
}
