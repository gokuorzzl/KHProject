/**
 * 
 */

(function ($){
	




$(document).ready(function(){
	  $('.backgroundTransition').backgroundTransition({
		  backgrounds:[
			  { src: '../../img/dayeon.png' },
			  { src: '../../img/hyeyeon.png' },
			  { src: '../../img/jongkyu.png' },
			  { src: '../../img/sola.png' },
			  { src: '../../img/myeongsang.png' },
			  { src: '../../img/yeonggi.png' },
			  { src: '../../img/yongseon.png' }
		  ],
		  transitionDelay: 3,
		  animationSpeed: 800
	  });
});


//MENU
$('.menu-burger').on('click', function() {
  $('.menu-bg, .menu-items, .menu-burger').toggleClass('fs');
  $('.menu-burger').text() == "☰" ? $('.menu-burger').text('✕') : $('.menu-burger').text('☰');
});

})(jQuery);