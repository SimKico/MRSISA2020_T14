package com.mrsisa.eclinic.service;

import java.util.List;

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
	
	public List<Lijek> findAll(){
		return lijekRepository.findAll();
	}
	
	public Lijek save(Lijek lijek) {
		return lijekRepository.save(lijek);
	}

}
