<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="com.healthme.admin.vo.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



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
                
                <a class="navbar-brand" href="MainAdmin.jsp"><img src="../../img/로고.png" class="logo"></a>
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
                        <a  href="adminMain.jsp"><i class="fa fa-desktop"></i>홈(설정)</a>
                    </li>
                    <!-- 홈 하나 끝 -->
                    
                    
                    <!-- 일반설정 시작 -->
                    <li>
                        <a href="adminNormalSet.jsp"><i class="fa fa-desktop"></i>일반설정(설정)</a>
                    
                    </li>
                    
                    <!-- 일반설정 끝 -->
                    
                    
                    <!--  게시판 관리 시작 -->
                     <li>
                        <a class="active-menu" href="adminMemberSet.jsp"><i class="fa fa-desktop"></i>회원설정</a>
                    </li>
                    <li>
                        <a href="adminBoardSet.jsp"><i class="fa fa-desktop"></i>게시판설정 </a>
                        
                    </li>
                
                    <li>
                       <a href="adminVisitSet.jsp"><i class="fa fa-sign-in "></i>방문자 및 광고</a>
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
                        <a href="adminMemberAdmin.jsp">
                            <i class="fa fa-bolt fa-3x"></i>
                            <h5>관리자설정</h5>
                        </a>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="main-box mb-dull">
                        <a href="#">
                            <i class="fa fa-plug fa-3x"></i>
                            <h5>회원설정</h5>
                        </a>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="main-box mb-pink">
                        <a href="#">
                            <i class="fa fa-dollar fa-3x"></i>
                            <h5>트레이너수정</h5>
                        </a>
                    </div>
                </div>
             <div class="col-md-3">
                    <div class="main-box mb-pink">
                        <a href="#">
                            <i class="fa fa-dollar fa-3x"></i>
                            <h5>매칭설정</h5>
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

<jsp:include page="/page/footer/footer.jsp"/>


</body>
</html>