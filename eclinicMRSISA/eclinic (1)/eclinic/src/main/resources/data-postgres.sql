--Dodavanje sifarnika dijagnoza--
insert into sifarnik_dijagnoza(naziv_sifarnika)values('Sifarnik dijagnoza');
--Dodavanje sifarnika lijekova--
insert into sifarnik_lijekova(naziv_sifarnika)values('Sifarnik lijekova');


----KARTONI--
insert into zdravstveni_karton(krvna_grupa, alergije, dioptrija, visina, tezina) values ('AB', null, null, 0, 0);
insert into zdravstveni_karton(krvna_grupa, alergije, dioptrija, visina, tezina) values ('A', null, null, 0, 0);

--Dodavanje klinickog centra--
insert into klinicki_centar(kc_id,sif_dij_id, sif_lijek_id)values('Eclinic',1, 1);

--Dodavanje tip_pregleda --
insert into tip_pregleda(cijena, sifra, trajanje, tip)values(12.5, 'specoft',1,0);
insert into tip_pregleda(cijena, sifra, trajanje, tip)values(20, 'specpulmo',1,1);	

--Dodavanje klinika--
insert into klinike(grad,adresa, naziv_klinike, ocjena_klinike, tip_klinike, kc_id)
values('Beograd','adr','VMA', '4', 0, 'Eclinic');

insert into klinike(grad,adresa, naziv_klinike, ocjena_klinike, tip_klinike, kc_id)
values('Banjaluka','adr','UKC', '4', 0, 'Eclinic');

insert into klinike(grad,adresa, naziv_klinike, ocjena_klinike, tip_klinike, kc_id)
values('Sarajevo','adr' ,'Kosevo', '2', 0, 'Eclinic');

insert into klinike(grad,adresa, naziv_klinike, ocjena_klinike, tip_klinike, kc_id)
values('Zagreb','adr', 'Nasa Klinika', '5', 3, 'Eclinic');

insert into klinike(grad, adresa,naziv_klinike, ocjena_klinike, tip_klinike, kc_id)
values('Novi Sad','adr' ,'Klinika Svjetlost', '3', 4, 'Eclinic');

insert into klinike(grad, adresa,naziv_klinike, ocjena_klinike, tip_klinike, kc_id)
values('Sarajevo','adr', 'Nova Bolnica', '4', 3, 'Eclinic');

insert into klinike(grad, adresa,naziv_klinike, ocjena_klinike, tip_klinike, kc_id)
values('Zagreb','adr', 'Dr Pavlovic', '5', 3, 'Eclinic');

insert into klinike(grad,adresa, naziv_klinike, ocjena_klinike, tip_klinike, kc_id)
values('Novi Sad','adr', 'Klinika Diva', '3', 4, 'Eclinic');
----KORISNICI--------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------

insert into tabela_prijava(eadresa, lozinka)values('user', '$2a$12$6D9aDtMhyfGJF/H5BjoQdeZYUoXItPpaEi7z.ctMT8tl57PWvOEqC');
insert into tabela_prijava(eadresa, lozinka)values('pacijent1', '$2a$12$6D9aDtMhyfGJF/H5BjoQdeZYUoXItPpaEi7z.ctMT8tl57PWvOEqC');
insert into tabela_prijava(eadresa, lozinka)values('pacijent2@eclinic.com', '$2a$12$6D9aDtMhyfGJF/H5BjoQdeZYUoXItPpaEi7z.ctMT8tl57PWvOEqC');
insert into tabela_prijava(eadresa, lozinka)values('vaso@eclinic.com', '$2a$12$6D9aDtMhyfGJF/H5BjoQdeZYUoXItPpaEi7z.ctMT8tl57PWvOEqC');
insert into tabela_prijava(eadresa, lozinka)values('dr1@eclinic.com', '$2a$12$6D9aDtMhyfGJF/H5BjoQdeZYUoXItPpaEi7z.ctMT8tl57PWvOEqC');
insert into tabela_prijava(eadresa, lozinka)values('admink1@eclinic.com', '$2a$12$6D9aDtMhyfGJF/H5BjoQdeZYUoXItPpaEi7z.ctMT8tl57PWvOEqC');
------Admin klinike--
insert into tabela_korisnika(user_type, aktivan, ime, prezime, dodijeljena_lozinka, predefinisani, info, ocjena, radno_vrijeme, specijalizacija, adresa, broj_telefona, drzava, grad,jbo,prijava_id,klinika_id,karton_id, kc_id, enabled, last_password_reset_date,email, password) 
values('AK', true, 'Nikola', 'Nikic', true, null, null, null, null, null, null, null, null, null, null,'admink1@eclinic.com', 1,null, 'Eclinic', true,'2020-01-01 21:58:58', 'admink1@eclinic.com', '$2a$12$6D9aDtMhyfGJF/H5BjoQdeZYUoXItPpaEi7z.ctMT8tl57PWvOEqC');

