package com.mrsisa.eclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mrsisa.eclinic.dto.AKcDTO;
import com.mrsisa.eclinic.dto.AdminKlinikeDTO;
import com.mrsisa.eclinic.dto.PacijentDTO;
import com.mrsisa.eclinic.model.AdminKlinickogCentra;
import com.mrsisa.eclinic.model.AdminKlinike;
import com.mrsisa.eclinic.model.Pacijent;
import com.mrsisa.eclinic.model.Prijava;
import com.mrsisa.eclinic.service.AdminKlinikeService;
import com.mrsisa.eclinic.service.KlinikaService;



@RestController
@RequestMapping("/adminKlinikeHomepage")
@CrossOrigin("*")
public class AdminKlinikeController {
	
	@Autowired
	private AdminKlinikeService adminKlinikeService;
	
	@Autowired 
	private KlinikaService klinikaService;

	
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<AdminKlinikeDTO> getHomepageAK()
	{
		 AdminKlinike adminKlinike = adminKlinikeService.findOne((long) 3);
		 return new ResponseEntity<>(new AdminKlinikeDTO(adminKlinike), HttpStatus.OK);
	}
	
	@PostMapping(value = "/mojProfil", consumes =  "application/json")
	public ResponseEntity<AdminKlinikeDTO> saveAK(@RequestBody AdminKlinikeDTO akdto) {
		AdminKlinike ak = new AdminKlinike();
		ak.setAktivan(false);
		ak.setIme(akdto.getIme());
		ak.setPrezime(akdto.getPrezime());
		ak.setId(akdto.getId());
		
		ak = adminKlinikeService.save(ak);
		return new ResponseEntity<AdminKlinikeDTO>(akdto, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/mojProfil",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<AdminKlinikeDTO> getProfilAK(@RequestParam("id") Long id){
		AdminKlinike adminKlinike = adminKlinikeService.findOne(id);
		return new ResponseEntity<>(new AdminKlinikeDTO(adminKlinike), HttpStatus.OK);
	}

}
