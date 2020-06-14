var token = localStorage.getItem("token");
var events = [];
function prikaziPreglede(){
	    	$('.schedule-tab').empty();
	    	console.log("Usli smo u f-ju");
	    	eadresa = localStorage.getItem("email");
	    	
	    	console.log(eadresa);
	    	$.ajax({
	 			type : "GET",
	 			url : "/ljekar/pregledi",
	 			headers: { "Authorization": "Bearer " + token},
	 			data: {eadresa: eadresa},
	 			success : function(data) {
	 		
	 				//localStorage.setItem("kalendar", JSON.stringify(data));
	 				//console.log(data);
	 				
	 				$.each(data, function(key, value) {
	 					podaci = {
	 							id: 'r' + value.id.toString() + key.toString() + 'p', 
	 							name: "P: " + value.pacijentDTO.ime.toString()[0]+". " + value.pacijentDTO.prezime.toString() + " " +value.vrijemePocetka.toString(), 
	 							date: new Date(value.datum), 
	 							type: "birthday"
	 					};
	 					events.push(podaci);
	 				 });
	 				
	 				$('#demoEvoCalendar').evoCalendar({
	 			    	
	 			        todayHighlight: true,
	 			        format: 'mm/dd/yyyy',
	 			        calendarEvents:[{
	 						id: 'fs5fs5', 
	 						name: "O: S. Simic",
	 						date: new Date(), 
	 						type: "holiday"
	 				}]
	 			    });
	 			    
	 			    $('#demoEvoCalendar').evoCalendar('setTheme', "Midnight blue");
	 				
	 			   
	 			    $.each(events, function(key, value) {
	 			    	$("#demoEvoCalendar").evoCalendar('addCalendarEvent', value);
	 			    });
	 			},
	 			error: function(data) {
	 				console.log(data);
	 			}
	    	});
	 }

function goBack(){
	window.location = "zapocinjanjePregleda.html"
}


$(document).ready(function() {
	
	    
	prikaziPreglede();
	

	
    
});