(function ($) {
    jQuery.fn.do = function () {
        return $(this)
            .on('click',function(){
                $(this).children().nextAll().toggle(500);
            });
    };
})(jQuery);

$(document).ready(function(){
    $('.el').do();
});