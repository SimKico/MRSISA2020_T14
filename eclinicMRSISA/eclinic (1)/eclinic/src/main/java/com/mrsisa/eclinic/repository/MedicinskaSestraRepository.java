package com.mrsisa.eclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrsisa.eclinic.model.MedicinskaSestra;

public interface MedicinskaSestraRepository extends JpaRepository<MedicinskaSestra, Long>{
	
	MedicinskaSestra findOneByprijava_eAdresa(String eadresa);
	

}
