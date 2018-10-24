<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
</head>
<body>

<div id="naverIdLogin"></div> 

<script type="text/javascript">
	var naverLogin = new naver.LoginWithNaverId(
		{
			clientId: "Mvl6A4PJd71edlyhqsJu",
			callbackUrl: "http://localhost/page/loginPage/naverCallback.jsp",
			isPopup: true, /* 팝업을 통한 연동처리 여부 */
			loginButton: {color: "green", type: 3, height: 60} /* 로그인 버튼의 타입을 지정 */
		}
	);
	
   /* 설정정보를 초기화하고 연동을 준비 */
	naverLogin.init();
</script>
</body>
</html>