--Dodavanje predefinisanog admina klinickog centra--
insert into tabela_korisnika(user_type, aktivan, ime, prezime, dodijeljena_lozinka, predefinisani, info, ocjena, radno_vrijeme, specijalizacija, adresa, broj_telefona, drzava, grad,jbo,prijava_id,klinika_id,karton_id, kc_id, enabled, last_password_reset_date,email, password) 
	values('AC', true, 'Marko', 'Maricic', true, true, null, null, null, null, null, null, null, null, null, 'user', null,null, 'Eclinic', true, '2020-01-01 21:58:58', 'user', '$2a$12$6D9aDtMhyfGJF/H5BjoQdeZYUoXItPpaEi7z.ctMT8tl57PWvOEqC');

--pacijenti--
insert into tabela_korisnika(user_type, aktivan, ime, prezime, 		dodijeljena_lozinka, predefinisani, info, ocjena, radno_vrijeme, specijalizacija, adresa, 		broj_telefona, drzava, grad,		jbo,	prijava_id,	klinika_id,karton_id, kc_id, enabled,  last_password_reset_date,	email, 			password)
						values('P', false, 'Snjezana', 'Simic', false, null, null, null, null, null, 'Hajduk Veljka bb', '066617528', 'Bosna', 'Derventa', '123456', 'pacijent1', null,1,  'Eclinic',  true,	'2020-01-01 21:58:58', 			'pacijent1', '$2a$12$6D9aDtMhyfGJF/H5BjoQdeZYUoXItPpaEi7z.ctMT8tl57PWvOEqC');

insert into tabela_korisnika(user_type, prijava_id, kc_id, ime, prezime, jbo, adresa, grad, drzava, broj_telefona, karton_id, enabled,last_password_reset_date,email, password )
	values('P', 'pacijent2@eclinic.com', 'Eclinic', 'Vaso', 'Vasic', '222222', 'Jevrjeska', 'Novi Sad', 'Srbija', '066553334', 2 , true,'2020-01-01 21:58:58', 'pacijent2@eclinic.com', '$2a$12$6D9aDtMhyfGJF/H5BjoQdeZYUoXItPpaEi7z.ctMT8tl57PWvOEqC');

	--Ljekari--
insert into tabela_prijava(eadresa, lozinka)values('ljekar1@eclinic.com', '$2a$12$6D9aDtMhyfGJF/H5BjoQdeZYUoXItPpaEi7z.ctMT8tl57PWvOEqC');
insert into tabela_korisnika(user_type, ime, prezime,info, ocjena,radno_vrijeme,specijalizacija,prijava_id,klinika_id,karton_id, kc_id,enabled, last_password_reset_date,email, password)
values('LJ', 'Stojan', 'Mutikasa','Studirao u Beogradu.',5,'09:00-17:00',0, 'ljekar1@eclinic.com',1,null,'Eclinic' , true,'2020-01-01 21:58:58','ljekar1@eclinic.com', '$2a$12$6D9aDtMhyfGJF/H5BjoQdeZYUoXItPpaEi7z.ctMT8tl57PWvOEqC');

