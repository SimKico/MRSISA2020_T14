function registracija(){
	if($("#password").value != $("#confirmPassword").value) {
        alert("Error: Passwords don't match");
        $("#password").focus();
        return false;
    } else {
        var user = {};
        user.ime = document.getElementById("ime").value;
        user.prezime = document.getElementById("prezime").value;
        user.eAdresa = document.getElementById("email").value;
        console.log(document.getElementById("email").value);
        user.grad = document.getElementById("grad").value;
        user.drzava = document.getElementById("drzava").value;
        user.brojTelefona = document.getElementById("telefon").value;
        user.jbo = document.getElementById("jbo").value;
        user.adresaPrebivalista = document.getElementById("adresa").value;
        user.lozinka = document.getElementById("password").value;
    
        $.ajax({
            url: "http://localhost:8080/homepagePacijent1/registracija",
            method: "POST",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(user),
            success: function(result) {
            	alert("Dobicete email na kome cete aktivirati vas mejl.")
                //TODO: write "Click on link in email to activate your account"
               
            }, error: function(error){
                alert("Registration successful");
                location.replace("/");
            }
           
        });
          
      }
	
}