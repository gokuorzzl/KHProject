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
    <meta name="subject" content="헬th미 Q&APage" />
    <!--키워드-->
    <meta name="keywords" content="www.healthme.com, 트레이너, 나만의, 맞춤" />
    <!--Q&APage 스타일-->
    <link rel="stylesheet" href="../../css/communityPage/noticePage.css" />
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
                핸드폰일 경우 메뉴
            </div>
            <div id="logo">
               로고
            </div>
            <div id="searchBar">
                검색바
            </div>
            <div id="menu">
                로그인, 메뉴
            </div>
        </div>
        
        <!--컨텐츠가 들어가는 중간부분-->
        <!--페이지별로 달라지는 부분-->
        <div id="middle">
            <!--지역, 종목 등 선택할 수 있는 선택박스-->
            <!--트레이너 별점 등 컨텐츠 나오는 부분-->
            <div id="contents">
                <div id="realContents">
                    <div id="communityMenuFrame">
                        <div class="communityMenu" id="noticeBoardBtn">게시판
                        </div>
                        <div class="communityMenu">
                            <a href="/page/communityPage/Q&APage.jsp">Q&A</a>
                        </div>
                    </div>
                    <div id="noticeBoardListFrame" >
                        <table>
                            <colgroup>
                                <col style="width:*%">
                                <col style="width:14%">
                                <col style="width:18%">
                                <col style="width:10%">
                            </colgroup>
                            <thead>
                                <tr>
                                    <th scope="col">제 목</th>
                                    <th scope="col">작성자</th>
                                    <th scope="col">작성일</th>
                                    <th scope="col">조회</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td><a href="/page/communityPage/readingPage.jsp">게시판입니다!!</a></td>
                                    <td>주용선</td>
                                    <td>2018-10-09</td>
                                    <td>0</td>
                                </tr>
                                <tr>
                                    <td><a href="#">게시판입니다!!</a></td>
                                    <td>주용선</td>
                                    <td>2018-10-09</td>
                                    <td>0</td>
                                </tr>
                                <tr>
                                    <td><a href="#">게시판입니다!!</a></td>
                                    <td>주용선</td>
                                    <td>2018-10-09</td>
                                    <td>0</td>
                                </tr>
                                <tr>
                                    <td><a href="#">게시판입니다!!</a></td>
                                    <td>주용선</td>
                                    <td>2018-10-09</td>
                                    <td>0</td>
                                </tr>
                                <tr>
                                    <td><a href="#">게시판입니다!!</a></td>
                                    <td>주용선</td>
                                    <td>2018-10-09</td>
                                    <td>0</td>
                                </tr>
                                <tr>
                                    <td><a href="#">게시판입니다!!</a></td>
                                    <td>주용선</td>
                                    <td>2018-10-09</td>
                                    <td>0</td>
                                </tr>
                                <tr>
                                    <td><a href="#">게시판입니다!!</a></td>
                                    <td>주용선</td>
                                    <td>2018-10-09</td>
                                    <td>0</td>
                                </tr>
                                <tr>
                                    <td><a href="#">게시판입니다!!</a></td>
                                    <td>주용선</td>
                                    <td>2018-10-09</td>
                                    <td>0</td>
                                </tr>
                                <tr>
                                    <td><a href="#">게시판입니다!!</a></td>
                                    <td>주용선</td>
                                    <td>2018-10-09</td>
                                    <td>0</td>
                                </tr>
                                <tr>
                                    <td><a href="#">게시판입니다!!</a></td>
                                    <td>주용선</td>
                                    <td>2018-10-09</td>
                                    <td>0</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    
                    <div id="noticeBoardSearchFrame">
                    <form>
                        <div class="searchEmptyPlace"></div>
                        <div id="searchMenu">
                            <select id="searchSelect">
                                <option>제목</option>
                                <option>작성자</option>
                                <option>내용</option>
                            </select>
                        </div>
                        <div id="search">
                            <input type="text" id="searchText">
                        </div>
                        <div id="searchSubmit">
                            <input type="submit" value="검색">
                        </div>
                        <div class="searchEmptyPlace">
                        </div>
                        </form>
                    </div>
                    <div id="writeFrame">
                        <div id="writeBtnEmptySpace" ><a href="#">1</a></div>
                        <div id="writeBtnFrame">
                            <button id="write" onclick="writeBtn();">글쓰기</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--회사정보가 들어가는 아랫부분-->
        <!--bottom부분은 관리자페이지 제외한 모든 페이지 통일-->
        <div id="bottom">
            김구이김주정조 정보
        </div>
    </div>
    <script>
        function searchBtn(){
            var searchText = document.getElementById("searchText").value;
            if(searchText==""){
                alert("검색할 내용을 입력하세요!");
            }
        }
        function writeBtn(){
        	location.href="/page/communityPage/writingPage.jsp"
        }
    </script>
</body>
</html>