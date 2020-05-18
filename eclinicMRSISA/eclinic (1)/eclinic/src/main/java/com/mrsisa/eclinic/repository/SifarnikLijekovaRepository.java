package com.mrsisa.eclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrsisa.eclinic.model.SifarnikLijekova;

public interface SifarnikLijekovaRepository extends JpaRepository<SifarnikLijekova, Long> {
	
	SifarnikLijekova findOneBysifLid(Long id);

}
