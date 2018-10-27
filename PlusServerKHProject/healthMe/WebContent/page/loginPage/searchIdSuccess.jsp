<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.healthme.member.vo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<% String memberId = (String)request.getAttribute("memberId"); %>

<script>

alert("회원님의 아이디는 "+'<%=memberId %>'+" 입니다.");
location.href="/page/loginPage/login.jsp";
</script>


</body>
</html>