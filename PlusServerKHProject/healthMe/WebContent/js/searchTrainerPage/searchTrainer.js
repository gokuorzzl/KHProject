/**
 * searchTrainer와 관련된 JavaScript
 */

$(function(){
	
//	$('.screenSize').val($(window).width());
//	
//	$(window).resize(function(){//화면 사이즈가 변하는 이벤트가 발생하면 크기를 다시 조정함
//		
//		$('.screenSize').val($(window).width());
//		$('.searchForm').submit(); //form태그를 다시 실행함
//		
//	});
	
	$('.searchFormDiv').click(function(){
		setTimeout( "$('.trainerForm').submit()", 15500 );
	});
	
	$('.trainerForm').click(function(){
		window.open('../../page/searchTrainerPage/trainerBeforeAd.jsp', 'adPopup', 'width=1000, height=600, scrollbars=0, toolbar=0, menubar=no');
		$('.adVideo').play().close();
		window.close();
	});
	
//	$('.adVideo').on('ended', function(){
//		$(this).close();
//	});


});


