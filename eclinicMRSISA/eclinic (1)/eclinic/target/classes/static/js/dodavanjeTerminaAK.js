  $(function(){

    $("#odabraniLekar").on('click', 'li a', function(){
      $("#lekarBtn:first-child").text($(this).text());
      $("#lekarBtn:first-child").val($(this).text());
	  promenaLekara();
	  });

});

function promenaLekara(){
	window.alert("reaguje na promenu");
}
  $(function(){

    $("#odabranaSala").on('click', 'li a', function(){
      $("#salaBtn:first-child").text($(this).text());
      $("#salaBtn:first-child").val($(this).text());
   });

});

  $(function(){

    $("#tipPregledaLista").on('click', 'li a', function(){
      $("#tipPregledaBtn:first-child").text($(this).text());
      $("#tipPregledaBtn:first-child").val($(this).text());
   });

});

  $(function(){

    $("#vremePocetka").on('click', 'li a', function(){
      $("#vremeBtn:first-child").text($(this).text());
      $("#vremeBtn:first-child").val($(this).text());
   });

});
 
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
	
	var lekar = $('#odabraniLekar');
	var sala = $('#odabranaSala');
	var tipPregledaLista = $("#tipPregledaLista"); 

	var i = 0;
	
	//dodavanje tipova pregleda
	for(i; i < klinikaJSON.tipoviPregleda.length; i++){
	tipPregledaLista.append(`<li><a href="#">${klinikaJSON.tipoviPregleda[i].specijalizacija} (${klinikaJSON.tipoviPregleda[i].trajanje} min)</a></li>`);
	}
	//dodavanje lekara
	for(i=0;i < klinikaJSON.ljekari.length; i++){
	lekar.append(`<li id="${klinikaJSON.ljekari[i].id}"><a href="#">${klinikaJSON.ljekari[i].ime} ${klinikaJSON.ljekari[i].prezime}</a></li>`);
	}
	//dodavanje sala
	for(i=0;i < klinikaJSON.sala.length; i++){
	sala.append(`<li><a href="#">Sala broj ${klinikaJSON.sala[i].broj}</a></li>`);
	}
	
}


function dodajTermin(){

	window.alert("Slobodan termin za rezervaciju dodat.");
}