package com.mrsisa.eclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsisa.eclinic.model.Recept;
import com.mrsisa.eclinic.repository.ReceptRepository;

@Service
public class ReceptService {

	@Autowired
	ReceptRepository receptRepository;
	
	public Recept findOneById(Long id) {
		return receptRepository.findOneByreceptId(id);
	}
	
	public List<Recept> findAllByIzvjestaj(Long id){
		return receptRepository.findAllByIzvjestajPregleda_izvjestajId(id);
	}
	
	public Recept save(Recept recept) {
		return receptRepository.save(recept);
	}
}
