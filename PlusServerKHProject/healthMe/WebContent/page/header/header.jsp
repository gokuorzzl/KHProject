<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ 
	page import="com.healthme.search.model.vo.*" 
		import = "java.util.ArrayList"
		import ="com.healthme.member.vo.*"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
	<!--인코딩 문자셋-->
    <meta charset="UTF-8">
    <!--반응형 웹을 만들기 위한 meta태그의 viewport-->
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <!--페이지 설명-->
    <meta name="subject" content="헬th미 메인페이지" />
    <!--키워드-->
    <meta name="keywords" content="www.healthme.com, 트레이너, 나만의, 맞춤" />
    <!--스타일-->
    <link rel="stylesheet" href="../../css/header/header.css" />
    <!-- 스크립트 -->
    <script src="https://code.jquery.com/jquery-3.3.1.js"
 			integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
  			crossorigin="anonymous"></script>
  	<script type="text/javascript" src="../../js/header/sideMenu.js"></script>
  	<script type="text/javascript" src="../../js/searchTrainerPage/searchTrainer.js"></script>
  	<!-- fa 아이콘 링크  -->
  	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <!--title-->
    <title>헬th미:나만의 트레이너</title>


</head>
<body>
<%
	session = request.getSession(false);
	Member member = null;
	member = (Member)session.getAttribute("member");

%>
	<!-- Menu -->
	<div id="navigation">
		<div><p>✕</p></div>
		<% if(member==null) {%>		
		<div id="navigation-login"><a href = "../loginPage/login.jsp">로그인
		</a></div>
		<% } else{ %>
		<div id="navigation-login"><a href = "/logout.do">로그아웃
		</a></div>		
		<% } %>
		<ul>
			<li><a href="../../index.jsp">메인</a></li>
	        <li><a href="../searchTrainerPage/searchTrainerPage.jsp">트레이너 찾기</a></li>
	        <li><a href="../mypage/trainerInfoPage.jsp">트레이너 등록</a></li>
	        <li><a href="/freePage.do">게시판</a></li>
	        <li><a href="/qnaPage.do">Q & A</a></li>
		</ul>
	</div>

    <!--로고, 메뉴가 들어가는 윗부분-->
    <!--top부분은 관리자페이지 제외한 모든 페이지 통일-->
    <div id="mobileMenu">
        <div><p>☰</p></div>
    </div>
    <div id="logo">
       	<div><img src="../../img/%EB%A1%9C%EA%B3%A0.png"></div>
    </div>
    <div id="searchBar">
   		<form class="searchForm" action="/searchInput.do" method="get" >
   			<div>
				<input type="text" name="searchInput" class="searchInput" placeholder="지역, 종목 검색" required="검색어를 입력해주세요."/>
				<input type="hidden" name="screenSize" class="screenSize"  />
				<button type="submit"><i class="fa fa-search"></i></button>
   			</div>
   		</form>
    </div>
    <div id="menu">
    <%	if(member==null) {%>
        <div id="loginMenu">
            <a href="../loginPage/login.jsp">로그인</a> 
        </div>
    <%	}else{ %>
    	<div id="loginMenu">
            <a href="/logout.do">로그아웃</a> 
        </div>
    <%	} %>
        <div id="menuButton">
            <div><p>☰</p></div>
        </div>
    </div>
        
        

</body>
</html>