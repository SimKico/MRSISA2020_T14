package com.mrsisa.eclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsisa.eclinic.model.AdminKlinickogCentra;
import com.mrsisa.eclinic.model.AdminKlinike;
import com.mrsisa.eclinic.repository.AdminKlinikeRepository;

@Service
public class AdminKlinikeService {

	@Autowired
	private AdminKlinikeRepository adminKlinikeRepository;

	public AdminKlinike findOne(Long id) {
		return adminKlinikeRepository.findOneById(id);
	}
	public AdminKlinike save(AdminKlinike ak) {
		return adminKlinikeRepository.save(ak);
	}
}
