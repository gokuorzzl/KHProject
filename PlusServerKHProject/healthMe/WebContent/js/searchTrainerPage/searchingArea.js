/**
 * 광역시/도, 시/군/구, 읍/면/동 선택, 종목선택
 */

	
$(function(){
	
	//각 검색 선택어들을 담기 위한 변수
	var area1=null;
	var area2=null;
	var area3=new Array();
	var field=new Array();
	
	$('#field li').click(function(){//종목 선택에 관한 함수

		if(field==""){//종목을 최초로 선택하는 경우(field 배열이 비어있는 경우)
			$(this).css('background-color', '#FF9B55'); //주황색으로 배경색 변경
			field.push($(this).html());	//field배열에 담아줌
		}else if(field.includes($(this).html())){ //한 번 선택한 값을 다시 선택하는 경우(사용자가 취소하는 경우)(field 배열에 해당 값이 있는 경우)
			$(this).css('background-color', 'white'); //배경색을 흰색으로 변경
			for(var i=0; i<field.length; i++){
				if(field[i]==$(this).html()){ //field 배열 내에 현재 선택한 내용과 일치하는 내용이 있는경우
					field.splice(i, 1); //해당 값을 field에서 삭제
				}
			}
		}else{
			$(this).css('background-color', '#FF9B55'); //처음 선택한 값은 아니지만 새로운 값을 선택한 경우
			field.push($(this).html());	//배열에 해당 값 추가
		}
	});
	
	$('#area li:eq(0)').click(function(){//서울특별시 선택
		
		if(area1==$(this).html()){
			$(this).css('background-color', 'white');
			area1=null;
			$('#subArea>ul').html('');
			$('#subArea2>ul').html('');
		}else{
			$('#area li').css('background', 'white');
			$(this).css('background-color', '#FF9B55');
			area1=$(this).html();
			$('#subArea>ul').html('<li>종로구</li>');
			$('#subArea>ul').append('<li>중구</li>');
			$('#subArea>ul').append('<li>용산구</li>');
			$('#subArea>ul').append('<li>성동구</li>');
			$('#subArea>ul').append('<li>광진구</li>');
			$('#subArea>ul').append('<li>동대문구</li>');
			$('#subArea>ul').append('<li>중랑구</li>');
			$('#subArea>ul').append('<li>성북구</li>');
			$('#subArea>ul').append('<li>강북구</li>');
			$('#subArea>ul').append('<li>도봉구</li>');
			$('#subArea>ul').append('<li>노원구</li>');
			$('#subArea>ul').append('<li>은평구</li>');
			$('#subArea>ul').append('<li>서대문구</li>');
			$('#subArea>ul').append('<li>마포구</li>');
			$('#subArea>ul').append('<li>양천구</li>');
			$('#subArea>ul').append('<li>강서구</li>');
			$('#subArea>ul').append('<li>구로구</li>');
			$('#subArea>ul').append('<li>금천구</li>');
			$('#subArea>ul').append('<li>영등포구</li>');
			$('#subArea>ul').append('<li>동작구</li>');
			$('#subArea>ul').append('<li>관악구</li>');
			$('#subArea>ul').append('<li>서초구</li>');
			$('#subArea>ul').append('<li>강남구</li>');
			$('#subArea>ul').append('<li>송파구</li>');
			$('#subArea>ul').append('<li>강동구</li>');	
			
			$('#subArea li:eq(0)').click(function(){//서울특별시 종로구 선택
				if(area2==$(this).html()){
					$(this).css('background-color', 'white');
					area2=null;
					$('#subArea2>ul').html('');
				}else{
					$('#subArea li').css('background', 'white');
					$(this).css('background-color', '#FF9B55');
					area2=$(this).html();
					$('#subArea2>ul').html('<li>청운효자동</li>');
					$('#subArea2>ul').append('<li>사직동</li>');
					$('#subArea2>ul').append('<li>삼청동</li>');
					$('#subArea2>ul').append('<li>부암동</li>');
					$('#subArea2>ul').append('<li>평창동</li>');
					$('#subArea2>ul').append('<li>무악동</li>');
					$('#subArea2>ul').append('<li>교남동</li>');
					$('#subArea2>ul').append('<li>가회동</li>');
					$('#subArea2>ul').append('<li>종로1/2/3/4동</li>');
					$('#subArea2>ul').append('<li>종로5/6동</li>');
					$('#subArea2>ul').append('<li>이화동</li>');
					$('#subArea2>ul').append('<li>혜화동</li>');
					$('#subArea2>ul').append('<li>창신1동</li>');
					$('#subArea2>ul').append('<li>창신2동</li>');
					$('#subArea2>ul').append('<li>창신3동</li>');
					$('#subArea2>ul').append('<li>숭인1동</li>');
					$('#subArea2>ul').append('<li>숭인2동</li>');
					
					$('#subArea2 li').click(function(){//읍/면/동 선택 -> 메소드로 만들어서 중복코드 줄이기
						if(area3==""){//읍/면/동을 최초로 선택하는 경우(area3 배열이 비어있는 경우)
							$(this).css('background-color', '#FF9B55'); //주황색으로 배경색 변경
							area3.push($(this).html());	//area3배열에 담아줌
						}else if(area3.includes($(this).html())){ //한 번 선택한 값을 다시 선택하는 경우(사용자가 취소하는 경우)(area3 배열에 해당 값이 있는 경우)
							$(this).css('background-color', 'white'); //배경색을 흰색으로 변경
							for(var i=0; i<area3.length; i++){
								if(area3[i]==$(this).html()){ //area3 배열 내에 현재 선택한 내용과 일치하는 내용이 있는경우
									field.splice(i, 1); //해당 값을 area3에서 삭제
								}
							}
						}else{
							$(this).css('background-color', '#FF9B55'); //처음 선택한 값은 아니지만 새로운 값을 선택한 경우
							area3.push($(this).html());	//배열에 해당 값 추가
						}
					});


					
				}
			});//서울특별시 종로구 '읍/면/동'함수 끝
			
			$('#subArea li:eq(1)').click(function(){//서울특별시 중구 선택
				if(area2==$(this).html()){
					$(this).css('background-color', 'white');
					area2=null;
					$('#subArea2>ul').html('');
				}else{
					$('#subArea li').css('background', 'white');
					$(this).css('background-color', '#FF9B55');
					area2=$(this).html();
					$('#subArea2>ul').html('<li>소공동</li>');
					$('#subArea2>ul').append('<li>회현동</li>');
					$('#subArea2>ul').append('<li>명동</li>');
					$('#subArea2>ul').append('<li>필동</li>');
					$('#subArea2>ul').append('<li>장충동</li>');
					$('#subArea2>ul').append('<li>광희동</li>');
					$('#subArea2>ul').append('<li>을지로동</li>');
					$('#subArea2>ul').append('<li>신당동</li>');
					$('#subArea2>ul').append('<li>다산동</li>');
					$('#subArea2>ul').append('<li>약수동</li>');
					$('#subArea2>ul').append('<li>청구동</li>');
					$('#subArea2>ul').append('<li>신당제5동</li>');
					$('#subArea2>ul').append('<li>동화동</li>');
					$('#subArea2>ul').append('<li>황학동</li>');
					$('#subArea2>ul').append('<li>중림동</li>');
				}
			});//서울특별시 중구 '읍/면/동'함수 끝
			
			$('#subArea li:eq(2)').click(function(){//서울특별시 용산구 선택
				if(area2==$(this).html()){
					$(this).css('background-color', 'white');
					area2=null;
					$('#subArea2>ul').html('');
				}else{
					$('#subArea li').css('background', 'white');
					$(this).css('background-color', '#FF9B55');
					area2=$(this).html();
					$('#subArea2>ul').html('<li>후암동</li>');
					$('#subArea2>ul').append('<li>용산2가동</li>');
					$('#subArea2>ul').append('<li>남영동</li>');
					$('#subArea2>ul').append('<li>청파동</li>');
					$('#subArea2>ul').append('<li>원효로1동</li>');
					$('#subArea2>ul').append('<li>원효로2동</li>');
					$('#subArea2>ul').append('<li>효창동</li>');
					$('#subArea2>ul').append('<li>용문동</li>');
					$('#subArea2>ul').append('<li>한강로동</li>');
					$('#subArea2>ul').append('<li>이촌1동</li>');
					$('#subArea2>ul').append('<li>이촌2동</li>');
					$('#subArea2>ul').append('<li>이태원1동</li>');
					$('#subArea2>ul').append('<li>이태원2동</li>');
					$('#subArea2>ul').append('<li>한남동</li>');
					$('#subArea2>ul').append('<li>서빙고동</li>');
					$('#subArea2>ul').append('<li>보광동</li>');
				}
			});//서울특별시 용산구 '읍/면/동'함수 끝
			
			$('#subArea li:eq(3)').click(function(){//서울특별시 성동구 선택
				if(area2==$(this).html()){
					$(this).css('background-color', 'white');
					area2=null;
					$('#subArea2>ul').html('');
				}else{
					$('#subArea li').css('background', 'white');
					$(this).css('background-color', '#FF9B55');
					area2=$(this).html();
					$('#subArea2>ul').html('<li>왕십리제2동</li>');
					$('#subArea2>ul').append('<li>왕십리도선동</li>');
					$('#subArea2>ul').append('<li>마장동</li>');
					$('#subArea2>ul').append('<li>사근동</li>');
					$('#subArea2>ul').append('<li>행당제1동</li>');
					$('#subArea2>ul').append('<li>행당제2동</li>');
					$('#subArea2>ul').append('<li>응봉동</li>');
					$('#subArea2>ul').append('<li>금호1가동</li>');
					$('#subArea2>ul').append('<li>금호2/3동</li>');
					$('#subArea2>ul').append('<li>금호4가동</li>');
					$('#subArea2>ul').append('<li>성수1가제1동</li>');
					$('#subArea2>ul').append('<li>성수1가제2동</li>');
					$('#subArea2>ul').append('<li>성수2가제1동</li>');
					$('#subArea2>ul').append('<li>성수2가제3동</li>');
					$('#subArea2>ul').append('<li>송정동</li>');
					$('#subArea2>ul').append('<li>용답동</li>');
					$('#subArea2>ul').append('<li>옥수동</li>');
				}
			});//서울특별시 성동구 '읍/면/동'함수 끝
			
			$('#subArea li:eq(4)').click(function(){//서울특별시 광진구 선택
				if(area2==$(this).html()){
					$(this).css('background-color', 'white');
					area2=null;
					$('#subArea2>ul').html('');
				}else{
					$('#subArea li').css('background', 'white');
					$(this).css('background-color', '#FF9B55');
					area2=$(this).html();
					$('#subArea2>ul').html('<li>중곡제1동</li>');
					$('#subArea2>ul').append('<li>중곡제2동</li>');
					$('#subArea2>ul').append('<li>중곡제3동</li>');
					$('#subArea2>ul').append('<li>중곡제4동</li>');
					$('#subArea2>ul').append('<li>능동</li>');
					$('#subArea2>ul').append('<li>구의제1동</li>');
					$('#subArea2>ul').append('<li>구의제2동</li>');
					$('#subArea2>ul').append('<li>구의제3동</li>');
					$('#subArea2>ul').append('<li>광장동</li>');
					$('#subArea2>ul').append('<li>자양제1동</li>');
					$('#subArea2>ul').append('<li>자양제2동</li>');
					$('#subArea2>ul').append('<li>자양제3동</li>');
					$('#subArea2>ul').append('<li>자양제4동</li>');
					$('#subArea2>ul').append('<li>화양동</li>');
					$('#subArea2>ul').append('<li>군자동</li>');
				}
			});//서울특별시 광진구 '읍/면/동'함수 끝
			
			$('#subArea li:eq(5)').click(function(){//서울특별시 동대문구 선택
				if(area2==$(this).html()){
					$(this).css('background-color', 'white');
					area2=null;
					$('#subArea2>ul').html('');
				}else{
					$('#subArea li').css('background', 'white');
					$(this).css('background-color', '#FF9B55');
					area2=$(this).html();
					$('#subArea2>ul').html('<li>용신동</li>');
					$('#subArea2>ul').append('<li>제기동</li>');
					$('#subArea2>ul').append('<li>전농제1동</li>');
					$('#subArea2>ul').append('<li>전농제2동</li>');
					$('#subArea2>ul').append('<li>답십리제1동</li>');
					$('#subArea2>ul').append('<li>답십리제2동</li>');
					$('#subArea2>ul').append('<li>장안제1동</li>');
					$('#subArea2>ul').append('<li>장안제2동</li>');
					$('#subArea2>ul').append('<li>청량리동</li>');
					$('#subArea2>ul').append('<li>회기동</li>');
					$('#subArea2>ul').append('<li>휘경제1동</li>');
					$('#subArea2>ul').append('<li>휘경제2동</li>');
					$('#subArea2>ul').append('<li>이문제1동</li>');
					$('#subArea2>ul').append('<li>이문제2동</li>');
				}
			});//서울특별시 동대문구 '읍/면/동'함수 끝
			
			$('#subArea li:eq(6)').click(function(){//서울특별시 중랑구 선택
				if(area2==$(this).html()){
					$(this).css('background-color', 'white');
					area2=null;
					$('#subArea2>ul').html('');
				}else{
					$('#subArea li').css('background', 'white');
					$(this).css('background-color', '#FF9B55');
					area2=$(this).html();
					$('#subArea2>ul').html('<li>면목본동</li>');
					$('#subArea2>ul').append('<li>면목제2동</li>');
					$('#subArea2>ul').append('<li>면목제3/8동</li>');
					$('#subArea2>ul').append('<li>면목제4동</li>');
					$('#subArea2>ul').append('<li>면목제5동</li>');
					$('#subArea2>ul').append('<li>면목제7동</li>');
					$('#subArea2>ul').append('<li>상봉제1동</li>');
					$('#subArea2>ul').append('<li>상봉제2동</li>');
					$('#subArea2>ul').append('<li>중화제1동</li>');
					$('#subArea2>ul').append('<li>중화제2동</li>');
					$('#subArea2>ul').append('<li>묵제1동</li>');
					$('#subArea2>ul').append('<li>묵제2동</li>');
					$('#subArea2>ul').append('<li>망우본동</li>');
					$('#subArea2>ul').append('<li>망우제3동</li>');
					$('#subArea2>ul').append('<li>신내1동</li>');
					$('#subArea2>ul').append('<li>신내2동</li>');
				}
			});//서울특별시 중랑구 '읍/면/동'함수 끝
			
			$('#subArea li:eq(7)').click(function(){//서울특별시 성북구 선택
				if(area2==$(this).html()){
					$(this).css('background-color', 'white');
					area2=null;
					$('#subArea2>ul').html('');
				}else{
					$('#subArea li').css('background', 'white');
					$(this).css('background-color', '#FF9B55');
					area2=$(this).html();
					$('#subArea2>ul').html('<li>성북동</li>');
					$('#subArea2>ul').append('<li>삼선동</li>');
					$('#subArea2>ul').append('<li>동선동</li>');
					$('#subArea2>ul').append('<li>돈암제1동</li>');
					$('#subArea2>ul').append('<li>돈암제2동</li>');
					$('#subArea2>ul').append('<li>안암동</li>');
					$('#subArea2>ul').append('<li>보문동</li>');
					$('#subArea2>ul').append('<li>정릉제1동</li>');
					$('#subArea2>ul').append('<li>정릉제2동</li>');
					$('#subArea2>ul').append('<li>정릉제3동</li>');
					$('#subArea2>ul').append('<li>정릉제4동</li>');
					$('#subArea2>ul').append('<li>정릉제5동</li>');
					$('#subArea2>ul').append('<li>길음제1동</li>');
					$('#subArea2>ul').append('<li>길음제2동</li>');
					$('#subArea2>ul').append('<li>종암동</li>');
					$('#subArea2>ul').append('<li>월곡제1동</li>');
					$('#subArea2>ul').append('<li>월곡제2동</li>');
					$('#subArea2>ul').append('<li>장위제1동</li>');
					$('#subArea2>ul').append('<li>장위제2동</li>');
					$('#subArea2>ul').append('<li>장위제3동</li>');
					$('#subArea2>ul').append('<li>석관동</li>');
				}
			});//서울특별시 성북구 '읍/면/동'함수 끝
			
			$('#subArea li:eq(8)').click(function(){//서울특별시 강북구 선택
				if(area2==$(this).html()){
					$(this).css('background-color', 'white');
					area2=null;
					$('#subArea2>ul').html('');
				}else{
					$('#subArea li').css('background', 'white');
					$(this).css('background-color', '#FF9B55');
					area2=$(this).html();
					$('#subArea2>ul').html('<li>삼양동</li>');
					$('#subArea2>ul').append('<li>미아동</li>');
					$('#subArea2>ul').append('<li>송중동</li>');
					$('#subArea2>ul').append('<li>삼각산동</li>');
					$('#subArea2>ul').append('<li>번제1동</li>');
					$('#subArea2>ul').append('<li>번제2동</li>');
					$('#subArea2>ul').append('<li>번제3동</li>');
					$('#subArea2>ul').append('<li>수유제1동</li>');
					$('#subArea2>ul').append('<li>수유제2동</li>');
					$('#subArea2>ul').append('<li>수유제3동</li>');
					$('#subArea2>ul').append('<li>우이동</li>');
					$('#subArea2>ul').append('<li>인수동</li>');
				}
			});//서울특별시 강북구 '읍/면/동'함수 끝
			
			$('#subArea li:eq(9)').click(function(){//서울특별시 도봉구 선택
				if(area2==$(this).html()){
					$(this).css('background-color', 'white');
					area2=null;
					$('#subArea2>ul').html('');
				}else{
					$('#subArea li').css('background', 'white');
					$(this).css('background-color', '#FF9B55');
					area2=$(this).html();
					$('#subArea2>ul').html('<li>쌍문제1동</li>');
					$('#subArea2>ul').append('<li>쌍문제2동</li>');
					$('#subArea2>ul').append('<li>쌍문제3동</li>');
					$('#subArea2>ul').append('<li>쌍문제4동</li>');
					$('#subArea2>ul').append('<li>방학제1동</li>');
					$('#subArea2>ul').append('<li>방학제2동</li>');
					$('#subArea2>ul').append('<li>창제1동</li>');
					$('#subArea2>ul').append('<li>창제2동</li>');
					$('#subArea2>ul').append('<li>창제3동</li>');
					$('#subArea2>ul').append('<li>창제4동</li>');
					$('#subArea2>ul').append('<li>창제5동</li>');
					$('#subArea2>ul').append('<li>도봉제1동</li>');
					$('#subArea2>ul').append('<li>도봉제2동</li>');
				}
			});//서울특별시 도봉구 '읍/면/동'함수 끝
			
			$('#subArea li:eq(10)').click(function(){//서울특별시 노원구 선택
				if(area2==$(this).html()){
					$(this).css('background-color', 'white');
					area2=null;
					$('#subArea2>ul').html('');
				}else{
					$('#subArea li').css('background', 'white');
					$(this).css('background-color', '#FF9B55');
					area2=$(this).html();
					$('#subArea2>ul').html('<li>월계1동</li>');
					$('#subArea2>ul').append('<li>월계2동</li>');
					$('#subArea2>ul').append('<li>월계3동</li>');
					$('#subArea2>ul').append('<li>공릉1동</li>');
					$('#subArea2>ul').append('<li>공릉2동</li>');
					$('#subArea2>ul').append('<li>하계1동</li>');
					$('#subArea2>ul').append('<li>하계2동</li>');
					$('#subArea2>ul').append('<li>중계본동</li>');
					$('#subArea2>ul').append('<li>중계1동</li>');
					$('#subArea2>ul').append('<li>중계2/3동</li>');
					$('#subArea2>ul').append('<li>중계4동</li>');
					$('#subArea2>ul').append('<li>상계1동</li>');
					$('#subArea2>ul').append('<li>상계2동</li>');
					$('#subArea2>ul').append('<li>상계3/4동</li>');
					$('#subArea2>ul').append('<li>상계5동</li>');
					$('#subArea2>ul').append('<li>상계6/7동</li>');
					$('#subArea2>ul').append('<li>상계8동</li>');
					$('#subArea2>ul').append('<li>상계9동</li>');
					$('#subArea2>ul').append('<li>상계10동</li>');
				}
			});//서울특별시 노원구 '읍/면/동'함수 끝
			
			$('#subArea li:eq(11)').click(function(){//서울특별시 은평구 선택
				if(area2==$(this).html()){
					$(this).css('background-color', 'white');
					area2=null;
					$('#subArea2>ul').html('');
				}else{
					$('#subArea li').css('background', 'white');
					$(this).css('background-color', '#FF9B55');
					area2=$(this).html();
					$('#subArea2>ul').html('<li>녹번동</li>');
					$('#subArea2>ul').append('<li>불광제1동</li>');
					$('#subArea2>ul').append('<li>불광제2동</li>');
					$('#subArea2>ul').append('<li>갈현제1동</li>');
					$('#subArea2>ul').append('<li>갈현제2동</li>');
					$('#subArea2>ul').append('<li>구산동</li>');
					$('#subArea2>ul').append('<li>대조동</li>');
					$('#subArea2>ul').append('<li>응암제1동</li>');
					$('#subArea2>ul').append('<li>응암제2동</li>');
					$('#subArea2>ul').append('<li>응암제3동</li>');
					$('#subArea2>ul').append('<li>역촌동</li>');
					$('#subArea2>ul').append('<li>신사제1동</li>');
					$('#subArea2>ul').append('<li>신사제2동</li>');
					$('#subArea2>ul').append('<li>증산동</li>');
					$('#subArea2>ul').append('<li>수색동</li>');
					$('#subArea2>ul').append('<li>진관동</li>');
				}
			});//서울특별시 은평구 '읍/면/동'함수 끝
			
			$('#subArea li:eq(12)').click(function(){//서울특별시 서대문구 선택
				if(area2==$(this).html()){
					$(this).css('background-color', 'white');
					area2=null;
					$('#subArea2>ul').html('');
				}else{
					$('#subArea li').css('background', 'white');
					$(this).css('background-color', '#FF9B55');
					area2=$(this).html();
					$('#subArea2>ul').html('<li>충현동</li>');
					$('#subArea2>ul').append('<li>천연동</li>');
					$('#subArea2>ul').append('<li>북아현동</li>');
					$('#subArea2>ul').append('<li>신촌동</li>');
					$('#subArea2>ul').append('<li>연희동</li>');
					$('#subArea2>ul').append('<li>홍제제1동</li>');
					$('#subArea2>ul').append('<li>홍제제2동</li>');
					$('#subArea2>ul').append('<li>홍제제3동</li>');
					$('#subArea2>ul').append('<li>홍은제1동</li>');
					$('#subArea2>ul').append('<li>홍은제2동</li>');
					$('#subArea2>ul').append('<li>남가좌제1동</li>');
					$('#subArea2>ul').append('<li>남가좌제2동</li>');
					$('#subArea2>ul').append('<li>북가좌제1동</li>');
					$('#subArea2>ul').append('<li>북가좌제2동</li>');
				}
			});//서울특별시 서대문구 '읍/면/동'함수 끝
			
			$('#subArea li:eq(13)').click(function(){//서울특별시 마포구 선택
				if(area2==$(this).html()){
					$(this).css('background-color', 'white');
					area2=null;
					$('#subArea2>ul').html('');
				}else{
					$('#subArea li').css('background', 'white');
					$(this).css('background-color', '#FF9B55');
					area2=$(this).html();
					$('#subArea2>ul').html('<li>공덕동</li>');
					$('#subArea2>ul').append('<li>아현동</li>');
					$('#subArea2>ul').append('<li>도화동</li>');
					$('#subArea2>ul').append('<li>용강동</li>');
					$('#subArea2>ul').append('<li>대흥동</li>');
					$('#subArea2>ul').append('<li>염리동</li>');
					$('#subArea2>ul').append('<li>신수동</li>');
					$('#subArea2>ul').append('<li>서강동</li>');
					$('#subArea2>ul').append('<li>서교동</li>');
					$('#subArea2>ul').append('<li>합정동</li>');
					$('#subArea2>ul').append('<li>망원제1동</li>');
					$('#subArea2>ul').append('<li>망원제2동</li>');
					$('#subArea2>ul').append('<li>연남동</li>');
					$('#subArea2>ul').append('<li>성산제1동</li>');
					$('#subArea2>ul').append('<li>성산제2동</li>');
					$('#subArea2>ul').append('<li>상암동</li>');
				}
			});//서울특별시 마포구 '읍/면/동'함수 끝
			
			$('#subArea li:eq(14)').click(function(){//서울특별시 양천구 선택
				if(area2==$(this).html()){
					$(this).css('background-color', 'white');
					area2=null;
					$('#subArea2>ul').html('');
				}else{
					$('#subArea li').css('background', 'white');
					$(this).css('background-color', '#FF9B55');
					area2=$(this).html();
					$('#subArea2>ul').html('<li>목1동</li>');
					$('#subArea2>ul').append('<li>목2동</li>');
					$('#subArea2>ul').append('<li>목3동</li>');
					$('#subArea2>ul').append('<li>목4동</li>');
					$('#subArea2>ul').append('<li>목5동</li>');
					$('#subArea2>ul').append('<li>신월1동</li>');
					$('#subArea2>ul').append('<li>신월2동</li>');
					$('#subArea2>ul').append('<li>신월3동</li>');
					$('#subArea2>ul').append('<li>신월4동</li>');
					$('#subArea2>ul').append('<li>신월5동</li>');
					$('#subArea2>ul').append('<li>신월6동</li>');
					$('#subArea2>ul').append('<li>신월7동</li>');
					$('#subArea2>ul').append('<li>신정1동</li>');
					$('#subArea2>ul').append('<li>신정2동</li>');
					$('#subArea2>ul').append('<li>신정3동</li>');
					$('#subArea2>ul').append('<li>신정4동</li>');
					$('#subArea2>ul').append('<li>신정6동</li>');
					$('#subArea2>ul').append('<li>신정7동</li>');
				}
			});//서울특별시 양천구 '읍/면/동'함수 끝
			
			$('#subArea li:eq(15)').click(function(){//서울특별시 강서구 선택
				if(area2==$(this).html()){
					$(this).css('background-color', 'white');
					area2=null;
					$('#subArea2>ul').html('');
				}else{
					$('#subArea li').css('background', 'white');
					$(this).css('background-color', '#FF9B55');
					area2=$(this).html();
					$('#subArea2>ul').html('<li>염창동</li>');
					$('#subArea2>ul').append('<li>등촌제1동</li>');
					$('#subArea2>ul').append('<li>등촌제2동</li>');
					$('#subArea2>ul').append('<li>등촌제3동</li>');
					$('#subArea2>ul').append('<li>화곡본동</li>');
					$('#subArea2>ul').append('<li>화곡제1동</li>');
					$('#subArea2>ul').append('<li>화곡제2동</li>');
					$('#subArea2>ul').append('<li>화곡제3동</li>');
					$('#subArea2>ul').append('<li>화곡제4동</li>');
					$('#subArea2>ul').append('<li>화곡제6동</li>');
					$('#subArea2>ul').append('<li>화곡제8동</li>');
					$('#subArea2>ul').append('<li>우장산동</li>');
					$('#subArea2>ul').append('<li>가양제1동</li>');
					$('#subArea2>ul').append('<li>가양제2동</li>');
					$('#subArea2>ul').append('<li>가양제3동</li>');
					$('#subArea2>ul').append('<li>발산제1동</li>');
					$('#subArea2>ul').append('<li>공항동</li>');
					$('#subArea2>ul').append('<li>방화제1동</li>');
					$('#subArea2>ul').append('<li>방화제2동</li>');
					$('#subArea2>ul').append('<li>방화제3동</li>');
				}
			});//서울특별시 강서구 '읍/면/동'함수 끝
			
			$('#subArea li:eq(16)').click(function(){//서울특별시 구로구 선택
				if(area2==$(this).html()){
					$(this).css('background-color', 'white');
					area2=null;
					$('#subArea2>ul').html('');
				}else{
					$('#subArea li').css('background', 'white');
					$(this).css('background-color', '#FF9B55');
					area2=$(this).html();
					$('#subArea2>ul').html('<li>신도림동</li>');
					$('#subArea2>ul').append('<li>구로제1동</li>');
					$('#subArea2>ul').append('<li>구로제2동</li>');
					$('#subArea2>ul').append('<li>구로제3동</li>');
					$('#subArea2>ul').append('<li>구로제4동</li>');
					$('#subArea2>ul').append('<li>구로제5동</li>');
					$('#subArea2>ul').append('<li>가리봉동</li>');
					$('#subArea2>ul').append('<li>고척제1동</li>');
					$('#subArea2>ul').append('<li>고척제2동</li>');
					$('#subArea2>ul').append('<li>개봉제1동</li>');
					$('#subArea2>ul').append('<li>개봉제2동</li>');
					$('#subArea2>ul').append('<li>개봉제3동</li>');
					$('#subArea2>ul').append('<li>오류제1동</li>');
					$('#subArea2>ul').append('<li>오류제2동</li>');
					$('#subArea2>ul').append('<li>수궁동</li>');
				}
			});//서울특별시 구로구 '읍/면/동'함수 끝
			
			$('#subArea li:eq(17)').click(function(){//서울특별시 금천구 선택
				if(area2==$(this).html()){
					$(this).css('background-color', 'white');
					area2=null;
					$('#subArea2>ul').html('');
				}else{
					$('#subArea li').css('background', 'white');
					$(this).css('background-color', '#FF9B55');
					area2=$(this).html();
					$('#subArea2>ul').html('<li>신도림동</li>');
					$('#subArea2>ul').append('<li>가산동</li>');
					$('#subArea2>ul').append('<li>독산제1동</li>');
					$('#subArea2>ul').append('<li>독산제2동</li>');
					$('#subArea2>ul').append('<li>독산제3동</li>');
					$('#subArea2>ul').append('<li>독산제4동</li>');
					$('#subArea2>ul').append('<li>시흥제1동</li>');
					$('#subArea2>ul').append('<li>시흥제2동</li>');
					$('#subArea2>ul').append('<li>시흥제3동</li>');
					$('#subArea2>ul').append('<li>시흥제4동</li>');
					$('#subArea2>ul').append('<li>시흥제5동</li>');
				}
			});//서울특별시 금천구 '읍/면/동'함수 끝
			
			$('#subArea li:eq(18)').click(function(){//서울특별시 영등포구 선택
				if(area2==$(this).html()){
					$(this).css('background-color', 'white');
					area2=null;
					$('#subArea2>ul').html('');
				}else{
					$('#subArea li').css('background', 'white');
					$(this).css('background-color', '#FF9B55');
					area2=$(this).html();
					$('#subArea2>ul').html('<li>영등포본동</li>');
					$('#subArea2>ul').append('<li>영등포동</li>');
					$('#subArea2>ul').append('<li>여의동</li>');
					$('#subArea2>ul').append('<li>당산제1동</li>');
					$('#subArea2>ul').append('<li>당산제2동</li>');
					$('#subArea2>ul').append('<li>문래동</li>');
					$('#subArea2>ul').append('<li>양평제1동</li>');
					$('#subArea2>ul').append('<li>양평제2동</li>');
					$('#subArea2>ul').append('<li>신길제1동</li>');
					$('#subArea2>ul').append('<li>신길제3동</li>');
					$('#subArea2>ul').append('<li>신길제4동</li>');
					$('#subArea2>ul').append('<li>신길제5동</li>');
					$('#subArea2>ul').append('<li>신길제6동</li>');
					$('#subArea2>ul').append('<li>신길제7동</li>');
					$('#subArea2>ul').append('<li>대림제1동</li>');
					$('#subArea2>ul').append('<li>대림제2동</li>');
					$('#subArea2>ul').append('<li>대림제3동</li>');
					$('#subArea2>ul').append('<li>도림동</li>');
				}
			});//서울특별시 영등포구 '읍/면/동'함수 끝
			
			$('#subArea li:eq(19)').click(function(){//서울특별시 동작구 선택
				if(area2==$(this).html()){
					$(this).css('background-color', 'white');
					area2=null;
					$('#subArea2>ul').html('');
				}else{
					$('#subArea li').css('background', 'white');
					$(this).css('background-color', '#FF9B55');
					area2=$(this).html();
					$('#subArea2>ul').html('<li>노량진제1동</li>');
					$('#subArea2>ul').append('<li>노량진제2동</li>');
					$('#subArea2>ul').append('<li>상도제1동</li>');
					$('#subArea2>ul').append('<li>상도제2동</li>');
					$('#subArea2>ul').append('<li>상도제3동</li>');
					$('#subArea2>ul').append('<li>상도제4동</li>');
					$('#subArea2>ul').append('<li>흑석동</li>');
					$('#subArea2>ul').append('<li>사당제1동</li>');
					$('#subArea2>ul').append('<li>사당제2동</li>');
					$('#subArea2>ul').append('<li>사당제3동</li>');
					$('#subArea2>ul').append('<li>사당제4동</li>');
					$('#subArea2>ul').append('<li>사당제5동</li>');
					$('#subArea2>ul').append('<li>대방동</li>');
					$('#subArea2>ul').append('<li>신대방제1동</li>');
					$('#subArea2>ul').append('<li>신대방제2동</li>');
				}
			});//서울특별시 동작구 '읍/면/동'함수 끝
			
			$('#subArea li:eq(20)').click(function(){//서울특별시 관악구 선택
				if(area2==$(this).html()){
					$(this).css('background-color', 'white');
					area2=null;
					$('#subArea2>ul').html('');
				}else{
					$('#subArea li').css('background', 'white');
					$(this).css('background-color', '#FF9B55');
					area2=$(this).html();
					$('#subArea2>ul').html('<li>보라매동</li>');
					$('#subArea2>ul').append('<li>청림동</li>');
					$('#subArea2>ul').append('<li>행운동</li>');
					$('#subArea2>ul').append('<li>낙성대동</li>');
					$('#subArea2>ul').append('<li>중앙동</li>');
					$('#subArea2>ul').append('<li>인헌동</li>');
					$('#subArea2>ul').append('<li>남현동</li>');
					$('#subArea2>ul').append('<li>서원동</li>');
					$('#subArea2>ul').append('<li>신원동</li>');
					$('#subArea2>ul').append('<li>서림동</li>');
					$('#subArea2>ul').append('<li>신사동</li>');
					$('#subArea2>ul').append('<li>신림동</li>');
					$('#subArea2>ul').append('<li>난향동</li>');
					$('#subArea2>ul').append('<li>조원동</li>');
					$('#subArea2>ul').append('<li>대학동</li>');
					$('#subArea2>ul').append('<li>은천동</li>');
					$('#subArea2>ul').append('<li>성현동</li>');
					$('#subArea2>ul').append('<li>청룡동</li>');
					$('#subArea2>ul').append('<li>난곡동</li>');
					$('#subArea2>ul').append('<li>삼성동</li>');
					$('#subArea2>ul').append('<li>미성동</li>');
				}
			});//서울특별시 관악구 '읍/면/동'함수 끝
			
			$('#subArea li:eq(21)').click(function(){//서울특별시 서초구 선택
				if(area2==$(this).html()){
					$(this).css('background-color', 'white');
					area2=null;
					$('#subArea2>ul').html('');
				}else{
					$('#subArea li').css('background', 'white');
					$(this).css('background-color', '#FF9B55');
					area2=$(this).html();
					$('#subArea2>ul').html('<li>서초1동</li>');
					$('#subArea2>ul').append('<li>서초2동</li>');
					$('#subArea2>ul').append('<li>서초3동</li>');
					$('#subArea2>ul').append('<li>서초4동</li>');
					$('#subArea2>ul').append('<li>잠원동</li>');
					$('#subArea2>ul').append('<li>반포1동</li>');
					$('#subArea2>ul').append('<li>반포2동</li>');
					$('#subArea2>ul').append('<li>반포3동</li>');
					$('#subArea2>ul').append('<li>반포4동</li>');
					$('#subArea2>ul').append('<li>방배본동</li>');
					$('#subArea2>ul').append('<li>방배1동</li>');
					$('#subArea2>ul').append('<li>방배2동</li>');
					$('#subArea2>ul').append('<li>방배3동</li>');
					$('#subArea2>ul').append('<li>방배4동</li>');
					$('#subArea2>ul').append('<li>양재1동</li>');
					$('#subArea2>ul').append('<li>양재2동</li>');
					$('#subArea2>ul').append('<li>내곡동</li>');
				}
			});//서울특별시 서초구 '읍/면/동'함수 끝
			
			$('#subArea li:eq(22)').click(function(){//서울특별시 강남구 선택
				if(area2==$(this).html()){
					$(this).css('background-color', 'white');
					area2=null;
					$('#subArea2>ul').html('');
				}else{
					$('#subArea li').css('background', 'white');
					$(this).css('background-color', '#FF9B55');
					area2=$(this).html();
					$('#subArea2>ul').html('<li>신사동</li>');
					$('#subArea2>ul').append('<li>논현1동</li>');
					$('#subArea2>ul').append('<li>논현2동</li>');
					$('#subArea2>ul').append('<li>압구정동</li>');
					$('#subArea2>ul').append('<li>청담동</li>');
					$('#subArea2>ul').append('<li>삼성1동</li>');
					$('#subArea2>ul').append('<li>삼성2동</li>');
					$('#subArea2>ul').append('<li>대치1동</li>');
					$('#subArea2>ul').append('<li>대치2동</li>');
					$('#subArea2>ul').append('<li>대치4동</li>');
					$('#subArea2>ul').append('<li>역삼1동</li>');
					$('#subArea2>ul').append('<li>역삼2동</li>');
					$('#subArea2>ul').append('<li>도곡1동</li>');
					$('#subArea2>ul').append('<li>도곡2동</li>');
					$('#subArea2>ul').append('<li>개포1동</li>');
					$('#subArea2>ul').append('<li>개포2동</li>');
					$('#subArea2>ul').append('<li>개포4동</li>');
					$('#subArea2>ul').append('<li>세곡동</li>');
					$('#subArea2>ul').append('<li>일원본동</li>');
					$('#subArea2>ul').append('<li>일원1동</li>');
					$('#subArea2>ul').append('<li>일원2동</li>');
					$('#subArea2>ul').append('<li>수성동</li>');
				}
			});//서울특별시 강남구 '읍/면/동'함수 끝
			
			$('#subArea li:eq(23)').click(function(){//서울특별시 송파구 선택
				if(area2==$(this).html()){
					$(this).css('background-color', 'white');
					area2=null;
					$('#subArea2>ul').html('');
				}else{
					$('#subArea li').css('background', 'white');
					$(this).css('background-color', '#FF9B55');
					area2=$(this).html();
					$('#subArea2>ul').html('<li>풍납1동</li>');
					$('#subArea2>ul').append('<li>풍납2동</li>');
					$('#subArea2>ul').append('<li>거여1동</li>');
					$('#subArea2>ul').append('<li>거여2동</li>');
					$('#subArea2>ul').append('<li>마천1동</li>');
					$('#subArea2>ul').append('<li>마천2동</li>');
					$('#subArea2>ul').append('<li>방이1동</li>');
					$('#subArea2>ul').append('<li>방이2동</li>');
					$('#subArea2>ul').append('<li>오륜동</li>');
					$('#subArea2>ul').append('<li>오금동</li>');
					$('#subArea2>ul').append('<li>송파1동</li>');
					$('#subArea2>ul').append('<li>송파2동</li>');
					$('#subArea2>ul').append('<li>석촌동</li>');
					$('#subArea2>ul').append('<li>삼전동</li>');
					$('#subArea2>ul').append('<li>가락본동</li>');
					$('#subArea2>ul').append('<li>가락1동</li>');
					$('#subArea2>ul').append('<li>가락2동</li>');
					$('#subArea2>ul').append('<li>문정1동</li>');
					$('#subArea2>ul').append('<li>문정2동</li>');
					$('#subArea2>ul').append('<li>장지동</li>');
					$('#subArea2>ul').append('<li>위례동</li>');
					$('#subArea2>ul').append('<li>잠실본동</li>');
					$('#subArea2>ul').append('<li>잠실2동</li>');
					$('#subArea2>ul').append('<li>잠실3동</li>');
					$('#subArea2>ul').append('<li>잠실4동</li>');
					$('#subArea2>ul').append('<li>잠실6동</li>');
					$('#subArea2>ul').append('<li>잠실7동</li>');
				}
			});//서울특별시 송파구 '읍/면/동'함수 끝
			
			$('#subArea li:eq(24)').click(function(){//서울특별시 강동구 선택
				if(area2==$(this).html()){
					$(this).css('background-color', 'white');
					area2=null;
					$('#subArea2>ul').html('');
				}else{
					$('#subArea li').css('background', 'white');
					$(this).css('background-color', '#FF9B55');
					area2=$(this).html();
					$('#subArea2>ul').html('<li>강일동</li>');
					$('#subArea2>ul').append('<li>상일동</li>');
					$('#subArea2>ul').append('<li>명일1동</li>');
					$('#subArea2>ul').append('<li>명일2동</li>');
					$('#subArea2>ul').append('<li>고덕1동</li>');
					$('#subArea2>ul').append('<li>고덕2동</li>');
					$('#subArea2>ul').append('<li>암사1동</li>');
					$('#subArea2>ul').append('<li>암사2동</li>');
					$('#subArea2>ul').append('<li>암사3동</li>');
					$('#subArea2>ul').append('<li>천호1동</li>');
					$('#subArea2>ul').append('<li>천호2동</li>');
					$('#subArea2>ul').append('<li>천호3동</li>');
					$('#subArea2>ul').append('<li>성내1동</li>');
					$('#subArea2>ul').append('<li>성내2동</li>');
					$('#subArea2>ul').append('<li>성내3동</li>');
					$('#subArea2>ul').append('<li>길동</li>');
					$('#subArea2>ul').append('<li>둔촌1동</li>');
					$('#subArea2>ul').append('<li>둔촌2동</li>');
				}
			});//서울특별시 강동구 '읍/면/동'함수 끝
			
		}//서울특별시 if문의 끝
		
	});//서울특별시 선택함수의 끝
	
	$('#area li:eq(1)').click(function(){//부산광역시 선택
		
		if(area1==$(this).html()){
			$(this).css('background-color', 'white');
			area1=null;
			$('#subArea>ul').html('');
			$('#subArea2>ul').html('');
		}else{
			$('#area li').css('background', 'white');
			$(this).css('background-color', '#FF9B55');
			area1=$(this).html();
			$('#subArea>ul').html('<li>중구</li>');
			$('#subArea>ul').append('<li>서구</li>');
			$('#subArea>ul').append('<li>동구</li>');
			$('#subArea>ul').append('<li>영도구</li>');
			$('#subArea>ul').append('<li>부산진구</li>');
			$('#subArea>ul').append('<li>동래구</li>');
			$('#subArea>ul').append('<li>남구</li>');
			$('#subArea>ul').append('<li>북구</li>');
			$('#subArea>ul').append('<li>강서구</li>');
			$('#subArea>ul').append('<li>해운대구</li>');
			$('#subArea>ul').append('<li>사하구</li>');
			$('#subArea>ul').append('<li>금정구</li>');
			$('#subArea>ul').append('<li>연제구</li>');
			$('#subArea>ul').append('<li>수영구</li>');
			$('#subArea>ul').append('<li>사상구</li>');	
			
		}//부산광역시 if문의 끝
		
	});//부산광역시 선택함수의 끝
	
	$('#area li:eq(2)').click(function(){//대구광역시 선택
		
		if(area1==$(this).html()){
			$(this).css('background-color', 'white');
			area1=null;
			$('#subArea>ul').html('');
			$('#subArea2>ul').html('');
		}else{
			$('#area li').css('background', 'white');
			$(this).css('background-color', '#FF9B55');
			area1=$(this).html();
			$('#subArea>ul').html('<li>중구</li>');
			$('#subArea>ul').append('<li>동구</li>');
			$('#subArea>ul').append('<li>서구</li>');
			$('#subArea>ul').append('<li>남구</li>');
			$('#subArea>ul').append('<li>북구</li>');
			$('#subArea>ul').append('<li>수성구</li>');
			$('#subArea>ul').append('<li>달서구</li>');
			
		}//대구광역시 if문의 끝
		
	});//대구광역시 선택함수의 끝
	
	$('#area li:eq(3)').click(function(){//인천광역시 선택
		
		if(area1==$(this).html()){
			$(this).css('background-color', 'white');
			area1=null;
			$('#subArea>ul').html('');
			$('#subArea2>ul').html('');
		}else{
			$('#area li').css('background', 'white');
			$(this).css('background-color', '#FF9B55');
			area1=$(this).html();
			$('#subArea>ul').html('<li>중구</li>');
			$('#subArea>ul').append('<li>동구</li>');
			$('#subArea>ul').append('<li>미추홀구</li>');
			$('#subArea>ul').append('<li>연수구</li>');
			$('#subArea>ul').append('<li>남동구</li>');
			$('#subArea>ul').append('<li>부평구</li>');
			$('#subArea>ul').append('<li>계양구</li>');
			$('#subArea>ul').append('<li>서구</li>');
			$('#subArea>ul').append('<li>강화군</li>');
			$('#subArea>ul').append('<li>옹진군</li>');
			
		}//인천광역시 if문의 끝
		
	});//인천광역시 선택함수의 끝
	
	$('#area li:eq(4)').click(function(){//광주광역시 선택
		
		if(area1==$(this).html()){
			$(this).css('background-color', 'white');
			area1=null;
			$('#subArea>ul').html('');
			$('#subArea2>ul').html('');
		}else{
			$('#area li').css('background', 'white');
			$(this).css('background-color', '#FF9B55');
			area1=$(this).html();
			$('#subArea>ul').html('<li>동구</li>');
			$('#subArea>ul').append('<li>서구</li>');
			$('#subArea>ul').append('<li>남구</li>');
			$('#subArea>ul').append('<li>북구</li>');
			$('#subArea>ul').append('<li>광산구</li>');
			
		}//광주광역시 if문의 끝
		
	});//광주광역시 선택함수의 끝
	
	$('#area li:eq(5)').click(function(){//대전광역시 선택
		
		if(area1==$(this).html()){
			$(this).css('background-color', 'white');
			area1=null;
			$('#subArea>ul').html('');
			$('#subArea2>ul').html('');
		}else{
			$('#area li').css('background', 'white');
			$(this).css('background-color', '#FF9B55');
			area1=$(this).html();
			$('#subArea>ul').html('<li>동구</li>');
			$('#subArea>ul').append('<li>중구</li>');
			$('#subArea>ul').append('<li>서구</li>');
			$('#subArea>ul').append('<li>유성구</li>');
			$('#subArea>ul').append('<li>대덕구</li>');
			
		}//대전광역시 if문의 끝
		
	});//대전광역시 선택함수의 끝
	
	$('#area li:eq(6)').click(function(){//울산광역시 선택
		
		if(area1==$(this).html()){
			$(this).css('background-color', 'white');
			area1=null;
			$('#subArea>ul').html('');
			$('#subArea2>ul').html('');
		}else{
			$('#area li').css('background', 'white');
			$(this).css('background-color', '#FF9B55');
			area1=$(this).html();
			$('#subArea>ul').html('<li>동구</li>');
			$('#subArea>ul').append('<li>남구</li>');
			$('#subArea>ul').append('<li>동구</li>');
			$('#subArea>ul').append('<li>북구</li>');
			$('#subArea>ul').append('<li>울주군</li>');
			
		}//울산광역시 if문의 끝
		
	});//울산광역시 선택함수의 끝
	
	$('#area li:eq(7)').click(function(){//세종시 선택
		
		if(area1==$(this).html()){
			$(this).css('background-color', 'white');
			area1=null;
			$('#subArea>ul').html('');
			$('#subArea2>ul').html('');
		}else{
			$('#area li').css('background', 'white');
			$(this).css('background-color', '#FF9B55');
			area1=$(this).html();
		}//세종시 if문의 끝
		
	});//세종시 선택함수의 끝
	
	$('#area li:eq(8)').click(function(){//경기도 선택
		
		if(area1==$(this).html()){
			$(this).css('background-color', 'white');
			area1=null;
			$('#subArea>ul').html('');
			$('#subArea2>ul').html('');
		}else{
			$('#area li').css('background', 'white');
			$(this).css('background-color', '#FF9B55');
			area1=$(this).html();
			$('#subArea>ul').html('<li>수원시 장안구</li>');
			$('#subArea>ul').append('<li>수원시 권선구</li>');
			$('#subArea>ul').append('<li>수원시 팔달구</li>');
			$('#subArea>ul').append('<li>수원시 영통구</li>');
			$('#subArea>ul').append('<li>성남시 수정구</li>');
			$('#subArea>ul').append('<li>성남시 중원구</li>');
			$('#subArea>ul').append('<li>성남시 분당구</li>');
			$('#subArea>ul').append('<li>안양시 만안구</li>');
			$('#subArea>ul').append('<li>안양시 동안구</li>');
			$('#subArea>ul').append('<li>안산시 상록구</li>');
			$('#subArea>ul').append('<li>안산시 단원구</li>');
			$('#subArea>ul').append('<li>용인시 처인구</li>');
			$('#subArea>ul').append('<li>용인시 기흥구</li>');
			$('#subArea>ul').append('<li>용인시 수지구</li>');
			$('#subArea>ul').append('<li>광명시</li>');
			$('#subArea>ul').append('<li>평택시</li>');
			$('#subArea>ul').append('<li>과천시</li>');
			$('#subArea>ul').append('<li>오산시</li>');
			$('#subArea>ul').append('<li>시흥시</li>');
			$('#subArea>ul').append('<li>군포시</li>');
			$('#subArea>ul').append('<li>의왕시</li>');
			$('#subArea>ul').append('<li>하남시</li>');
			$('#subArea>ul').append('<li>이천시</li>');
			$('#subArea>ul').append('<li>안성시</li>');
			$('#subArea>ul').append('<li>김포시</li>');
			$('#subArea>ul').append('<li>화성시</li>');
			$('#subArea>ul').append('<li>광주시</li>');
			$('#subArea>ul').append('<li>여주시</li>');
			$('#subArea>ul').append('<li>부천시</li>');
			$('#subArea>ul').append('<li>양평군</li>');
			$('#subArea>ul').append('<li>고양시 덕양구</li>');
			$('#subArea>ul').append('<li>고양시 일산동구</li>');
			$('#subArea>ul').append('<li>고양시 일산서구</li>');
			$('#subArea>ul').append('<li>의정부시</li>');
			$('#subArea>ul').append('<li>동두천시</li>');
			$('#subArea>ul').append('<li>구리시</li>');
			$('#subArea>ul').append('<li>남양주시</li>');
			$('#subArea>ul').append('<li>파주시</li>');
			$('#subArea>ul').append('<li>양주시</li>');
			$('#subArea>ul').append('<li>포천시</li>');
			$('#subArea>ul').append('<li>연천군</li>');
			$('#subArea>ul').append('<li>가평군</li>');
		}//경기도 if문의 끝
		
	});//경기도 선택함수의 끝
	
	$('#area li:eq(9)').click(function(){//강원도 선택
		
		if(area1==$(this).html()){
			$(this).css('background-color', 'white');
			area1=null;
			$('#subArea>ul').html('');
			$('#subArea2>ul').html('');
		}else{
			$('#area li').css('background', 'white');
			$(this).css('background-color', '#FF9B55');
			area1=$(this).html();
			$('#subArea>ul').html('<li>춘천시</li>');
			$('#subArea>ul').append('<li>원주시</li>');
			$('#subArea>ul').append('<li>강릉시</li>');
			$('#subArea>ul').append('<li>동해시</li>');
			$('#subArea>ul').append('<li>태백시</li>');
			$('#subArea>ul').append('<li>속초시</li>');
			$('#subArea>ul').append('<li>삼척시</li>');
			$('#subArea>ul').append('<li>홍천군</li>');
			$('#subArea>ul').append('<li>횡성군</li>');
			$('#subArea>ul').append('<li>영월군</li>');
			$('#subArea>ul').append('<li>평창군</li>');
			$('#subArea>ul').append('<li>정선군</li>');
			$('#subArea>ul').append('<li>철원군</li>');
			$('#subArea>ul').append('<li>화천군</li>');
			$('#subArea>ul').append('<li>양구군</li>');
			$('#subArea>ul').append('<li>인제군</li>');
			$('#subArea>ul').append('<li>고성군</li>');
			$('#subArea>ul').append('<li>양양군</li>');
		}//강원도 if문의 끝
		
	});//강원도 선택함수의 끝
	
	$('#area li:eq(10)').click(function(){//충청북도 선택
		
		if(area1==$(this).html()){
			$(this).css('background-color', 'white');
			area1=null;
			$('#subArea>ul').html('');
			$('#subArea2>ul').html('');
		}else{
			$('#area li').css('background', 'white');
			$(this).css('background-color', '#FF9B55');
			area1=$(this).html();
			$('#subArea>ul').html('<li>청주시 상당구</li>');
			$('#subArea>ul').append('<li>청주시 서원구</li>');
			$('#subArea>ul').append('<li>청주시 흥덕구</li>');
			$('#subArea>ul').append('<li>청주시 청원구</li>');
			$('#subArea>ul').append('<li>충주시</li>');
			$('#subArea>ul').append('<li>제천시</li>');
			$('#subArea>ul').append('<li>보은군</li>');
			$('#subArea>ul').append('<li>옥천군</li>');
			$('#subArea>ul').append('<li>영동군</li>');
			$('#subArea>ul').append('<li>진천군</li>');
			$('#subArea>ul').append('<li>괴산군</li>');
			$('#subArea>ul').append('<li>음성군</li>');
			$('#subArea>ul').append('<li>단양군</li>');
			$('#subArea>ul').append('<li>증평군</li>');
		}//충청북도 if문의 끝
		
	});//충청북도 선택함수의 끝
	
	$('#area li:eq(11)').click(function(){//충청남도 선택
		
		if(area1==$(this).html()){
			$(this).css('background-color', 'white');
			area1=null;
			$('#subArea>ul').html('');
			$('#subArea2>ul').html('');
		}else{
			$('#area li').css('background', 'white');
			$(this).css('background-color', '#FF9B55');
			area1=$(this).html();
			$('#subArea>ul').html('<li>천안시 동남구</li>');
			$('#subArea>ul').append('<li>천안시 서북구</li>');
			$('#subArea>ul').append('<li>공주시</li>');
			$('#subArea>ul').append('<li>보령시</li>');
			$('#subArea>ul').append('<li>아산시</li>');
			$('#subArea>ul').append('<li>서산시</li>');
			$('#subArea>ul').append('<li>논산시</li>');
			$('#subArea>ul').append('<li>계룡시</li>');
			$('#subArea>ul').append('<li>당진시</li>');
			$('#subArea>ul').append('<li>금산군</li>');
			$('#subArea>ul').append('<li>부여군</li>');
			$('#subArea>ul').append('<li>서천군</li>');
			$('#subArea>ul').append('<li>청양군</li>');
			$('#subArea>ul').append('<li>홍성군</li>');
			$('#subArea>ul').append('<li>예산군</li>');
			$('#subArea>ul').append('<li>태안군</li>');
		}//충청남도 if문의 끝
		
	});//충청남도 선택함수의 끝
	
	$('#area li:eq(12)').click(function(){//전라북도 선택
		
		if(area1==$(this).html()){
			$(this).css('background-color', 'white');
			area1=null;
			$('#subArea>ul').html('');
			$('#subArea2>ul').html('');
		}else{
			$('#area li').css('background', 'white');
			$(this).css('background-color', '#FF9B55');
			area1=$(this).html();
			$('#subArea>ul').html('<li>전주시 완산구</li>');
			$('#subArea>ul').append('<li>전주시 덕진구</li>');
			$('#subArea>ul').append('<li>군산시</li>');
			$('#subArea>ul').append('<li>익산시</li>');
			$('#subArea>ul').append('<li>정읍시</li>');
			$('#subArea>ul').append('<li>남원시</li>');
			$('#subArea>ul').append('<li>김제시</li>');
			$('#subArea>ul').append('<li>완주군</li>');
			$('#subArea>ul').append('<li>진안군</li>');
			$('#subArea>ul').append('<li>무주군</li>');
			$('#subArea>ul').append('<li>장수군</li>');
			$('#subArea>ul').append('<li>임실군</li>');
			$('#subArea>ul').append('<li>순창군</li>');
			$('#subArea>ul').append('<li>고창군</li>');
			$('#subArea>ul').append('<li>부안군</li>');
		}//전라북도 if문의 끝
		
	});//전라북도 선택함수의 끝
	
	$('#area li:eq(13)').click(function(){//전라남도 선택
		
		if(area1==$(this).html()){
			$(this).css('background-color', 'white');
			area1=null;
			$('#subArea>ul').html('');
			$('#subArea2>ul').html('');
		}else{
			$('#area li').css('background', 'white');
			$(this).css('background-color', '#FF9B55');
			area1=$(this).html();
			$('#subArea>ul').html('<li>목포시</li>');
			$('#subArea>ul').append('<li>여수시</li>');
			$('#subArea>ul').append('<li>순천시</li>');
			$('#subArea>ul').append('<li>나주시</li>');
			$('#subArea>ul').append('<li>광양시</li>');
			$('#subArea>ul').append('<li>담양군</li>');
			$('#subArea>ul').append('<li>곡성군</li>');
			$('#subArea>ul').append('<li>구례군</li>');
			$('#subArea>ul').append('<li>고흥군</li>');
			$('#subArea>ul').append('<li>보성군</li>');
			$('#subArea>ul').append('<li>화순군</li>');
			$('#subArea>ul').append('<li>장흥군</li>');
			$('#subArea>ul').append('<li>강진군</li>');
			$('#subArea>ul').append('<li>해남군</li>');
			$('#subArea>ul').append('<li>영암군</li>');
			$('#subArea>ul').append('<li>무안군</li>');
			$('#subArea>ul').append('<li>함평군</li>');
			$('#subArea>ul').append('<li>영광군</li>');
			$('#subArea>ul').append('<li>장성군</li>');
			$('#subArea>ul').append('<li>완도군</li>');
			$('#subArea>ul').append('<li>진도군</li>');
			$('#subArea>ul').append('<li>신안군</li>');
		}//전라남도 if문의 끝
		
	});//전라남도 선택함수의 끝
	
	$('#area li:eq(14)').click(function(){//경상북도 선택
		
		if(area1==$(this).html()){
			$(this).css('background-color', 'white');
			area1=null;
			$('#subArea>ul').html('');
			$('#subArea2>ul').html('');
		}else{
			$('#area li').css('background', 'white');
			$(this).css('background-color', '#FF9B55');
			area1=$(this).html();
			$('#subArea>ul').html('<li>포항시 남구</li>');
			$('#subArea>ul').append('<li>포항시 북구</li>');
			$('#subArea>ul').append('<li>경주시</li>');
			$('#subArea>ul').append('<li>김천시</li>');
			$('#subArea>ul').append('<li>안동시</li>');
			$('#subArea>ul').append('<li>구미시</li>');
			$('#subArea>ul').append('<li>영주시</li>');
			$('#subArea>ul').append('<li>영천시</li>');
			$('#subArea>ul').append('<li>상주시</li>');
			$('#subArea>ul').append('<li>문경시</li>');
			$('#subArea>ul').append('<li>경산시</li>');
			$('#subArea>ul').append('<li>군위군</li>');
			$('#subArea>ul').append('<li>의성군</li>');
			$('#subArea>ul').append('<li>청송군</li>');
			$('#subArea>ul').append('<li>영양군</li>');
			$('#subArea>ul').append('<li>영덕군</li>');
			$('#subArea>ul').append('<li>청도군</li>');
			$('#subArea>ul').append('<li>고령군</li>');
			$('#subArea>ul').append('<li>성주군</li>');
			$('#subArea>ul').append('<li>칠곡군</li>');
			$('#subArea>ul').append('<li>예천군</li>');
			$('#subArea>ul').append('<li>봉화군</li>');
			$('#subArea>ul').append('<li>울진군</li>');
			$('#subArea>ul').append('<li>울릉군</li>');
		}//경상북도 if문의 끝
		
	});//경상북도 선택함수의 끝
	
	$('#area li:eq(15)').click(function(){//경상남도 선택
		
		if(area1==$(this).html()){
			$(this).css('background-color', 'white');
			area1=null;
			$('#subArea>ul').html('');
			$('#subArea2>ul').html('');
		}else{
			$('#area li').css('background', 'white');
			$(this).css('background-color', '#FF9B55');
			area1=$(this).html();
			$('#subArea>ul').html('<li>창원시 의창구</li>');
			$('#subArea>ul').append('<li>창원시 성산구</li>');
			$('#subArea>ul').append('<li>창원시 마산합포구</li>');
			$('#subArea>ul').append('<li>창원시 마산회원구</li>');
			$('#subArea>ul').append('<li>창원시 진해구</li>');
			$('#subArea>ul').append('<li>진주시</li>');
			$('#subArea>ul').append('<li>통영시</li>');
			$('#subArea>ul').append('<li>사천시</li>');
			$('#subArea>ul').append('<li>김해시</li>');
			$('#subArea>ul').append('<li>밀양시</li>');
			$('#subArea>ul').append('<li>거제시</li>');
			$('#subArea>ul').append('<li>양산군</li>');
			$('#subArea>ul').append('<li>의령군</li>');
			$('#subArea>ul').append('<li>함안군</li>');
			$('#subArea>ul').append('<li>창녕군</li>');
			$('#subArea>ul').append('<li>고성군</li>');
			$('#subArea>ul').append('<li>남해군</li>');
			$('#subArea>ul').append('<li>하동군</li>');
			$('#subArea>ul').append('<li>산청군</li>');
			$('#subArea>ul').append('<li>함양군</li>');
			$('#subArea>ul').append('<li>거창군</li>');
			$('#subArea>ul').append('<li>합천군</li>');
		}//경상남도 if문의 끝
		
	});//경상남도 선택함수의 끝
	
	$('#area li:eq(16)').click(function(){//제주도 선택
		
		if(area1==$(this).html()){
			$(this).css('background-color', 'white');
			area1=null;
			$('#subArea>ul').html('');
			$('#subArea2>ul').html('');
		}else{
			$('#area li').css('background', 'white');
			$(this).css('background-color', '#FF9B55');
			area1=$(this).html();
			$('#subArea>ul').html('<li>제주시</li>');
			$('#subArea>ul').append('<li>서귀포시</li>');
		}//제주도 if문의 끝
		
	});//제주도 선택함수의 끝
	
});
