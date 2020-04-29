$(document).ready(function () {

    $("#my-profile").click(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });

});

function mojKarton() {

    var jbo = $("#jbo").val()
//    search["my-profile"] = $("#moj-karton").val();
//    //search["email"] = $("#email").val();

    $("#my-profile").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/api/myProfile",
        data: JSON.stringify({"jbo": jbo }),
        dataType: "json",
//        cache: false,
//        timeout: 600000,
        success: function (data) {

//            var json = "<h4>Ajax Response</h4><pre>"
//                + JSON.stringify(data, null, 4) + "</pre>";
//            $('#feedback').html(json);
//
//            console.log("SUCCESS : ", data);
//            $("#btn-search").prop("disabled", false);
//
//        },
//        error: function (e) {
//
//            var json = "<h4>Ajax Response</h4><pre>"
//                + e.responseText + "</pre>";
//            $('#feedback').html(json);
//
//            console.log("ERROR : ", e);
//            $("#btn-search").prop("disabled", false);

        }
    });

}