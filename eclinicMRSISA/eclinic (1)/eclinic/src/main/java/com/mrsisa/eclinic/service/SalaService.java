package com.mrsisa.eclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsisa.eclinic.model.Sala;
import com.mrsisa.eclinic.repository.SalaRepository;



@Service
public class SalaService {

	@Autowired
	private SalaRepository salaRepository;
	
	public List<Sala> findAll(){
		return salaRepository.findAll();
	}
	

	public Sala findOne(Integer broj_sale) {
		return salaRepository.findOneByBrojSale(broj_sale);
	}
	
	public Sala findOneByklinika_id(Long klinika_id) {
		return salaRepository.findOneByklinika_id(klinika_id);
	}
}
