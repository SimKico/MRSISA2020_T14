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
				localStorage.setItem("klinikaZaPregledPodaci", JSON.stringify(result));
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





