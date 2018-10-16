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
    <link rel="stylesheet" href="../../CSS/SearchTrainerPage/serchTrainerPage.css" />
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
               <img src="../images/%EB%A1%9C%EA%B3%A0.png">
            </div>
            <div id="searchBar">
                <input type="text" name="searchInput" id="searchInput" value="지역, 종목 검색" />
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
                        <div>지역</div>
                        <div>세부지역</div>
                        <div>분야</div>
                        <div>종목</div>
                    </div>
                    <div id="selectMenu">
                        <div id="area" class="scrollStyle">
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
                            서울특별시를 선택하면 동대문구, 중랑구 등 단위로 나올 수 있도록 스크립트? 작성
                        </div>
                        <div id="field" class="scrollStyle">
                            <ul>
                                <li>다이어트</li>
                                <li>체형교정</li>
                                <li>...</li>
                            </ul>
                        </div>
                        <div id="subField" class="scrollStyle">
                            다이어트도 체형교정도 헬스 할 수 있잖아??
                            세부종목 말고 다른 것 들어가도 좋을 것 같은데..
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