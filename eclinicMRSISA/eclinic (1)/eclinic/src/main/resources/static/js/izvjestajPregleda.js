 function ucitajLjekare() {
 		$.ajax({
 			type : "GET",
 			url : "/ljekar/ucitaj",
 			success : function(data) {
 				console.log(data);
 				console.log(data[0].naziv);
 				$.each(data, function(key, value) {
 					$('#ljekari').append($('<option>', {
 						value : value.eadresa,
 						text : value.ime + " " + value.prezime
 					}));
 				});
 			}
 		});
 	}
     
    function prikaziPreglede(){
    	$('.schedule-tab').empty();
    	console.log("Usli smo u f-ju");
    	eadresa = localStorage.getItem("email");
    	
    	console.log(eadresa);
    	$.ajax({
 			type : "GET",
 			url : "/ljekar/pregledi",
 			data: {eadresa: eadresa},
 			success : function(data) {
 				console.log(data);
 				$.each(data, function(key, value) {
 					localStorage.setItem("pregled" + value.id, value.id);
  					$('.schedule-tab').append($('<div id = "' + value.id +'"></div>')
  									  .append($('<div class="medi-info">').append($('<h3>').text(value.pacijentDTO.ime + " " + value.pacijentDTO.ime))
  											  							  .append($('<table style="margin: 8px 0px 0px;" border="1">').append($('<tbody>')
  											  									.append($('<tr>').append($('<td style="width:250px">').text(" Jedinstveni broj osiguranika  ")).append($('<td style="width:250px">').text( value.pacijentDTO.jedBrojOsiguranika)))
  											  									.append($('<tr>').append($('<td>').text(" Tip pregleda ")).append($('<td>').text(value.tipPregledaDTO.specijalizacija)))
  											  									.append($('<tr>').append($('<td>').text(" Vrijeme početka ")).append($('<td >').text(value.vrijemePocetka)))
  											  									.append($('<tr>').append($('<td>').text(" Trajanje: ")).append($('<td>').text(value.tipPregledaDTO.trajanje + " sat/a")))
  											  									.append($('<tr>').append($('<td>').text(" Klinika: ")).append($('<td>').text(value.ljekarDTO.klinika)))
  											  									  ))
							  											  .append($('<a href="#" onclick = zapocniPregled(this,'+  value.id + ') class="medi-info-btn">').text("ZAPOCNI").attr("id", value.id))))
							  											 			  
							
  				});
 			},
 			error: function(data) {
 				$('.schedule-tab').append($('<h3 class="white">').text("Nemate zakazanih pregleda"));
 			}
 		});
    	
    	
    }
    
    
function zapocniPregled (data, identifier){
		
    	idPregleda = $(data).attr("id");
    	localStorage.setItem("idPregleda", idPregleda);
    	$.ajax({
			type: "GET",
			url: "/ljekar/zapocni",
			data: {id: idPregleda},
			success: function(data){
				console.log(data);
				
				window.location = "zapocetPregled.html" ;
			},
			error: function(data){
				console.log(data);
				alert(data.responseText);
			}
	  }); 
    	
    }


function onLoadFunction(){
	  zdravstveniKarton();
	  ucitajDijagnoze();
	  ucitajLijekove();
}

function ucitajDijagnoze(){
	 idPregleda = localStorage.getItem("idPregleda");
	 console.log("IDDD " + idPregleda);
	  $.ajax({
			type: "GET",
			url: "/sifarnik/ucitajDijagnoze",
			success: function(data){
				console.log(data);
				$.each(data, function(key, value) {
					$('#dijagnoza').append($('<option>', { 
				        value: key,
				        text : value.dijagnoza 
				    }));
				});
			}
	  }); 
}

function ucitajLijekove(){
	idPregleda = localStorage.getItem("idPregleda");
	 console.log("IDDD " + idPregleda);
	  $.ajax({
			type: "GET",
			url: "/sifarnik/ucitajLijekove",
			success: function(data){
				console.log(data);
				$.each(data, function(key, value) {
					$('#lijek').append($('<option>', { 
				        value: key,
				        text : value.lijek 
				    }));
				});
			}
	  }); 
}

function zdravstveniKarton(){
	 idPregleda = localStorage.getItem("idPregleda");
	 console.log(idPregleda);
	  $.ajax({
			type: "GET",
			url: "/zdravKarton/ucitajZdravKarton",
			data: {idPregleda: idPregleda},
			success: function(data){
				console.log(data);
				localStorage.setItem("jbo", data.jboPacijenta);
				$('#ime').append(data.imePacijenta);
				$('#prezime').append(data.prezimePacijenta);
				$('#jbo').append(data.jboPacijenta);
				$('#krvnaGrupa').append(data.krvnaGrupa==null? "--" : data.krvnaGrupa);
				$('#alergije').append(data.alergije==null? "--" : data.alergije);
				$('#dioptrija').append(data.dioptrija==null? "--" : data.dioptrija);
				$('#visina').append(data.visinaCm==0? "--" : data.visinaCm);
				$('#tezina').append(data.tezinaKg==0? "--" : data.tezinaKg);
				$('#ime1').append(data.imePacijenta);
				$('#prezime1').append(data.prezimePacijenta);
				$('#jbo1').append(data.jboPacijenta);
				$('#krvnaGrupa1').val(data.krvnaGrupa==null? "--" : data.krvnaGrupa);
				$('#alergije1').val(data.alergije==null? "--" : data.alergije);
				$('#dioptrija1').val(data.dioptrija==null? "--" : data.dioptrija);
				$('#visina1').val(data.visinaCm==0? "--" : data.visinaCm);
				$('#tezina1').val(data.tezinaKg==0? "--" : data.tezinaKg);
			}
	  }); 
}

