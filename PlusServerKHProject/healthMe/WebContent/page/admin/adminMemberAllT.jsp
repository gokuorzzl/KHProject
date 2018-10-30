<%@page import="com.healthme.trainer.model.vo.Trainer"%>
<%@page import="com.healthme.member.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.healthme.admin.vo.*"%>


<%
	ArrayList<Trainer> list = (ArrayList<Trainer>)request.getAttribute("memberAllListT");
%>



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

		<nav class="navbar navbar-default navbar-cls-top " role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".sidebar-collapse">
					<span class="sr-only">김구이김주정조</span> <span class="icon-bar"></span>
					<span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>

				<a class="navbar-brand" href="MainAdmin.jsp"><img
					src="../../img/로고.png" class="logo"></a>
			</div>
			<div class="header-left">

				<a href="#" class="left-head-icon" title="새메세지"><span
					class="iconposition">93 </span><img src="../../img/message.png"
					class="message"></a> <a href="#" class="left-head-icon"
					title="새로운사용자"><span class="iconposition">08 </span><img
					src="../../img/newuser.png" class="newuser"></a> <a href="#"
					class="left-head-icon" title="매칭회원"><span class="iconposition">17
				</span><img src="../../img/success.png" class="success"></a>
				<%
				session = request.getSession(false);
				Admin admin = (Admin)session.getAttribute("admin");
				if(admin!=null){
				%>
				<H3>
					[<%=admin.getAdminId()%>]님 환영합니다.
				</H3>
				<%
				}else{
				%>
				<H3>
					<a href="/page/admin/adminlogin.jsp">관리자가 아닙니다.(로그인화면돌아가기)</a>
				</H3>
				<%} %>

			</div>



			<div class="header-right">

				<a href="/adminLoginOut.do" class="left-head-icon" title="Sign Out"><img
					src="../../img/logout.png" class="logout"></a>


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
					<li><a href="/page/admin/adminNormalSet.jsp"><i class="fa fa-desktop"></i>일반설정(설정)</a>

					</li>

					<!-- 일반설정 끝 -->


					<!--  게시판 관리 시작 -->
					<li><a class="active-menu" href="adminMemberSet.jsp"><i
							class="fa fa-desktop"></i>회원설정</a></li>
					<li><a href="/page/admin/adminBoardSet.jsp"><i class="fa fa-desktop"></i>게시판설정
					</a></li>

					<li><a href="/page/admin/adminVisitSet.jsp"><i class="fa fa-sign-in "></i>방문자
							및 광고</a></li>
					<li><a href="#"><i class="fa fa-sign-in "></i>Chart &
							Graph(#)</a></li>

					<!-- 게시판 관리 끝 -->




				</ul>

			</div>

		</nav>
		<div id="page-wrapper">
			<ul class="breadcrumbs" style="margin-bottom: -10px">
				<li><a href="dashboard.html"
					style="text-decoration: none; color: #383737; font-weight: bold"><i
						class="fa fa-home"></i></a> > <a href=""
					style="text-decoration: none; color: #383737; font-weight: bold">ADMIN
						관리자</a><span class="separator"></span></li>
			</ul>
			<div id="page-inner">
				<div class="row" style="margin-bottom: 20px">
					<div class="col-md-12">
						<h1 class="page-head-line">
							<i class="fa fa-desktop" style="padding-right: 10px"></i>관리자 회원설정
						</h1>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3">
						<div class="main-box mb-red">
							<a href="/page/admin/adminMemberAdmin.jsp"> <i class="fa fa-bolt fa-3x"></i>
								<h5>관리자설정</h5>
							</a>
						</div>
					</div>
					<div class="col-md-3">
						<div class="main-box mb-dull">
							<a href="/adminAllList.do"> <i class="fa fa-plug fa-3x"></i>
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
							<a href="#"> <i class="fa fa-dollar fa-3x"></i>
								<h5>매칭설정</h5>
							</a>
						</div>
					</div>
				</div>
				<hr style="border: 1px solid #000;" />
				<div class="row">

					<div class="col-md-8">

						<div class="table-responsive">
							<h3>회원설정</h3>
							<table class="table table-striped table-bordered table-hover">
								<!--       <table cellSpacing=0 borderColorDark=white width="760" bgColor=#c0c0c0 borderColorLight=#dddddd border=1 class="s1">-->
								
									<input type="hidden" name="theme"
										value="basicinfo/basic_info2_qry"> <input
										type="hidden" name="menushow" value="menu1">

									<tr bgColor=E0E4E8>
										<td colSpan=4><font color="#333333">&nbsp; 아이디</font></td>
										<td colSpan=4><font color="#333333">&nbsp; 프로필경로</font></td>
										<td colSpan=4><font color="#333333">&nbsp; 대학교졸업파일</font></td>
										<td colSpan=4><font color="#333333">&nbsp; 대학교</font></td>
										<td colSpan=4><font color="#333333">&nbsp; a재학,b졸업,c수료</font></td>
										<td colSpan=4><font color="#333333">&nbsp; 직장주소</font></td>
										<td colSpan=4><font color="#333333">&nbsp; 수업제목</font></td>
										<td colSpan=4><font color="#333333">&nbsp; 수업소개</font></td>
										<td colSpan=4><font color="#333333">&nbsp; 종목</font></td>
										<td colSpan=4><font color="#333333">&nbsp; 경력인증파일</font></td>
										<td colSpan=4><font color="#333333">&nbsp; 경력시작1</font></td>
										<td colSpan=4><font color="#333333">&nbsp; 경력종료1</font></td>
										<td colSpan=4><font color="#333333">&nbsp; 경력1</font></td>
										
										<td colSpan=4><font color="#333333">&nbsp; 경력시작2</font></td>
										<td colSpan=4><font color="#333333">&nbsp; 경력종료2</font></td>
										<td colSpan=4><font color="#333333">&nbsp; 경력2</font></td>
										
										<td colSpan=4><font color="#333333">&nbsp; 경력시작3</font></td>
										<td colSpan=4><font color="#333333">&nbsp; 경력종료3</font></td>
										<td colSpan=4><font color="#333333">&nbsp; 경력3</font></td>
										
										<td colSpan=4><font color="#333333">&nbsp; 경력시작4</font></td>
										<td colSpan=4><font color="#333333">&nbsp; 경력종료4</font></td>
										<td colSpan=4><font color="#333333">&nbsp; 경력4</font></td>
										
										<td colSpan=4><font color="#333333">&nbsp; 경력시작5</font></td>
										<td colSpan=4><font color="#333333">&nbsp; 경력종료5</font></td>
										<td colSpan=4><font color="#333333">&nbsp; 경력5</font></td>
										
										<td colSpan=4><font color="#333333">&nbsp; 경력인증파일</font></td>
										<td colSpan=4><font color="#333333">&nbsp; 자격증1</font></td>
										<td colSpan=4><font color="#333333">&nbsp; 자격증2</font></td>
										<td colSpan=4><font color="#333333">&nbsp; 자격증3</font></td>
										<td colSpan=4><font color="#333333">&nbsp; 자격증4</font></td>
										<td colSpan=4><font color="#333333">&nbsp; 자격증5</font></td>
										
										<td colSpan=4><font color="#333333">&nbsp; 수정</font></td>
										<td colSpan=4><font color="#333333">&nbsp; 삭제</font></td>
									</tr>
									<form id=updateform method="post" action="/adminMember.do">
									
									<%for(Trainer t:list){ %>
									<tr>	
										<td colSpan=4><font color="#333333">&nbsp; <%=t.getMemberId()%></font></td>
										<td colSpan=4><font color="#333333">&nbsp; <%=t.getProfileFile()%></font></td>
										<td colSpan=4><font color="#333333">&nbsp; <%=t.getTrainerGradFile()%></font></td>
										<td colSpan=4><font color="#333333">&nbsp; <%=t.getTrainerUniv()%></font></td>
										<td colSpan=4><font color="#333333">&nbsp; <%=t.getTrainerGrad()%></font></td>
										<td colSpan=4><font color="#333333">&nbsp; <%=t.getTrainerRegion()%></font></td>
										<td colSpan=4><font color="#333333">&nbsp; <%=t.getTrainerSubject()%></font></td>
										<td colSpan=4><font color="#333333">&nbsp; <%=t.getTrainerContent()%></font></td>
										<td colSpan=4><font color="#333333">&nbsp; <%=t.getTrainerEvent()%></font></td>
										<td colSpan=4><font color="#333333">&nbsp; <%=t.getTrainerCareerFile()%></font></td>
										
										<td colSpan=4><font color="#333333">&nbsp; <%=t.getCareerStart1()%></font></td>
										<td colSpan=4><font color="#333333">&nbsp; <%=t.getCareerEnd1()%></font></td>
										<td colSpan=4><font color="#333333">&nbsp; <%=t.getCareerName1()%></font></td>
										
										<td colSpan=4><font color="#333333">&nbsp; <%=t.getCareerStart2()%></font></td>
										<td colSpan=4><font color="#333333">&nbsp; <%=t.getCareerEnd2()%></font></td>
										<td colSpan=4><font color="#333333">&nbsp; <%=t.getCareerName2()%></font></td>
										
										<td colSpan=4><font color="#333333">&nbsp; <%=t.getCareerStart3()%></font></td>
										<td colSpan=4><font color="#333333">&nbsp; <%=t.getCareerEnd3()%></font></td>
										<td colSpan=4><font color="#333333">&nbsp; <%=t.getCareerName3()%></font></td>
										
										<td colSpan=4><font color="#333333">&nbsp; <%=t.getCareerStart4()%></font></td>
										<td colSpan=4><font color="#333333">&nbsp; <%=t.getCareerEnd4()%></font></td>
										<td colSpan=4><font color="#333333">&nbsp; <%=t.getCareerName4()%></font></td>
										
										<td colSpan=4><font color="#333333">&nbsp; <%=t.getCareerStart5()%></font></td>
										<td colSpan=4><font color="#333333">&nbsp; <%=t.getCareerEnd5()%></font></td>
										<td colSpan=4><font color="#333333">&nbsp; <%=t.getCareerName5()%></font></td>
										
										<td colSpan=4><font color="#333333">&nbsp; <%=t.getTrainerLicenseFile()%></font></td>
										<td colSpan=4><font color="#333333">&nbsp; <%=t.getLicenseName1()%></font></td>
										<td colSpan=4><font color="#333333">&nbsp; <%=t.getLicenseName2()%></font></td>
										<td colSpan=4><font color="#333333">&nbsp; <%=t.getLicenseName3()%></font></td>
										<td colSpan=4><font color="#333333">&nbsp; <%=t.getLicenseName4()%></font></td>
										<td colSpan=4><font color="#333333">&nbsp; <%=t.getLicenseName5()%></font></td>
									
									<td bgColor=#ffffff colSpan=4><button id="btn1" onclick="modifyActive();">수정</button></td>
									<td bgColor=#ffffff colSpan=4><button id="btn2" onclick="delNotice();">삭제</button></td>
									
									
									</tr>
									<%} %>

								</form>




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

									<a href="#" class="list-group-item"> <i
										class="fa fa-twitter fa-fw"></i>총회원수 <span
										class="pull-right text-muted small"><em>100명</em> </span>
									</a> <a href="#" class="list-group-item"> <i
										class="fa fa-envelope fa-fw"></i>트레이너회원 <span
										class="pull-right text-muted small"><em>30개</em> </span>
									</a> <a href="#" class="list-group-item"> <i
										class="fa fa-tasks fa-fw"></i>광고수입 <span
										class="pull-right text-muted small"><em>100만원</em> </span>
									</a> <a href="#" class="list-group-item"> <i
										class="fa fa-upload fa-fw"></i>새로운게시글 <span
										class="pull-right text-muted small"><em>20개</em> </span>
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
<script>
	function back(){
		history.go(-1);
		return false;
	}
</script>


	<jsp:include page="/page/footer/footer.jsp" />


</body>
</html>