--Dodavanje sifarnika dijagnoza--
insert into sifarnik_dijagnoza(naziv_sifarnika)values('Sifarnik dijagnoza');
--Dodavanje sifarnika lijekova--
insert into sifarnik_lijekova(naziv_sifarnika)values('Sifarnik lijekova');
--Dodavanje klinickog centra--
insert into klinicki_centar(kc_id,sif_dij_id, sif_lijek_id)values('Eclinic',1, 1);
--Dodavanje predefinisanog admina klinickog centra--
insert into tabela_prijava(eadresa, lozinka)values('predefinisani@eclinic.com', 'padmin');
insert into tabela_korisnika(type, aktivan, ime, prezime, dodijeljena_lozinka, predefinisani, info, ocjena, radno_vrijeme, specijalizacija, adresa, broj_telefona, drzava, grad,jbo,prijava_id,klinika_id,karton_id, kc_id) values('AC', true, 'Marko', 'Maricic', false, true, null, null, null, null, null, null, null, null, null, 'predefinisani@eclinic.com', null,null, 'Eclinic');