/**
 * searchTrainerPage에서 작동하는 검색 이외의 스크립트
 */

$(function(){
	
	//로고 누르면 메인페이지로
	$('#logo').click(function(){
		location.href="../../index.jsp";
	});
	
	//메뉴 표시 누르면 메뉴 등장
	$('#menuButton>div>p').click(function(){
		$('#navigation').css('display', 'block');
	});
	
	//mobileMenu에서 누르면 왼쪽에서 떠야 함
	$('#mobileMenu>div>p').click(function(){
		$('#navigation').css('display', 'block');
		$('#menu').css('display', 'none');
	});
	
	//x표시 누르면 메뉴 빠잉빠잉
	//모바일메뉴에서 껐을 수도 있으므로 css 값을 초기화
	$('#navigation>div>p').click(function(){
		$('#navigation').css('display', 'none');
		$('#menu').css('display', 'block');
	});
	
});