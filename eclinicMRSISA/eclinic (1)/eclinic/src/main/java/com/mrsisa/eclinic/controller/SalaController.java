package com.mrsisa.eclinic.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mrsisa.eclinic.dto.LjekarDTO;
import com.mrsisa.eclinic.dto.ZahtjevZaSaluDTO;
import com.mrsisa.eclinic.model.AdminKlinike;
import com.mrsisa.eclinic.model.Ljekar;
import com.mrsisa.eclinic.model.Operacija;
import com.mrsisa.eclinic.model.Pacijent;
import com.mrsisa.eclinic.model.ZahtjeviZaSale;
import com.mrsisa.eclinic.service.AdminKlinikeService;
import com.mrsisa.eclinic.service.EmailService;
import com.mrsisa.eclinic.service.KlinikaService;
import com.mrsisa.eclinic.service.LjekarService;
import com.mrsisa.eclinic.service.OperacijaService;
import com.mrsisa.eclinic.service.PacijentService;
import com.mrsisa.eclinic.service.ZahtjeviSalaService;

@RestController
@RequestMapping("sala")
public class SalaController {
	
	@Autowired
	ZahtjeviSalaService zsService;
	
	@Autowired
	AdminKlinikeService akService;
	
	@Autowired
	KlinikaService klinikaService;
	
	@Autowired
	OperacijaService operacijaService;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	LjekarService ljekarService;
	
	@Autowired
	PacijentService pacijentService;
	
	@RequestMapping(value = "/zahtjevi", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ROLE_ADMINK')")
	public ResponseEntity<List<ZahtjevZaSaluDTO>> getAll(@RequestParam("eadresa") String eadresa){
		
		List<ZahtjeviZaSale> lista = zsService.findAll();
		AdminKlinike ak = akService.getAKbyEadresa(eadresa);
		List<ZahtjevZaSaluDTO> zahtjevi = new ArrayList<ZahtjevZaSaluDTO>();
		
		for(ZahtjeviZaSale zs : lista) {
			if((zs.getLjekar().getKlinika().getNaziv()).equals(ak.getKlinika().getNaziv())) {
				zahtjevi.add(new ZahtjevZaSaluDTO(zs.getDatum(), zs.getSatnica(), zs.getSvrha(), zs.getLjekar().getId(), zs.getSala().getBrojSale()));
			}
		}
		if(zahtjevi.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(zahtjevi,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/zakazi", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ROLE_ADMINK')")
	public ResponseEntity<List<LjekarDTO>> getLjekari(@RequestParam("id") Long id){
		
		Ljekar ljekar = ljekarService.findOne(id);
		

		List<LjekarDTO> lista = new ArrayList<LjekarDTO>();
		Set<Ljekar> ljekari = new HashSet<>();
		
		for(Ljekar lj : ljekar.getKlinika().getLjekari()) {
			lista.add(new LjekarDTO(lj));
		}
		
		//Kako bih djelimicno zakazala, bez provjera
//		List<ZahtjeviZaSale> zs = zsService.findAll();
//		for(ZahtjeviZaSale z : zs) {
//			if((z.getLjekar().getIme()).equals(ljekar.getIme())) {
//				z.setPrihvacen(true);
//				z = zsService.save(z);
//				Operacija op = new Operacija();
//				ljekari.add(ljekar);
//				op.setLjekari(ljekari);
//				op.setSala(z.getSala());
//				op.setVrijemePocetka(z.getSatnica());
//				Pacijent pac = pacijentService.findOne(z.getSvrha());
//				op.setZdravstveniKarton(pac.getZdravstveniKarton());
//				op.setTrajanje(4);
//			}
//		}
		
		if(lista.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

}
