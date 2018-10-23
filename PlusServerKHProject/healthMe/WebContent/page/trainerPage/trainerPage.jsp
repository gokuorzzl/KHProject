<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    
    <!--인코딩 문자셋-->
    <meta charset="UTF-8">
    <!--반응형 웹을 만들기 위한 meta태그의 viewport-->
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <!--페이지 설명-->
    <meta name="subject" content="헬th미 메인페이지" />
    <!--키워드-->
    <meta name="keywords" content="www.healthme.com, 트레이너, 나만의, 맞춤" />
    <!--스타일--> 
    <link rel="stylesheet" href="../../css/trainerPage/trainerPage.css" />
    <!--title-->           
    <title>트레이너 정보</title>

</head>
<body>

    <!--전체 공간-->    
    <div id="wrapper">
        <jsp:include page="/page/header/header.jsp"/>
        <div id="middle">

        </div>
                
        <!--회사정보가 들어가는 아랫부분-->
        <!--bottom부분은 관리자페이지 제외한 모든 페이지 통일-->
    <div id="bottom">
      	<jsp:include page="/page/footer/footer.jsp"/>        
    </div>

    </div>

   
<script>
var div = a // 이미지를 감싸는 div
var img = v // 이미지
var divAspect = 90 / 120; // div의 가로세로비는 알고 있는 값이다
var imgAspect = img.height / img.width;
 
if (imgAspect <= divAspect) {
    // 이미지가 div보다 납작한 경우 세로를 div에 맞추고 가로는 잘라낸다
    var imgWidthActual = div.offsetHeight / imgAspect;
    var imgWidthToBe = div.offsetHeight / divAspect;
    var marginLeft = -Math.round((imgWidthActual - imgWidthToBe) / 2);
    img.style.cssText = 'width: auto; height: 100%; margin-left: '
                      + marginLeft + 'px;'
} else {
    // 이미지가 div보다 길쭉한 경우 가로를 div에 맞추고 세로를 잘라낸다
    img.style.cssText = 'width: 100%; height: auto; margin-left: 0;';
}
</script>    

</body>
</html>