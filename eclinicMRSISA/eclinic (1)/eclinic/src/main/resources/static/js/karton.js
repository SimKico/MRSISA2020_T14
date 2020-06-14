var email = localStorage.getItem('email');
var token = localStorage.getItem('token');
console.log(token);

function kartonPacijenta()
{
	
	$.ajax({
		url: "/homepagePacijent1/kartonPacijenta/"+email,
		type: "GET",

		headers: { "Authorization": "Bearer " + token},
		success: function (result) {
			console.log(result);
			localStorage.setItem("alergije", result.alergije);
			localStorage.setItem("dioptrija", result.dioptrija);
			localStorage.setItem("krvnaGrupa", result.krvnaGrupa);
			localStorage.setItem("tezina", result.tezinaKg);
	
			localStorage.setItem("visina", result.visinaCm);
		
			location.href = "zdravstveniKarton.html";
		},
		error: function(result) {
			toastr.error("Something is wrong with your request.(get details)");
		}
    });	
}

function popuniKarton()
{
	console.log("popunjavanje kartona");
	$("#alergija").append(localStorage.getItem("alergije"));
	$("#dioptrija").append(localStorage.getItem('dioptrija'));
	$("#krvnaGrupa").append(localStorage.getItem('krvnaGrupa'));

	$("#tezina").append(localStorage.getItem('tezina') + "kg");
	$("#visina").append(localStorage.getItem('visina') + "cm");

}

function istorijaOperacija()
{
	$.ajax({
		url: "/homepagePacijent1/istorijaOperacija/"+email,
		type: "GET",

		headers: { "Authorization": "Bearer " + token},
		success: function (result) {
			console.log(result);
//			localStorage.setItem("alergije", result.alergije);
//			localStorage.setItem("dioptrija", result.dioptrija);
//			localStorage.setItem("krvnaGrupa", result.krvnaGrupa);
//			localStorage.setItem("tezina", result.tezinaKg);
//	
//			localStorage.setItem("visina", result.visinaCm);
		
			location.href = "istorijaOperacijaPacijenta.html";
		},
		error: function(result) {
			toastr.error("Something is wrong with your request.(get details)");
		}
    });	
}

function istorijaPregleda()
{
	
	$.ajax({
		url: "/homepagePacijent1/istorijaPregleda/"+email,
		type: "GET",
		headers: { "Authorization": "Bearer " + token},
		success: function (result) {
			console.log(result);
			localStorage.setItem('operacijePacijenta',  JSON.stringify(result));
//			localStorage.setItem("alergije", result.alergije);
//			localStorage.setItem("dioptrija", result.dioptrija);
//			localStorage.setItem("krvnaGrupa", result.krvnaGrupa);
//			localStorage.setItem("tezina", result.tezinaKg);
//	
//			localStorage.setItem("visina", result.visinaCm);
		
			location.href = "listaPregledaPacijenta.html";
		},
		error: function(result) {
			toastr.error("Something is wrong with your request.(get details)");
		}
    });	
}
function ucitajOperacije()
{
	var operacijePacijenta = localStorage.getItem('operacijePacijenta');
	var operacijePacijenta = JSON.parse(operacijePacijenta);
	console.log(operacijePacijenta);
	
	for( i in operacijePacijenta){
		
			$("#table2")
			.append($("<tr>")
					.append($("<td>")
						.text(operacijePacijenta[i].tipPregledaDTO.specijalizacija))
//										
					.append($("<td>")
						.text(operacijePacijenta[i].ljekarDTO.klinika))
					.append($("<td>")
						.text(operacijePacijenta[i].ocjenaKlinike))
					.append($("<td>")
						.text(operacijePacijenta[i].adresaKlinike))
					.append($("<td>")
						.text(operacijePacijenta[i].grad))
					.append($("<td>")
						.text(operacijePacijenta[i].datum))
			
				
				);
		
}
}

