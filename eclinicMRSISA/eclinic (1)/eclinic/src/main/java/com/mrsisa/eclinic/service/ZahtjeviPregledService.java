package com.mrsisa.eclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsisa.eclinic.model.ZahtjeviZaPregled;
import com.mrsisa.eclinic.repository.ZahtjeviPregledRepository;

@Service
public class ZahtjeviPregledService {
	
	@Autowired
	ZahtjeviPregledRepository zahtjeviZaPregledRepository;
	
	public ZahtjeviZaPregled save(ZahtjeviZaPregled zahtjev) {
		return zahtjeviZaPregledRepository.save(zahtjev);
	}
}
