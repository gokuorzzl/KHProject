/**
 * 광역시/도, 시/군/구, 읍/면/동 선택, 종목선택
 */

$(function(){

	var area1=null;
	var area2=null;
	var area3=new Array();
	var field=new Array();
	
	$('#field li').click(function(){
		$(this).css('background', '#FF9B55');
		field.push($(this).html());
	});
	
	$('#area li:eq(0)').click(function(){//서울특별시 선택
		$('#area li').css('background', 'white');
		$(this).css('background', '#FF9B55');
		area1 = $(this).html();
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
			$('#subArea li').css('background', 'white');
			$(this).css('background', '#FF9B55');
			area2 = $(this).html();
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
			
			$('#subArea2 li').click(function(){
				$(this).css('background', '#FF9B55');
				area3.push($(this).html());
			});
		});
		
		$('#subArea li:eq(1)').click(function(){//서울특별시 중구 선택
			$('#subArea li').css('background', 'white');
			$(this).css('background', '#FF9B55');
			area2 = $(this).html();
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
			
			$('#subArea2 li').click(function(){
				$(this).css('background', '#FF9B55');
				area3.push($(this).html());
			});
		});
		
		$('#subArea li:eq(2)').click(function(){//서울특별시 용산구 선택
			$('#subArea li').css('background', 'white');
			$(this).css('background', '#FF9B55');
			area2 = $(this).html();
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
			
			$('#subArea2 li').click(function(){
				$(this).css('background', '#FF9B55');
				area3.push($(this).html());
			});
		});
		
		$('#subArea li:eq(3)').click(function(){//서울특별시 성동구 선택
			$('#subArea li').css('background', 'white');
			$(this).css('background', '#FF9B55');
			area2 = $(this).html();
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
			
			$('#subArea2 li').click(function(){
				$(this).css('background', '#FF9B55');
				area3.push($(this).html());
			});
		});
	
		$('#subArea li:eq(4)').click(function(){//서울특별시 광진구 선택
			$('#subArea li').css('background', 'white');
			$(this).css('background', '#FF9B55');
			area2 = $(this).html();
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
			
			$('#subArea2 li').click(function(){
				$(this).css('background', '#FF9B55');
				area3.push($(this).html());
			});
		});
		
		$('#subArea li:eq(5)').click(function(){//서울특별시 동대문구 선택
			$('#subArea li').css('background', 'white');
			$(this).css('background', '#FF9B55');
			area2 = $(this).html();
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
			
			$('#subArea2 li').click(function(){
				$(this).css('background', '#FF9B55');
				area3.push($(this).html());
			});
		});
		
		$('#subArea li:eq(5)').click(function(){//서울특별시 중랑구 선택
			$('#subArea li').css('background', 'white');
			$(this).css('background', '#FF9B55');
			area2 = $(this).html();
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
			
			$('#subArea2 li').click(function(){
				$(this).css('background', '#FF9B55');
				area3.push($(this).html());
			});
		});
		
		$('#subArea li:eq(5)').click(function(){//서울특별시 성북구 선택
			$('#subArea li').css('background', 'white');
			$(this).css('background', '#FF9B55');
			area2 = $(this).html();
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
			
			$('#subArea2 li').click(function(){
				$(this).css('background', '#FF9B55');
				area3.push($(this).html());
			});
		});
		
	});
	
	$('#area li:eq(1)').click(function(){//부산광역시 선택
		$('#area li').css('background', 'white');
		$(this).css('background', '#FF9B55');
		area1 = $(this).html();
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
	});
	
	$('#area li:eq(2)').click(function(){//대구광역시 선택
		$('#area li').css('background', 'white');
		$(this).css('background', '#FF9B55');
		area1 = $(this).html();
		$('#subArea>ul').html('<li>중구</li>');
		$('#subArea>ul').append('<li>동구</li>');
		$('#subArea>ul').append('<li>서구</li>');
		$('#subArea>ul').append('<li>남구</li>');
		$('#subArea>ul').append('<li>북구</li>');
		$('#subArea>ul').append('<li>수성구</li>');
		$('#subArea>ul').append('<li>달서구</li>');
	});
	
	$('#area li:eq(3)').click(function(){//인천광역시 선택
		$('#area li').css('background', 'white');
		$(this).css('background', '#FF9B55');
		area1 = $(this).html();
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
	});
	
	$('#area li:eq(4)').click(function(){//광주광역시 선택
		$('#area li').css('background', 'white');
		$(this).css('background', '#FF9B55');
		area1 = $(this).html();
		$('#subArea>ul').html('<li>동구</li>');
		$('#subArea>ul').append('<li>서구</li>');
		$('#subArea>ul').append('<li>남구</li>');
		$('#subArea>ul').append('<li>북구</li>');
		$('#subArea>ul').append('<li>광산구</li>');
	});
	
	$('#area li:eq(5)').click(function(){//대전광역시 선택
		$('#area li').css('background', 'white');
		$(this).css('background', '#FF9B55');
		area1 = $(this).html();
		$('#subArea>ul').html('<li>동구</li>');
		$('#subArea>ul').append('<li>중구</li>');
		$('#subArea>ul').append('<li>서구</li>');
		$('#subArea>ul').append('<li>유성구</li>');
		$('#subArea>ul').append('<li>대덕구</li>');
	});
	
	$('#area li:eq(6)').click(function(){//울산광역시 선택
		$('#area li').css('background', 'white');
		$(this).css('background', '#FF9B55');
		area1 = $(this).html();
		$('#subArea>ul').html('<li>동구</li>');
		$('#subArea>ul').append('<li>남구</li>');
		$('#subArea>ul').append('<li>동구</li>');
		$('#subArea>ul').append('<li>북구</li>');
		$('#subArea>ul').append('<li>울주군</li>');
	});
	
	$('#area li:eq(7)').click(function(){//세종시 선택
		$('#area li').css('background', 'white');
		$(this).css('background', '#FF9B55');
		area1 = $(this).html();
	});
	
	$('#area li:eq(8)').click(function(){//경기도 선택
		$('#area li').css('background', 'white');
		$(this).css('background', '#FF9B55');
		area1 = $(this).html();
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
	});
	
	$('#area li:eq(9)').click(function(){//강원도 선택
		$('#area li').css('background', 'white');
		$(this).css('background', '#FF9B55');
		area1 = $(this).html();
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
	});
	
	$('#area li:eq(10)').click(function(){//충청북도 선택
		$('#area li').css('background', 'white');
		$(this).css('background', '#FF9B55');
		area1 = $(this).html();
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
	});
	
	$('#area li:eq(11)').click(function(){//충청남도 선택
		$('#area li').css('background', 'white');
		$(this).css('background', '#FF9B55');
		area1 = $(this).html();
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
	});
	
	$('#area li:eq(12)').click(function(){//전라북도 선택
		$('#area li').css('background', 'white');
		$(this).css('background', '#FF9B55');
		area1 = $(this).html();
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
	});
	
	$('#area li:eq(13)').click(function(){//전라남도 선택
		$('#area li').css('background', 'white');
		$(this).css('background', '#FF9B55');
		area1 = $(this).html();
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
	});
	
	$('#area li:eq(14)').click(function(){//경상북도 선택
		$('#area li').css('background', 'white');
		$(this).css('background', '#FF9B55');
		area1 = $(this).html();
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
	});
	
	$('#area li:eq(15)').click(function(){//경상남도 선택
		$('#area li').css('background', 'white');
		$(this).css('background', '#FF9B55');
		area1 = $(this).html();
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
	});
	
	$('#area li:eq(16)').click(function(){//제주도 선택
		$('#area li').css('background', 'white');
		$(this).css('background', '#FF9B55');
		area1 = $(this).html();
		$('#subArea>ul').html('<li>제주시</li>');
		$('#subArea>ul').append('<li>서귀포시</li>');
	});
	
});