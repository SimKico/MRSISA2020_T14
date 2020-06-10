package com.mrsisa.eclinic.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mrsisa.eclinic.model.Ljekar;
import com.mrsisa.eclinic.model.Sala;

public interface SalaRepository extends JpaRepository<Sala, Integer> {
	
	Sala findOneByBrojSale(int brojSale);
	
	Sala findOneByklinika_id(Long klinika_id);
	
	Page<Sala> findAll(Pageable  pageable);
	
}
