<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@  page import = "com.healthme.community.model.vo.*"
		%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% 
char boardtype = (char)request.getAttribute("boardtype"); 
Board board = (Board)request.getAttribute("board");

%>
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
    <link rel="stylesheet" href="../../css/communityPage/writingPage.css" />
    <!--title-->
    <title>헬th미:나만의 트레이너</title>
</head>
<body>
    
    <!--전체 공간-->    
    <div id="wrapper">
        
        <!--로고, 메뉴가 들어가는 윗부분-->
        <!--top부분은 관리자페이지 제외한 모든 페이지 통일-->
        <div id="top">
      		<jsp:include page="/page/header/header.jsp"/>  	
        </div>
        
        <!--컨텐츠가 들어가는 중간부분-->
        <!--페이지별로 달라지는 부분-->
        <div id="middle">
            <!--지역, 종목 등 선택할 수 있는 선택박스-->
            <!--트레이너 별점 등 컨텐츠 나오는 부분-->
            <div id="contents">
            <%if(boardtype=='f'){ %>
                <form action="/freeEditPage.do" method="post">
            <%}else{ %>
            	<form action="/qnaEditPage.do" method="post">
            <%} %>
                <div id="realContents">
                    <div id="wirtePartFrame">
                        <div id="divisionframe">
                            <div id="realDivisionframe"><pre>구     분 : <select name="boardDivision">
                            <%if(boardtype=='f'){ %>
                                <option value="0">게시판</option>
                            <%}else{ %>
                                <option value="1">Q&A</option>
                            <%} %>
                                </select>
                            </pre>
                            </div>
                        </div>
                        <div id="titleframe">
                            <div id="realTitleframe">
                            <input type="hidden" name="boardNumber" value="<%=board.getNum()%>">
                                <pre>제     목 : <input type="text" id="titleText" name="titleText" value="<%=board.getTitle()%>"/>
                                </pre>
                            </div>
                        </div>
                        <div id="writeContentsframe">
                            <div id="realWriteContentsframe">
                                <pre><span>내     용 :</span> <textarea id="contentsText" name="contentsText" style="resize:none;"><%=board.getContent() %></textarea>
                                </pre>
                            </div>
                        </div>
                        <div id="passwordframe">
                            <div id="realPasswordframe">
                                	비밀번호 : 
                                <input id="passwordText" name="passwordText" type="text" value="<%=board.getPwd()%>"/>
                                on<input type="radio" name="pwdRadio" onclick="radioCheck(this.value);" value="on"/>
                                off<input type="radio" checked name="pwdRadio" onclick="radioCheck(this.value);" value="off"/>
                            </div>
                        </div>
                    </div>
                    <div id="writePageBtnFrame">
                        <div id="wirteEmptyPlace"></div>
                        <div id="writeBtnFrame">
                            <input type="submit" id="writeBtn" onclick="return check();" value="수정"/>
                        </div>
                        <div id="cancelBtnFrame">
                            <input type="button" id="cancelBtn" onclick="back();" value="취소"/>
                        </div>
                    </div>
                </div>
            </form>  
            </div>
        </div>
        
        <!--회사정보가 들어가는 아랫부분-->
        <!--bottom부분은 관리자페이지 제외한 모든 페이지 통일-->
        <div id="bottom">
			<jsp:include page="/page/footer/footer.jsp"/>
		</div>
    </div>
    
    
    <script>
    	function radioCheck(v){
		   	 // 라디오 버튼 value 값 조건 비교
		   	 if(v == "on"){
		   	  document.getElementById("passwordText").style.display = "inline";
		   	 }else{
		   	  document.getElementById("passwordText").style.display = "none";
		   	 }
    	}

        function check(){
            var TitleText = document.getElementById("titleText").value;
            var ContentsText = document.getElementById("contentsText").value;
            if(TitleText==""){
                alert("제목을 작성해주세요!");
                return false;
            }else if(ContentsText==""){
                alert("내용을 작성해주세요!");
                return false;
            }
        }
        function back(){
        	history.go(-1);
		}
    </script>
</body>
</html>