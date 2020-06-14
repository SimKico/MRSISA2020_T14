var email = localStorage.getItem('email');
var token = localStorage.getItem('token');
console.log(token);

function prikaziListuKlinika(){
	console.log("nesto");
	$.ajax({
		url: "/klinika/listaKlinika",
		type: "GET",
		headers: { "Authorization": "Bearer " + token},
		success: function (result) {
			localStorage.setItem("result", JSON.stringify(result));
			location.href = "listaKlinika.html" ;
		}
	,
		error: function(result) {
			alert("Something is wrong with your request.(get details)");
		}
    });	
}

function prikaziKlinike(){
	
	var retrivedData = localStorage.getItem('result');
	console.log(retrivedData);
	var retrivedJSON = JSON.parse(retrivedData);
	console.log(retrivedJSON);
	var elements = retrivedJSON.length;
	var i = 0;
	for(i; i<elements; i++){
		var text  = ` <a class = "white" href="http://localhost:8080/klinika/${retrivedJSON[i].naziv}" id = "${retrivedJSON[i].naziv}">`
			console.log(retrivedJSON[i].naziv);
		$("#table1")
		.append($("<tr>")
				.append($("<td>")
						.append($(text)
								.text(retrivedJSON[i].naziv)
									.append($("</a>"))))
				.append($("<td>")
					.text(retrivedJSON[i].grad))
				.append($("<td>")
					.text(retrivedJSON[i].ocjenaKlinike))
			);
	}
	
	$("#table1").click(function(e){
		var name = e.target.id;
		
		
		console.log(name);
		$.ajax({
			url: "/klinika/listaKlinika/" + name,
			type: "GET",
			headers: { "Authorization": "Bearer " + token},
			success: function (result) {
				localStorage.setItem("klinikaPodaci", JSON.stringify(result));
				location.href = "klinika.html" ;
			}
				,	
			error: function(result) {
				toastr.error("Something is wrong with your request.(get details)");
			}
	    });	
	});

}

function ucitajPodatkeKlinike(){
	var klinikaPodaci = localStorage.getItem('klinikaPodaci');
	var klinikaPodaci = JSON.parse(klinikaPodaci);
	console.log(klinikaPodaci);
	$("#naziv").append(klinikaPodaci.naziv);
	$("#grad").append(klinikaPodaci.grad);
	$("#ocjena").append(klinikaPodaci.ocjenaKlinike);
	//TO DO iscitati iz baze sta znaci koji broj pregleda
	$("#tipKlinike").append(klinikaPodaci.tipKlinike);
	for(i in klinikaPodaci.ljekari)
		{
		//TO DO srediti izgled ocjene
		var ocjena = klinikaPodaci.ljekari[i].prosjecnaOcjena? "(" +  klinikaPodaci.ljekari[i].prosjecnaOcjena + ")" : " ";
		$("#tim-ljekara")
			.append($("<h3>")
					.append("dr " + klinikaPodaci.ljekari[i].ime + " "+ klinikaPodaci.ljekari[i].prezime + ocjena )
			.append($("</h3>")))
			.append($("<p>")
					.append(klinikaPodaci.ljekari[i].specijalizacija)
			.append($("</p>"))
					);
		console.log(klinikaPodaci.ljekari[i].ime);
		}
	for(j in klinikaPodaci.pregled){
		var appoint  = `<button value="${klinikaPodaci.pregled[j].id}" onclick = "zakaziBrziPregled()" class="btn">Zakažite pregled </a>`;
		$("#table1")
		.append($("<tr>")
				.append($("<td>")
					.text("dr " + klinikaPodaci.pregled[j].ljekarDTO.ime +klinikaPodaci.pregled[j].ljekarDTO.prezime))		
				.append($("<td>")
					.text(klinikaPodaci.pregled[j].datum))
				.append($("<td>")
					.text(klinikaPodaci.pregled[j].vrijemePocetka + "h"))
				.append($("<td>")
					.text(klinikaPodaci.pregled[j].tipPregledaDTO.specijalizacija))
				.append($("<td>")
					.text(klinikaPodaci.pregled[j].tipPregledaDTO.cijena + "€"))
				.append($("<td>")
					.text("nema"))
					.append($(appoint))
			);
	}
	$("button").click(function() {
		 var fired_button = $(this).val();
		 localStorage.setItem("sifra_pregleda",fired_button);
		 console.log(fired_button);
	});
}


