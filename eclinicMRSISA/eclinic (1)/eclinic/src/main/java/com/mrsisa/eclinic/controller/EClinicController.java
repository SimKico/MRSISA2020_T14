package com.mrsisa.eclinic.controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class EClinicController {

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello world";
	}
	
}
