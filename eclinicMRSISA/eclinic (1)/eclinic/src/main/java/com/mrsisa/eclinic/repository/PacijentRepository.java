package com.mrsisa.eclinic.repository;

//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mrsisa.eclinic.model.Pacijent;

@Repository
public interface PacijentRepository extends JpaRepository<Pacijent, Long> {
	
	Pacijent findOneByJedBrojOsiguranika(String jedBrojOsiguranika);
	Pacijent findOneByprijava_eAdresa(String email);
	Pacijent findOneByEmail(String email);
}
