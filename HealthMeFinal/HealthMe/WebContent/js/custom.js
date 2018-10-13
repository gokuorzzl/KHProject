(function ($) {

  "use strict";

    // 시간 설정함수
    $(window).load(function(){
      $('.preloader').fadeOut(2000); 
    });


    // MENU
    $('.menu-burger').on('click', function() {
      $('.menu-bg, .menu-items, .menu-burger').toggleClass('fs');
      $('.menu-burger').text() == "☰" ? $('.menu-burger').text('✕') : $('.menu-burger').text('☰');
    });


    // 배경 슬라이드 속도 조절
    $('body').vegas({
          overlay: true,
        transition: 'fade', 
        transitionDuration: 4000,
        delay: 7000,
        animation: 'random',
        animationDuration: 20000,
        backgroundSize:'cover',
        slides: [
            { src: 'images/dayeon_bg.jpg' },
            { src: 'images/hyeyeon_bg.jpg' },
            { src: 'images/sola_bg.jpg' },
            { src: 'images/jongkyu_bg.jpg' },
            { src: 'images/myeongsang_bg.jpg' },
            { src: 'images/yeonggi_bg.jpg' },
            { src: 'images/yongseon_bg.jpg' },
        ],
        timer: true,
        transition: [ 'zoomOut', ]
    });

})(jQuery);
