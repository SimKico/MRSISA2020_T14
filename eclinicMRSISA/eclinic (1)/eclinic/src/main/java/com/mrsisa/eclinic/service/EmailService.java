package com.mrsisa.eclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.mrsisa.eclinic.model.ZahtjeviZaRegistraciju;

@Service
public class EmailService {
	
	@Autowired
	JavaMailSender emailSender;
	
	@Autowired
	ZahtjeviRegService regService;
	
	@Async
	public void sendDenialEmail(String email, String reason) {
		
		//ZahtjeviZaRegistraciju zahtjev = regService.findOneByEmail(email);
		
		SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo("kovacevic.natasa.95@gmail.com"); 
        message.setSubject("Eclinic - Zahtjev za registraciju"); 
        message.setText("Odbijen vam je zahtjev za registraciju." + reason);
        emailSender.send(message);
	}
	
	@Async
	public void sendAcceptanceEmail(String email) {
		
		ZahtjeviZaRegistraciju zahtjev = regService.findOneByEmail(email);
		
		SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo("kovacevic.natasa.95@gmail.com"); 
        message.setSubject("Eclinic - Aktivacija naloga"); 
        message.setText("Aktivirajte nalog klikom na aktivacioni link: \n\n" 
        		+ "http://localhost:8080/zahtjeviReg/aktivacija/"+zahtjev.getIdZahtjeva());
        emailSender.send(message);
	}

}
