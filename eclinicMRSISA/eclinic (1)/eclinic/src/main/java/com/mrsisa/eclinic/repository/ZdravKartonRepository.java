package com.mrsisa.eclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrsisa.eclinic.model.ZdravstveniKarton;

public interface ZdravKartonRepository extends JpaRepository<ZdravstveniKarton, Long>{
	
	ZdravstveniKarton findOneByidKartona(Long id);
	
	

}