function izvjestajPregleda(){
	izvjestaj = $('#izvjestaj').val();
	jbo = localStorage.getItem("jbo");
	pregledId = localStorage.getItem("idPregleda");
	dijagnoza = $("#dijagnoza option:selected").text();
	lijekovi = [];
    $( "#lijek option:selected" ).each(function() {
    	lijekovi.push( $( this ).text());
      });
	console.log(jbo);
	console.log(izvjestaj);
	console.log(dijagnoza);
	console.log(pregledId);
	console.log(lijekovi);
	data = {
			"izvjestaj" : izvjestaj,
			"pacijentJbo" : jbo,
			"pregledId" : pregledId,
			"dijagnozaDTO" : dijagnoza,
			"lijekovi" : lijekovi
	};
	
	console.log(data);
	 $.ajax({
			type: "POST",
			url: "/zdravKarton/izvjestajPregleda",
			data : JSON.stringify(data),
			dataType: 'json',
 		    contentType:  "application/json",
			success: function(data){
				console.log(data);
				window.location = "zapocinjanjePregleda.html"
			}
	  }); 
	
	
}

function prikaziPolja(){
	if($('#pregled').is(':hidden'))
		$('#pregled').prop('hidden', false);
	else
		$('#pregled').prop('hidden', true);
}

function zakaziPregled(){
	datum = $('#datum').val();
	popust = $('#popust').val();
	popust = popust == "" ? "0" : popust;
	vrijemePocetka = $('#pocetak option:selected').text();
	idTekucegPregleda = localStorage.getItem("idPregleda");
	data = {
		"datum": datum,
		"popust": popust,
		"vrijemePocetka" : vrijemePocetka,
		"idTekucegPregleda": idTekucegPregleda
	};
	console.log(data);
	$.ajax({
		type: "POST",
		url: "/pregled/noviPregled",
		data : JSON.stringify(data),
		dataType: 'json',
		contentType:  "application/json",
		success: function(data){
			console.log(data);
			$('#pregled').prop('hidden', true);
		},
		error(data){
			console.log(data);
			alert("Postoji vec zakazan pregled datuma " + datum + " u vrijeme " + vrijemePocetka);
		}
  }); 
	
}

function prikaziEdit(){
	$('#info').prop('hidden', true);
	$('#edit').prop('hidden', false);
}

function ponisti(){
	$('#info').prop('hidden', false);
	$('#edit').prop('hidden', true);
}

function sacuvajIzmjene(){
	imePacijenta = $('#ime1').text();
	prezimePacijenta = $('#prezime1').text();
	jboPacijenta = $('#jbo1').text();
	visinaCm = $('#visina1').val() == "--" ? 0 : $('#visina1').val();
	tezinaKg = $('#tezina1').val() == "--" ? 0 : $('#tezina1').val();
	krvnaGrupa = $('#krvnaGrupa1').val();
	dioptrija = $('#dioptrija1').val();
	alergije = $('#alergije1').val();
	console.log(imePacijenta + " " + prezimePacijenta + " " + jboPacijenta + " " + visinaCm + " " +tezinaKg + " " + krvnaGrupa + " " + dioptrija + " " +alergije)
	data = {
		"imePacijenta" : imePacijenta,
		"prezimePacijenta" : prezimePacijenta,
		"jboPacijenta" : jboPacijenta,
		"visinaCm" : visinaCm,
		"tezinaKg" : tezinaKg,
		"krvnaGrupa" : krvnaGrupa,
		"dioptrija" : dioptrija,
		"alergije" : alergije
	};
	$.ajax({
		type: "PUT",
		url: "/zdravKarton/izmjenaPodataka",
		data : JSON.stringify(data),
		dataType: 'json',
		contentType:  "application/json",
		success: function(data){
			console.log(data);
			$('#info').prop('hidden', false);
			$('#edit').prop('hidden', true);
			
			$('#krvnaGrupa').empty().append("Krvna grupa: ").append(data.krvnaGrupa==null? "--" : data.krvnaGrupa);;
			$('#alergije').empty().append("Alergije: ").append(data.alergije==null? "--" : data.alergije);;
			$('#dioptrija').empty().append("Dioptrija: ").append(data.dioptrija==null? "--" : data.dioptrija);;
			$('#visina').empty().append("Visina (cm): ").append(data.visinaCm==0? "--" : data.visinaCm);;
			$('#tezina').empty().append("Težina (kg): ").append(data.tezinaKg==0? "--" : data.tezinaKg);;
			
			$('#krvnaGrupa1').empty().append("Krvna grupa: ").val(data.krvnaGrupa==null? "--" : data.krvnaGrupa);;
			$('#alergije1').empty().append("Alergije: ").val(data.alergije==null? "--" : data.alergije);;
			$('#dioptrija1').empty().append("Dioptrija: ").val(data.dioptrija==null? "--" : data.dioptrija);;
			$('#visina1').empty().append("Visina (cm): ").val(data.visinaCm==0? "--" : data.visinaCm);;
			$('#tezina1').empty().append("Težina (kg): ").val(data.tezinaKg==0? "--" : data.tezinaKg);;
			
		},
		error(data){
			console.log(data);
			alert("Promjene nisu unesene");
		}
  }); 
	
}



   