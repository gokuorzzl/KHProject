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
     <script type="text/javascript" src="../../js/loginPage/enroll.js"></script>
     <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
    <script
    src="http://code.jquery.com/jquery-3.3.1.js"
    integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
    crossorigin="anonymous"></script>
     <link rel="stylesheet" href="../../css/loginPage/enroll.css?ver=1"/>
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
                <!-- 핸드폰일 경우 메뉴 -->
            </div>
            <div id="logo">
               <!-- 로고 -->
            </div>
            <div id="searchBar">
              <!--   검색바 -->
            </div>
            <div id="menu">
                <!-- 로그인, 메뉴 -->
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
                    
                    <form  action="/enroll.do" name="data" method="post"> 
                     <!-- onsubmit="return checked()"> -->
                        <label for="memberId" style="float:left;">아이디</label><div class="conditionId" style="float:left; box-sizing:border-box; margin-left:1%; margin-right:14%; margin-top:1%; ">(4~12자이내 영문소문자, 숫자, 언더라인( _ ) 사용가능)</div>
                        <button class="doubleCheck" onclick="return idCheck();">ID 중복 확인</button><br>
                        <input type="hidden" id="checkFlag" value=0/>
                        
                        <input type="text" id="memberId" name="memberId" required><br>
    
                         <label for="memberPw" style="float:left;">비밀번호</label><div class="conditionPw" style="float:left; box-sizing:border-box; margin-left:1%; margin-right:7%; margin-top:0.8%; ">(8~24자이내 영문대소문자, 숫자, 특수문자 혼합 사용)</div>
                         <input type="password" id="memberPw" name="memberPw" required ><br>
                          
                         <label for="memberPw2">비밀번호 재확인</label><br>
                         <input type="password" name="memberPw2" id="memberPw2" required><br>
                        
                        <label for="memberName">이름</label><br>
                        <input type="text" id="memberName" name="memberName" required><br>
                         
                         <label for="memberSocialId" style="float:left;">주민등록번호</label><div class="conditionPw" style="float:left; box-sizing:border-box; margin-left:1%; margin-right:7%; margin-top:0.8%; ">(ex. 123456-7891011 형식으로 입력)</div>
                        <input type="text" maxlength="14" id="memberSocialId" name="memberSocialId" required><br> 
     
                         <label for="memberAddr">주소</label><br>
                        <input type="text" id="sample6_postcode" placeholder="우편번호">
                        <input type="button" id="sample6_fpostcode" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
                        <input type="text" id="memberAddr" name="memberAddr" placeholder="주소">
                        <input type="text" id="sample6_address2" placeholder="상세주소">

                        <label for="memberPhone" style="float:left;">핸드폰 번호</label><div class="conditionPw" style="float:left; box-sizing:border-box; margin-left:1%; margin-right:7%; margin-top:0.8%; ">(ex. 010-1111-2222 형식으로 입력)</div>
                        <input type="text" maxlength="13" id="memberPhonㄷ" name="memberPhone" required><br>
               
                        <label for="memberEmail">이메일</label><br>
                         <input type="email" placeholder="이메일 주소에 '@'를 포함해주세요" id="memberEmail" name="memberEmail" required> 
                          
                       <button type="submit" value="회원가입"  onclick="return checked()" class="register-button">가입하기</button> 
                  <!--  if(!memberSubmit(this.form)){return false;} -->
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

</body>
</html>