function pretraziPreglede(){
	console.log("nestoPregledi");
	
	var tipPregleda = $("#tip").val();

	var datumPregleda = $("#datum").val();
	
	console.log(tipPregleda, datumPregleda);
	
	$.ajax({
		url: "/pregled/pretragaPregleda/" + tipPregleda + "/" + datumPregleda,
		type: "GET",

		headers: { "Authorization": "Bearer " + token},
		success: function (result) {
			console.log(result);
			var elements = result.length;
			location.href = " #doctor-team";
			console.log(elements);
			
//			$("#table2").find("tr").find("td").remove();
			document.getElementById("table2").style.visibility = "visible";
			var i = 0;
			for(i; i<elements; i++){

				localStorage.setItem("datumPregleda",datumPregleda);
				localStorage.setItem("tipPregleda",tipPregleda);
				var text  = ` <a  onclick = "klinikaZaPregled()" id = "${result[i].naziv}">`
				var j = 0;
				$("#table2")
				.append($("<tr>")
						.append($("<td>")
								.append($(text)
										.text(result[i].naziv)
											.append($("</a>"))))
						.append($("<td>")
							.text(result[i].adresa))
						.append($("<td>")
							.text(result[i].grad))
						.append($("<td>")
							.text(result[i].ocjenaKlinike))
						.append($("<td>")
							.text(result[i].tipoviPregleda[0].cijena + "€"))
					);
		
			}
		}
	,
		error: function(result) {
			alert("Something is wrong with your request.(get details)");
		}
    });	
	
}

function klinikaZaPregled(){
	$("#table2").click(function(e){
		var tipPregleda = localStorage.getItem('tipPregleda');
		var datumPregleda = localStorage.getItem('datumPregleda');
		var naziv = e.target.id;
		$.ajax({
			url: "/pregled/pretragaPregleda/" + tipPregleda + "/" + datumPregleda + "/" + naziv,
			type: "GET",
			headers: { "Authorization": "Bearer " + token},
			success: function (result) {	
				localStorage.setItem("klinikaPodaciZaPregled", JSON.stringify(result));
				location.href = "klinikaPregled.html" ;
				console.log("usaosi");
			}
				,	
			error: function(result) {
				toastr.error("Something is wrong with your request.(get details)");
			}
		});
	});
}

function ucitajPodatkeKlinikeZaPregled(){
	var klinikaPodaciZaPregled = localStorage.getItem('klinikaPodaciZaPregled');
	var klinikaPodaciZaPregled = JSON.parse(klinikaPodaciZaPregled);
	console.log(klinikaPodaciZaPregled);
	$("#naziv").append(klinikaPodaciZaPregled.naziv);
	$("#grad").append(klinikaPodaciZaPregled.grad);
	$("#ocjena").append(klinikaPodaciZaPregled.ocjenaKlinike);
	$("#tipKlinike").append(klinikaPodaciZaPregled.tipKlinike);
	for(i in klinikaPodaciZaPregled.ljekari)
	{
		var prosjecnaOcjena = klinikaPodaciZaPregled.ljekari[i].prosjecnaOcjena? "(" +  klinikaPodaciZaPregled.ljekari[i].prosjecnaOcjena + ")" : " ";
		var br_pregleda = klinikaPodaciZaPregled.ljekari[i].slobodniTermini.length;
		console.log(br_pregleda);
		var j= 0;
			var text = `<select id = "termin">`;
			var appoint  = `<button value="${klinikaPodaciZaPregled.ljekari[i].eadresa}" onclick = "potvrdiZakazivanje()" class="btn">Zakažite pregled </a>`;
			console.log("usao");
			$("#table1")
			.append($("<tr>")
					.append($("<td>")
						.text("dr " + klinikaPodaciZaPregled.ljekari[i].ime))		
					.append($("<td>")
						.text(klinikaPodaciZaPregled.ljekari[i].prezime))	
					.append($("<td>")
						.text(klinikaPodaciZaPregled.ljekari[i].prosjecnaOcjena))
					.append($(text))
					.append($(appoint))
				
				);
			for(j; j<br_pregleda;j++){
				
				$("#termin")
					.append($("<option>")
									.text(klinikaPodaciZaPregled.ljekari[i].slobodniTermini[j])	
									);
									
			}
	}
	$("button").click(function() {
		 var fired_button = $(this).val();
		 localStorage.setItem("emailLjekara",fired_button);
	   
	});

}


