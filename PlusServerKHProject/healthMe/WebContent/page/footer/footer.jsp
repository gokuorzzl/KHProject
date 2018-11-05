<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "com.healthme.community.model.vo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="../../css/footer/footer.css">
</head>
<body>
<%
	Board b = new Board();
	
%>
<script>
	$(document).ready(function(){
		$.ajax({
			type:"get",
			url:"/footer.do",
			error: function(){
				colsole.log("ajax통신 에러");
			},
			success: function(result){
				var data= result;
				$("#boardData").text(data);
			}
		});
	});
</script>
<footer>
<hr>
	<div class="totalSize"><br>
		<div class="imgLine">
			<div><img src="../../img/%EB%A1%9C%EA%B3%A0.png" class="imgStyle" width="30%" height="18%"><br>
				<div><a href="../../page/communityPage/boardPage.jsp" class="tagStyle">공지사항 > </a> <p id="boardData"></p></div>
			</div> 
		</div>
<hr>
		<div>
		<a href=""> 회사소개 </a> | <a href=""> 이용약관 </a> | <a href=""> 개인정보처리방침 </a> | <a href=""> 고객센터 </a> | <a href=""> 인재 채용 </a> | <a href=""> 서비스약관 </a> | <a href=""> 광고안내 </a> | <a href=""> 고객센터 </a>
		</div>
	</div>
<br>
</footer>
</body>
</html>