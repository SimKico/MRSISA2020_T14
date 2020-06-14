package com.mrsisa.eclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsisa.eclinic.model.ZahtjeviZaSale;
import com.mrsisa.eclinic.repository.ZahtjeviSalaRepository;

@Service
public class ZahtjeviSalaService {
	
	@Autowired
	ZahtjeviSalaRepository zsRepository;
	
	public ZahtjeviZaSale findOne(Long id) {
		return zsRepository.findOneByid(id);
	}
	
	public List<ZahtjeviZaSale> findAll(){
		return zsRepository.findAll();
	}
	
	public ZahtjeviZaSale save(ZahtjeviZaSale zs) {
		return zsRepository.save(zs);
	}

}
