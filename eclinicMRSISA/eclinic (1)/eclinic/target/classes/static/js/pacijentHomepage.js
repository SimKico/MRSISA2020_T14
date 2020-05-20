function prikaziHomepagePacijenta(){
	console.log("nesto");
	$.ajax({
		url: "/homepagePacijent1",
		type: "GET",
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
		success: function (result) {
			console.log(result);
			localStorage.setItem("ime", result.ime);
			localStorage.setItem("prezime", result.prezime);
			localStorage.setItem("adr", result.adresaPrebivalista);
			localStorage.setItem("grad", result.grad);
			localStorage.setItem("drz", result.drzava);
			localStorage.setItem("tel", result.brojTelefona);
			localStorage.setItem("jbo", result.jedBrojOsiguranika);
			localStorage.setItem("email", result.email);
			location.href = "profilPacijent.html";
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
			$("#telefon").append(localStorage.getItem('tel'));
			$("#jbo").append(localStorage.getItem('jbo'));
			$("#email").append(localStorage.getItem('email'));
	
 }



//Azuriranje podataka pacijenta

function prikaziAzuriranjePacijenta(){
	console.log("nesto");
	$.ajax({
		url: "/homepagePacijent1/profilPacijent/azurirajPodatke",
		type: "GET",
		success: function (result) {
			console.log(result);
			console.log("fgdagadfgdf");
			localStorage.setItem("ime", result.ime);
			localStorage.setItem("prezime", result.prezime);
			localStorage.setItem("adr", result.adresaPrebivalista);
			localStorage.setItem("grad", result.grad);
			localStorage.setItem("drz", result.drzava);
			localStorage.setItem("tel", result.brojTelefona);
			localStorage.setItem("jbo", result.jedBrojOsiguranika);
			localStorage.setItem("email", result.email);
	
			location.href = "azurirajProfil1.html" ;
		},
		error: function(result) {
			toastr.error("Something is wrong with your request.(get details)");
		}
    });	
}

function popuniPodatkePacijentaAzuriranje(){
	
	$("#ime").append(localStorage.getItem("ime"));
	$("#prezime").append(localStorage.getItem('prezime'));
	$("#adresa").val(localStorage.getItem('adr'));
	$("#grad").val(localStorage.getItem('grad'));
	$("#drzava").val(localStorage.getItem('drz'));
	$("#telefon").val(localStorage.getItem('tel'));
	$("#jbo").append(localStorage.getItem('jbo'));
	$("#email").append(localStorage.getItem('email'));
}

function azurirajPodatke(){
	adresa =  $("#adresa").val();
	grad = $("#grad").val();
	drzava = $("#drzava").val();
	telefon = $("#telefon").val();
	jbo = localStorage.getItem("jbo");
	console.log("nesto ba");
	console.log(adresa, grad, drzava, telefon, jbo);
	
		
		 $.ajax({
			type: "PUT",
			url: "/homepagePacijent1/profilPacijent/azurirajProfil",
			data: JSON.stringify({adresaPrebivalista: adresa, grad: grad, drzava: drzava, brojTelefona: telefon, jedBrojOsiguranika :jbo}),
//		    dataType: 'json',
		    contentType:  "application/json",
			success: function(result){

				alert("Uspjesno ste azurirali podatke");
				profilPacijenta();
			},
			error: function(result) {
				toastr.error("Something is wrong with your request.(get details)");
			}
		 });
}
		 