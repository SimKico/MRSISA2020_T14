package com.mrsisa.eclinic.service;

import java.util.Date;
import java.util.List;

import javax.persistence.Tuple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsisa.eclinic.dto.KlinikaDTO;
import com.mrsisa.eclinic.dto.PretragaLjekaraDTO;
import com.mrsisa.eclinic.model.Klinika;
import com.mrsisa.eclinic.model.Ljekar;
import com.mrsisa.eclinic.model.Specijalizacija;
import com.mrsisa.eclinic.repository.LjekarRepository;

@Service
public class LjekarService {
	@Autowired
	private LjekarRepository ljekarRepository;
	
	public List<Ljekar> findAll(){
		return ljekarRepository.findAll();
	}
	
//	public List<Ljekar> findAllInKlinika(Long klinika_id){
//		return ljekarRepository.findAllById(klinika_id);
//	}
	public Ljekar findOne(Long id) {
		return ljekarRepository.findById(id).orElseGet(null);
	}
	public List<String> slobodniTermini(Date date1, Long id) {
		return ljekarRepository.slobodniTermini(date1, id);
	}
	
	public Ljekar findOneByEmail(String email) {
		return ljekarRepository.findOneByprijava_eAdresa(email);
	}

//	public List<Ljekar> findOneBy(PretragaLjekaraDTO podaci) {
//		
//		return ljekarRepository.findOneByPodaci(podaci.getIme(), podaci.getPrezime(), Specijalizacija.valueOf(podaci.getTip()), podaci.getOcjena());
//	}

	public List<Ljekar> findOneByime(String ime) {
		return ljekarRepository.findOneByime(ime);
	}
}
