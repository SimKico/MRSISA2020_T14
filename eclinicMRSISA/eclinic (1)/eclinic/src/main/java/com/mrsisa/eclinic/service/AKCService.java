package com.mrsisa.eclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsisa.eclinic.dto.AKcDTO;
import com.mrsisa.eclinic.model.AdminKlinickogCentra;
import com.mrsisa.eclinic.repository.AKcRepository;

@Service
public class AKCService {
	
	@Autowired
	private AKcRepository akcRepository;
	
	public AKcDTO getAKCbyEmail(String eadresa) {
		AdminKlinickogCentra akc = akcRepository.findOneByprijava_eAdresa(eadresa);
		
		return new AKcDTO(akc);
	}
	
	public AKcDTO getAKCbyIme(String ime) {
		AdminKlinickogCentra akc = akcRepository.findOneByprijava_eAdresa(ime);
		
		return new AKcDTO(akc);
	}
	
}
