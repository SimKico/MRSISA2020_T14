package com.mrsisa.eclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mrsisa.eclinic.dto.AKcDTO;
import com.mrsisa.eclinic.model.AdminKlinickogCentra;
import com.mrsisa.eclinic.model.Prijava;
import com.mrsisa.eclinic.service.AKCService;
import com.mrsisa.eclinic.service.PrijavaService;

@RestController
@RequestMapping("profilAKC")
public class AKcController {
	
	private AKCService akcService;
	
	private PrijavaService prijavaService;
	
	@Autowired
	public AKcController(AKCService akcService, PrijavaService prijavaService) {
		this.akcService = akcService;
		this.prijavaService = prijavaService;
	}
	
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<AKcDTO> getOneByEmail(@RequestParam("eadresa") String eadresa){
		System.out.print(eadresa);
		AdminKlinickogCentra akc = akcService.getAKCbyEmail(eadresa);
		return new ResponseEntity<AKcDTO>(new AKcDTO(akc), HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/{email}/{ime}/{prezime}")
	public ResponseEntity<AKcDTO> getOneByEmail2(@PathVariable("email") String eadresa, @PathVariable("ime") String ime, @PathVariable("prezime") String prezime){
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
		
	
	

}
