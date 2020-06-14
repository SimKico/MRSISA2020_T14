function registracija(){
	if($("#password").value != $("#confirmPassword").value) {
        alert("Error: Passwords don't match");
        $("#password").focus();
        return false;
	}
}