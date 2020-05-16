package com.mrsisa.eclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsisa.eclinic.model.SifarnikDijagnoza;
import com.mrsisa.eclinic.repository.SifarnikDijagnozaRepository;

@Service
public class SifarnikDijagnozaService {
	
	@Autowired
	SifarnikDijagnozaRepository sdRepository;
	
	public SifarnikDijagnoza findSDById(Long id) {
		return sdRepository.findOneBysifDid(id);
	}
}
