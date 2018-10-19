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
    <link rel="stylesheet" href="../../css/SearchTrainerPage/serchTrainerPage.css" />
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

<!--전체 공간-->    
    <div id="wrapper">
        
        <!--로고, 메뉴가 들어가는 윗부분-->
        <!--top부분은 관리자페이지 제외한 모든 페이지 통일-->
        <div id="top">
            <div id="mobileMenu">
                <div>
                    <a href="#">☰</a>
                </div>
            </div>
            <div id="logo">
               <img src="../../img/%EB%A1%9C%EA%B3%A0.png">
            </div>
            <div id="searchBar">
           		<form>
           			<div>
           				<input type="text" name="searchInput" id="searchInput" value="지역, 종목 검색" />
               			<button type="submit"><i class="fa fa-search"></i></button>
           			</div>
           		</form>
            </div>
            <div id="menu">
                <div id="loginMenu">
                    <a href="#">로그인</a> 
                </div>
                <div id="menuButton">
                    <a href="#">☰</a>
                </div>
            </div>
        </div>
        
        <!--컨텐츠가 들어가는 중간부분-->
        <!--페이지별로 달라지는 부분-->
        <div id="middle">
            <!--지역, 종목 등 선택할 수 있는 선택박스-->
            <div id="searchBox">
                <div id="realSearchBox">
                    <div id="searchName">
                        <div>광역시/도</div>
                        <div>시/군/구</div>
                        <div>읍/면/동</div>
                        <div>종목</div>
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
							<input type="hidden" name="areaInput"/>
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
            </div>
            <!--트레이너 별점 등 컨텐츠 나오는 부분-->
            <div id="contents">
                <div id="realContents">
                    <div class="trainerBox">
                        <div class="boxImg"><img src="#"/></div>
                        <div class="boxInfo"></div>
                    </div>
                    <div class="blank"></div>
                </div>
            </div>
        </div>
        
        <!--회사정보가 들어가는 아랫부분-->
        <!--bottom부분은 관리자페이지 제외한 모든 페이지 통일-->
        <div id="bottom">
            김구이김주정조 정보
        </div>
    </div>
   

</body>
</html>