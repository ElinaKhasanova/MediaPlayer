(function($){
    jQuery.fn.accordion = function(options) {
        var make = function() {
            $(this).click(function () {
                var findArticle = $(this).next().toggle(500);
            });

            // var el = $(this);
            // // el.find(next());
            // console.log(el.find('h3'));
            // el.find('h3').click(function (e) {
            //     console.log($(this));
            // });
        };
        return this.each(make);
    };
})(jQuery);

$(document).ready(function(){
    $('.el').accordion();
});