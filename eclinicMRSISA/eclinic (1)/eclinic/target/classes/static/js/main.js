$(document).ready(function () {

    $("#myProfile").on(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });

});

function mojKarton() {

	var jbo = 15;
//    var jbo = $("#jbo").val()
//    search["my-profile"] = $("#moj-karton").val();
//    //search["email"] = $("#email").val();

    $("#myProfile").prop("disabled", true);

    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "homepagePacijent1",
        dataType: "json",
        success: function (result) {
        	location.href = "azurirajProfil.html";
        }
    });

}
