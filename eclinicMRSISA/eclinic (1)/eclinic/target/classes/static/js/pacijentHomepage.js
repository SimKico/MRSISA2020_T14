function prikaziHomepagePacijenta(){
	console.log("nesto");
	$.ajax({
		url: "/homepagePacijent1",
		type: "GET",
//		dataType: "json",
//        crossDomain: true,
		success: function (result) {
			localStorage.setItem("ime", result.ime);
			location.href = "homepagePacijent1.html" ;

		},
		error: function(result) {
			toastr.error("Something is wrong with your request.(get details)");
		}
    });	
}

function profilPacijenta(){
	
	console.log("nesto");
	$.ajax({
		url: "/homepagePacijent1/profilPacijent",
		type: "GET",
//		dataType: "json",
//        crossDomain: true,
		success: function (result) {
			localStorage.setItem("ime", result.ime);
			localStorage.setItem("prezime", result.prezime);
			localStorage.setItem("adr", result.adresaPrebivalista);
			localStorage.setItem("grad", result.grad);
			localStorage.setItem("drz", result.drzava);
			localStorage.setItem("jbo", result.jedBrojOsiguranika);
			localStorage.setItem("email", result.email);
			location.href = "profilPacijent.html" ;
		},
		error: function(result) {
			toastr.error("Something is wrong with your request.(get details)");
		}
    });	
}

function popuni()
{
	console.log("fasdfas");
			$("#ime").append(localStorage.getItem("ime"	));
			$("#prezime").append(localStorage.getItem('prezime'));
			$("#adresa").append(localStorage.getItem('adr'));
			$("#grad").append(localStorage.getItem('grad'));
			$("#drzava").append(localStorage.getItem('drz'));
			$("#telefon").val(localStorage.getItem('tel'));
			$("#jbo").append(localStorage.getItem('jbo'));
			$("#email").append(localStorage.getItem('email'));
	
 }

function prikaziListuKlinika(){
	console.log("nesto");
	$.ajax({
		url: "/homepagePacijent1/listaKlinika",
		type: "GET",
		success: function (result) {
			localStorage.setItem("result", JSON.stringify(result));
			location.href = "listaKlinika.html" ;
		},
		error: function(result) {
			toastr.error("Something is wrong with your request.(get details)");
		}
    });	
}

function prikaziKlinike(){
	
	var retrivedData = localStorage.getItem('result');
	console.log(retrivedData);
	var retrivedJSON = JSON.parse(retrivedData);
	console.log(retrivedJSON);
	
	var elements = retrivedJSON.length;
	console.log(elements);
	
	var i = 0;
	for(i; i<elements; i++){
		$("#table1")
		.append($("<tr>")
				.append($("<td>")
					.text(retrivedJSON[i].naziv))
				.append($("<td>")
					.text(retrivedJSON[i].grad))
				.append($("<td>")
					.text(retrivedJSON[i].tipKlinike))
			);
	}
}