package com.mrsisa.eclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsisa.eclinic.model.Lijek;
import com.mrsisa.eclinic.repository.LijekRepository;

@Service
public class LijekService {
	
	@Autowired
	LijekRepository lijekRepository;
	
	public Lijek findLijekByName(String lijek) {
		return lijekRepository.findOneBynaziv(lijek);
	}
	
	public Lijek save(Lijek lijek) {
		return lijekRepository.save(lijek);
	}

}
