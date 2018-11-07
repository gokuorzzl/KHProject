<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.healthme.community.model.vo.*" 
		import = "com.healthme.member.vo.*"
		import = "java.util.ArrayList"%>
<%
	session = request.getSession(false);
	Member member = null;
	member = (Member)session.getAttribute("member");
	BoardPageData bpd = (BoardPageData)request.getAttribute("boardPageData");
	String keyword = (String)request.getAttribute("keyword");
	ArrayList<Board> list = null;
	String pageNavi = null;
	
	if(bpd!=null){
		list = bpd.getList();//현재 페이지의 글 목록
		pageNavi = bpd.getPageNavi();//현재 navi Bar
	}
%>
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
    <link rel="stylesheet" href="../../css/communityPage/boardPage.css" />
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
                <div id="realContents">
                    <div id="communityMenuFrame">
                        <div class="communityMenu" id="noticeBoardBtn">게시판
                        </div>
                        <div class="communityMenu">
                            <a href="/qnaPage.do">Q&A</a>
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
                              	<%if(bpd!=null){
                            	for(Board b : list){ %>
								<tr>
									<td><a href="/freeSelect.do?freeNum=<%=b.getNum()%>" onclick="return pwdCheck(<%=b.getPwd()%>)"><%=b.getTitle() %></a></td>
									<td><%=b.getUserId() %></td>
									<td><%=b.getInsertDate() %></td>
									<td><%=b.getHits() %></td>
								</tr>
								<%}%>
                            </tbody>
                        </table>
                            	<%}else{%>
                            	</tbody>
                        </table>
                        	검색한 결과가 없습니다.
                         <% }%>
                    </div>
                    
                    <div id="noticeBoardSearchFrame">
                    <form action="/freeSearch.do" method="get">
                        <div class="searchEmptyPlace"></div>
                        <div id="searchMenu">
                            <select id="searchSelect" name="searchSelect">
                                <option value="0">제목</option>
                                <option value="1">작성자</option>
                                <option value="2">내용</option>
                            </select>
                        </div>
                        <div id="search">
                           <%if(keyword!=null){ %>
                            	<input type="text" id="searchText" name="searchText" value="<%=keyword%>"/>
	                        <%}else { %>
	                        	<input type="text" id="searchText" name="searchText"/>
	                        <%}%>
                        </div>
                        <div id="searchSubmit">
                            <button type="submit" onclick="return searchBtn();">검색</button>
                        </div>
                        <div class="searchEmptyPlace"></div>
                        </form>
                    </div>
                    <div id="writeFrame">
                    <%if(pageNavi!=null){ %>
                        <div id="writeBtnEmptySpace" ><label><%=pageNavi %></label></div>
                    <%}else{ %>
                   		 <div id="writeBtnEmptySpace" ><label>0</label></div>
                    <%} %>
                        <div id="writeBtnFrame">
                            <button id="write" onclick="return writeBtn();">글쓰기</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--회사정보가 들어가는 아랫부분-->
        <!--bottom부분은 관리자페이지 제외한 모든 페이지 통일-->
        <div id="bottom">
			<jsp:include page="/page/footer/footer.jsp"/>
		</div>
    </div>
    <script>
        function searchBtn(){
            var searchText = document.getElementById("searchText").value;
            if(searchText==""){
                alert("검색할 내용을 입력하세요!");
                return false;
            }
        }
        function writeBtn(){
        	<%if(member!=null){%>
    			location.href="/page/communityPage/writingPage.jsp";
	    	<%}else{%>
	    		alert("로그인을 해주세요;");
	    		return false;
	    	<%}%>
        }
        function pwdCheck(pwdnumber) {
			if(pwdnumber==0){
				return true;
			}else{
				return false;
			}
		}
    </script>
</body>
</html>