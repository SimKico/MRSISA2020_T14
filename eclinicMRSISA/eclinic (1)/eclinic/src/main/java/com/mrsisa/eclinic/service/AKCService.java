package com.mrsisa.eclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsisa.eclinic.dto.AKcDTO;
import com.mrsisa.eclinic.model.AdminKlinickogCentra;
import com.mrsisa.eclinic.model.Prijava;
import com.mrsisa.eclinic.repository.AKcRepository;

@Service
public class AKCService {
	
	@Autowired
	private AKcRepository akcRepository;
	
	public AdminKlinickogCentra getAKCbyEmail(String eadresa) {
		return akcRepository.findOneByprijava_eAdresa(eadresa);
		
	}
	
	public AdminKlinickogCentra getAKCbyIme(String ime) {
		return akcRepository.findOneByime(ime);
	}
	
	public AdminKlinickogCentra save(AdminKlinickogCentra akc) {
		return akcRepository.save(akc);
	}
	
}
