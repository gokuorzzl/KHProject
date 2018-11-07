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

	AdminMain am = (AdminMain)request.getAttribute("adminMainChart");	
%>




<!--  반응형 웹을 위해서 meta date를 넣어주었다. 핸드폰과 사이트 둘다 봤을때 깔끔하게 보이게 하기 위해서이다. -->
<meta name="viewport" content="width=device-width" , initial-scale="1">

<!-- 디자인담당css -->
  <link href="../../css/admin/adminMain.css" rel="stylesheet" />
    <link href="../../css/admin/adminCustom.css" rel="stylesheet" />


<%--차트 cdn기능 --%>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>
<script src="https://code.highcharts.com/modules/drilldown.js"></script>



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
							
							
							    <%--차트 들어갈 부분 --%> -->
                       
                       <div id="chartGrap" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
                       
                       
                       <script>
                    // Create the chart
                      Highcharts.chart('chartGrap', {
    chart: {
        type: 'column'
    },
    title: {
        text: 'healthme 김구이김주정조'
    },
    subtitle: {
        text: 'healthme의 모든것'
    },
    xAxis: {
        type: 'category'
    },
    yAxis: {
        title: {
            text: '숫자로 표현되는 수'
        }

    },
    legend: {
        enabled: false
    },
    plotOptions: {
        series: {
            borderWidth: 0,
            dataLabels: {
                enabled: true,
                format: '{point.y:.1f}%'
            }
        }
    },

    tooltip: {
        headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
        pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}%</b> of total<br/>'
    },

    "series": [
        {
            "name": "Browsers",
            "colorByPoint": true,
            "data": [
                {
                    "name": "회원수",
                    "y": <%=am.getMemberNum()%>,
                    "drilldown": "회원수"
                },
                {
                    "name": "트레이너승인신청수",
                    "y": <%=am.getTmptrainerNum()%>,
                    "drilldown": "트레이너신청수"
                },
                {
                    "name": "트레이너수",
                    "y": <%=am.getTrainerNum()%>,
                    "drilldown": "트레이너수"
                },
                {
                    "name": "매칭수",
                    "y": <%=am.getMatchingNum()%>,
                    "drilldown": "매칭수"
                },
                {
                    "name": "질문게시글수",
                    "y": <%=am.getQuestionNum()%>,
                    "drilldown": "질문게시글수"
                },
                {
                    "name": "자유게시글수",
                    "y": <%=am.getFreeNum()%>,
                    "drilldown": "자유게시글수"
                },
                {
                    "name": "그외",
                    "y": 10,
                    "drilldown": "그외"
                }
            ]
        }
    ],
    "drilldown": {
        "series": [
            {
                "name": "Chrome",
                "id": "Chrome",
                "data": [
                    [
                        "v65.0",
                        0.1
                    ],
                    [
                        "v64.0",
                        1.3
                    ],
                    [
                        "v63.0",
                        53.02
                    ],
                    [
                        "v62.0",
                        1.4
                    ],
                    [
                        "v61.0",
                        0.88
                    ],
                    [
                        "v60.0",
                        0.56
                    ],
                    [
                        "v59.0",
                        0.45
                    ],
                    [
                        "v58.0",
                        0.49
                    ],
                    [
                        "v57.0",
                        0.32
                    ],
                    [
                        "v56.0",
                        0.29
                    ],
                    [
                        "v55.0",
                        0.79
                    ],
                    [
                        "v54.0",
                        0.18
                    ],
                    [
                        "v51.0",
                        0.13
                    ],
                    [
                        "v49.0",
                        2.16
                    ],
                    [
                        "v48.0",
                        0.13
                    ],
                    [
                        "v47.0",
                        0.11
                    ],
                    [
                        "v43.0",
                        0.17
                    ],
                    [
                        "v29.0",
                        0.26
                    ]
                ]
            },
            {
                "name": "Firefox",
                "id": "Firefox",
                "data": [
                    [
                        "v58.0",
                        1.02
                    ],
                    [
                        "v57.0",
                        7.36
                    ],
                    [
                        "v56.0",
                        0.35
                    ],
                    [
                        "v55.0",
                        0.11
                    ],
                    [
                        "v54.0",
                        0.1
                    ],
                    [
                        "v52.0",
                        0.95
                    ],
                    [
                        "v51.0",
                        0.15
                    ],
                    [
                        "v50.0",
                        0.1
                    ],
                    [
                        "v48.0",
                        0.31
                    ],
                    [
                        "v47.0",
                        0.12
                    ]
                ]
            },
            {
                "name": "Internet Explorer",
                "id": "Internet Explorer",
                "data": [
                    [
                        "v11.0",
                        6.2
                    ],
                    [
                        "v10.0",
                        0.29
                    ],
                    [
                        "v9.0",
                        0.27
                    ],
                    [
                        "v8.0",
                        0.47
                    ]
                ]
            },
            {
                "name": "Safari",
                "id": "Safari",
                "data": [
                    [
                        "v11.0",
                        3.39
                    ],
                    [
                        "v10.1",
                        0.96
                    ],
                    [
                        "v10.0",
                        0.36
                    ],
                    [
                        "v9.1",
                        0.54
                    ],
                    [
                        "v9.0",
                        0.13
                    ],
                    [
                        "v5.1",
                        0.2
                    ]
                ]
            },
            {
                "name": "Edge",
                "id": "Edge",
                "data": [
                    [
                        "v16",
                        2.6
                    ],
                    [
                        "v15",
                        0.92
                    ],
                    [
                        "v14",
                        0.4
                    ],
                    [
                        "v13",
                        0.1
                    ]
                ]
            },
            {
                "name": "Opera",
                "id": "Opera",
                "data": [
                    [
                        "v50.0",
                        0.96
                    ],
                    [
                        "v49.0",
                        0.82
                    ],
                    [
                        "v12.1",
                        0.14
                    ]
                ]
            }
        ]
    }
});
                       
                       
                       
                       </script>
                       
                       <%--차트 기능 끝나는 부분 --%>
							
							
							
							
							
							
							
							


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