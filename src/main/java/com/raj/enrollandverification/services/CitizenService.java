package com.raj.enrollandverification.services;

import com.raj.enrollandverification.domains.Citizen;

public interface CitizenService {
	
	
	public Citizen findCitizenById(String ssn);

	public Citizen addCitizen(Citizen citizen);

}
