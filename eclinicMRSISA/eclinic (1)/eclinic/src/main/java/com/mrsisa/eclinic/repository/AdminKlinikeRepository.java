package com.mrsisa.eclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrsisa.eclinic.model.AdminKlinickogCentra;
import com.mrsisa.eclinic.model.AdminKlinike;

public interface AdminKlinikeRepository extends JpaRepository<AdminKlinike, Long> {
	
	AdminKlinike findOneById(Long id);
	
	AdminKlinike findOneByime(String ime);
	
}
