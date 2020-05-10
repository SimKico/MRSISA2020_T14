package com.mrsisa.eclinic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mrsisa.eclinic.model.ZahtjeviZaRegistraciju;

public interface ZahtjeviRegRepository extends JpaRepository<ZahtjeviZaRegistraciju, Long>{
	
	ZahtjeviZaRegistraciju findOneByeAdresa(String eadresa);
	
	void deleteByeAdresa(String eadresa);
	
	List<ZahtjeviZaRegistraciju> findAllByprihvacen(boolean prihvacen);
	
	List<ZahtjeviZaRegistraciju> findAll();

}
