package com.mrsisa.eclinic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrsisa.eclinic.model.Prijava;
import com.mrsisa.eclinic.model.Specijalizacija;
import com.mrsisa.eclinic.model.TipPregleda;

public interface TipPregledaRepository extends JpaRepository<TipPregleda, Long>   {
	List<TipPregleda> findAllBytip(Specijalizacija tip);
	
}
