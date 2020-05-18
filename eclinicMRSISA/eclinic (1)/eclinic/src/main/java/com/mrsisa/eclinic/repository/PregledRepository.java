package com.mrsisa.eclinic.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrsisa.eclinic.model.Pregled;
import com.mrsisa.eclinic.model.Specijalizacija;
import com.mrsisa.eclinic.model.TipPregleda;

public interface PregledRepository extends JpaRepository<Pregled, Long> {
	List<Pregled> findAllBydatum(Date datum);
	List<Pregled> findAllBytipPregleda(TipPregleda tip);
	List<Pregled> findAllByljekar_id(Long id);
}
