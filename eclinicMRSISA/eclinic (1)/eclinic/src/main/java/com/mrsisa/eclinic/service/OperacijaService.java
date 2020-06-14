package com.mrsisa.eclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsisa.eclinic.model.Operacija;
import com.mrsisa.eclinic.repository.OperacijaRepository;

@Service
public class OperacijaService {
	
	@Autowired
	OperacijaRepository operacijaRepository;
	
	public Operacija findOne(Long id) {
		return operacijaRepository.findOneByidOperacije(id);
	}
	
	public Operacija save(Operacija operacija) {
		return operacijaRepository.save(operacija);
	}
	
	public List<Operacija> findAllByljekari_id(Long id){
		return operacijaRepository.findAllByljekari_id(id);
	}
}
