package com.mrsisa.eclinic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mrsisa.eclinic.model.ZahtjeviZaRegistraciju;
import com.mrsisa.eclinic.service.ZahtjeviRegService;

@RestController
@RequestMapping("zahtjeviReg")
public class ZahtjeviRegController {
	
	@Autowired
	private ZahtjeviRegService regService;
	
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
		return new ResponseEntity<>(HttpStatus.OK);
	}


}
