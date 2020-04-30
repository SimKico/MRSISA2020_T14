package com.mrsisa.eclinic.repository;

//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.mrsisa.eclinic.model.Pacijent;


public interface PacijentRepository extends JpaRepository<Pacijent, Long> {

	Pacijent findOneByJedBrojOsiguranika(String jedBrojOsiguranika);
	
}