function potvrdiZakazivanje(){
	confirm("Sigurno želite da zakažete pregled?");
	var vrijemePregleda =  	$("#termin option:selected" ).text();

	var emailLjekara = localStorage.getItem('emailLjekara');
	
	var tipPregleda = localStorage.getItem('tipPregleda');
	var datumPregleda = localStorage.getItem('datumPregleda');
	var klinikaPodaciZaPregled = localStorage.getItem('klinikaPodaciZaPregled');
	var klinikaPodaciZaPregled = JSON.parse(klinikaPodaciZaPregled);

	var klinika = klinikaPodaciZaPregled.naziv;
	
	$.ajax({
		url: "/pregled/zakaziPregled/"+ email,
		type: "POST",
		headers: { "Authorization": "Bearer " + token},
		data: {tipPregleda : tipPregleda, datumPregleda: datumPregleda, emailLjekara: emailLjekara, vrijemePregleda : vrijemePregleda, klinika: klinika},
		success: function (result) {
			alert("Zahtjev za pregled je poslat. Dobicete odgovor u sto kracem roku. Hvala Vam na povjerenju!");
		}
	,
		error: function(result) {
			alert("Something is wrong with your request.(get details)");
		}
    });	
}
function zakaziBrziPregled(){
	confirm("Sigurno želite da zakažete pregled?")
	var id = localStorage.getItem('sifra_pregleda');
	$.ajax({
		url: "/pregled/zakaziBrzi/"+email,
		type: "PUT",

		headers: { "Authorization": "Bearer " + token},
		data: {id : id },
		success: function (result) {
			console.log(result);
			alert("Zahtjev za pregled je poslat. Dobicete odgovor u sto kracem roku. Hvala Vam na povjerenju!");
		}
	,
		error: function(result) {
			alert("Something is wrong with your request.(get details)");
		}
    });	
}
function pretraziLjekare()
{ console.log("fasdfas");
	var tipLjekara = $("#tip").val();
	 var datumPregleda = $("#datum").val();
	var ime = $("#ime").val();
	var prezime = $("#prezime").val();
	var ocjena = $("#ocjena").val();
	console.log(tipLjekara + ime + prezime + ocjena + datumPregleda );
	
//	console.log(pretragaLjekaraParametri);
//	localStorage.setItem("pretragaLjekaraParametri", JSON.stringify(pretragaLjekaraParametri));
	
	$.ajax({
		url: "/ljekar/pretragaLjekara" ,
		method: "GET",
		dataType: "json",
        contentType: "application/json",
		data :({tipLjekara: tipLjekara, ime : ime, prezime: prezime, ocjena : ocjena}),
		headers: { "Authorization": "Bearer " + token},
		success: function (result) {
			console.log(result);
			localStorage.setItem("ljekariZaListanje", JSON.stringify(result));
			location.href = "pretragaLjekaraLista.html";
		}
	});
		
}
function ucitajPodatkeLjekara()
{
	var ljekari = localStorage.getItem('ljekariZaListanje');
	var ljekari = JSON.parse(ljekari);
	console.log(ljekari);
	for(i in ljekari)
	{
		var prosjecnaOcjena = ljekari[i].prosjecnaOcjena? "(" + ljekari[i].prosjecnaOcjena + ")" : " ";
		var br_pregleda = 0;
		if(ljekari[i].slobodniTermini!= null){
			br_pregleda = ljekari[i].slobodniTermini.length;}
		console.log(br_pregleda);
		var j= 0;
			var text = `<select id = "termin">`;
			var appoint  = `<button value="${ljekari[i].eadresa}" onclick = "potvrdiZakazivanje()" class="btn">Zakažite pregled </a>`;
			console.log("usao");
			$("#table1")
			.append($("<tr>")
					.append($("<td>")
						.text("dr " + ljekari[i].ime))		
					.append($("<td>")
						.text(ljekari[i].prezime))	
					.append($("<td>")
						.text(ljekari[i].prosjecnaOcjena))
					.append($(text))
					.append($(appoint))
				
				);
			for(j; j<br_pregleda;j++){
				
				$("#termin")
					.append($("<option>")
									.text(ljekari[i].slobodniTermini[j])	
									);
									
			}
	}
	$("button").click(function() {
		 var fired_button = $(this).val();
		 localStorage.setItem("emailLjekara",fired_button);
	   
	});
}

