package com.mrsisa.eclinic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrsisa.eclinic.model.IzvjestajPregleda;

public interface IzvjestajPregledaRepository extends JpaRepository<IzvjestajPregleda, Long> {
	
	IzvjestajPregleda findOneByizvjestajId(Long id);
	
	IzvjestajPregleda findOneBypregled_pregledId(Long id);
	
	//List<IzvjestajPregleda> findAllBykarton_id(Long id); 
}
