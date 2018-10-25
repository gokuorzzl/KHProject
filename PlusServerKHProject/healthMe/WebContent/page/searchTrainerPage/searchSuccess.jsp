<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ 
	page import="com.healthme.search.model.vo.*" 
		import = "java.util.ArrayList"
%>
<%
	//컨트롤러에서 온 값
	SearchResultPage resultPage = (SearchResultPage)request.getAttribute("resultPage");
	//검색결과인 트레이너 객체
	ArrayList<SearchedTrainerResult> resultList = resultPage.getResultList();
	//페이지 처리 
	String pageNavi = resultPage.getPageNavi();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% for(SearchedTrainerResult n : resultList){ %>
		아이디 : <%=n.getMemberId() %>
		이름 : <%=n.getMemberName() %>
		프로필 경로 : <%=n.getProfileFile() %>
		종목 : <%=n.getTrainerEvent() %>
		별점 : <%=n.getTrainerScore() %>
	<% } %>
	
	<div style="width:315px; text-align:center;">
		<label><%=pageNavi %></label>
	</div>

</body>
</html>