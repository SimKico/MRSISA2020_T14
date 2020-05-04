package com.mrsisa.eclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrsisa.eclinic.model.AdminKlinickogCentra;
import com.mrsisa.eclinic.model.KlinickiCentar;

public interface KcRepository extends JpaRepository<KlinickiCentar, Long> {
	
	KlinickiCentar findOneByKCid(String id);

}
