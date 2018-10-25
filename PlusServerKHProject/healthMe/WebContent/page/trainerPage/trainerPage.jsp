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
    <link rel="stylesheet" href="../../css/trainerPage/trainerPage.css?after" />
    <!--title-->           
    <title>트레이너 정보</title>

</head>


<body>

    <!--전체 공간-->    
    <div id="wrapper">
    	<div id="top">
        <jsp:include page="/page/header/header.jsp"/>
        </div>
        <br>
        <div id="middle" class="border">
        	<div class="contents">
        		<div class="resume">
        			<div class="resumeDivL border">      			
        				<div class="imgBoxSize">
        					<img src="../../img/dayeon.png" class="imgSize">
        				</div>
        				<div class="imgUnderText textMiddle">
        					<h1>트레이너 이름</h1>
        				</div>
        			</div>
        			<div class="resumeDivR border">
        				<div class="resumeTextBox">
        					<div class="resumeTextTop textMiddle">
        						위
        					</div>
        					<div class="resumeTextMiddle textMiddle">
        						중간
        					</div>
        					<div class="resumeTextButtom textMiddle">
        						아래
        					</div>
        				</div>
        			</div>
        			
        		</div>
			</div>
			<div class="contents_2 border">
				<div class="infoBox">
					<br>
					<div class="infoBox_1"></div>
					<hr>
					<div class="infoBox_2"></div>
					<hr>
					<div class="infoBox_3"></div>
					<hr>
					<div class="infoBox_4"></div>
					<hr>
					<div class="infoBox_5"></div>
					<br>
					<div class="infoBox_6"></div>
					<br>
					<div class="infoBox_7"></div>
				</div>
				<br>
				<div class="infoButtom">
					<div class="infoButtomIconBox">
						<div class="iconLeft">
							<img src="../../img/heart.png" class="iconImg">
						</div>
						<div class="iconRight textMiddle">
							찜하기
						</div>
					</div>
				</div>
			</div>
        </div>
                
        <!--회사정보가 들어가는 아랫부분-->
        <!--bottom부분은 관리자페이지 제외한 모든 페이지 통일-->
    <div id="bottom">
      	<jsp:include page="/page/footer/footer.jsp"/>        
    </div>

    </div>

    

</body>
</html>