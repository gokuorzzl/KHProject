<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.healthme.member.vo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<%
     Member m = (Member)request.getAttribute("member");
%>

<body>
<script>
  alert("회원님 탈퇴하셨습니다.");
  location.href="/index.jsp";
</script>

</body>
</html>