<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ 
	page import="com.healthme.search.model.vo.*" 
		import = "java.util.ArrayList"
%>
<%
	//컨트롤러에서 온 값
	SearchResult resultPage = (SearchResult)request.getAttribute("searchResult");
	//검색결과인 트레이너 객체
	ArrayList<SearchedTrainerResult> trainerList = resultPage.getTrainerList();
	//페이지 처리 
	String pageNavi = resultPage.getPageNavi();
%> --%>

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
    <link rel="stylesheet" href="../../css/mypage/myPage.css" />
    <!-- 스크립트 -->
    <script src="https://code.jquery.com/jquery-3.3.1.js"
 			integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
  			crossorigin="anonymous"></script>
  	<script type="text/javascript" src="../../js/searchTrainerPage/searchingArea.js"></script>
  	<script type="text/javascript" src="../../js/searchTrainerPage/searchTrainer.js"></script>
  	<!-- fa 아이콘 링크  -->
  	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <!--title-->
    <title>헬th미:나만의 트레이너</title>
</head>
<body>
<!--전체 공간-->
		<%-- <% for(SearchedTrainerResult n : trainerList){ %>
									아이디 : <%=n.getMemberId() %><br>
									이름 : <%=n.getMemberName() %><br>
									프로필 경로 : <%=n.getProfileFile() %><br>
									종목 : <%=n.getTrainerEvent() %><br>
									별점 : <br>
									<br><br><br>
		<% } %> --%>
    
    <div id="wrapper">
        <div id="top">
      		<jsp:include page="/page/header/header.jsp"/>  	
        </div>
        
        <!--컨텐츠가 들어가는 중간부분-->
        <!--페이지별로 달라지는 부분-->
        <div id="middle">
            <!--지역, 종목 등 선택할 수 있는 선택박스-->
            <div id="searchBox">
            	<div id="area01">
	                <div id="sec01">
	                    <div class="box">
	                        <img id="img01" src="../images/jaehun.jpg" alt="userImg">
	                        <p id="p1">
                        	</p>
                        	
	                        <p id="p2" name="">씨언어가씨블씨블</p>
	                        <p id="p3">정보수정</p>
	                        <p id="p4">로그아웃</p>
	                    </div>
	                </div>
	                <div id="sec02">
	                    <div class="box">
	                        <div class="box1">
	                            <a href="">
	                                <img id="img02" src="../../img/icon_my_menu01.png">
	                                <p id="sec02_p1">받은수업 신청서</p>
	                                <p>0건</p>
	                            </a>
	                        </div>
	                        <div class="box2">
	                            <a href="">
	                                <img id="img03" src="../../img/icon_my_menu02.png">
	                                <p id="sec02_p2">신청한 수업</p>
	                                <p>0건</p>
	                            </a>
	                        </div>
	                        <div class="box3">
	                            <a href="">
	                                <img id="img04" src="../../img/icon_my_menu03.png">
	                                <p id="sec02_p3">관심 트레이너</p>
	                                <p>0건</p>
	                            </a>
	                        </div>
	                    </div>
	                </div>
	                <div id="sec03">
	                </div>
            	</div>
	            <div id="area02">
	            </div>
            </div>
						
            
    	</div>
        <!--회사정보가 들어가는 아랫부분-->
        <!--bottom부분은 관리자페이지 제외한 모든 페이지 통일-->
		<div id="bottom">
			<jsp:include page="/page/footer/footer.jsp"/>
		</div>
    </div>
    

</body>
</html>