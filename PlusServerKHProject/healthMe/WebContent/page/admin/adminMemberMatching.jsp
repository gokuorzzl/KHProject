<%@page import="java.util.ArrayList"%>
<%@page import="com.healthme.trainer.model.vo.Matching"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="com.healthme.admin.vo.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<%

	ArrayList<Matching> list = (ArrayList<Matching>)request.getAttribute("matchingAllList");
%>




<!--  반응형 웹을 위해서 meta date를 넣어주었다. 핸드폰과 사이트 둘다 봤을때 깔끔하게 보이게 하기 위해서이다. -->
<meta name="viewport" content="width=device-width" , initial-scale="1">

<!-- 디자인담당css -->
  <link href="../../css/admin/adminMain.css" rel="stylesheet" />
    <link href="../../css/admin/adminCustom.css" rel="stylesheet" />


<title>관리자페이지 메인</title>
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
                
               <a class="navbar-brand" href="/page/admin/adminMain.jsp"><img src="../../img/로고.png" class="logo"></a>
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
                        <a class="active-menu" href="/page/admin/adminMain.jsp"><i class="fa fa-desktop"></i>홈(설정)</a>
                    </li>
                    <!-- 홈 하나 끝 -->
                    
                    
                    <!-- 일반설정 시작 -->
                    <li>
                        <a href="/page/admin/adminNormalSet.jsp"><i class="fa fa-desktop"></i>일반설정(설정)</a>
                    
                    </li>
                    
                    <!-- 일반설정 끝 -->
                    
                    
                    <!--  게시판 관리 시작 -->
                     <li>
                        <a class="active-menu" href="/page/admin/adminMemberSet.jsp"><i class="fa fa-desktop"></i>회원설정</a>
                    </li>
                    <li>
                        <a href="/page/admin/adminBoardSet.jsp"><i class="fa fa-desktop"></i>게시판설정 </a>
                        
                    </li>
                
                    <li>
                       <a href="/page/admin/adminVisitSet.jsp"><i class="fa fa-sign-in "></i>방문자 및 광고</a>
                    </li>
                     <li>
                        <a href="#"><i class="fa fa-sign-in "></i>Chart & Graph(#)</a>
                    </li>
                    
                    <!-- 게시판 관리 끝 -->
                    
                     
       
                   
                </ul>

            </div>

        </nav>
       <div id="page-wrapper">
        <ul class="breadcrumbs" style="margin-bottom:-10px">
                <li><a href="dashboard.html" style="text-decoration:none;color:#383737;font-weight:bold"><i class="fa fa-home"></i></a> > <a href="" style="text-decoration:none;color:#383737;font-weight:bold">ADMIN 관리자</a><span class="separator"></span></li>
            </ul>
        <div id="page-inner">
            <div class="row" style="margin-bottom:20px">
                <div class="col-md-12">
                    <h1 class="page-head-line"><i class="fa fa-desktop" style="padding-right:10px"></i>관리자 회원설정</h1>
                </div>
            </div>
         <div class="row">
                <div class="col-md-3">
                    <div class="main-box mb-red">
                        <a href="/page/admin/adminMemberAdmin.jsp">
                            <i class="fa fa-bolt fa-3x"></i>
                            <h5>관리자설정</h5>
                        </a>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="main-box mb-dull">
                        <a href="/adminAllList.do">
                            <i class="fa fa-plug fa-3x"></i>
                            <h5>회원설정</h5>
                        </a>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="main-box mb-pink">
                        <a href="/adminAllListT.do">
                            <i class="fa fa-dollar fa-3x"></i>
                            <h5>트레이너수정</h5>
                        </a>
                    </div>
                </div>
             <div class="col-md-3">
                    <div class="main-box mb-pink">
                        <a href="/adminMatchingAll.do">
                            <i class="fa fa-dollar fa-3x"></i>
                            <h5>매칭설정</h5>
                        </a>
                    </div>
                </div>
            </div>
            
             <hr style="border:1px solid #000;"/>
                <div class="row">

					<%--테이블 들어갈 공간 --%>

							<div class="table-responsive">
							<h3>회원설정</h3>
							<table class="table table-striped table-bordered table-hover">
								<!--       <table cellSpacing=0 borderColorDark=white width="760" bgColor=#c0c0c0 borderColorLight=#dddddd border=1 class="s1">-->
								<!--  <form id=updateform method="post" action="/adminMemberAllUpdate.do"> -->
									<input type="hidden" name="theme"
										value="basicinfo/basic_info2_qry"> <input
										type="hidden" name="menushow" value="menu1">

									<tr bgColor=E0E4E8>
										<td colSpan=4 align="center"><font color="#333333">매칭회원</font></td>
										<td colSpan=4 align="center"><font color="#333333">여부체크</font></td>
										<td colSpan=4 align="center"><font color="#333333">담당트레이너</font></td>
										<td colSpan=4 align="center"><font color="#333333">매칭점수</font></td>
									
									</tr>
									
									<%for(Matching g:list){ %>
									<tr>	
										<td colSpan=4><font color="#333333"><%=g.getMatchingMemberId()%></font></td>
										<td colSpan=4><font color="#333333"><%=g.getWishTrainerCheck()%></font></td>
										<td colSpan=4><font color="#333333"><%=g.getMatchedMemberId()%></font></td>
										<td colSpan=4><font color="#333333"><%=g.getMatchingScore()%></font></td>
								
									</tr>
									
									
									<%} %>

							
							</table>


                    <%--테이블 끝날 공간 --%>
                    </div>
                </div>
              
        </div>
        <!-- /. PAGE INNER  -->
    </div>
        
    
        </div>


<jsp:include page="/page/footer/footer.jsp"/>


</body>
</html>