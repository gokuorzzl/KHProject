<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="com.healthme.trainer.model.vo.*" 
		import = "com.healthme.member.vo.*"		
%>
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
<%
	SearchData sd = (SearchData)request.getAttribute("searchData");
	Member m = sd.getM();
	Trainer t = sd.getT();
	int starScore = sd.getStarScore(); 
%>

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
        					<img src="../..<%=t.getProfileFile()%>" class="imgSize">
        				</div>
        				<div class="imgUnderText textMiddle">
        					<div class="textSize"><%=m.getMemberName()%></div>
        				</div>
        			</div>
        			<div class="resumeDivR border">
        				<div class="resumeTextBox">
        					<div class="resumeTextTop textMiddle">
        						<div class="textSize"><%=t.getTrainerSubject()%></div>
        					</div>
        					<div class="resumeTextMiddle textMiddle">
        						별점
        					</div>       					
        					<div class="resumeTextButtom textMiddle">
        					<div class="starBoxFull textMiddle">
								<%
								if(starScore==0){%>
									<div class="starBox">
								<%		for(int i =0; i<5; i++) {%>
										<img src="../../img/star/starNull.PNG" style="width:60px; height:60px"/>
							<%			} %>
									</div>
	<%							}else if(starScore==1){%>
								<div class="starBox">
								<img src= "../../img/star/starFull.PNG" style="width:60px; height:60px"/>
								<%	for(int i =0; i<4; i++) {%>
									<img src="../../img/star/starNull.PNG" style="width:60px; height:60px"/>
								<%	} %>
								</div>	
	<%							}else if(starScore==2){%>
								<div class="starBox">
								<%	for(int i =0; i<2; i++) {%>
									<img src="../../img/star/starFull.PNG" style="width:60px; height:60px"/>
								<%	} %>
								<%	for(int i =0; i<3; i++) {%>
									<img src="../../img/star/starNull.PNG" style="width:60px; height:60px"/>
								<%	} %>
								</div>	
	<%							}else if(starScore==3){%>
								<div class="starBox">
								<%	for(int i =0; i<3; i++) {%>
									<img src="../../img/star/starFull.PNG" style="width:60px; height:60px"/>
								<%	} %>
								<%	for(int i =0; i<2; i++) {%>
									<img src="../../img/star/starNull.PNG" style="width:60px; height:60px"/>
								<%	} %>
								</div>		
	<%							}else if(starScore==4){%>
								<div class="starBox">
								<%	for(int i =0; i<4; i++) {%>
									<img src="../../img/star/starFull.PNG" style="width:60px; height:60px"/>
								<%	} %>
								<%	for(int i =0; i<1; i++) {%>
									<img src="../../img/star/starNull.PNG" style="width:60px; height:60px"/>
								<%	} %>
								</div>	
	<%							}else if(starScore==5){%>
								<div class="starBox">
								<%	for(int i =0; i<5; i++) {%>
									<img src="../../img/star/starFull.PNG" style="width:60px; height:60px"/>
								<%	} %>
								</div>		
	<%							}
								%>
								</div>
        					</div>
        				</div>
        			</div>
        			
        		</div>
        		<br><br>
        		<!--간단 이력 밑 부분-->
				<div class="contents_3 border">
					<div class="content3Box">
					<div class="myInfo_1 textMiddle"><br>
					트레이너 정보
					</div><br>
					<div class="myInfoInner textMiddle" >
						트레이너 이름&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : <%=m.getMemberName()%><br><br>
						트레이너 이메일&nbsp;&nbsp; : <%=m.getMemberEmail()%><br><br>
						트레이너 번호&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : <%=m.getMemberPhone()%><br><br>						
					</div>
					<hr>
					<div class="myInfo_2 textMiddle">
					자격 사항
					</div><br>
					<div class="myInfoInner textMiddle" >
					<%
						if(t.getLicenseName1()!=null){ %>
							자격증 : <%=t.getLicenseName1()%>	
							<br>						
<%						}%>
					<%
						if(t.getLicenseName2()!=null){ %>
							자격증 : <%=t.getLicenseName2()%>		
							<br>					
<%						}%>
					<%
						if(t.getLicenseName3()!=null){ %>
							자격증 : <%=t.getLicenseName3()%>	
							<br>						
<%						}%>
					<%
						if(t.getLicenseName4()!=null){ %>
							자격증 : <%=t.getLicenseName4()%>			
							<br>				
<%						}%>
					<%
						if(t.getLicenseName5()!=null){ %>
							자격증 : <%=t.getLicenseName5()%>			
							<br>	
<%						}%>
					</div>
					<hr>
					<div class="myInfo_3 textMiddle">
					경력사항
					</div><br>
					<div class="myInfoInner textMiddle" >
