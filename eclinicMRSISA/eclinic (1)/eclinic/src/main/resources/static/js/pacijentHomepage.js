//$(document).ready(function () {
//
//    $("#listaKlinika").on('click',function (event) {
//
//        //stop submit the form, we will post it manually.
//        event.preventDefault();
//
//        getListaKlinika();
//
//    });
//
//});
//
//function getListaKlinika() {
//
//	
//   $("#listaKlinika").prop("disabled", true);
//
//    $.ajax({
//    	url: "/homepagePacijent1/listaKlinika",
//        method: "GET",
//        contentType: "application/json",
//        
//        dataType: "json",
//        data: {}
//        success: function (result) {
//        	console.log(result);
//        }
//    });
//
//}
