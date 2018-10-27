<%@page import="com.healthme.admin.vo.Admin"%>
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
    <link rel="stylesheet" href="../../css/loginPage/login.css" />
    
    <!--네이버 로그인  -->
     <script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
 	 <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
    
    
    <!--title-->
    <title>헬th미: 로그인</title> <!--로그인 첫페이지-->

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
                <img src="../../img/로고.png" alt="logo" class="logo-center";>
              </div>
            </div>
            <!--트레이너 별점 등 컨텐츠 나오는 부분-->
            <div id="contents">
                <div id="realContents">
                
                    <form action="/adminLogin.do" method="post" name="login-form">                      
                        <div class="login-container1">
                           <label for="userId"></label>
                          <input type="text" placeholder="아이디 입력해주세요" id="adminId" name="adminId" required>

                         <label for="psw"></label><br>
                         <input type="password" placeholder="비밀번호 입력해주세요" id="adminPW" name="adminPw" required><br>
                          
                         <button type="submit" class="login-button" value="로그인"><p id="login-letter">로그인</p></button><br>
                       
                       
                     <!-- 네이버아이디로로그인 버튼 노출 영역 -->
  <div id="naver_id_login"></div>
  <!-- //네이버아이디로로그인 버튼 노출 영역 -->
  <script type="text/javascript">
  	var naver_id_login = new naver_id_login("IG6PV5dvNKOxys9LQVdt", "http://127.0.0.1/page/admin/adminlogin.jsp");
  	var state = naver_id_login.getUniqState();
  	naver_id_login.setButton("white", 2,40);
  	naver_id_login.setDomain(".healthme.com");
  	naver_id_login.setState(state);
  	naver_id_login.setPopup();
  	naver_id_login.init_naver_id_login();
  </script>  
           
         
               <script type="text/javascript">

  naver_id_login.get_naver_userprofile("naverSignInCallback()");
  // 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
  function naverSignInCallback() {
    alert(naver_id_login.getProfileData('email'));
    alert(naver_id_login.getProfileData('nickname'));
    alert(naver_id_login.getProfileData('age'));
  }
</script>
               
               
               
                       
                       
                       
                       
                       
                       
                        </div>
                   </form>
                   <div align="center">
                   <br>
                   	* 이곳은 관리자 영역입니다. <br><br>
                   	* 관리자 외에 접근할 수 없도록 비밀번호 관리를 잘 하여주시기 바랍니다.<br><br>
                   	<a href="/index.jsp">홈으로 돌아가기</a>
                   	
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