insert into tabela_prijava(eadresa, lozinka)values('ljekar2@eclinic.com', '$2a$12$6D9aDtMhyfGJF/H5BjoQdeZYUoXItPpaEi7z.ctMT8tl57PWvOEqC');
insert into tabela_korisnika(user_type, ime, prezime,info, ocjena,radno_vrijeme,specijalizacija,prijava_id,klinika_id,karton_id, kc_id,enabled, last_password_reset_date,email, password)
values('LJ', 'Stanko', 'Stanic','Studirao u Novom Sadu.',5,'09:00-17:00',0, 'ljekar2@eclinic.com',2,null,'Eclinic', true,'2020-01-01 21:58:58','ljekar2@eclinic.com', '$2a$12$6D9aDtMhyfGJF/H5BjoQdeZYUoXItPpaEi7z.ctMT8tl57PWvOEqC' );

insert into tabela_prijava(eadresa, lozinka)values('ljekar3@eclinic.com', '$2a$12$6D9aDtMhyfGJF/H5BjoQdeZYUoXItPpaEi7z.ctMT8tl57PWvOEqC');
insert into tabela_korisnika(user_type, ime, prezime,info, ocjena,radno_vrijeme,specijalizacija,prijava_id,klinika_id,karton_id, kc_id, enabled, last_password_reset_date,email, password)
values('LJ', 'Vladimir', 'Stojanovic','Studirao u Beogradu.',5,'09:00-17:00',0, 'ljekar3@eclinic.com',3,null,'Eclinic', true,'2020-01-01 21:58:58' ,'ljekar3@eclinic.com', '$2a$12$6D9aDtMhyfGJF/H5BjoQdeZYUoXItPpaEi7z.ctMT8tl57PWvOEqC');

insert into tabela_prijava(eadresa, lozinka)values('ljekar4@eclinic.com', '$2a$12$6D9aDtMhyfGJF/H5BjoQdeZYUoXItPpaEi7z.ctMT8tl57PWvOEqC');
insert into tabela_korisnika(user_type, ime, prezime,info, ocjena,radno_vrijeme,specijalizacija,prijava_id,klinika_id,karton_id, kc_id, enabled, last_password_reset_date,email, password)
values('LJ', 'Micomir', 'Perkovic','Studirao u Banjaluci.',5,'09:00-17:00',1, 'ljekar4@eclinic.com',4,null,'Eclinic' , true,'2020-01-01 21:58:58','ljekar4@eclinic.com', '$2a$12$6D9aDtMhyfGJF/H5BjoQdeZYUoXItPpaEi7z.ctMT8tl57PWvOEqC');

insert into tabela_prijava(eadresa, lozinka)values('ljekar5@eclinic.com', '$2a$12$6D9aDtMhyfGJF/H5BjoQdeZYUoXItPpaEi7z.ctMT8tl57PWvOEqC');
insert into tabela_korisnika(user_type, ime, prezime,info, ocjena,radno_vrijeme,specijalizacija,prijava_id,klinika_id,karton_id, kc_id, enabled, last_password_reset_date,email, password)
values('LJ', 'Vladimir', 'Velimirovic','Studirao u Beogradu.',5,'09:00-17:00',1, 'ljekar5@eclinic.com',1,null,'Eclinic', true ,'2020-01-01 21:58:58','ljekar5@eclinic.com', '$2a$12$6D9aDtMhyfGJF/H5BjoQdeZYUoXItPpaEi7z.ctMT8tl57PWvOEqC');
--
--nsert into tabela_korisnika(type, aktivan, ime, prezime, dodijeljena_lozinka, predefinisani, info, ocjena, radno_vrijeme, specijalizacija, adresa, broj_telefona, drzava, grad,jbo,prijava_id,klinika_id,karton_id, kc_id) 
--						values('P', false, 'Snjezana', 'Simic', false, null, null, null, null, null, 'Hajduk Veljka bb', '066617528', 'Bosna', 'Derventa', '123456', 'pacijent1@eclinic.com', null,1, 'Eclinic');

