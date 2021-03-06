<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.healthme.member.vo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
     <title>Heal th Me</title>

     <meta charset="UTF-8">
     <meta http-equiv="X-UA-Compatible" content="IE=Edge">
     <meta name="description" content="">
     <meta name="keywords" content="">
     <meta name="team" content="">
     <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
     <link rel="stylesheet" href="css/main/bootstrap.min.css?var=1">
     <link rel="stylesheet" href="css/main/vegas.min.css?var=1">
	 <!-- MAIN CSS -->
     <link rel="stylesheet" href="css/main/templatemo-style.css">
     <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<%
				session = request.getSession(false);
				Member member = (Member)session.getAttribute("member");
				%>
<!--메뉴 부분-->
    <div class="menu-bg"></div>
    <div class="menu-burger">☰</div>
    <div class="menu-items">
       <div class="container">
         <div class="row">
           <div class="col-md-offset-1 col-md-4 col-sm-6">
            <h1>Navigations</h1>
             <ul class="menu">
                <li><a href="/index.jsp">메인</a></li>
                <li><a href="/page/searchTrainerPage/searchTrainerPage.jsp">트레이너 찾기</a></li>
                <li><a href="/page/mypage/trainerInfoPage.jsp">트레이너 등록</a></li>
                <li><a href="/freePage.do">게시판</a></li>
                <li><a href="/qnaPage.do">Q & A</a></li>

<%
				if(member!=null && member.getMemberId().equals("admin")){				
%>
				<li><a href="/page/admin/adminlogin.jsp">관리자페이지</a></li>
<%
				}
%>
            </ul>
           </div>
			 <!--로그인-->
           <div class="col-md-4 col-sm-6">
             <div class="container">
	        <%
				if(member!=null){
			 %>
			<H1><%=member.getMemberName() %>님 환영합니다.</H1>
			<div class="col-md-offset-1 col-md-4 col-sm-6"></div>
                 	<br><br>
                 		<h2>heal th me</h2>
                 		<a href="/mypageMain.do" class="loginForm">마이페이지ㆍ</a>
                 		<a href="/logout.do" class="loginForm">로그아웃</a>
                 		 
            </div>
			<%
				} else{
			%>
                 <div class="col-md-offset-1 col-md-4 col-sm-6">
                     <br><br>
                     <form action="/page/loginPage/login.jsp">
                     <h3 style="color:white">heal th me를 더 안전하고 편리하게 이용하세요. </h3>
                     <input type="submit" class="menu-local btn btn-primary btn-lg myinfo" value="heal th me 로그인"></form>
                     <a href="/page/loginPage/searchId.jsp" class="menu-local-font">아이디 찾기</a><a href="/page/loginPage/searchPwd.jsp" class="menu-local-font">ㆍ비밀번호 찾기</a>
                     <a href="/page/loginPage/enroll.jsp" class="menu-local-font-join" >회원가입</a>
                 </div>
                 
                
  			<%	} %>
               </div>
           </div> 
         </div>
       </div>
    </div>
     <!-- 메인 -->
     <section id="home">
        <div class="overlay"></div>
          <div class="container">
               <div class="row">
				   <!--로고 삽입 부분-->
                    <div class="col-md-12 col-sm-12">
                         <div class="home-info">
                             <div>
                             <img src="img/%EB%A1%9C%EA%B3%A0.png"
                            width="50%" height="30%">
                            </div> 
							 <!-- 검색바 -->
							 <div class="subscribe-form">
							 <form action="/searchInput.do" method="get" autocomplete="off">
                            <input type="text" name="searchInput" class="form-control" placeholder="지역 / 종목 검색" required="">
							<input type="hidden" name="screenSize" class="screenSize"/>
							<button type="submit" class="form-control">
							<i class="fa fa-search"></i>
							</button>
							</form>  
                            </div>
                         </div>
                    </div>
               </div>
          </div>
     </section>
     <!-- SCRIPTS -->
      <script src="https://code.jquery.com/jquery-3.3.1.js"
          integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
           crossorigin="anonymous"></script>
     <script src="js/jquery.js"></script>
     <script src="js/bootstrap.min.js"></script>
     <script src="js/vegas.min.js"></script>
     <script src="js/custom.js"></script>			
	 <script type="text/javascript" src="js/searchTrainerPage/searchTrainer.js"></script>


</body>
</html>
