package com.mrsisa.eclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mrsisa.eclinic.dto.AKcDTO;
import com.mrsisa.eclinic.service.AKCService;

@RestController
@RequestMapping("profilAKC")
public class AKcController {
	
	private AKCService akcService;
	
	@Autowired
	public AKcController(AKCService akcService) {
		this.akcService = akcService;
	}
	
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<AKcDTO> getOneByEmail(@RequestParam("eadresa") String eadresa){
		System.out.print(eadresa);
		AKcDTO akc = akcService.getAKCbyEmail(eadresa);
		return new ResponseEntity<AKcDTO>(akc, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/{email}/{ime}/{prezime}")
	public ResponseEntity<AKcDTO> getOneByEmail2(@PathVariable("email") String eadresa, @PathVariable("ime") String ime, @PathVariable("prezime") String prezime){
		System.out.print(eadresa);
		AKcDTO akc = akcService.getAKCbyEmail(eadresa);
		return new ResponseEntity<AKcDTO>(akc, HttpStatus.OK);
	}
		
	
	

}