function ucitajPodatkePregledaPacijenta(){
	var podaciPregledaPacijenta = localStorage.getItem('preglediPacijenta');
	var podaciPregledaPacijenta = JSON.parse(podaciPregledaPacijenta);
	console.log(podaciPregledaPacijenta);
	
	for( i in podaciPregledaPacijenta){
		if(podaciPregledaPacijenta[i].status == "odrzan"){
			$("#table2")
			.append($("<tr>")
					.append($("<td>")
						.text(podaciPregledaPacijenta[i].tipPregledaDTO.specijalizacija))
//										
					.append($("<td>")
						.text(podaciPregledaPacijenta[i].ljekarDTO.klinika))
					.append($("<td>")
						.text(podaciPregledaPacijenta[i].ocjenaKlinike))
					.append($("<td>")
						.text(podaciPregledaPacijenta[i].adresaKlinike))
					.append($("<td>")
						.text(podaciPregledaPacijenta[i].grad))
					.append($("<td>")
						.text(podaciPregledaPacijenta[i].datum))
					.append($("<td>")
						.text(podaciPregledaPacijenta[i].vrijemePocetka))
					.append($("<td>")
						.text(podaciPregledaPacijenta[i].status))
					.append($("<td>")
						.text(podaciPregledaPacijenta[i].tipPregledaDTO.cijena + "€"))
				
				);
		}
		else if(podaciPregledaPacijenta[i].status == "zakazan")
			{
			var appoint  = `<button value="${podaciPregledaPacijenta[i].id}" onclick = "otkaziPregled()" class="btn btn-appoint">Otkažite pregled </a>`;
			$("#table1")
			.append($("<tr>")
					.append($("<td>")
						.text(podaciPregledaPacijenta[i].tipPregledaDTO.specijalizacija))
//										
					.append($("<td>")
						.text(podaciPregledaPacijenta[i].ljekarDTO.klinika))
					.append($("<td>")
						.text(podaciPregledaPacijenta[i].ocjenaKlinike))
					.append($("<td>")
						.text(podaciPregledaPacijenta[i].adresaKlinike))
					.append($("<td>")
						.text(podaciPregledaPacijenta[i].grad))
					.append($("<td>")
						.text(podaciPregledaPacijenta[i].datum))
					.append($("<td>")
						.text(podaciPregledaPacijenta[i].vrijemePocetka))
					.append($("<td>")
						.text(podaciPregledaPacijenta[i].status))
					.append($("<td>")
						.text(podaciPregledaPacijenta[i].tipPregledaDTO.cijena + "€"))
						.append($("<td>")
					.text("otkazi"))
						.append($(appoint))
							
				);
			}
	}
	$("button").click(function() {
		 var fired_button = $(this).val();
		 localStorage.setItem("idPregleda",fired_button);
	   
	});
	
}

function istorijaPregleda()
{
	
	$.ajax({
		url: "/homepagePacijent1/istorijaPregleda/"+email,
		type: "GET",
		headers: { "Authorization": "Bearer " + token},
		success: function (result) {
			console.log(result);
			localStorage.setItem('preglediPacijenta',  JSON.stringify(result));
//			localStorage.setItem("alergije", result.alergije);
//			localStorage.setItem("dioptrija", result.dioptrija);
//			localStorage.setItem("krvnaGrupa", result.krvnaGrupa);
//			localStorage.setItem("tezina", result.tezinaKg);
//	
//			localStorage.setItem("visina", result.visinaCm);
		
			location.href = "listaPregledaPacijenta.html";
		},
		error: function(result) {
			toastr.error("Something is wrong with your request.(get details)");
		}
    });	
}
function otkaziPregled(){
	confirm("Sigurno želite da zakažete pregled?")
	var id = localStorage.getItem('idPregleda');
	$.ajax({
		url: "/pregled/otkaziPregled/" + email,
		type: "PUT",
		data: {id : id },
		headers: { "Authorization": "Bearer " + token},
		success: function (result) {
			console.log(result);
			alert("Otkazali ste pregled!");
			istorijaPregleda();
		}
	,
		error: function(result) {
			alert("Something is wrong with your request.(get details)");
		}
    });	
}