-- GIVE AUTHORITIES TO USERS  ============================================================================================================
INSERT INTO authority( name) VALUES ('ROLE_ADMINKC');
INSERT INTO authority( name) VALUES ('ROLE_ADMINK');
INSERT INTO authority( name) VALUES ('ROLE_PACIENT');
INSERT INTO authority( name) VALUES ('ROLE_LJEKAR');
INSERT INTO authority( name) VALUES ('ROLE_SESTRA');

INSERT INTO user_authority (user_id, authority_id) VALUES (1, 2);
INSERT INTO user_authority (user_id, authority_id) VALUES (2, 1);
INSERT INTO user_authority (user_id, authority_id) VALUES (3, 3);
INSERT INTO user_authority (user_id, authority_id) VALUES (4, 3);
INSERT INTO user_authority (user_id, authority_id) VALUES (5, 4);
INSERT INTO user_authority (user_id, authority_id) VALUES (6, 4);
INSERT INTO user_authority (user_id, authority_id) VALUES (7, 4);
INSERT INTO user_authority (user_id, authority_id) VALUES (8, 4);
INSERT INTO user_authority (user_id, authority_id) VALUES (9, 4); 	

--Dodavanje pregleda--
insert into pregledi(datum_pregleda, popust, status, vrijeme_pocetka, sifra_pregleda, ljekar_id)
			values('Mon Jun 01 00:00:00 CEST 2020', 0,0, '09:00', 'specoft',4);
insert into pregledi(datum_pregleda, popust, status, vrijeme_pocetka, sifra_pregleda, ljekar_id)
			values('Mon Jun 03 00:00:00 CEST 2020', 0,0, '10:00', 'specoft',5);
insert into pregledi(datum_pregleda, popust, status, vrijeme_pocetka, sifra_pregleda, ljekar_id)
			values('Mon Jun 04 00:00:00 CEST 2020', 0,0, '11:00', 'specoft',5);
insert into pregledi(datum_pregleda, popust, status, vrijeme_pocetka, sifra_pregleda, ljekar_id)
			values('Mon Jun 05 00:00:00 CEST 2020', 0,0, '11:00', 'specoft',6);
insert into pregledi(datum_pregleda, popust, status, vrijeme_pocetka, sifra_pregleda,ljekar_id)
			values('Mon Jun 02 00:00:00 CEST 2020', 0,1, '08:00', 'specpulmo',7);
			
insert into pregledi(datum_pregleda, popust, status, vrijeme_pocetka, sifra_pregleda, ljekar_id)
			values('Mon Jun 01 00:00:00 CEST 2020', 0,1, '11:00', 'specpulmo',7);
		
insert into pregledi(datum_pregleda, popust, status, vrijeme_pocetka, sifra_pregleda, ljekar_id)
			values('Mon Jun 01 00:00:00 CEST 2020', 0,0, '07:00', 'specoft',6);
			
insert into pregledi(datum_pregleda, popust, status, vrijeme_pocetka, sifra_pregleda, ljekar_id)
			values('Mon Jun 01 00:00:00 CEST 2020', 0,1, '12:00', 'specpulmo',8);

----Dodavanje pregleda--
insert into pregledi(datum_pregleda, popust, status, vrijeme_pocetka, sifra_pregleda, ljekar_id, klinika_id, pacijent_id)
			values('Mon May 27 00:00:00 CEST 2020', 0,0, '18:00', 'specoft',4, 1, 3);
insert into pregledi(datum_pregleda, popust, status, vrijeme_pocetka, sifra_pregleda,ljekar_id, klinika_id, pacijent_id)
			values('Mon May 18 00:00:00 CEST 2020', 0,0, '19:00', 'specoft',5, 2, 3);
			
insert into pregledi(datum_pregleda, popust, status, vrijeme_pocetka, sifra_pregleda, ljekar_id, klinika_id, pacijent_id)
			values('Mon May 18 00:00:00 CEST 2020', 0,0, '20:00', 'specpulmo',7, 1, 3);
			
insert into pregledi(datum_pregleda, popust, status, vrijeme_pocetka, sifra_pregleda, ljekar_id, klinika_id, pacijent_id)
			values('Mon May 18 00:00:00 CEST 2020', 0,0, '21:00', 'specpulmo',8, 2, 3);
			
