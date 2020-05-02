package com.mrsisa.eclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrsisa.eclinic.model.AdminKlinickogCentra;

public interface AKcRepository extends JpaRepository<AdminKlinickogCentra, Long> {
	
	AdminKlinickogCentra findOneById(Long id);
	
	AdminKlinickogCentra findOneByime(String ime);

	AdminKlinickogCentra findOneByprijava_eAdresa(String email);

}
