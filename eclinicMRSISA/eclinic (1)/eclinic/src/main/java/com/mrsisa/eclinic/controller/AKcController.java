package com.mrsisa.eclinic.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mrsisa.eclinic.dto.AKcDTO;
import com.mrsisa.eclinic.service.AKCService;

@RestController
@RequestMapping("/profilAKC")
public class AKcController {
	
	private AKCService akcService;
	
	@Autowired
	public AKcController(AKCService akcService) {
		this.akcService = akcService;
	}
	
	
	@RequestMapping(value = "")
	@ResponseBody
	public String prikaziProfil() {
		return "profilAKC";
	}
	
	@RequestMapping(value = "/{email}")
	public ResponseEntity<AKcDTO> getOneByEmail(@PathVariable("email") String eadresa){
		System.out.print(eadresa);
		AKcDTO akc = akcService.getAKCbyEmail(eadresa);
		return new ResponseEntity<AKcDTO>(akc, HttpStatus.OK);
	}
		
	
	

}
