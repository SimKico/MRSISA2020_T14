package com.mrsisa.eclinic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mrsisa.eclinic.model.KlinickiCentar;
import com.mrsisa.eclinic.model.Korisnik;
import com.mrsisa.eclinic.model.Pacijent;
import com.mrsisa.eclinic.model.Prijava;
import com.mrsisa.eclinic.model.ZahtjeviZaRegistraciju;
import com.mrsisa.eclinic.model.ZdravstveniKarton;
import com.mrsisa.eclinic.service.EmailService;
import com.mrsisa.eclinic.service.KcService;
import com.mrsisa.eclinic.service.KorisnikService;
import com.mrsisa.eclinic.service.PacijentService;
import com.mrsisa.eclinic.service.PrijavaService;
import com.mrsisa.eclinic.service.ZahtjeviRegService;
import com.mrsisa.eclinic.service.ZdravKartonService;

@RestController
@RequestMapping("zahtjeviReg")
public class ZahtjeviRegController {
	
	@Autowired
	private ZahtjeviRegService regService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	KorisnikService korisnikService;
	
	@Autowired
	PacijentService pacijentService;
	
	@Autowired
	PrijavaService prijavaService;
	
	@Autowired
	KcService kcService;
	
	@Autowired
	ZdravKartonService zkService;
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<ZahtjeviZaRegistraciju>> getRegistrationRequests(){
		
		List<ZahtjeviZaRegistraciju> zahtjevi = new ArrayList<ZahtjeviZaRegistraciju>();
		zahtjevi = regService.findAllUnaccepted(false);
		
		return new ResponseEntity<List<ZahtjeviZaRegistraciju>>(zahtjevi, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/odbijanje")
	public ResponseEntity<String> deleteReg(@RequestParam("eadresa") String eadresa) {

		ZahtjeviZaRegistraciju zahtjev = regService.findOneByEmail(eadresa);

		if (zahtjev != null) {
			regService.remove(zahtjev.getIdZahtjeva());
			emailService.sendDenialEmail(eadresa, "Odluka administratora klinike. ");
			return new ResponseEntity<>("Zahtjev je odbijen",HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Zahtjev nije pronađen", HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value = "/prihvatanje")
	public ResponseEntity<String> acceptReg(@RequestParam("eadresa") String eadresa) {
		
		ZahtjeviZaRegistraciju zahtjev = regService.findOneByEmail(eadresa);

		if(zahtjev == null) {
			return new ResponseEntity<>("Zahtjev nije pronađen!",HttpStatus.NOT_FOUND);
		
		}
		
		Korisnik korisnik = korisnikService.getKorisnikByEmail(eadresa);
		
		if(korisnik != null) {
			regService.remove(zahtjev.getIdZahtjeva());
			emailService.sendDenialEmail(eadresa, "Korisnik sa tom eadresom već postoji!");
			return new ResponseEntity<>("Korisnik sa tom eadresom već postoji!", HttpStatus.BAD_REQUEST);
		}
		
		Pacijent pacijent = pacijentService.findOne(zahtjev.getJbo());
		
		if(pacijent!=null) {
			regService.remove(zahtjev.getIdZahtjeva());
			emailService.sendDenialEmail(eadresa, "Korisnik sa tim jedinstvenim brojem osiguranika vec postoji!");
			return new ResponseEntity<>("Korisnik sa tim jedinstvenim brojem osiguranika vec postoji!", HttpStatus.BAD_REQUEST);
		}
		
		
		zahtjev.setPrihvacen(true);
		zahtjev = regService.save(zahtjev);
		emailService.sendAcceptanceEmail(eadresa);
		return new ResponseEntity<>("Korisnik je dodan!",HttpStatus.OK);
	}
	
	@GetMapping(value = "aktivacija/{id}")
	public ResponseEntity<String> createAccount(@PathVariable Integer id) {

		ZahtjeviZaRegistraciju zahtjev = regService.findOneById((long) id);

		if(zahtjev == null) {
			return new ResponseEntity<>("Zahtjev je već obrađen!", HttpStatus.NOT_FOUND);
		}
		
		if(!zahtjev.isPrihvacen()) {
			return new ResponseEntity<>("Zahtjev nije prihvaćen!", HttpStatus.BAD_REQUEST);
		}
		
		KlinickiCentar kc = kcService.getKcByName("Eclinic");
		Pacijent noviPacijent = new Pacijent(zahtjev);
		ZdravstveniKarton zk = new ZdravstveniKarton();
		
		Prijava prijava = new Prijava();
		prijava.seteAdresa(zahtjev.geteAdresa());
		prijava.setLozinka(zahtjev.getLozinka());
		
		
		noviPacijent.setPrijava(prijava);
		noviPacijent.setZdravstveniKarton(zk);
		
		zk = zkService.save(zk);
		prijava = prijavaService.save(prijava);
		kc.getKorisnik().add(noviPacijent);
		noviPacijent = pacijentService.save(noviPacijent);
		
		regService.remove((long) id);
		
//		HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(URI.create("http://localhost:8000/"));
		
		return new ResponseEntity<>("Vaš nalog je aktiviran - " + noviPacijent.getIme()+ " " + noviPacijent.getPrezime(), HttpStatus.OK);
        
	}



}
