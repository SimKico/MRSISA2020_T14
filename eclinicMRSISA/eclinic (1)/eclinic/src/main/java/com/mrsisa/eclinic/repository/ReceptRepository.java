package com.mrsisa.eclinic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrsisa.eclinic.model.Recept;

public interface ReceptRepository extends JpaRepository<Recept, Long>{
	
	Recept findOneByreceptId(Long id);
	
	List<Recept> findAllByIzvjestajPregleda_izvjestajId(Long id);

}
