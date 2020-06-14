package com.mrsisa.eclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsisa.eclinic.model.Authority;
import com.mrsisa.eclinic.repository.AuthorityRepository;

@Service
public class AuthorityService {
	
	@Autowired
	AuthorityRepository aRep;
	
	public Authority findByName(String name) {
		return aRep.findOneByname(name);
	}
	

}
