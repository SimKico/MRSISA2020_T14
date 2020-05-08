package com.mrsisa.eclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsisa.eclinic.model.KlinickiCentar;
import com.mrsisa.eclinic.repository.KcRepository;

@Service
public class KcService {
	
	@Autowired
	private KcRepository kcRepository;
	
	public KlinickiCentar getKcByName(String Id) {
		return kcRepository.findOneByKCid(Id);
		
	}

}
