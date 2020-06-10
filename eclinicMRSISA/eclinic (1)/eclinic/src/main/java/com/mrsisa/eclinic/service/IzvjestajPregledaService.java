package com.mrsisa.eclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsisa.eclinic.model.IzvjestajPregleda;
import com.mrsisa.eclinic.repository.IzvjestajPregledaRepository;

@Service
public class IzvjestajPregledaService {

	@Autowired
	IzvjestajPregledaRepository ipRepository;
	
	public IzvjestajPregleda findIzjvPregledaById(Long id) {
		return ipRepository.findOneByizvjestajId(id);
	}
	
//	public List<IzvjestajPregleda> findAllByKarton(Long id){
//		return ipRepository.findAllBykarton_id(id);
//	}
//	
	public IzvjestajPregleda save(IzvjestajPregleda ip) {
		return ipRepository.save(ip);
	}
}
