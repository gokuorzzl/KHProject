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
        						제목
        					</div>
        					<div class="resumeTextMiddle textMiddle">
        						별점
        					</div>       					
        					<div class="resumeTextButtom textMiddle">
        						<div>
        						<hr>
        							<table border=1>
        								<tr>
        								<td>지역</td><td>횟수</td><td>인원</td><td>금액</td>
        								</tr>
        								<tr>
        								<td>지역</td><td>횟수</td><td>인원</td><td>금액</td>
        								</tr>
        							</table>
        						<hr>
        						</div>
        					</div>
        				</div>
        			</div>
        			
        		</div>
        		<br><br>
        		<!--간단 이력 밑 부분-->
				<div class="contents_3 border">
					<div class="content3Box">
					<div class="myInfo_1 textMiddle">
					트레이너 정보
					</div><br>
					<div class="myInfoInner textMiddle" >dddd</div>
					<hr>
					<div class="myInfo_2 textMiddle">
					자격사항
					</div><br>
					<div class="myInfoInner textMiddle" >dddd</div>
					<hr>
					<div class="myInfo_3 textMiddle">
					경력사항
					</div><br>
					<div class="myInfoInner textMiddle" >dddd</div>
					<hr>
					<div class="myInfo_4 textMiddle">
					수업 소개
					</div><br>
					<div class="myInfoInner textMiddle" >dddd</div>
					<hr>
					<div class="myInfo_5 textMiddle">
					위치정보
					</div><br>
					<div class="myInfoInner textMiddle" >dddd</div>
					<br>
					</div>
				</div>
			</div>

			<div class="contents_2 border">
				<div class="infoBox">
					<br>
					<div class="infoBox_1"></div>
					위치&nbsp;&nbsp;&nbsp;
					<hr>
					<div class="infoBox_2"></div>
					요일&nbsp;&nbsp;&nbsp;
					<hr>
					<div class="infoBox_3"></div>
					장소&nbsp;&nbsp;&nbsp;
					<hr>
					<div class="infoBox_4"></div>
					<div class="infoBox_5"></div>
					<br>
					<form action = "" method="post">
					<div class="infoBox_6">
						<div class="submitB"> 
						<input type="submit" class="submitBtn" value=" 수업 신청하기 ▶ ">
					</div></div>
					</form>
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
							<input type="submit" class="submitBtn submitB" value="찜하기">
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