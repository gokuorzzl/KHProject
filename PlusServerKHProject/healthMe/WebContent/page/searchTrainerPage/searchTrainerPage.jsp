<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  	<!-- fa 아이콘 링크  -->
  	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <!--title-->
    <title>헬th미:나만의 트레이너</title>

</head>
<body>

	<!-- Menu -->
	<div id="navigation">
		<div><p>✕</p></div>
		<div id="navigation-login"><a href = "../loginPage/login.jsp">로그인</a></div>
		<ul>
			<li><a href="../../index.jsp">메인</a></li>
	        <li><a href="searchTrainerPage.jsp">트레이너 찾기</a></li>
	        <li><a href="#">트레이너 등록</a></li>
	        <li><a href="../communityPage/boardPage.jsp">게시판</a></li>
	        <li><a href="../communityPage/Q&APage.jsp">Q & A</a></li>
		</ul>
	</div>

<!--전체 공간-->    
    <div id="wrapper">
        
		<jsp:include page="/page/header/header.jsp"/>
        
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
                            <!-- input에 정보를 담아서 가져옴 -> 자바 변수에 저장 -->
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
                <div id="submitButton"><button type="submit"><i class="fa fa-search"></i></button></div>
            </div>
            <!--트레이너 별점 등 컨텐츠 나오는 부분-->
            <div id="contents">
            	<div id="ment">
					<img style="height:100%; width:100%;" src="../../img/searchTrainerMainImg.PNG">
            	</div>
         	<!--  
        		<div id="realContents">
                    <div class="trainerBox">
                        <div class="boxImg"><img src="#"/></div>
                        <div class="boxInfo"></div>
                    </div>
                    <div class="blank"></div>
               	</div>
       		-->
            </div>
        </div>
        
        <!--회사정보가 들어가는 아랫부분-->
        <!--bottom부분은 관리자페이지 제외한 모든 페이지 통일-->

       <jsp:include page="/page/footer/footer.jsp"/>

    </div>
   

</body>
</html>