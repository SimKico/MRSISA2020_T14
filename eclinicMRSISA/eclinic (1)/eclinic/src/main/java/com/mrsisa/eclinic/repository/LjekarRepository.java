package com.mrsisa.eclinic.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.Tuple;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mrsisa.eclinic.model.Klinika;
import com.mrsisa.eclinic.model.Korisnik;
import com.mrsisa.eclinic.model.Ljekar;
@Repository
public interface LjekarRepository extends JpaRepository<Ljekar, Long>{
	//List<Ljekar> findAllById(Long id);
	Page<Ljekar> findAll(Pageable  pageable);

	@Query(value = "Select vrijeme_pocetka,trajanje from public.tabela_korisnika, public.pregledi, public.tip_pregleda\r\n" + 
			"where tabela_korisnika.id = ?2 and pregledi.datum_pregleda = ?1 and pregledi.sifra_pregleda = tip_pregleda.sifra\r\n" + 
			"\r\n" + 
			"\r\n" + 
			" ", nativeQuery = true)
	List<String> slobodniTermini(Date date1, Long id);
	
	}
