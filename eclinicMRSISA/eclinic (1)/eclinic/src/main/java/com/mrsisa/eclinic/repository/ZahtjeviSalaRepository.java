package com.mrsisa.eclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrsisa.eclinic.model.ZahtjeviZaSale;

public interface ZahtjeviSalaRepository extends JpaRepository<ZahtjeviZaSale, Long>{
	
	ZahtjeviZaSale findOneByid(Long id);
	
	
}
