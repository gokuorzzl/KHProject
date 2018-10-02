(function ($) {

  "use strict";

    // PRE LOADER
    $(window).load(function(){
      $('.preloader').fadeOut(1000); // set duration in brackets    
    });


    // MENU
    $('.menu-burger').on('click', function() {
      $('.menu-bg, .menu-items, .menu-burger').toggleClass('fs');
      $('.menu-burger').text() == "☰" ? $('.menu-burger').text('✕') : $('.menu-burger').text('☰');
    });


    // ABOUT SLIDER
    $('body').vegas({
        slides: [
            { src: 'images/dayeon.png' },
            { src: 'images/hyeyeon.png' },
            { src: 'images/sola.png' },
            { src: 'images/jongkyu.png' },
            { src: 'images/myeongsang.png' },
            { src: 'images/yeonggi.png' },
            { src: 'images/yongseon.png' },
        ],
        timer: false,
        transition: [ 'zoomOut', ]
    });

})(jQuery);
