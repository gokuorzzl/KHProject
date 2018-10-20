<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.healthme.member.vo.*" %>
<!DOCTYPE html>
<html>
<head>
 	 <meta charset="UTF-8">
     <meta http-equiv="X-UA-Compatible" content="IE=Edge">
     <meta name="description" content="">
     <meta name="keywords" content="">
     <meta name="team" content="">
     <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
     <link rel="stylesheet" href="haha.css">
     <link rel="stylesheet" href="templatemo-style.css">



<title>Insert title here</title>
</head>
<body>




     <div class="backgroundTransition">
          <div class="content">
          
          
          
          <!-- 수정사항 -->
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
                <li><a href="/Page/SearchTrainerPage/searchTrainerPage.jsp">트레이너 찾기</a></li>
                <li><a href="">트레이너 등록</a></li>
                <li><a href="/Page/communityPage/boardPage.jsp">게시판</a></li>
                <li><a href="/Page/communityPage/Q&APage.jsp">Q & A</a></li>
            </ul>
           </div>
			 <!--로그인-->
           <div class="col-md-4 col-sm-6">
             <div class="container">
	        <%
				session = request.getSession(false);
				Member member = (Member)session.getAttribute("member");
				if(member!=null){
			 %>
			<H1><%=member.getMemberName() %>님 환영합니다.</H1>
			<div class="col-md-offset-1 col-md-4 col-sm-6"></div>
                 	<br><br>
                 	<form action="">
                 		<h3>heal th me</h3>
                 		 <a href="">마이 페이지</a>
                 		 <a href="">로그아웃</a>

                 	</form>
            </div>
			<%
				} else{
			%>
                 <div class="col-md-offset-1 col-md-4 col-sm-6">
                     <br><br>
                     <form action="/Page/loginPage/login.jsp">
                     <h3>heal th me를 더 안전하고 편리하게 이용하세요.</h3>
                     <input type="submit" class="menu-local btn btn-primary btn-lg myinfo" value="heal th me 로그인"></form>
                     <a href="" class="menu-local-font">아이디ㆍ비밀번호 찾기</a>
                     <a href="/Page/loginPage/userLogin.jsp" class="menu-local-font-join" >회원가입</a>
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
							 <form action="/Page/SearchTrainerPage/searchTrainerPage.jsp" method="get">
                            <input type="text" name="search" class="form-control" placeholder="지역 / 종목 / 트레이너 검색" required="">
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




<!--  수정사항 끝 -->
          
          
          
          
          
     
            
            
            
            
          </div>
      </div>





<!-- 배경 바뀌게 하는것!! -->
<script src="jquery.js"></script>
<script type="text/javascript" src="backgroundTransition.js"></script>
<script src="background.js"></script>




</body>
</html>