package com.mrsisa.eclinic.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsisa.eclinic.dto.KlinikaDTO;
import com.mrsisa.eclinic.dto.LjekarDTO;
import com.mrsisa.eclinic.dto.PregledDTO;
import com.mrsisa.eclinic.dto.TipPregledaDTO;
import com.mrsisa.eclinic.model.Klinika;
import com.mrsisa.eclinic.model.Pregled;
import com.mrsisa.eclinic.model.Specijalizacija;
import com.mrsisa.eclinic.model.StatusPregleda;
import com.mrsisa.eclinic.model.TipPregleda;
import com.mrsisa.eclinic.repository.KlinikaRepository;
import com.mrsisa.eclinic.repository.PregledRepository;
import com.mrsisa.eclinic.repository.TipPregledaRepository;

@Service
public class PregledService {
	
	@Autowired 
	private PregledRepository pregledRepository;
//	@Autowired
//	private KlinikaRepository klinikaRepository;

	public List<PregledDTO> pretraziPreglede(Date datum, Specijalizacija tipPregleda) throws Exception{
		List<Pregled> pregled1 = pregledRepository.findAllBydatum(datum); 
		System.out.println("preglediDTO find all by datum");
		System.out.println(pregled1);
		List<PregledDTO> rezultatPretrage = new ArrayList<PregledDTO>();
		for(Pregled pregled : pregled1) {
			System.out.println("jedan od pregleda");
			System.out.println(pregled);
			if(pregled.getStatus().equals(StatusPregleda.slobodan)) {
				System.out.println("status pregleda");
				System.out.println(pregled.getStatus());
				if(pregled.getTipPregleda().getTip().equals(tipPregleda)) {
					LjekarDTO ljekarDTO = new LjekarDTO(pregled.getLjekar());
					TipPregledaDTO tipPregledaDTO = new TipPregledaDTO(pregled.getTipPregleda(),(Set<PregledDTO>) pregled);
					System.out.println(pregled.getLjekar().getKlinika().getAdresa());
					PregledDTO pregledDTO = new PregledDTO(pregled,ljekarDTO,
							tipPregledaDTO,
							pregled.getLjekar().getKlinika().getAdresa(),
							pregled.getLjekar().getKlinika().getGrad(),
							pregled.getLjekar().getKlinika().getOcjenaKlinike(),
							null
							);
					System.out.println("pregledDTO");
					System.out.println(pregledDTO);
					Set<LjekarDTO> ljekari = new HashSet();
					LjekarDTO ljekar = new LjekarDTO(pregled.getLjekar());
					ljekari.add(ljekar);
					rezultatPretrage.add(pregledDTO);
				}

			}

		}
		if (rezultatPretrage == null) {
            throw new Exception("Ne postoji trazeni pregled.");
        }

		return rezultatPretrage;
	}
	
	public List<Pregled> getAllByLjekarId(Long id){
		return pregledRepository.findAllByljekar_id(id);
	}

	public Pregled save(Pregled zakazaniPregled) {
		// TODO Auto-generated method stub
		return pregledRepository.save(zakazaniPregled);
	}
	
}
