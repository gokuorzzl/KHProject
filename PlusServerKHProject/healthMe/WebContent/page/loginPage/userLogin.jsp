<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!--인코딩 문자셋-->
    <meta charset="UTF-8">
    <!--반응형 웹을 만들기 위한 meta태그의 viewport-->
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <!--페이지 설명-->
    <meta name="subject" content="헬th미 메인페이지" />
    <!--키워드-->
    <meta name="keywords" content="www.healthme.com, 트레이너, 나만의, 맞춤" />
    <!--스타일-->
    <link rel="stylesheet" href="../../css/loginPage/userLogin.css"/>
    <!--title-->
    <title>헬th미: 회원가입</title>

</head>
<body>


 <!--전체 공간-->    
    <div id="wrapper">
        
        <!--로고, 메뉴가 들어가는 윗부분-->
        <!--top부분은 관리자페이지 제외한 모든 페이지 통일-->
        <div id="top">
            <div id="mobileMenu">
                핸드폰일 경우 메뉴
            </div>
            <div id="logo">
               로고
            </div>
            <div id="searchBar">
                검색바
            </div>
            <div id="menu">
                로그인, 메뉴
            </div>
        </div>
        
        <!--컨텐츠가 들어가는 중간부분-->
        <!--페이지별로 달라지는 부분-->
        <div id="middle">
            <!--지역, 종목 등 선택할 수 있는 선택박스-->
            <div id="searchBox">
                
                 <img src="../../img/로고.png" alt="logo" class="logo-center";>
                
            </div><!--트레이너 별점 등 컨텐츠 나오는 부분-->
            <div id="contents">
                <div id="realContents">
                  <div class="info-container">
                    <form action="/action_page.php" id="userR">
                     
                        <label for="id">아이디</label><br>
                        <input type="text" id="userId" name="userId"><br>
                         
                         <label for="psw">비밀번호</label><br>
                         <input type="password" name="psw"><br>
                         
                         <label for="psw">비밀번호 재확인</label><br>
                         <input type="password" name="re-psw"><br>
                        
                        <label for="name">이름</label><br>
                        <input type="text" id="name" name="name"><br>
                         
                         <label for="name">주민등록번호</label><br>
                        <input type="text" id="snumber1" name="snumber1"> -
                        <input type="password" id="snumber2" name="snumber2"><br> 
                         
                         <label for="addr">주소</label><br>
                        <input type="text" id="sample6_postcode" placeholder="우편번호">
                        <input type="button" id="sample6_fpostcode" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
                        <input type="text" id="sample6_address" placeholder="주소">
                        <input type="text" id="sample6_address2" placeholder="상세주소">

                        <label for="mnum">핸드폰 번호</label><br>
                        <input type="text" id="tel1" name="tel1"> -
                        <input type="text" id="tel2" name="tel2"> -
                        <input type="text" id="tel3" name="tel3"><br>

                        <label for="mnum">이메일</label><br>
                         <input type='text' id="email1" name="email1"> @
                         <input type='text' id="email2" name="email2">
                           <select name="emailaddr">
                               <option value="">직접입력</option>
                               <option value="daum.net">daum.net</option>
                               <option value="gmail.com">gmail.com</option>
                               <option value="naver.com">naver.com</option>
                               <option value="nate.com">nate.com</option>
                           </select>
                       
                      <button type="submit" class="register-button">가입하기</button>
                      
                   </form>
                </div>
                    
                    
                    
                </div>
            </div>
        </div>
        
        <!--회사정보가 들어가는 아랫부분-->
        <!--bottom부분은 관리자페이지 제외한 모든 페이지 통일-->
        <div id="bottom">
            김구이김주정조 정보
        </div>
    </div>
    
    
 <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;

                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('sample6_address').value = fullAddr;

                // 커서를 상세주소 필드로 이동한다.
                document.getElementById('sample6_address2').focus();
            }
        }).open();
    }
</script>

</body>
</html>