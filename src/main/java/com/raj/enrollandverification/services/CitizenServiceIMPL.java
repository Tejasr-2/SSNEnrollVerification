package com.raj.enrollandverification.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.enrollandverification.domains.Citizen;
import com.raj.enrollandverification.entities.CitizenEntity;
import com.raj.enrollandverification.repository.CitizenRepo;


@Service
public class CitizenServiceIMPL implements CitizenService {

	@Autowired
	CitizenRepo citizenRepo;
	
	
	
	@Override
	public Citizen findCitizenById(String ssn) {
	
		Optional<CitizenEntity> option = citizenRepo.findById(ssn);
		Citizen citizen = new Citizen();
		if(option.isPresent())
			BeanUtils.copyProperties(option.get(), citizen);
		
		
		return citizen;
	}

	@Override
	public Citizen addCitizen(Citizen citizen) {
		
		CitizenEntity citizenEntity = new CitizenEntity();
		BeanUtils.copyProperties(citizen, citizenEntity);
		
		CitizenEntity savedEntity = citizenRepo.save(citizenEntity);
		
		BeanUtils.copyProperties(savedEntity, citizen);
		return citizen;
	}

}
