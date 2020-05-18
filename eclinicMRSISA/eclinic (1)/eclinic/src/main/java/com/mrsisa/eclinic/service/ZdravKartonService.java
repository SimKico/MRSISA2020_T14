package com.mrsisa.eclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsisa.eclinic.model.ZdravstveniKarton;
import com.mrsisa.eclinic.repository.ZdravKartonRepository;

@Service
public class ZdravKartonService {
	
	@Autowired
	ZdravKartonRepository zkRepository;
	
	public ZdravstveniKarton findZkById(Long id) {
		return zkRepository.findOneByidKartona(id);
	}
	
	public ZdravstveniKarton save(ZdravstveniKarton zk) {
		return zkRepository.save(zk);
	}

}
