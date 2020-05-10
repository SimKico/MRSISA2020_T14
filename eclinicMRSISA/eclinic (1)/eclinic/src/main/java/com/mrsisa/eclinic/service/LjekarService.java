package com.mrsisa.eclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsisa.eclinic.dto.KlinikaDTO;
import com.mrsisa.eclinic.model.Klinika;
import com.mrsisa.eclinic.model.Ljekar;
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
}