function prikaziListuKlinika(){
	console.log("nesto");
	$.ajax({
		url: "/klinika/listaKlinika",
		type: "GET",
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
		var text  = ` <a class = "white" href ="http://localhost:8080/klinika/${retrivedJSON[i].naziv}" id = "${retrivedJSON[i].naziv}">`
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
		$.ajax({
			url: "/klinika/listaKlinika/" + name,
			type: "GET",
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
			);
	}
	
//	$("#telefon").append(localStorage.getItem('tel'));
//	$("#jbo").append(localStorage.getItem('jbo'));
//	$("#email").append(localStorage.getItem('email'));
}


function pretraziPreglede(){
	console.log("nestoPregledi");
	
	var tipPregleda = $("#tip").val();

	var datumPregleda = $("#datum").val();
	
	console.log(tipPregleda, datumPregleda);
	
	$.ajax({
		url: "/pregled/pretragaPregleda/" + tipPregleda + "/" + datumPregleda,
		type: "GET",
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
//TO DO ZA VISE TIPOVA PREGLEDA			
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
	//TO DO srediti izgled ocjene
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
	confirm("Potvrdite zakazivanje!");
	var vrijemePregleda =  	$("#termin option:selected" ).text();
	console.log(vrijemePregleda);
	var emailLjekara = localStorage.getItem('emailLjekara');
	console.log(emailLjekara);
	var tipPregleda = localStorage.getItem('tipPregleda');
	var datumPregleda = localStorage.getItem('datumPregleda');
	
	$.ajax({
		url: "/pregled/zakaziPregled",
		type: "POST",
		data: {tipPregleda : tipPregleda, datumPregleda: datumPregleda, emailLjekara: emailLjekara, vrijemePregleda : vrijemePregleda},
		success: function (result) {
			console.log(result);
			alert("Uspjesno ste zakazali pregled. Hvala Vam na povjerenju.");
		}
	,
		error: function(result) {
			alert("Something is wrong with your request.(get details)");
		}
    });	
}


