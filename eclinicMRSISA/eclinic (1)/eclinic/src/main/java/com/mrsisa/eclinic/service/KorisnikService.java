package com.mrsisa.eclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsisa.eclinic.model.Korisnik;
import com.mrsisa.eclinic.repository.KorisnikRepository;

@Service
public class KorisnikService {
	
	@Autowired 
	KorisnikRepository korisnikRepository;
	
	public Korisnik getKorisnikByEmail(String eadresa) {
		return korisnikRepository.findOneByprijava_eAdresa(eadresa);
		
	}
	
	public Korisnik save(Korisnik korisnik) {
		return korisnikRepository.save(korisnik);
	}
	
	public List<Korisnik> findAll(){
		return korisnikRepository.findAll();
	}

}
