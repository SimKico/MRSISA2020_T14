package com.mrsisa.eclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsisa.eclinic.dto.KlinikaDTO;
import com.mrsisa.eclinic.model.Klinika;
import com.mrsisa.eclinic.repository.KlinikaRepository;

@Service
public class KlinikaService {

	@Autowired 
	private KlinikaRepository klinikaRepository;
		
	public List<Klinika> findAll() {
		return klinikaRepository.findAll();
	}
	
	public Klinika findOneKlinkaByNaziv(String name)
	{
		return klinikaRepository.findOneByNaziv(name);
	}
}
