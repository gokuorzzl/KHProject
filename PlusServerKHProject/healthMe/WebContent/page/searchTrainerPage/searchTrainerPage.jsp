<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ 
	page import="com.healthme.search.model.vo.*" 
		import = "java.util.ArrayList"
		import ="com.healthme.member.vo.*"
%>
<%
	//컨트롤러에서 온 값
	SearchResult searchResult = (SearchResult)request.getAttribute("searchResult");
	//검색결과인 트레이너 객체
	ArrayList<SearchedTrainerResult> trainerList = null;	
	//페이지 처리 
	String pageNavi = null;
	//페이지 내 결과 수
	int recordPerPage = 0;
	if(searchResult!=null){//받아오는 데이터가 null이 아닐때만 데이터를 읽어야 서버 오류가 나지 않음
		trainerList = searchResult.getTrainerList();
		pageNavi = searchResult.getPageNavi();
		recordPerPage = searchResult.getRecordPerPage();
	}
	//searchInput값
	String searchInput = (String)request.getAttribute("searchInput");
	String searchBox = (String)request.getAttribute("searchBox");
	
	//세션을 받기 위한 코드
	session = request.getSession(false);
	Member member = null;
	member = (Member)session.getAttribute("member");

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
    <link rel="stylesheet" href="../../css/searchTrainerPage/serchTrainerPage.css" />
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
<form class="searchForm" action="/searchInput.do" method="get">
	<input type="hidden" name="searchInput" class="searchInput" value="<%=searchInput%>"/>
	<input type="hidden" name="screenSize" class="screenSize" value=""/>
