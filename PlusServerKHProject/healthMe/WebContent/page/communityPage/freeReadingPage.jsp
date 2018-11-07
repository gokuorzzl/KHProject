<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  page import = "com.healthme.community.model.vo.*"
		import = "com.healthme.member.vo.*"
		import = "java.util.ArrayList"%> 
<%
	session = request.getSession(false);
	Member member = null;
	member = (Member)session.getAttribute("member");
	
	CommentData cd = (CommentData)request.getAttribute("selectBoard");
	ArrayList<Comment> list = null;
	String pageNavi = null;
	Board b = null;
	
	if(cd!=null){
		list = cd.getList();//현재 페이지의 글 목록
		pageNavi = cd.getPageNavi();//현재 navi Bar
		b = cd.getB();
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
      		<jsp:include page="/page/header/header.jsp"/>  	
        </div>
        
        <!--컨텐츠가 들어가는 중간부분-->
        <!--페이지별로 달라지는 부분-->
        <div id="middle">
            <!--지역, 종목 등 선택할 수 있는 선택박스-->
            <!--트레이너 별점 등 컨텐츠 나오는 부분-->
            <div id="contents">
                <div id="realContents">
                    <div id="titleFrame">
                        <span id="title"><%=b.getTitle() %></span>
                    </div>
                    <div id="otherInformationFrame">
                        <div id="writerView">
                            <p id="writerBundle">
                                작성자 : <span id="writer"><%=b.getUserId() %></span>
                            </p>
                        </div>
                        <div id="dateCreatedView"> 
                            작성일 : <span id="dateCreated"><%=b.getInsertDate() %></span>
                        </div>
                    </div>
                    <div id="mainContentsFrame">
                        <span id="mainContents"><%=b.getContent() %></span>
                    </div>
                    <div id="buttonsFrame">
                    <%if(member!=null){ %>
                    <%if(b.getUserId().equals(member.getMemberId())){ %>
                     	<button id="editButton" onclick="edit();">수정</button>
                        <button id="deleteButton" onclick="boardDelete();">삭제</button>
                        <button id="listButton" onclick="back();">목록</button>
                    <%}else{ %>
                    	<button id="listButton" onclick="back();">목록</button>
                    <%} %>
                  <% }else{%>
                   <button id="listButton" onclick="back();">목록</button>
                  <%} %>
                    </div>
                    <div id="writeCommentFrame">
                    <form action="/freeInsertComment.do" method="get">
                        <div id="writeCommentTextView">
                            <textarea id="writeCommentText" name="writeCommentText" style="resize:none;"></textarea>
                        	<input type="hidden" name="freeNum" value="<%=b.getNum() %>">
                        </div>
                        <div id="writeCommentBtnView">
                            <button id="writeCommentBtn" type="submit" onclick="return commentBtn();">댓글</button>
                        </div>
                    </form> 
                    </div>
                    <div id="commentFrame">
                    <%if(list!=null){ %>
	                    <%for(Comment c : list){ %>
	                        <div id="commentWriterView">
	                            <span id="commentWriter"><%=c.getMemberID() %></span>
	                        </div>
	                        <div id="bundleComment">
	                            <div id="commentContentsView">
	                                <form action="/freeCommentEdit.do" method="get" id="formAction<%=c.getCommentNumber()%>" >
	                                <span id="commentContents<%=c.getCommentNumber()%>"><%=c.getCommentContent() %></span>
	                                 <textarea id="CommentTextarea<%=c.getCommentNumber()%>" name="writeCommentText" style="resize:none; display:none;"><%=c.getCommentContent() %></textarea>
	                                	<input type="hidden" name="cNum" value="<%=c.getCommentNumber()%>"> 
	                                	<input type="hidden" name="bNum" value="<%=b.getNum()%>"> 
				                    </form>
	                            </div>
	                            <div id="commentDateCreatedView">
	                                <span id="commentDateCreated"><%=c.getCommentInsertDate() %></span>
	                                <%if(c.getMemberID().equals(member.getMemberId())){ %>
	                                <button id="commentEditTextButton<%=c.getCommentNumber()%>" type="submit" onclick="commentEditText(<%=c.getCommentNumber()%>);" style="display:inline;">수정1</button>
	                                <button id="commentEditButton<%=c.getCommentNumber()%>" type="submit" onclick="commentEdit(<%=c.getCommentNumber()%>);" style="display:none;">수정2</button>
				                    <form action="/freeCommentDelete.do" method="get" id="formAction" style="display:inline">
	                                	<input type="hidden" name="cNum" value="<%=c.getCommentNumber()%>"> 
	                                	<input type="hidden" name="bNum" value="<%=b.getNum()%>"> 
				                     	<button id="deleteButton" type="submit" onclick="commentDelete();">삭제</button>
				                    </form>
				                    <%}%>
	                            </div>
	                        </div>
	                    <%} %>
                    <%}else{ %>
                    	댓글이 없습니다.
                    <%} %>
                    <%if(pageNavi!=null){ %>
                    <label><%=pageNavi %></label>
                    <%}else{ %>
                     <label>0</label>
                    <%} %>
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
        function commentBtn(){
            //수정이 필요함 댓글을 적어도 alert가 나옴..
            var commentText = document.getElementById("writeCommentText").value;
            if(commentText==""){
                alert("댓글내용을 작성해주세요!!");
                return false;
            }
            <%if(member!=null){%>
            	return true;
	    	<%}else{%>
	    		alert("로그인을 해주세요;");
	    		return false;
	    	<%}%>
        }
        function back() {
        	location.href="/qnaPage.do";
		}
        function boardDelete() {
        	<% if(member !=null){%>
				location.href="/freeBoardDelete.do?bNum=<%=b.getNum()%>&userId=<%=member.getMemberId()%>";
			<%}%>
        }
        function edit() {
        	location.href="/qnaOneSelect.do?boardNum=<%=b.getNum()%>";	
		}
        function commentEditText(commentNum) {
        	console.log(commentNum);
        	console.log("commentContents"+commentNum);
        	document.getElementById("commentContents"+commentNum).style.display = "none";
        	document.getElementById("CommentTextarea"+commentNum).style.display = "inline";
        	document.getElementById("commentEditTextButton"+commentNum).style.display = "none";
        	document.getElementById("commentEditButton"+commentNum).style.display = "inline";
		}
        function commentEdit(commentNum) {
        	document.getElementById("formAction"+commentNum).submit();
		}
    </script>
</body>
</html>