insert into pregledi(datum_pregleda, popust, status, vrijeme_pocetka, sifra_pregleda, ljekar_id, klinika_id, pacijent_id)
			values('Mon May 18 00:00:00 CEST 2020', 0,1, '22:00', 'specoft',6, 1, 4);
	
			
----zahtjevi za odsustvo--
insert into zahtjevi_odsustava(kraj, pocetak, prihvacen, tip_odsustva, ljekar_id)
						values('2001-08-28','2001-07-27',true, 0, 5);
						
insert into zahtjevi_odsustava(kraj, pocetak, prihvacen, tip_odsustva, ljekar_id)
						values('2001-08-28','2001-07-29',true, 0, 6);
						
----tipovi pregleda u klinici--
insert into tipovi_pregledauklinici(klinika_id,sifra)
							values(1,'specoft');
insert into tipovi_pregledauklinici(klinika_id,sifra)
							values(2,'specoft');
insert into tipovi_pregledauklinici(klinika_id,sifra)
							values(2,'specpulmo');
							
----Dodavanje pregleda--
--insert into pregledi(datum_pregleda, popust, status, vrijeme_pocetka, sifra_pregleda, ljekar_id, klinika_id, pacijent_id)
--			values('Mon Jun 18 00:00:00 CEST 2020', 0,1, '18:00', 'specoft',4, 1, 2);
--insert into pregledi(datum_pregleda, popust, status, vrijeme_pocetka, sifra_pregleda,ljekar_id, klinika_id, pacijent_id)
--			values('Mon Jun 18 00:00:00 CEST 2020', 0,1, '19:00', 'specoft',5, 2, 3);
--			
--insert into pregledi(datum_pregleda, popust, status, vrijeme_pocetka, sifra_pregleda, ljekar_id, klinika_id, pacijent_id)
--			values('Mon Jun 18 00:00:00 CEST 2020', 0,1, '20:00', 'specoft',6, 3, 2);
--			
--insert into pregledi(datum_pregleda, popust, status, vrijeme_pocetka, sifra_pregleda, ljekar_id, klinika_id, pacijent_id)
--			values('Mon Jun 18 00:00:00 CEST 2020', 0,1, '21:00', 'specoft',7, 4, 3);
--			
--insert into pregledi(datum_pregleda, popust, status, vrijeme_pocetka, sifra_pregleda, ljekar_id, klinika_id, pacijent_id)
--			values('Mon Jun 18 00:00:00 CEST 2020', 0,1, '22:00', 'specoft',8, 1, 2);
--			
--Dodavanje lijekova--
insert into lijekovi(naziv_lijeka, sif_lijek_id) values ('Ibuprofen', 1);
insert into lijekovi(naziv_lijeka, sif_lijek_id) values ('Paracetamol', 1);
insert into lijekovi(naziv_lijeka, sif_lijek_id) values ('Hemomicin', 1);
			
--Dodavanje dijagnoza--
insert into dijagnoze(naziv_dijagnoze, sif_dij_id) values ('Upala sinusa', 1);
insert into dijagnoze(naziv_dijagnoze, sif_dij_id) values ('Upala grla', 1);
insert into dijagnoze(naziv_dijagnoze, sif_dij_id) values ('Migrena', 1);

--Dodavanje sala--
insert into sale values (1, 1);
insert into sale values (2, 2);
insert into sale values (3, 3);
insert into sale values (4, 4);
insert into sale values (5, 5);
insert into sale values (6, 1);
insert into sale values (7, 1);

--Zahtjevi za registraciju--
insert into zahtjevi_registracija(eAdresa, lozinka, ime, prezime, jbo, adresa, grad, drzava, broj_telefona)
values('mile@eclinic.com', 'miloz', 'Mile', 'Milic', '144555', 'Stepe Stapanovica bb', 'Banja Luka', 'BiH', '066555444' );

insert into zahtjevi_registracija(eAdresa, lozinka, ime, prezime, jbo, adresa, grad, drzava, broj_telefona)
values('pero@eclinic.com', 'peloz', 'Pero', 'Peric', '111111', 'Gavrila Principa', 'Derventa', 'BiH', '066775444' );

