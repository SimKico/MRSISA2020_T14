package com.mrsisa.eclinic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrsisa.eclinic.model.AdminKlinickogCentra;
import com.mrsisa.eclinic.model.Prijava;

public interface PrijavaRepository extends JpaRepository<Prijava, Long> {
	
	Prijava findOneByeAdresa(String eadresa);
	
	Prijava findOneByLozinka(String lozinka);
	
	List<Prijava> findAll();
	


}
