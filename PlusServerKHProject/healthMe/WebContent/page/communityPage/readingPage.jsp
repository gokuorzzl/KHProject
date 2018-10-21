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
    <link rel="stylesheet" href="../../css/communityPage/readingPage.css" />
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
                    <div id="titleFrame">
                        <span id="title">제목란입니다.</span>
                    </div>
                    <div id="otherInformationFrame">
                        <div id="writerView">
                            <p id="writerBundle">
                                작성자 : <span id="writer">주용선</span>
                            </p>
                        </div>
                        <div id="dateCreatedView"> 
                            작성일 : <span id="dateCreated">2018-10-14 </span>
                        </div>
                    </div>
                    <div id="mainContentsFrame">
                        <span id="mainContents">내용들어올 곳</span>
                    </div>
                    <div id="buttonsFrame">
                        <button id="listButton" onclick="back();">목록</button>
                    </div>
                    <div id="writeCommentFrame">
                        <div id="writeCommentTextView">
                            <textarea id="writeCommentText"></textarea>
                        </div>
                        <div id="writeCommentBtnView">
                            <button id="writeCommentBtn" onclick="commentBtn();">댓글</button>
                        </div>
                        
                    </div>
                    <div id="commentFrame">
                        <div id="commentWriterView">
                            <span id="commentWriter">댓글 작성자</span>
                        </div>
                        <div id="bundleComment">
                            <div id="commentContentsView">
                                <span id="commentContents">댓글내용</span>
                            </div>
                            <div id="commentDateCreatedView">
                                <span id="commentDateCreated">작성일</span>
                            </div>
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
        function commentBtn(){
            //수정이 필요함 댓글을 적어도 alert가 나옴..
            var commentText = document.getElementById("writeCommentText").innerHTML;
            if(commentText==""){
                alert("댓글내용을 작성해주세요!!");
            }
        }
        function back() {
        	history.go(-1);
		}
    </script>
</body>
</html>