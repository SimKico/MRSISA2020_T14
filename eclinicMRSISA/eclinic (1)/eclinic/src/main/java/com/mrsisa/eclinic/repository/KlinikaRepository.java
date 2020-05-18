package com.mrsisa.eclinic.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mrsisa.eclinic.model.Klinika;
import com.mrsisa.eclinic.model.Ljekar;
import com.mrsisa.eclinic.model.Specijalizacija;
@Repository
public interface KlinikaRepository extends JpaRepository<Klinika, Long>{

	Klinika findOneBynaziv(String naziv);
	
	Page<Klinika> findAll(Pageable  pageable);
	
	List<Klinika> findAllByljekari(Ljekar ljekari);
	
	@Query(value ="Select klinika_id from public.tabela_korisnika "+
			" where tabela_korisnika.specijalizacija = 0 and "+
			" tabela_korisnika.id in (select ljekar_id "+
								" from public.zahtjevi_odsustava "+
								  " where prihvacen = false or (prihvacen=true and ?1 < to_char(pocetak,'DD-MM-YYYY') or ?1 > to_char(kraj,'DD-MM-YYYY'))) "+
									" and tabela_korisnika.id in (select ljekar_id "+
																" from public.pregledi"+
																" where to_char(datum_pregleda,'DD-MM-YYYY') != ?1 or"+
																" (to_char(datum_pregleda,'DD-MM-YYYY') = ?1))",nativeQuery = true)
	List<Long> search(String datum, Specijalizacija tipPregleda);

	Klinika findOneByid(Long id);
	

}
