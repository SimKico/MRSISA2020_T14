 function predjiNaProfil(){
	  
	  console.log("De nestoooo");
	  $.ajax({
			type: "GET",
			url: "/profilAKC",
			data: {eadresa: "predefinisani@eclinic.com"},
			success: function(data){
				console.log(data);
				localStorage.setItem("eadresa", data.eadresa);
				localStorage.setItem("ime", data.ime);
				localStorage.setItem("prezime", data.prezime);
				location.href = "profilAKC.html" ;
			}
		})
}
 
 function MyFunction(){
	  
	  console.log("he he");
	  console.log(localStorage.getItem("eadresa"));
	  $("#ime").append(localStorage.getItem("ime"));
	  $("#prezime").append(localStorage.getItem("prezime"));
	  $("#eadresa").append(localStorage.getItem("eadresa"));
	  
}