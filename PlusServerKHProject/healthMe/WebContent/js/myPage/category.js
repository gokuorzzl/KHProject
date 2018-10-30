
$(document).ready(function () {

    $("#sport1").change(function () {

        if ($("#sport1").is(":checked")) {
            $('#sport1_sub').css('display', 'block');
            $('#sport2_sub').hide();
            $('#sport3_sub').hide();
            $('#sport4_sub').hide();
            $('#sport5_sub').hide();
            $('#sport6_sub').hide();
            $('#sport7_sub').hide();
        }
    });

    $("#sport2").change(function () {
        if ($("#sport2").is(":checked")) {
            $('#sport2_sub').css('display', 'block');
            $('#sport1_sub').hide();
            $('#sport3_sub').hide();
            $('#sport4_sub').hide();
            $('#sport5_sub').hide();
            $('#sport6_sub').hide();
            $('#sport7_sub').hide();
        }
    });

    $("#sport3").change(function () {
        if ($("#sport3").is(":checked")) {
            $('#sport3_sub').css('display', 'block');
            $('#sport1_sub').hide();
            $('#sport2_sub').hide();
            $('#sport4_sub').hide();
            $('#sport5_sub').hide();
            $('#sport6_sub').hide();
            $('#sport7_sub').hide();
        }
    });

    $("#sport4").change(function () {
        if ($("#sport4").is(":checked")) {
            $('#sport4_sub').css('display', 'block');
            $('#sport1_sub').hide();
            $('#sport2_sub').hide();
            $('#sport3_sub').hide();
            $('#sport5_sub').hide();
            $('#sport6_sub').hide();
            $('#sport7_sub').hide();
        }
    });

    $("#sport5").change(function () {
        if ($("#sport5").is(":checked")) {
            $('#sport5_sub').css('display', 'block');
            $('#sport1_sub').hide();
            $('#sport2_sub').hide();
            $('#sport3_sub').hide();
            $('#sport4_sub').hide();
            $('#sport6_sub').hide();
            $('#sport7_sub').hide();
        }
    });

    $("#sport6").change(function () {
        if ($("#sport6").is(":checked")) {
            $('#sport6_sub').css('display', 'block');
            $('#sport1_sub').hide();
            $('#sport2_sub').hide();
            $('#sport3_sub').hide();
            $('#sport4_sub').hide();
            $('#sport5_sub').hide();
            $('#sport7_sub').hide();
        }
    });

    $("#sport7").change(function () {
        if ($("#sport7").is(":checked")) {
            $('#sport7_sub').css('display', 'block');
            $('#sport1_sub').hide();
            $('#sport2_sub').hide();
            $('#sport3_sub').hide();
            $('#sport4_sub').hide();
            $('#sport5_sub').hide();
            $('#sport6_sub').hide();
        }
    });

});