(function( $ ){
    $.fn.accord = function () {

        $('.wrap > article').hide();

        $('.wrap > h3').click(function () {
            var findArticle = $(this).next('article');
            var findWrap = $(this).closest('.wrap');  //ищет род элемент (DOM)

            if (findArticle.is(':visible')){
                findArticle.slideUp('slow');
            } else{
                findWrap.find('>article').slideUp('slow');
                findArticle.slideDown('slow');
            }
        });
    };
})( jQuery );

$(document).ready($('.wrap').accord);