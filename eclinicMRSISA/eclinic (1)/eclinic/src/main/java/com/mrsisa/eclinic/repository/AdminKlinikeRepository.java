package com.mrsisa.eclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrsisa.eclinic.model.AdminKlinike;


public interface AdminKlinikeRepository extends JpaRepository<AdminKlinike, Long> {
	
	AdminKlinike findOneByid(Long id);
	
	AdminKlinike findOneByime(String ime);
}
