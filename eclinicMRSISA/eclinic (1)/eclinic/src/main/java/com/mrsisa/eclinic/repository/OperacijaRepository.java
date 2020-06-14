package com.mrsisa.eclinic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrsisa.eclinic.model.Operacija;

public interface OperacijaRepository extends JpaRepository<Operacija, Long>{

		Operacija findOneByidOperacije(Long id);
		
		List<Operacija> findAllByljekari_id(Long id);
}
