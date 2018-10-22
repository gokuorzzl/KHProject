<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.healthme.member.model.service.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디 중복 확인</title>
</head>
<body>

<% String checkId = request.getParameter("checkId"); %>

<!--  아이디 DB통해 건너 왔는지 확인-->
<%--  <%=checkId %> --%>

<% boolean result = new MemberService().checkId(checkId);

%>

  <script>
      var memberId = '<%=checkId%>';
      var checkFlag = 0;
<%  //true :사용자 있음 false: 아이디 사용 가능
   if(result) {
%>	 
   //참일 때 동작 코드(참일 때: 해당ID가 중복일 때)
   window.onload = function() {
	   var msg = document.getElementById('msg');
	   msg.innerHTML = '아이디가 존재합니다. 다른 아이디를 입력해주세요.';
	   msg.style.color='red';
	   memberId=""; //확인 눌렀을 때 빈 화면 
   }
   
<% } else {%>  
   //거짓일 때 동작 코드 (참일 때: 해당ID가 중복이 아닐 때)
   window.onload = function() {
	   msg.innerHTML = '해당 아이디 사용 가능합니다.';
	   msg.style.color='blue';
	   checkFlag = 1;
   }

<% } %>
    //확인 누를 때 값이 그대로 나온다.
   function backBtn() {
    	//나를 연 브라우저
	   opener.document.getElementById('memberId').value = memberId; //값이 그대로 나온다.
	   opener.document.getElementById('checkFlag').value= checkFlag;
       window.close(); //브라우저 종료  (내 자신: 팝업창)
	   
	   
   }

</script>
<center>
<span id="msg"></span><br><br><button onclick="backBtn();">확인</button>
</center>

</body>
</html>