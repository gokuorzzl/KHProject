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
    <script type="text/javascript" src="../../js/loginPage/login.js"></script>
    <link rel="stylesheet" href="../../css/loginPage/searchPwd.css" />

    <!--title-->
    <title>헬th미: 비밀번호 찾기</title> <!--로그인 첫페이지-->

</head>
<body>

 <!--전체 공간-->    
    <div id="wrapper">
        
        <!--로고, 메뉴가 들어가는 윗부분-->
        <!--top부분은 관리자페이지 제외한 모든 페이지 통일-->
        <div id="top">
            <div id="mobileMenu">
              <!--   핸드폰일 경우 메뉴 -->
            </div>
            <div id="logo">
               <!-- 로고 -->
            </div>
            <div id="searchBar">
      <!--           검색바 -->
            </div>
            <div id="menu">
              <!--   로그인, 메뉴 -->
            </div>
        </div>
        
        <!--컨텐츠가 들어가는 중간부분-->
        <!--페이지별로 달라지는 부분-->
        <div id="middle">
            <!--지역, 종목 등 선택할 수 있는 선택박스-->
           <div id="searchBox">
              <div id="logoBox">
                <img src="../../img/로고.png" alt="logo" class="logo-center">
              </div>
            </div>
            <!--트레이너 별점 등 컨텐츠 나오는 부분-->
            <div id="contents">
                <div id="realContents">
                
                    <form name="findId" method = "post" action = "/searchPwd.do">                     
                        <div class="login-container1">
                          <br><label for="memberId">아이디 </label>
                          <input type="text" name="memberId" placeholder="아이디를 입력해주세요" id="memberId" required><br><br>

                        <label id="memberSocialIdName">주민등록번호</label><br>
                        <input type="text" maxlength="6" id="memberSocialId1" name="memberSocialId1" required> - 
                        <input type="password" maxlength="7" id="memberSocialId2" name="memberSocialId2" required><br><br>
                          
                         <label id="memberPhoneName">핸드폰 번호</label><div class="conditionPhone">(ex. 010-1111-2222 형식으로 입력)</div>
                         
                         
                         <input type="text" name="memberPhone" maxlength="13" placeholder="핸드폰 번호 입력해주세요" id="memberSocialId" required><br>
                          
                         <button type="submit" class="login-button"><p id="login-letter">비밀번호 찾기</p></button>

                        </div>
                   </form>
                   
                        
          
                </div>
            </div>
        </div>
        
        
        <!--회사정보가 들어가는 아랫부분-->
        <!--bottom부분은 관리자페이지 제외한 모든 페이지 통일-->
        <div id="bottom">
    
        </div>