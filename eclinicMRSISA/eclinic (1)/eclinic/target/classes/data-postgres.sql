--Dodavanje sifarnika dijagnoza--
insert into sifarnik_dijagnoza(naziv_sifarnika)values('Sifarnik dijagnoza');
--Dodavanje sifarnika lijekova--
insert into sifarnik_lijekova(naziv_sifarnika)values('Sifarnik lijekova');
--Dodavanje klinickog centra--
insert into klinicki_centar(kc_id,sif_dij_id, sif_lijek_id)values('Eclinic',1, 1);
--Dodavanje predefinisanog admina klinickog centra--
insert into tabela_prijava(eadresa, lozinka)values('predefinisani@eclinic.com', 'padmin');
insert into tabela_korisnika(type, aktivan, ime, prezime, dodijeljena_lozinka, predefinisani, info, ocjena, radno_vrijeme, specijalizacija, adresa, broj_telefona, drzava, grad,jbo,prijava_id,klinika_id,karton_id, kc_id) values('AC', true, 'Marko', 'Maricic', false, true, null, null, null, null, null, null, null, null, null, 'predefinisani@eclinic.com', null,null, 'Eclinic');


--Dodavanje nekog pacijenta--
insert into tabela_prijava(eadresa, lozinka)values('pacijent1@eclinic.com', 'ppacijent');

insert into tabela_prijava(eadresa, lozinka)values('dr1@eclinic.com', 'pljekar');
insert into tabela_korisnika(type, aktivan, ime, prezime, dodijeljena_lozinka, predefinisani, info, ocjena, radno_vrijeme, specijalizacija, adresa, broj_telefona, drzava, grad,jbo,prijava_id,klinika_id,karton_id, kc_id) 
						values('P', true, 'Snjezana', 'Simic', false, false, null, null, null, null, 'Hajduk Veljka bb', '066617528', 'Bosna', 'Derventa', '123456', 'pacijent1@eclinic.com', null,null, 'Eclinic');
			
--Dodavanje klinika--
insert into klinike(grad, naziv_klinike, ocjena_klinike, tip_klinike, kc_id)
values('Beograd', 'VMA', '4', 1, 'Eclinic');

insert into klinike(grad, naziv_klinike, ocjena_klinike, tip_klinike, kc_id)
values('Banjaluka', 'UKC', '4', 2, 'Eclinic');

insert into klinike(grad, naziv_klinike, ocjena_klinike, tip_klinike, kc_id)
values('Sarajevo', 'Kosevo', '2', 3, 'Eclinic');

insert into klinike(grad, naziv_klinike, ocjena_klinike, tip_klinike, kc_id)
values('Zagreb', 'Nasa Klinika', '5', 3, 'Eclinic');

insert into klinike(grad, naziv_klinike, ocjena_klinike, tip_klinike, kc_id)
values('Novi Sad', 'Klinika Svjetlost', '3', 3, 'Eclinic');

----Dodavanje doktora--
--insert into tabela_korisnika(type, aktivan, ime, prezime, dodijeljena_lozinka, predefinisani, info, ocjena, radno_vrijeme, specijalizacija, adresa, broj_telefona, drzava, grad,jbo,prijava_id,klinika_id,karton_id, kc_id) 
--						values('LJ', true, 'Biljana', 'Maksimovic', false , false, null, '5', '8', 1, null,null,null, null, null, 'dr1@eclinic.com', 1,null, 'Eclinic');
--										
--			

----Dodavanje doktora--
--insert into tabela_korisnika(type, aktivan, ime, prezime, dodijeljena_lozinka, predefinisani, info, ocjena, radno_vrijeme, specijalizacija, adresa, broj_telefona, drzava, grad,jbo,prijava_id,klinika_id,karton_id, kc_id) 
--						values('LJ', true, 'Ratko', 'Nikolic', false, false, null, 4, null, 2, null,null,null, null, null, null, 1,null, 'Eclinic');
--						
----Dodavanje doktora--
--insert into tabela_korisnika(type, aktivan, ime, prezime, dodijeljena_lozinka, predefinisani, info, ocjena, radno_vrijeme, specijalizacija, adresa, broj_telefona, drzava, grad,jbo,prijava_id,klinika_id,karton_id, kc_id) 
--						values('LJ', true, 'Gordana', 'Radic', false, false, null, 3, null, 1, null,null,null, null, null, null, 2,null, 'Eclinic');		
--						
----Dodavanje doktora--
--insert into tabela_korisnika(type, aktivan, ime, prezime, dodijeljena_lozinka, predefinisani, info, ocjena, radno_vrijeme, specijalizacija, adresa, broj_telefona, drzava, grad,jbo,prijava_id,klinika_id,karton_id, kc_id) 
--						values('LJ', true, 'Miodrag', 'Rakic', false, false, null, 2, null, 5, null,null,null, null, null, null, 3,null, 'Eclinic');