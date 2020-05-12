package com.mrsisa.eclinic.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mrsisa.eclinic.model.Klinika;

public interface KlinikaRepository extends JpaRepository<Klinika, Long>{

	Klinika findOneBynaziv(String naziv);
	
	Page<Klinika> findAll(Pageable  pageable);
	
	
}
