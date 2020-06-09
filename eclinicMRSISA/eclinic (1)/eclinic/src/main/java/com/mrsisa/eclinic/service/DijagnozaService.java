package com.mrsisa.eclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsisa.eclinic.model.Dijagnoza;
import com.mrsisa.eclinic.repository.DijagnozaRepository;

@Service
public class DijagnozaService {
	
	@Autowired
	DijagnozaRepository dijagnozaRepository;
	
	public Dijagnoza findDijagnozaByName(String dijagnoza) {
		return dijagnozaRepository.findOneBynaziv(dijagnoza);
	}
	
	public List<Dijagnoza> findAll() {
		return dijagnozaRepository.findAll();
	}
	
	public Dijagnoza save(Dijagnoza dijagnoza) {
		return dijagnozaRepository.save(dijagnoza);
	}

}
