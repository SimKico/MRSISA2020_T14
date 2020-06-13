package com.mrsisa.eclinic.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mrsisa.eclinic.authority.JwtAuthenticationRequest;
import com.mrsisa.eclinic.model.Korisnik;
import com.mrsisa.eclinic.model.UserTokenState;
import com.mrsisa.eclinic.security.TokenUtils;
import com.mrsisa.eclinic.service.CustomUserDetailsService;

@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {
	
	@Autowired 
	TokenUtils tokenUtils;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest,
			HttpServletResponse response) throws AuthenticationException, IOException {
		System.out.println("trala");
		System.out.println("email: " + authenticationRequest.getEmail());
		System.out.println("password: " + authenticationRequest.getPassword());

		System.out.println("lal-1");
		UsernamePasswordAuthenticationToken uat = new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()); 
		
		System.out.println(uat);

		System.out.println("lal-2");
		 Authentication authentication;

		System.out.println("prije petlje");
		try {

			System.out.println("lal-3");
			authentication = authenticationManager.authenticate(uat);

			System.out.println(authentication);
			
		} catch (BadCredentialsException ex) {

			System.out.println(ex);
			System.out.println("ladfasdfasdfasd3");
			return new ResponseEntity<>("Bad credentials", HttpStatus.UNAUTHORIZED);
		}
		System.out.println("lal-4");
		// add username & password to context
		SecurityContextHolder.getContext().setAuthentication(authentication);
		System.out.println("lal5");
		// create token
		Korisnik  korisnik = (Korisnik) authentication.getPrincipal();
		String jwt = tokenUtils.generateToken(korisnik);
		int expiresIn = tokenUtils.getExpiredIn();
		
		System.out.println("lal");
		// return token as response to signify successful authentication
		return ResponseEntity.ok(new UserTokenState(jwt, expiresIn, korisnik.getPrijava().geteAdresa(), korisnik.getIme(), korisnik.getTip()));
		
		
	}
	
}
