package com.mrsisa.eclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsisa.eclinic.model.SifarnikLijekova;
import com.mrsisa.eclinic.repository.SifarnikLijekovaRepository;

@Service
public class SifarnikLijekovaService {
	
	@Autowired
	SifarnikLijekovaRepository slRepository;
	
	public SifarnikLijekova findSLById(Long id) {
		return slRepository.findOneBysifLid(id);
	}

}