</form>
<!--전체 공간-->    
    <div id="wrapper">
        <div id="top">
      		<jsp:include page="/page/header/header.jsp"/>  	
        </div>
        <!--컨텐츠가 들어가는 중간부분-->
        <!--페이지별로 달라지는 부분-->
        <div id="middle">
            <!--지역, 종목 등 선택할 수 있는 선택박스-->
            <div id="searchBox">
	                <div id="realSearchBox">
	                    <div id="searchName">
	                        <div id="areaSearchName">광역시/도</div>
	                        <div id="subAreaSearchName">시/군/구</div>
	                        <div id="subArea2SearchName">읍/면/동</div>
	                        <div id="fieldSearchName">종목</div>
	                    </div>
	                    <div id="selectMenu">
	                        <div id="area" name = "area" class="scrollStyle">
	                            <ul>
	                                <li>서울특별시</li>
	                                <li>부산광역시</li>
	                                <li>대구광역시</li>
	                                <li>인천광역시</li>
	                                <li>광주광역시</li>
	                                <li>대전광역시</li>
	                                <li>울산광역시</li>
	                                <li>세종특별자치시</li>
	                                <li>경기도</li>
	                                <li>강원도</li>
	                                <li>충청북도</li>
	                                <li>충청남도</li>
	                                <li>전라북도</li>
	                                <li>전라남도</li>
	                                <li>경상북도</li>
	                                <li>경상남도</li>
	                                <li>제주특별자치도</li>
	                            </ul>
	                        </div>
	                        <div id="subArea" class="scrollStyle">
	  							<ul>
	  							<!-- id="area"에서 선택한 지역의 세부지역이 나오는 부분 -->
	  							</ul>
	                        </div>
	                        <div id="subArea2" class="scrollStyle">
	                            <ul>
	                            <!-- id="subArea2"에서 선택한 지역의 세부지역이 나오는 부분 -->
	                            </ul>
	                        </div>
	                        <div id="mobileFieldSearchName">종목</div>
	                        <div id="field" class="scrollStyle">
	                        	 <ul>
	                                <li>헬스</li>
	                                <li>요가</li>
	                                <li>구기종목</li>
	                                <li>무술</li>
	                                <li>라켓</li>
	                                <li>워터스포츠</li>
	                                <li>유산소운동</li>
	                            </ul>
	                        </div>
	                    </div>
	                </div>
	                <form id="searchBoxForm" action="/searchBox.do" method="get">
	                	<input type="hidden" name="searchBox" class="searchBox" value="<%=searchBox%>"/>
	               		<div id="submitButton"><button type="submit"><i class="fa fa-search"></i></button></div>
	                </form>
	            </div>
            <!--트레이너 별점 등 컨텐츠 나오는 부분-->
            <div id="contents">
            	<%String memberId = null; %>
           		<%if(searchResult==null){ //검색결과가 아닌 트레이너찾기 페이지를 띄워주는 경우 %>
            		<div id="ment">
						<img style="height:100%; width:100%;" src="../../img/searchTrainerMainImg.PNG">
					</div>
				<%} else { //검색해서 가져온 결과를 띄워주는 경우%>
					<div id="searchResultTrainer" style="width:100%; height:93%">
						<div style="width:80%; height:93%; margin:auto; margin-top:15px;">
							<% for(int i=0 ; i<(trainerList.size()<(recordPerPage/2)?trainerList.size():(recordPerPage/2)) ; i++){%>
									<%if(member==null){%>
										<a href="../page/error/loginFail.jsp" 
											style="width:30%; 
											height:49.5%; float:left; box-sizing:border-box; cursor: pointer;
											border:1.5px solid #3c3e3a; border-radius:6px 6px 6px 6px;
											margin-left:0.5%; margin-top:0.5%; text-align:right; overflow:hidden;"> 
									<%} else { %>
										<form class="trainerForm" action="/trainerOneSearch.do" method="post"
											style="width:30%; 
											height:49.5%; float:left; box-sizing:border-box; cursor: pointer;
											border:1.5px solid #3c3e3a; border-radius:6px 6px 6px 6px;
											margin-left:0.5%; margin-top:0.5%; text-align:right; overflow:hidden;">	
									<%} %>	
									<input type="hidden" name="memberId" value="<%=trainerList.get(i).getMemberId()%>"/>
										<div class="searchFormDiv" style="whidth:100%; height:100%;">
											<div style="width:100%; height:60%; box-sizing:border-box; overflow:hidden;">
												<img src="<%=trainerList.get(i).getProfileFile() %>"
													style="width:100%; height:auto; align:top; 
													border-radius:6px 6px 0 0; margin-bottom:5px; order:0;"/>
											</div>
											<div style="width:100%; height:40%; box-sizing:border-box; margin-left:-5px;">
												<div style="width:100%; height:30%; margin-top:1%; overflow:hidden;">[<%=trainerList.get(i).getMemberName() %>] 트레이너</div>
												<div style="width:100%; height:30%; margin-top:1%; overflow:hidden;"><%=trainerList.get(i).getTrainerEvent() %></div>
												<div style="width:100%; height:30%; margin-top:1%; overflow:hidden;">
													<%for(int j=0 ; j<Math.round(trainerList.get(i).getMatchingScore()) ; j++){ %>
														<img src="../../img/star/starFull.PNG" style="width:15%; height:100%;"/>
													<%} %>
													<%for(int j=0 ; j<5-Math.round(trainerList.get(i).getMatchingScore()) ; j++){ %>
														<img src="../../img/star/starNull.PNG" style="width:15%; height:100%;"/>
													<%} %>
												</div>
											</div>
										</div>
									<%if(member==null) {%>
										</a>
									<%} else { %>
										</form>
									<%} %>		
							<% } //for문 종료%>
							<%if(trainerList.size()>(recordPerPage/2)){ %>
								<% for(int i=(recordPerPage/2) ; i<trainerList.size() ; i++){ %>
									<%if(member==null){%>
										<a href="../page/error/loginFail.jsp" 
											style="width:30%; 
											height:49.5%; float:left; box-sizing:border-box; cursor: pointer;
											border:1.5px solid #3c3e3a; border-radius:6px 6px 6px 6px;
											margin-left:0.5%; margin-top:0.5%; text-align:right; overflow:hidden;">	 
									<%} else { %>
										<form class="trainerForm" action="/trainerOneSearch.do" method="post"
											style="width:30%; 
											height:49.5%; float:left; box-sizing:border-box; cursor: pointer;
											border:1.5px solid #3c3e3a; border-radius:6px 6px 6px 6px;
											margin-left:0.5%; margin-top:0.5%; text-align:right; overflow:hidden;">	
									<%} %>	
										<input type="hidden" name="memberId" value="<%=trainerList.get(i).getMemberId()%>"/>
											<div class="searchFormDiv" style="whidth:100%; height:100%;">
												<div style="width:100%; height:60%; box-sizing:border-box; overflow:hidden;">
													<img src="<%=trainerList.get(i).getProfileFile() %>"
														style="width:100%; height:auto; align:top; 
														border-radius:6px 6px 0 0; margin-bottom:5px; order:0;"/>
												</div>
												<div style="width:100%; height:40%; box-sizing:border-box; margin-left:-5px;">
													<div style="width:100%; height:30%; margin-top:1%; overflow:hidden;">[<%=trainerList.get(i).getMemberName() %>] 트레이너</div>
													<div style="width:100%; height:30%; margin-top:1%; overflow:hidden;"><%=trainerList.get(i).getTrainerEvent() %></div>
													<div style="width:100%; height:30%; margin-top:1%; overflow:hidden;">
													<%for(int j=0 ; j<Math.round(trainerList.get(i).getMatchingScore()) ; j++){ %>
														<img src="../../img/star/starFull.PNG" style="width:15%; height:100%;"/>
													<%} %>
													<%for(int j=0 ; j<5-Math.round(trainerList.get(i).getMatchingScore()) ; j++){ %>
														<img src="../../img/star/starNull.PNG" style="width:15%; height:100%;"/>
													<%} %>
													</div>
												</div>
											</div>
									<%if(member==null) {%>
										</a>
									<%} else { %>
										</form>
									<%} %>
								<% } //for문 종료%>
							<%} %>
						</div>
					</div>
					<div id="searchNavi" style="width:100%; height:7%; box-sizing:border-box; margin-top:0;">
						<label><%=pageNavi %></label><br><br><br><br>
					</div>
				<%} //if종료%>
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