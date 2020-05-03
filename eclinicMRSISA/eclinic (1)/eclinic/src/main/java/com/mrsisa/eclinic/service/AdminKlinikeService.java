package com.mrsisa.eclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsisa.eclinic.model.AdminKlinickogCentra;
import com.mrsisa.eclinic.model.AdminKlinike;
import com.mrsisa.eclinic.repository.AdminKlinikeRepository;

@Service
public class AdminKlinikeService {
	
	@Autowired
	AdminKlinikeRepository akRepository;
	
	public AdminKlinike getAKCbyIme(String ime) {
		return akRepository.findOneByime(ime);
	}
	
	public AdminKlinike save(AdminKlinike ak) {
		return akRepository.save(ak);
	}

}
