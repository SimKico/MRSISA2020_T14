package com.mrsisa.eclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrsisa.eclinic.model.Lijek;

public interface LijekRepository extends JpaRepository<Lijek, Long>{
	
	Lijek findOneBynaziv(String naziv);

}
