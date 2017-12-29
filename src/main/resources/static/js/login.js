$.ajaxSetup({
    beforeSend : function(xhr, settings) {
        if (settings.type == 'POST' || settings.type == 'PUT'
            || settings.type == 'DELETE') {
            if (!(/^http:.*/.test(settings.url) || /^https:.*/
                    .test(settings.url))) {
                // Only send the token to relative URLs i.e. locally.
                xhr.setRequestHeader("X-XSRF-TOKEN", Cookies
                    .get('XSRF-TOKEN'));
            }
        }
    }
});
/*
$.ajax({
    url : "/user",
    success : function(data) {
        $(".error").hide();
        $(".unauthenticated").hide();
        $("#user").html(data.userAuthentication.details.name);
        $(".authenticated").show();
    }

    ,
    error : function(data) {
        $("#user").html('');
        $(".unauthenticated").show();
        $(".authenticated").hide();
        if (location.href.indexOf("error=true")>=0) {
            $(".error").show();
        }
    }
});
*/

$.get("/user", function(data) {
    $("#user").html(data.userAuthentication.details.name);
    $(".unauthenticated").hide();
    $(".authenticated").show();
});

var logout = function() {
    $.post("/logout", function() {
        $("#user").html('');
        $(".unauthenticated").show();
        $(".authenticated").hide();
    })
    return true;
}