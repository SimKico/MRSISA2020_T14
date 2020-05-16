package com.mrsisa.eclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrsisa.eclinic.model.SifarnikDijagnoza;

public interface SifarnikDijagnozaRepository extends JpaRepository<SifarnikDijagnoza, Long> {
	
	SifarnikDijagnoza findOneBysifDid(Long id);

}
