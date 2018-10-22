<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="com.healthme.admin.vo.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<!--  반응형 웹을 위해서 meta date를 넣어주었다. 핸드폰과 사이트 둘다 봤을때 깔끔하게 보이게 하기 위해서이다. -->
<meta name="viewport" content="width=device-width" , initial-scale="1">

<!-- 디자인담당css -->
  <link href="../../css/admin/adminMain.css" rel="stylesheet" />
    <link href="../../css/admin/adminCustom.css" rel="stylesheet" />


<title>관리자페이지</title>
</head>
<body>

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
                        <a class="active-menu" href="dashboard.html"><i class="fa fa-desktop "></i>홈</a>
                    </li>
                    <!-- 홈 하나 끝 -->
                    
                    
                    <!-- 일반설정 시작 -->
                    <li>
                        <a href="#"><i class="fa fa-desktop "></i>일반설정 <span class="fa arrow"></span></a>
                         
                         <ul class="nav nav-second-level">                
                            <li>
                                <a href="input-forms.html"><i class="fa fa-toggle-on"></i>관리자 개인정보 설정</a>
        	                    </li>
		                        <li>
                                <a href="content-writer.html"><i class="fa fa-pencil-square-o"></i>광고설정</a>
                            </li>       
                        </ul>
                    </li>
                    
                    <!-- 일반설정 끝 -->
                    
                    
                    <!--  게시판 관리 시작 -->
                     <li>
                        <a href="#"><i class="fa fa-yelp "></i>게시판관리 <span class="fa arrow"></span></a>
                        
                    </li>
                    <li>
                        <a href="table-formats.html"><i class="fa fa-flash "></i>자유게시판 </a>
                        
                    </li>
                
                    <li>
                        <a href="login.html"><i class="fa fa-sign-in "></i>Login Page</a>
                    </li>
                     <li>
                        <a href="grapgs-and-charts.html"><i class="fa fa-sign-in "></i>Chart & Graph</a>
                    </li>
                    
                    <!-- 게시판 관리 끝 -->
                    
                    <!-- 회원관리 시작 -->
                    <li>
                        <a href="#"><i class="fa fa-sitemap "></i>회원관리 <span class="fa arrow"></span></a>
                         <ul class="nav nav-second-level">
                            <li>
                                <a href="#"><i class="fa fa-bicycle "></i>일반 회원 관리</a>
                            </li>
                             <li>
                                <a href="#"><i class="fa fa-flask "></i>트레이너 관리</a>
                            </li>
                           <!-- 회원관리 끝 --> 
                            
                            
                            <li>
                                <a href="#">Second Level Link<span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a href="#"><i class="fa fa-plus "></i>Third Level Link</a>
                                    </li>
                                    <li>
                                        <a href="#"><i class="fa fa-comments-o "></i>Third Level Link</a>
                                    </li>

                                </ul>

                            </li>
                        </ul>
                    </li>
                   
                   
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
                    <h1 class="page-head-line"><i class="fa fa-desktop" style="padding-right:10px"></i>Admin Page</h1>
                </div>
            </div>
         <div class="row">
                <div class="col-md-3">
                    <div class="main-box mb-red">
                        <a href="#">
                            <i class="fa fa-bolt fa-3x"></i>
                            <h5>새로운정보1</h5>
                        </a>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="main-box mb-dull">
                        <a href="#">
                            <i class="fa fa-plug fa-3x"></i>
                            <h5>새로운정보2</h5>
                        </a>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="main-box mb-pink">
                        <a href="#">
                            <i class="fa fa-dollar fa-3x"></i>
                            <h5>새로운정보3</h5>
                        </a>
                    </div>
                </div>
             <div class="col-md-3">
                    <div class="main-box mb-pink">
                        <a href="#">
                            <i class="fa fa-dollar fa-3x"></i>
                            <h5>새로운정보4</h5>
                        </a>
                    </div>
                </div>
            </div>
             <hr style="border:1px solid #000;"/>
                <div class="row">

                    <div class="col-md-8">

                        <div class="table-responsive">
                        <h3>자유게시판</h3>
                            <table class="table table-striped table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>번호</th>
                                        <th>제목</th>
                                        <th>내용</th>
                                        <th>이름</th>
                                        <th>Q/A, 자유</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td><span class="label label-danger">Mark</span></td>
                                        <td>Otto</td>
                                        <td>김종규</td>
                                        <td><span class="label label-info">100090</span></td>
                                    </tr>
                                     <tr>
                                        <td>1</td>
                                        <td><span class="label label-danger">Mark</span></td>
                                        <td>Otto</td>
                                        <td>김종규</td>
                                        <td><span class="label label-info">100090</span></td>
                                    </tr>
                                       <tr>
                                        <td>1</td>
                                        <td><span class="label label-danger">Mark</span></td>
                                        <td>Otto</td>
                                        <td>김종규</td>
                                        <td><span class="label label-info">100090</span></td>
                                    </tr>
                                       <tr>
                                        <td>1</td>
                                        <td><span class="label label-danger">Mark</span></td>
                                        <td>Otto</td>
                                        <td>김종규</td>
                                        <td><span class="label label-info">100090</span></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>


                    </div>
                    <div class="col-md-4">
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <i class="fa fa-bell fa-fw"></i>새로운소식
                            </div>

                            <div class="panel-body">
                                <div class="list-group">

                                    <a href="#" class="list-group-item">
                                        <i class="fa fa-twitter fa-fw"></i>총회원수
                                    <span class="pull-right text-muted small"><em>100명</em>
                                    </span>
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <i class="fa fa-envelope fa-fw"></i>트레이너회원
                                    <span class="pull-right text-muted small"><em>30개</em>
                                    </span>
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <i class="fa fa-tasks fa-fw"></i>광고수입
                                    <span class="pull-right text-muted small"><em>100만원</em>
                                    </span>
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <i class="fa fa-upload fa-fw"></i>새로운게시글
                                    <span class="pull-right text-muted small"><em>20개</em>
                                    </span>
                                    </a>
                                   
                                </div>
                                <!-- /.list-group -->
                                <a href="#" class="btn btn-info btn-block">View All Alerts</a>
                            </div>

                        </div>
                    </div>
                </div>
              
        </div>
        <!-- /. PAGE INNER  -->
    </div>
        
    
        </div>
    <!--  
         <script src="assets/js/jquery-1.10.2.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
         <script src="assets/js/jquery.metisMenu.js"></script>
         <script src="assets/js/custom.js"></script>


-->
</body>
</html>