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

	$("#tezina").append(localStorage.getItem('tezina'));
	$("#visina").append(localStorage.getItem('visina'));

}