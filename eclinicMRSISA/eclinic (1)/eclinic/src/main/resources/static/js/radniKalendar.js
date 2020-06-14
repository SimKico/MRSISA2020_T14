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
	 		
	 				localStorage.setItem("data", JSON.stringify(data));
	 				console.log(data);
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
	
	console.log("Hmmmm");
	    
	prikaziPreglede();
	
	podaci = JSON.parse(localStorage.getItem("data"));
	$.each(podaci, function(key, value) {
			podaci = {
					id: 'r' + value.id.toString() + key.toString() + 'p', 
					name: "P: " + value.pacijentDTO.ime.toString()[0]+". " + value.pacijentDTO.prezime.toString() + " " +value.vrijemePocetka.toString(), 
					date: new Date(value.datum), 
					type: "birthday"
			};
			events.push(podaci);
		 });
	
	console.log(events);
	
    $('#demoEvoCalendar').evoCalendar({
    	
        todayHighlight: true,
        format: 'mm/dd/yyyy',
        calendarEvents: []
    });
    
    $('#demoEvoCalendar').evoCalendar('setTheme', "Midnight blue");
   //$("#demoEvoCalendar").evoCalendar('addCalendarEvent', events);
    $.each(events, function(key, value) {
    	$("#demoEvoCalendar").evoCalendar('addCalendarEvent', value);
    });
});