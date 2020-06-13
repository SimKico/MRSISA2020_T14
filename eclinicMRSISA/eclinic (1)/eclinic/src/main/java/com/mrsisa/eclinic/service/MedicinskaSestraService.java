package com.mrsisa.eclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsisa.eclinic.model.MedicinskaSestra;
import com.mrsisa.eclinic.repository.MedicinskaSestraRepository;
import com.mrsisa.eclinic.repository.ReceptRepository;

@Service
public class MedicinskaSestraService {
	
	@Autowired
	MedicinskaSestraRepository msRepository;
	
	public MedicinskaSestra findByEmail(String eadresa) {
		return msRepository.findOneByprijava_eAdresa(eadresa);
	}
	
	public MedicinskaSestra save(MedicinskaSestra sestra) {
		return msRepository.save(sestra);
	}
	
	public void remove(MedicinskaSestra sestra) {
		msRepository.delete(sestra);
	}

}
