var user = {};

function logovanje()
{
	 user.email = document.getElementById("email").value;
	 user.password = document.getElementById("lozinka").value;
       console.log("before");
       console.log(user.email);
       console.log(user.password);
       console.log("after");
	$.ajax({
		url:"/auth/login",
		method :"POST",
	    dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(user),
        success: function(result) {
        	console.log(result);
        	console.log(result.accessToken);
            localStorage.setItem("token", result.accessToken);
            localStorage.setItem("email", result.email);
            localStorage.setItem("expiresIn", result.expiresIn);
            localStorage.setItem("firstName", result.firstName);
            localStorage.setItem("type", result.type);
            
            if (result.type == "P") {
            	location.replace("/homepagePacijent1.html");
            } else if (result.type == "AC") {
            	location.replace("/ProfilAKC.html");
            } else if (result.type == "AK") {
            	location.replace("/adminKlinikeHomepage.html")
            }else if (result.type == "LJ") {
            	location.replace("/zapocinjanjePregleda.html")
            } else {
            	location.replace("/index.html");
            }
            
        }, error: function(error) {
            alert("Wrong email or password");
            console.log(error);
        }
        });
	}
