package com.mrsisa.eclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsisa.eclinic.model.AdminKlinickogCentra;
import com.mrsisa.eclinic.model.Prijava;
import com.mrsisa.eclinic.repository.PrijavaRepository;

@Service
public class PrijavaService {
	
	@Autowired
	PrijavaRepository prijavaRepository;
	
	public Prijava getPrijavabyEmail(String eadresa) {
		return prijavaRepository.findOneByeAdresa(eadresa);	
	}
	
	public Prijava getPrijavabyLozinka(String lozinka) {
		return prijavaRepository.findOneByLozinka(lozinka);		
	}
	
	public Prijava save(Prijava prijava) {
		return prijavaRepository.save(prijava);
	}

}
