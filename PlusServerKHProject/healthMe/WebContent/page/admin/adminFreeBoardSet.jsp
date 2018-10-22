<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="com.healthme.admin.vo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자 자유게시판</title>
</head>
<body>
<!-- 로그인이 안되었을 경우창 띄우게 할지 말지 결정해보기 -->

<!-- 전체를 묶는다. -->	
    <div id="wrapper">

        <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">김구이김주정조</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                
                <a class="navbar-brand" href="MainAdmin.html"><img src="../../img/로고.png" class="logo"></a>
            </div>
            <div class="header-left">

                <a href="#" class="left-head-icon" title="새메세지"><span class="iconposition">93 </span><img src="../../img/message.png" class="message"></a>
                <a href="#" class="left-head-icon" title="새로운사용자"><span class="iconposition">08 </span><img src="../../img/newuser.png" class="newuser"></a>
                 <a href="#" class="left-head-icon" title="매칭회원"><span class="iconposition">17 </span><img src="../../img/success.png" class="success"></a>
				<%
				session = request.getSession(false);
				Admin admin = (Admin)session.getAttribute("admin");
				if(admin!=null){
				%>
				<H3>[<%=admin.getAdminId()%>]님 환영합니다.</H3>
				<%
				}else{
				%>
				<H3><a href="/page/admin/adminlogin.jsp">관리자가 아닙니다.(로그인화면돌아가기)</a></H3>
				<%} %>
				
            </div>
            <div class="header-right">

             <a href="/adminLoginOut.do" class="left-head-icon" title="Sign Out"><img src="../../img/logout.png" class="logout"></a>
             

            </div>
        </nav>

         <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                   


                    <li>
                        <a class="active-menu" href="adminMain.jsp"><i class="fa fa-desktop "></i>홈(설정)</a>
                    </li>
                    <!-- 홈 하나 끝 -->
                    
                    
                    <!-- 일반설정 시작 -->
                    <li>
                        <a href="adminNormalSet.jsp"><i class="fa fa-desktop "></i>일반설정(설정) <span class="fa arrow"></span></a>
                         
                         <ul class="nav nav-second-level">                
                            <li>
                                <a href="#"><i class="fa fa-toggle-on"></i>관리자 개인정보 설정(#)</a>
        	                    </li>
		                        <li>
                                <a href="#"><i class="fa fa-pencil-square-o"></i>광고설정(#)</a>
                            </li>       
                        </ul>
                    </li>
                    
                    <!-- 일반설정 끝 -->
                    
                    
                    <!--  게시판 관리 시작 -->
                     <li>
                        <a href="adminQuestionBoardSet.jsp"><i class="fa fa-yelp "></i>질문게시판관리(설정) <span class="fa arrow"></span></a>
                        
                    </li>
                    <li>
                        <a href="adminFreeBoardSet.jsp"><i class="fa fa-flash "></i>자유게시판(설정) </a>
                        
                    </li>
                
                    <li>
                        <a href="#"><i class="fa fa-sign-in "></i>Login Page(#)</a>
                    </li>
                     <li>
                        <a href="#"><i class="fa fa-sign-in "></i>Chart & Graph(#)</a>
                    </li>
                    
                    <!-- 게시판 관리 끝 -->
                    
                    <!-- 회원관리 시작 -->
                    <li>
                        <a href="adminMemberSet.jsp"><i class="fa fa-sitemap "></i>회원관리(설정) <span class="fa arrow"></span></a>
                         <ul class="nav nav-second-level">
                            <li>
                                <a href="adminMemberSet.jsp"><i class="fa fa-bicycle "></i>일반 회원 관리(설정)</a>
                            </li>
                             <li>
                                <a href="adminTrainerSet.jsp"><i class="fa fa-flask "></i>트레이너 관리(설정)</a>
                            </li>
                           <!-- 회원관리 끝 --> 
                            
                            
                            <li>
                                <a href="#">Second Level Link(#)<span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a href="#"><i class="fa fa-plus "></i>Third Level Link(#)</a>
                                    </li>
                                    <li>
                                        <a href="#"><i class="fa fa-comments-o "></i>Third Level Link(#)</a>
                                    </li>

                                </ul>

                            </li>
                        </ul>
                    </li>
                   
                   
                </ul>

            </div>

        </nav>
</body>
</html>