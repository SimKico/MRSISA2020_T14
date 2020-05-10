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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mrsisa.eclinic.model.ZahtjeviZaRegistraciju;
import com.mrsisa.eclinic.service.EmailService;
import com.mrsisa.eclinic.service.ZahtjeviRegService;

@RestController
@RequestMapping("zahtjeviReg")
public class ZahtjeviRegController {
	
	@Autowired
	private ZahtjeviRegService regService;
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<ZahtjeviZaRegistraciju>> getRegistrationRequests(){
		
		List<ZahtjeviZaRegistraciju> zahtjevi = new ArrayList<ZahtjeviZaRegistraciju>();
		zahtjevi = regService.findAllUnaccepted(false);
		
		return new ResponseEntity<List<ZahtjeviZaRegistraciju>>(zahtjevi, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/odbijanje")
	public ResponseEntity<Void> deleteReg(@RequestParam("eadresa") String eadresa) {

		ZahtjeviZaRegistraciju zahtjev = regService.findOneByEmail(eadresa);

		if (zahtjev != null) {
			regService.remove(zahtjev.getIdZahtjeva());
			emailService.sendDenialEmail(eadresa);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value = "/prihvatanje")
	public ResponseEntity<Void> acceptReg(@RequestParam("eadresa") String eadresa) {

		ZahtjeviZaRegistraciju zahtjev = regService.findOneByEmail(eadresa);

		if(zahtjev == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		}
		
		zahtjev.setPrihvacen(true);
		zahtjev = regService.save(zahtjev);
		emailService.sendAcceptanceEmail(eadresa);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "aktivacija/{id}")
	public ResponseEntity<String> createAccount(@PathVariable Integer id) {

		ZahtjeviZaRegistraciju zahtjev = regService.findOneById((long) id);

		if(zahtjev == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		}
		
		
		return new ResponseEntity<>("Vas nalog je aktiviran", HttpStatus.OK);
	}



}
