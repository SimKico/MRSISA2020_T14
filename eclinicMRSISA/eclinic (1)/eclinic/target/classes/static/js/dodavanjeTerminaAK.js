  $(function(){

    $("#odabraniLekar").on('click', 'li a', function(e){
		e.preventDefault();
      $("#lekarBtn:first-child").text($(this).text());
      $("#lekarBtn:first-child").val($(this).text());
	  promenaLekara();
	  });

});

function promenaLekara(){
	console.log("promena lekara");
}


  $(function(){

    $("#odabranaSala").on('click', 'li a', function(e){
		e.preventDefault();
      $("#salaBtn:first-child").text($(this).text());
      $("#salaBtn:first-child").val($(this).text());
   });

});

function promenaSale(){
	console.log("promena sale");
}


  $(function(){

    $("#tipPregledaLista").on('click', 'li a', function(e){
		e.preventDefault();
      $("#tipPregledaBtn:first-child").text($(this).text());
      $("#tipPregledaBtn:first-child").val($(this).text());
   });

});

function promenaTipaPreglead(){
	console.log("promena tipa pregleda");
}


  $(function(){

    $("#vremePocetka").on('click', 'li a', function(e){
		e.preventDefault();
      $("#vremeBtn:first-child").text($(this).text());
      $("#vremeBtn:first-child").val($(this).text());
   });

});

function promenaVremena(){
	console.log("promena vremena");
}

 
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
	lekar.append(`<li id="${klinikaJSON.ljekari[i].id}"><a href="#">Dr. ${klinikaJSON.ljekari[i].ime} ${klinikaJSON.ljekari[i].prezime} (${klinikaJSON.ljekari[i].specijalizacija})</a></li>`);
	}
	//dodavanje sala
	for(i=0;i < klinikaJSON.sale.length; i++){
	sala.append(`<li><a href="#">Sala broj ${klinikaJSON.sale[i].brojSale}</a></li>`);
	}
	console.log("broj sala u klinici:" + klinikaJSON.sala.length);
	
}


function dodajTermin(){
	var lekar = $('#odabraniLekar').val();
	var sala = $('#odabranaSala').val();
	var tipPregledaLista = $("#tipPregledaLista").val(); 
	var vreme = $('#vremePocetka').val();
	
	
	  		 $.ajax({
 			type: "PUT",
 			url: "adminKlinikeHomepage/mojProfil",
 			data: JSON.stringify({}),
 		    dataType: 'json',
 		    contentType:  "application/json",
 			success: function(data){
 				
 				console.log("uspesna izmena, svaka cast");
 				console.log(data);
 			}
 		})
		
	window.alert("Slobodan termin za rezervaciju dodat.");
}