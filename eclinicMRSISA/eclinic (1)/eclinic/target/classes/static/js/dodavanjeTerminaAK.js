 function dodavanjeTerminaLoad(){
	$.ajax({
		url: "adminKlinikeHomepage/dodavanjeTermina",
		type: "GET",
		success: function (result) {
			console.log("usao u dodavanje termina");
			localStorage.setItem("klinika", JSON.stringify(result));
			location.href = "dodavanjeSlobodnihTermina.html" ;

			

		},
		error: function(result) {
			console.log("Something is wrong with your request.");
		}
    });	
}

function popuniFormuTermina(){
	var klinika = localStorage.getItem('klinika');
	console.log(klinika);
	var klinikaJSON = JSON.parse(klinika);
	console.log(klinikaJSON);
	
	$('#odabraniLekar').val('ok');
	
	var i = 0;
	var tipPregledaLista = $("#tipPregledaLista"); 
	$('#tipPregledaLista').val('koji kurac vise');
	tipPregledaLista.append("<li>novi element</li>");
	for(i; i < klinikaJSON.tipoviPregleda.length; i++){
		tipPregledaLista.append("<li>novi element</li>");
		window.alert(klinikaJSON.tipoviPregleda[i].specijalizacija);
	}
	
}