insert into zahtjevi_registracija(eAdresa, lozinka, ime, prezime, jbo, adresa, grad, drzava, broj_telefona)
values('boro@eclinic.com', 'boloz', 'Boro', 'Boric', '143355', 'Gajeva', 'Novi Sad', 'Srbija', '066558844' );

insert into zahtjevi_registracija(eAdresa, lozinka, ime, prezime, jbo, adresa, grad, drzava, broj_telefona)
values('vaso@eclinic.com', 'boloz', 'Vaso', 'Vasic', '222222', 'Jevrjeska', 'Novi Sad', 'Srbija', '066553334' );

insert into zahtjevi_registracija(eAdresa, lozinka, ime, prezime, jbo, adresa, grad, drzava, broj_telefona)
values('Rade@eclinic.com', 'boloz', 'Rade', 'Radic', '123456', 'Cara Dusana', 'Novi Sad', 'Srbija', '066599844' );

--Pregledi--
insert into pregledi(datum_pregleda, popust, status, vrijeme_pocetka, sifra_pregleda, ljekar_id, klinika_id, pacijent_id)
			values('Sun Jun 14 02:30:00 CEST 2020', 0,1, '13:30', 'specoft',5, 1, 3);
insert into pregledi(datum_pregleda, popust, status, vrijeme_pocetka, sifra_pregleda, ljekar_id, klinika_id, pacijent_id)
			values('Sun Jun 14 02:30:00 CEST 2020', 0,1, '14:30', 'specoft',5, 1, 3);
insert into pregledi(datum_pregleda, popust, status, vrijeme_pocetka, sifra_pregleda, ljekar_id, klinika_id, pacijent_id)
			values('Sun Jun 14 00:00:00 CEST 2020', 0,1, '15:30', 'specoft',5, 1, 3);
insert into pregledi(datum_pregleda, popust, status, vrijeme_pocetka, sifra_pregleda,ljekar_id, klinika_id, pacijent_id)
			values('Sun Jun 14 00:00:00 CEST 2020', 0,1, '20:45', 'specoft',6, 2, 3);
			
insert into pregledi(datum_pregleda, popust, status, vrijeme_pocetka, sifra_pregleda, ljekar_id, klinika_id, pacijent_id)
			values('Sat Jun 13 00:00:00 CEST 2020', 0,1, '20:45', 'specoft',7, 3, 3);
			
insert into pregledi(datum_pregleda, popust, status, vrijeme_pocetka, sifra_pregleda, ljekar_id, klinika_id, pacijent_id)
			values('Sat Jun 13 00:00:00 CEST 2020', 0,1, '20:45', 'specoft',8, 4, 3);
			
insert into pregledi(datum_pregleda, popust, status, vrijeme_pocetka, sifra_pregleda, ljekar_id, klinika_id, pacijent_id)
			values('Sat Jun 13 00:00:00 CEST 2020', 0,1, '16:45', 'specoft',9, 1, 3);

-- NE DODAVATI NOVE PREGLEDE IZNAD NEGO ISPOD --
insert into pregledi(datum_pregleda, popust, status, vrijeme_pocetka, sifra_pregleda, ljekar_id, klinika_id, pacijent_id)
			values('Sat Jun 13 00:00:00 CEST 2020', 0,2, '15:45', 'specoft',5, 1, 3);
insert into pregledi(datum_pregleda, popust, status, vrijeme_pocetka, sifra_pregleda,ljekar_id, klinika_id, pacijent_id)
			values('Sat Jun 13 00:00:00 CEST 2020', 0,2, '15:45', 'specoft',6, 2, 3);
			
insert into izvjestaji_pregleda(izvjestaj, sifra, pregled_id, karton_id) values ('Pritisak u ocima', 3, 13, 1);
insert into izvjestaji_pregleda(izvjestaj, sifra, pregled_id, karton_id) values ('Pritisak u ocima', 3, 14, 1);
-- ISPOD --