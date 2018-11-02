<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
<% int result = Integer.parseInt(request.getParameter("result")); 
	if(result==1){
%>	
	alert("게시물이 작성되었습니다!");
	location.href="/page/communityPage/boardPage.jsp";
<%
	}else{
%>
	alert("게시물을 다시 작성해주세요!");
	location.href="/page/communityPage/boardPage.jsp";
<%
	}
%>
</script>
</body>
</html>