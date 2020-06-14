var token = localStorage.getItem("token");

function predjiNaProfil(){
	  email = localStorage.getItem("email");
	  console.log("De nestoooo");
	  console.log(email);
	  data = {
		"eadresa" : email	  
	  };
	  $.ajax({
			type: "GET",
			url: "/profilAKC/profil",
			headers: { "Authorization": "Bearer " + token},
			data: data,
			contentType : "application/json",
			success: function(data){
				console.log(data);
				localStorage.setItem("eadresa", data.eadresa);
				localStorage.setItem("ime", data.ime);
				localStorage.setItem("prezime", data.prezime);
				$("#ime").append(localStorage.getItem("ime"));
				$("#prezime").append(localStorage.getItem("prezime"));
				$("#eadresa").append(localStorage.getItem("eadresa"));
			},
			error: function(data){
				console.log(data);
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