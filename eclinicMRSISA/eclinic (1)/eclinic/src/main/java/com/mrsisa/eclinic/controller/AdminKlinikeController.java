package com.mrsisa.eclinic.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mrsisa.eclinic.dto.AdminKlinikeDTO;
import com.mrsisa.eclinic.dto.KlinikaDTO;
import com.mrsisa.eclinic.dto.LjekarDTO;
import com.mrsisa.eclinic.dto.TipPregledaDTO;
import com.mrsisa.eclinic.model.AdminKlinike;
import com.mrsisa.eclinic.model.Klinika;
import com.mrsisa.eclinic.model.Ljekar;
import com.mrsisa.eclinic.model.Prijava;
import com.mrsisa.eclinic.model.TipPregleda;
import com.mrsisa.eclinic.service.AdminKlinikeService;
import com.mrsisa.eclinic.service.KlinikaService;
import com.mrsisa.eclinic.service.LjekarService;

@RestController
@RequestMapping("/adminKlinikeHomepage")
@CrossOrigin("*")
public class AdminKlinikeController {

	private AdminKlinike ulogovanAK;
	@Autowired
	private AdminKlinikeService adminKlinikeService;
	@Autowired
	private LjekarService ljekariService;

	@Autowired
	private KlinikaService klinikaService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<AdminKlinikeDTO> getHomepageAK() {
		AdminKlinike adminKlinike = adminKlinikeService.getAKbyEadresa("admink1@eclinic.com");
		ulogovanAK = adminKlinike;
		return new ResponseEntity<>(new AdminKlinikeDTO(adminKlinike), HttpStatus.OK);
	}

	@PutMapping(value = "/mojProfil", consumes = "application/json")
	public ResponseEntity<AdminKlinikeDTO> saveAK(@RequestBody AdminKlinikeDTO akDTO) {
		/*
		 * AdminKlinike ak = new AdminKlinike();
		 * 
		 * Prijava prijava = new Prijava(); prijava.seteAdresa(akDTO.getEadresa());
		 * prijava.setLozinka(akDTO.getLozinka());
		 * 
		 * ak.setAktivan(false); ak.setIme(akDTO.getIme());
		 * ak.setPrezime(akDTO.getPrezime()); ak.setPrijava(prijava);
		 */
		Prijava prijava = new Prijava();
		prijava.seteAdresa(akDTO.getEadresa());
		prijava.setLozinka(akDTO.getLozinka());

		ulogovanAK.setIme(akDTO.getIme());
		ulogovanAK.setPrezime(akDTO.getPrezime());
		ulogovanAK.setPrijava(prijava);

		ulogovanAK = adminKlinikeService.save(ulogovanAK);
		return new ResponseEntity<AdminKlinikeDTO>(new AdminKlinikeDTO(ulogovanAK), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/mojProfil", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<AdminKlinikeDTO> getProfilAK(@RequestParam("eadresa") String eadresa) {
		AdminKlinike adminKlinike = adminKlinikeService.getAKbyEadresa(eadresa);
		return new ResponseEntity<>(new AdminKlinikeDTO(adminKlinike), HttpStatus.OK);
	}

	@RequestMapping(value = "/profilKlinike", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<KlinikaDTO> getKlinika() {
		Set<LjekarDTO> ljekariDTO = new HashSet<LjekarDTO>();
		List<Klinika> sveKlinike = klinikaService.findAll();
		Klinika klinika = null;
		List<Ljekar> ljekari = ljekariService.findAll();

		for (Klinika k : sveKlinike) {
			if(k.getId() == ulogovanAK.getKlinika().getId())
				klinika = k;
		}
		if (klinika != null) {
			for (Ljekar ljekar : ljekari) {
				if (ljekar.getKlinika().getId() == klinika.getId())
					ljekariDTO.add(new LjekarDTO(ljekar));
			}
		}
		
		System.out.println("************\n************\n" + ljekariDTO.size());		

		return new ResponseEntity<>(new KlinikaDTO(klinika, ljekariDTO,null,null), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/dodavanjeTermina", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<KlinikaDTO> dodavanjeTerminaLoad(){
		Set<LjekarDTO> ljekariDTO = new HashSet<LjekarDTO>();
		Set<TipPregledaDTO> tipoviPregledaDTO = new HashSet<TipPregledaDTO>();
		List<Klinika> sveKlinike = klinikaService.findAll();
		Klinika klinika = null;
		List<Ljekar> ljekari = ljekariService.findAll();

		for (Klinika k : sveKlinike) {
			if(k.getId() == ulogovanAK.getKlinika().getId())
				klinika = k;
		}
		if (klinika != null) {
			for (Ljekar ljekar : ljekari) {
				if (ljekar.getKlinika().getId() == klinika.getId())
					ljekariDTO.add(new LjekarDTO(ljekar));
			}
			for (TipPregleda tp : klinika.getTipoviPregleda()) {
				tipoviPregledaDTO.add(new TipPregledaDTO(tp));
			}
			
		}
		System.out.println("*********\n Broj lekara direktno preko klinike: " + klinika.getLjekari().size());
		System.out.println("********\n BROJ TIPOVA PREGLEDA:"+klinika.getTipoviPregleda().size());

		return new ResponseEntity<>(new KlinikaDTO(klinika, ljekariDTO,tipoviPregledaDTO,null), HttpStatus.OK);
	}
	 

}
