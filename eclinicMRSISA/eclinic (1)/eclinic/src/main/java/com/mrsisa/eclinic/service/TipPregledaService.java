package com.mrsisa.eclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsisa.eclinic.dto.TipPregledaDTO;
import com.mrsisa.eclinic.model.Klinika;
import com.mrsisa.eclinic.model.Specijalizacija;
import com.mrsisa.eclinic.model.TipPregleda;
import com.mrsisa.eclinic.repository.PregledRepository;
import com.mrsisa.eclinic.repository.TipPregledaRepository;

@Service
public class TipPregledaService {

	@Autowired 
	private TipPregledaRepository tipPregledaRepository;
	
	
	public List<TipPregleda> getAllBySpecijalicazija(Specijalizacija tip){
		return tipPregledaRepository.findAllBytip(tip);
	}
	
	public TipPregleda getOneBySpecijalizacija(Specijalizacija tip) {
		return tipPregledaRepository.findOneBytip(tip);
	}
}
