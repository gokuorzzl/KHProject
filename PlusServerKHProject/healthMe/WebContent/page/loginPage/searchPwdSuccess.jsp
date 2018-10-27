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

<% String memberPw = (String)request.getAttribute("memberPw"); %>

<script>

alert("회원님의 비밀번호는 "+'<%=memberPw %>'+" 입니다.");
location.href="/page/loginPage/login.jsp";
</script>


</body>
</html>