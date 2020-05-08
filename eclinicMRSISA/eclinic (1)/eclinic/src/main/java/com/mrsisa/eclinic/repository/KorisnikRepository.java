package com.mrsisa.eclinic.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mrsisa.eclinic.model.Korisnik;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long>{
	
	Korisnik findOneByprijava_eAdresa(String eadresa);
	
	Page<Korisnik> findAll(Pageable  pageable);

}
