 function prikaziHomepageAK(){
	console.log("nesto");
	$.ajax({
		url: "/adminKlinikeHomepage",
		type: "GET",
		success: function (data) {
			location.href = "adminKlinikeHomepage.html";
			localStorage.setItem("ime", data.ime);
			localStorage.setItem("prezime", data.prezime);
			localStorage.setItem("eadresa", data.eadresa);
			

		},
		error: function(data) {
			console.log("Something is wrong with your request.");
		}
    });	
}
function dobrodoslica(){
			console.log(data.ime)
			var paragraph = document.getElementById("dobrodoslica");
			var text = document.createTextNode(data.ime);
			paragraph.appendChild(text);
}
 

 
 function profilAK(){
	  
	  $.ajax({
			type: "GET",
			url: "adminKlinikeHomepage/mojProfil",
			data: {id: 3},
			success: function(data){
					location.href = "profilAK.html";
			}
		})
}
 
 function upisiProfilAK(){
	  console.log("usao u upis imena");
	  console.log(localStorage.getItem("ime"));
	  var ime = $('#ime');
      ime.val(localStorage.getItem("ime")); 
	  var prezime = $('#prezime');
      prezime.val(localStorage.getItem("prezime")); 
	  var eadresa = $('#eadresa');
      eadresa.val(localStorage.getItem("eadresa")); 
	  
}

function sacuvajIzmene(){
	var ime = $('#ime').val();
	var prezime = $('#prezime').val();
	var eadresa = $('#eadresa').val();
	var id = 3;
	  		 $.ajax({
 			type: "POST",
 			url: "adminKlinikeHomepage/mojProfil",
 			data: JSON.stringify({id: id, ime: ime, prezime: prezime, eadresa: eadresa}),
 		    dataType: 'json',
 		    contentType:  "application/json",
 			success: function(data){
 				
 				console.log("uspesna izmena, svaka cast");
 				console.log(data);
 			}
 		})
	window.alert("uspesno izmenjeni podaci");
}