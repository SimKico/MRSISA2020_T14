package com.mrsisa.eclinic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mrsisa.eclinic.dto.AKcDTO;
import com.mrsisa.eclinic.dto.AdminKlinikeDTO;
import com.mrsisa.eclinic.dto.KlinikaDTO;
import com.mrsisa.eclinic.model.AdminKlinickogCentra;
import com.mrsisa.eclinic.model.AdminKlinike;
import com.mrsisa.eclinic.model.Klinika;
import com.mrsisa.eclinic.model.Prijava;
import com.mrsisa.eclinic.service.AKCService;
import com.mrsisa.eclinic.service.AdminKlinikeService;
import com.mrsisa.eclinic.service.KlinikaService;
import com.mrsisa.eclinic.service.PrijavaService;

@RestController
@RequestMapping("profilAKC")
public class AKcController {
	
	private AKCService akcService;
	
	private PrijavaService prijavaService;
	
	private KlinikaService klinikaService;
	
	private AdminKlinikeService akService;
	
	@Autowired
	public AKcController(AKCService akcService, PrijavaService prijavaService, KlinikaService klinikaService, AdminKlinikeService akService) {
		this.akcService = akcService;
		this.prijavaService = prijavaService;
		this.klinikaService = klinikaService;
		this.akService = akService;
	}
	
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<AKcDTO> getOneByEmail(@RequestParam("eadresa") String eadresa){
		System.out.print(eadresa);
		AdminKlinickogCentra akc = akcService.getAKCbyEmail(eadresa);
		return new ResponseEntity<AKcDTO>(new AKcDTO(akc), HttpStatus.OK);
	}
	
	@PostMapping(value = "/dodajAKC", consumes =  "application/json")
	public ResponseEntity<AKcDTO> saveAKC(@RequestBody AKcDTO akcdto) {
		System.out.println(akcdto);
		AdminKlinickogCentra akc = new AdminKlinickogCentra();
		
		Prijava prijava = new Prijava();
		prijava.seteAdresa(akcdto.getEadresa());
		prijava.setLozinka(akcdto.getLozinka());
		
		akc.setAktivan(false);
		akc.setIme(akcdto.getIme());
		akc.setPrezime(akcdto.getPrezime());
		akc.setPrijava(prijava);
		akc.setPredefinisaniAdmin(false);
		akc.setDodijeljenaLozinka(true);
		
		prijava = prijavaService.save(prijava);
		akc = akcService.save(akc);
		return new ResponseEntity<AKcDTO>(akcdto, HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/registrujKliniku", consumes =  "application/json")
	public ResponseEntity<KlinikaDTO> saveKlinika(@RequestBody KlinikaDTO klinikaDto) {
		System.out.println(klinikaDto);
		Klinika klinika = new Klinika();
		klinika.setNaziv(klinikaDto.getNaziv());
		klinika.setGrad(klinikaDto.getGrad());
		klinika.setOcjenaKlinike(klinikaDto.getOcjenaKlinike());
		klinika.setTipKlinike(klinikaDto.getTipKlinike());
		
		klinika = klinikaService.save(klinika);
	
		return new ResponseEntity<KlinikaDTO>(klinikaDto, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/ucitajKlinike",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<KlinikaDTO>> getAllKlinika(){	
		List<Klinika> listaKlinika = klinikaService.findAll();
		List<KlinikaDTO> klinike = new ArrayList<KlinikaDTO>();
		
		for(Klinika klinika : listaKlinika) {
			klinike.add(new KlinikaDTO(klinika));
		}
		
		return new ResponseEntity<>(klinike, HttpStatus.OK);

	}
	
	@PostMapping(value = "/registrujAdminaKlinike", consumes =  "application/json")
	public ResponseEntity<AdminKlinikeDTO> saveAdminKl(@RequestBody AdminKlinikeDTO akDto) {
		
		Klinika klinika = klinikaService.findOneKlinkaByNaziv(akDto.getNazivKlinike());
		
		Prijava prijava = new Prijava();
		prijava.seteAdresa(akDto.getEadresa());
		prijava.setLozinka(akDto.getLozinka());
		
		AdminKlinike ak = new AdminKlinike();
		ak.setAktivan(false);
		ak.setDodijeljenaLozinka(true);
		ak.setIme(akDto.getIme());
		ak.setPrezime(akDto.getPrezime());
		ak.setPrijava(prijava);
		ak.setKlinika(klinika);
		
		prijava = prijavaService.save(prijava);
		ak = akService.save(ak);
		
		return new ResponseEntity<AdminKlinikeDTO>(akDto, HttpStatus.CREATED);
	}
		
	
	

}
