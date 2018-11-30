(function ($) {
    jQuery.fn.acc = function () {
        return $(this)
            .on('click',function(){
                if ($(this).children().is(':visible')){
                    $(this).children().next().slideUp();
                } else{

                    $(this).children().next().slideDown();
                }
                //$(this).children().nextAll().toggle(500);
            });


    };
})(jQuery);

$(document).ready(function(){
    $('.el').acc();
});