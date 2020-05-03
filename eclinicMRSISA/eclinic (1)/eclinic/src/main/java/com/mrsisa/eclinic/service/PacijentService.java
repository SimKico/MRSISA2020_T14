package com.mrsisa.eclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsisa.eclinic.dto.PacijentDTO;
import com.mrsisa.eclinic.model.Pacijent;
import com.mrsisa.eclinic.repository.PacijentRepository;

@Service
public class PacijentService {

	@Autowired
	private PacijentRepository pacijentRepository;
	
	public Pacijent findOne(String id) {
//		Pacijent pacijent = (Pacijent) 	
		//Pacijent pacijent = pacijentRepository.findOneByJedBrojOsiguranika("123456");
		return pacijentRepository.findOneByJedBrojOsiguranika(id);
	}

	public Pacijent save(Pacijent pacijent) {
		
		return pacijentRepository.save(pacijent);
	}
	
	
	
}
