package com.raj.enrollandverification.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raj.enrollandverification.constants.AppConstants;
import com.raj.enrollandverification.domains.Citizen;
import com.raj.enrollandverification.response.SSNResponse;
import com.raj.enrollandverification.services.CitizenService;

@RestController
@RequestMapping("/SSN")
public class SSNEnrollController {
	
	@Autowired
	CitizenService citizenService;

	@PostMapping(value = "/citizens", produces= "application/json", consumes ="application/json")
	public SSNResponse handleEnrollProcess(@RequestBody Citizen citizen) {
		
	//	System.out.println(citizen);
		Citizen savedCitizen = citizenService.addCitizen(citizen);
	//	System.out.println(savedCitizen);
		
		SSNResponse res = new SSNResponse();
		res.setSsn(showSSN(savedCitizen));
		res.setStatus(AppConstants.SUCC_MSG);

		return res;
	}

	private String showSSN(Citizen savedCitizen) {
		String ssn = savedCitizen.getSsn();
		StringBuilder str = new StringBuilder(ssn);
		str.insert(4, AppConstants.SSN_SEPERATOR);
		str.insert(7, AppConstants.SSN_SEPERATOR);
	
		return str.toString();
	}
	

	

}
