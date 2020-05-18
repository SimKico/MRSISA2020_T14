package com.mrsisa.eclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrsisa.eclinic.model.Dijagnoza;

public interface DijagnozaRepository extends JpaRepository<Dijagnoza, Long>{
	
	Dijagnoza findOneBynaziv(String naziv);

}
