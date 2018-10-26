<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>헬th미: 아이디 찾기</title>
</head>
<body>


<form name="findId" method = "post" action = "/searchId.do">

이름 : <input type="text" name="findName" id="findName"> <br>
주민등록번호 : <input type="text" name="findSocial" id="findSocial"> <br>
핸드폰 번호 : <input type="text" name="findPhone" id="findPhone"> <br>

<button type="submit" value="찾기" onclick="return id_search();">찾기</button> 
<button type="reset" value="취소" onclick="cancel();">취소</button> 
</form>

</body>
</html>