package com.mrsisa.eclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsisa.eclinic.model.ZahtjeviZaRegistraciju;
import com.mrsisa.eclinic.repository.ZahtjeviRegRepository;

@Service
public class ZahtjeviRegService {
	
	@Autowired
	ZahtjeviRegRepository regRepository;
	
	public ZahtjeviZaRegistraciju findOneByEmail(String email) {
		return regRepository.findOneByeAdresa(email);
	}
	
	public List<ZahtjeviZaRegistraciju> findAllUnaccepted(boolean accepted) {
		return regRepository.findAllByprihvacen(accepted);
	}
	
	public ZahtjeviZaRegistraciju save(ZahtjeviZaRegistraciju zahtjev) {
		return regRepository.save(zahtjev);
	}

}