<%						if(t.getCareerName1()!=null){ %>
							경력 : <%=t.getCareerName1()%>							
							기간 : <%=t.getCareerStart1()%> ~ <%=t.getCareerEnd1()%>
							<br>	
<%						}%>		
					<%
						if(t.getCareerName2()!=null){ %>
							경력 : <%=t.getCareerName2()%>							
							기간 : <%=t.getCareerStart2()%> ~ <%=t.getCareerEnd2()%>
							<br>
<%						}%>		
					<%
						if(t.getCareerName3()!=null){ %>
							경력 : <%=t.getCareerName3()%>							
							기간 : <%=t.getCareerStart3()%> ~ <%=t.getCareerEnd3()%>
								<br>
<%						}%>	
					<%
						if(t.getCareerName4()!=null){ %>
							경력 : <%=t.getCareerName4()%>							
							기간 : <%=t.getCareerStart4()%> ~ <%=t.getCareerEnd4()%>
							<br>	
<%						}%>		
					<%
						if(t.getCareerName5()!=null){ %>
							경력 : <%=t.getCareerName5()%>							
							기간 : <%=t.getCareerStart5()%> ~ <%=t.getCareerEnd5()%>
							<br>	
<%						}%>			
					</div>
					<hr>
					<div class="myInfo_4 textMiddle">
					수업 소개
					</div><br>
					<div class="myInfoInner textMiddle">
						수업명 : <%=t.getTrainerSubject()%><br><br><br>
					</div>	
					<div class="myInfoInner textMiddle">
						<%=t.getTrainerContent()%><br>
					</div>
					<hr>
					<div class="myInfo_5 textMiddle">
					위치정보
					</div><br>
					
				
					
					
					
					<div class="myInfoInner textMiddle" >
					
						<div id="map" style="width:500px;height:400px;">
						
							<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=eef1064eeb14762d1843dc67b3733660&libraries=services"></script>
							
							<!--  eef1064eeb14762d1843dc67b3733660   -->
							
							<!--지도를 띄우는 코드 작성-->
							<script>
							var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
							    mapOption = {
							        center: new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
							        level: 3 // 지도의 확대 레벨
							    };  
		
							// 지도를 생성합니다    
							var map = new daum.maps.Map(mapContainer, mapOption); 

							// 주소-좌표 변환 객체를 생성합니다
							var geocoder = new daum.maps.services.Geocoder();

							// 주소로 좌표를 검색합니다
							geocoder.addressSearch("<%=t.getTraienrRegion()%>", function(result, status) {

							    // 정상적으로 검색이 완료됐으면 
							     if (status === daum.maps.services.Status.OK) {

							        var coords = new daum.maps.LatLng(result[0].y, result[0].x);

							        // 결과값으로 받은 위치를 마커로 표시합니다
							        var marker = new daum.maps.Marker({
							            map: map,
							            position: coords
							        });

							        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
							        map.setCenter(coords);
							    } 
							});    
	
							</script>
						</div>
					
					</div>
					<br>
					</div>
				</div>
			</div>

			<div class="contents_2 border">
				<div class="infoBox">
					<br>
					<div class="infoBox_1"></div>
					<div class="infoBoxFont">
					위치&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=t.getTraienrRegion()%>
					</div>
					<br>
					<hr>
					<div class="infoBox_2"></div>
					<div class="infoBoxFont">
					이메일&nbsp;&nbsp;&nbsp;<%=m.getMemberEmail()%>
					</div>
					<br>
					<hr>
					<div class="infoBox_3"></div>
					<div class="infoBoxFont">
					연락처&nbsp;&nbsp;&nbsp;<%=m.getMemberPhone()%>
					</div>
					<br>
					<hr>
					<div class="infoBox_4"></div>
					<div class="infoBox_5 "></div>
					<br>
					<form action = "/register.do" method="post">
					<div class="infoBox_6">
						<div class="submitB"> 
						<input type="submit" class="submitBtn" value=" 수업 신청하기 ▶ ">
						<input type="hidden" value="<%=t.getMemberId()%>" name="trainerId"/>
						<input type="hidden" value="<%=t.getTrainerSubject()%>" name="trainerSubject"/>
					</div>
					</div>
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