<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Random" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.3.1.js"
 			integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
  			crossorigin="anonymous"></script>
<script type="text/javascript" src="../../js/searchTrainerPage/searchTrainer.js"></script>
<title>Insert title here</title>
</head>
<body>
<%
	Random r = new Random(); 
	int num = r.nextInt(6) + 1;
%>
	<center>
	 	<video class="adVideo" poster="../../img/로고.png" width="800" height="500" autoplay>
	 		<%if(num==1){ %>
				<source src="../../videos/ad1.mp4" type="video/mp4;"/>
			<%} else if(num==2) {%>
				<source src="../../videos/ad2.mp4" type="video/mp4;"/>
			<%} else if(num==3) {%>
				<source src="../../videos/ad3.mp4" type="video/mp4;"/>
			<%} else if(num==4) {%>
				<source src="../../videos/ad4.mp4" type="video/mp4;"/>
			<%} else if(num==5) {%>		
				<source src="../../videos/ad5.mp4" type="video/mp4;"/>
			<%} else if(num==6) {%>
				<source src="../../videos/ad6.mp4" type="video/mp4;"/>
			<%} %>		
		</video>
		<h5>※ 본 광고를 시청하시면 트레이너 정보를 열람할 수 있습니다.</h5>
	</center>
	
</body>
</html>