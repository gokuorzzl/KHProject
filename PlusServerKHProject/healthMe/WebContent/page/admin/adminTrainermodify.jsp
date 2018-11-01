<%@page import="com.healthme.trainer.model.vo.Trainer"%>
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
    <meta name="subject" content="헬th미 trainerInfoPage" />
    <!--키워드-->
    <meta name="keywords" content="www.healthme.com, 트레이너, 나만의, 맞춤" />
    <!--스타일-->
    <link rel="stylesheet" href="../../css/mypage/trainerInfoPage.css" />
    <link rel="stylesheet" href="../css/trainerInfoPage/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- 스크립트 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../../js/myPage/enroll.js"></script>
    <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
    <script type="text/javascript" src="../../js/myPage/category.js"></script>
    
    <title>헬th미:나만의 트레이너</title>
</head>
<%
		Trainer t = (Trainer)request.getAttribute("adminTrainermodify");
	
	%>


<%--값 수정사항

1. 트레이너 헬스 요가 등등에 대한 것에서 헬스를 누르고 요가를 누를경우값이 중복되서 나타남(활동지역문제)

2. 핸드폰번호를 member테이블을 참조해서 하는건지?

3. 신분/학력 인증을 할경우 대학인증에어떤걸로 들어가는지
trainerUniv가 값이 합쳐져서 들어가는건지

4. 그냥 메인 로그인페이지꺼 다 떼어와서 값만 써놓는 것도 괜찮을 것같다.



 --%>




<body>


   <!--전체 공간-->
    <div id="wrapper">
        <!--로고, 메뉴가 들어가는 윗부분-->
        <!--top부분은 관리자페이지 제외한 모든 페이지 통일-->
        <div id="top">
            <div id="mobileMenu">
                핸드폰일 경우 메뉴
            </div>
            <div id="logo">
                <img src="../../img/%EB%A1%9C%EA%B3%A0.png">
            </div>
            <div id="searchBar">
                <input type="text" name="searchInput" id="searchInput" value="지역, 종목 검색" />
            </div>
            <div id="menu">
                로그인, 메뉴
            </div>
        </div>

        <!-- CONTAINER -->
<!--  enctype="multipart/form-data" 파일 입출력용임 -->
        <div id="middle">
            <h3>- 정보수정(<%=t.getMemberId()%>) -</h3>
            <div class="linecolor"></div>
            <form method="post" id="frm-register-detail" action="/adminTrainerTUpdateSel.do">
                <div id="contents">
                    <div id="realcontents">
                        <ul>
                            <li>
                                <label>프로필사진</label><br>
                                <div id="picture_cover">
                                    <div>
                                        <input type="file" id="profileFile" name="profileFile" value="<%=t.getProfileFile()%>"/>
                                        <img src="/img/trainerImage/<%=t.getMemberId()%>/<%=t.getMemberId()%>profileFile.png" width="150" height="150">
                                    </div>
                                    <span>

                                    </span>
                                </div>
                                <div id="ex_image">
                                    <ul>
                                        <img src="../../img/gd.jpg">스타일리쉬한 모습
                                        <img src="../../img/yuna.jpg">밝고 쾌활히 웃는
                                        <img src="../../img/jubin.jpg">무언가에 열중
                                    </ul>
                                </div>
                            </li>
                        </ul>
                        
                       
                        
                      
                        
                        <div class="linecolor"></div>
                        
                        <ul id="total_sport_tag">
                            <li>
                                <label for="memberAddr">활동 지역</label><br>
                                <input type="text" id="sample6_postcode" placeholder="우편번호">
                                <input type="button" id="sample6_fpostcode" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
                                <input type="text" id="trainerRegion" name="trainerRegion" value="<%=t.getTrainerRegion()%>">
                                <input type="text" id="sample6_address2" placeholder="상세주소">
                            </li><br>
                            <li style=i>
                            <label for="trainerEvent">트레이너종목</label><br>
                              <input type="text" id="trainerEvent" name="trainerEvent" value="<%=t.getTrainerEvent()%>">
                            </li>
                            
                            <li style=i>
                            <label for="trainerCareerFile">경력 인증 파일</label><br>
                              <input type="text" id="trainerCareerFile" name="trainerCareerFile" value="<%=t.getTrainerCareerFile()%>">
                            </li>
                            
                            
                            
                         
                        </ul>
                        
                        <div class="linecolor"></div>
                        
                        <ul>
                            <li>
                                <label>신분/학력 인증</label><br>
                                <div id="SchoolMajor">
                                <input type="text" name="trainerUniv" value="<%=t.getTrainerUniv()%>"/>
                               </li>
                               <li>
                                <label>대학교 재학/졸업/수료 상태</label>
                               <%if(t.getTrainerGrad().equals('a')){%>
                               <p><input name="trainerGrad" type="radio" value="<%=t.getTrainerGrad()%>" checked /><label for="univ_y">재학</label></p>
                               
                               <%}else if(t.getTrainerGrad().equals('b')){%>
                                    <p><input name="trainerGrad" type="radio" value="<%=t.getTrainerGrad()%>"  checked/><label for="univ_y">졸업</label></p>
                                    
                               <%}else{%>
                               		<p><input name="trainerGrad" type="radio" value="<%=t.getTrainerGrad()%>" checked/><label for="univ_y">수료</label></p>
                               <%}%>
                                   <%--null들어가면 에러나므로 데이터 넣을때 a,b,c중 값으로 넣기 --%>
                                   
                                   </li>
                                    <br>
                                    <p><b>학력 인증(<font color="red">필수</font>)</b> - 학생증, 재학증명서, 졸업증명서</p>
                                    <p><input type="file" name="trainerGradFile" value="<%=t.getTrainerGradFile()%>"/></p>
                                   <%--경로 이미지경로 재설정하기폴더만들어질 경우--%>
                                    <img src="/img/trainerImage/<%=t.getMemberId()%>/<%=t.getMemberId()%>profileFile.png" width="150" height="150">
                                </div>

                               
                            </li>
                        </ul>

                        <div class="linecolor"></div>
                        
                        <ul>
                            <li>
                                <label>자격증(최대 5개) (선택)</label>
								
                                <!--input 추가됨-->
                                <div id="cert">
                                <%--이미지경로추가시키기 --%>
                                    <input type="file" id="LicenseName1" name="LicenseName1" value="<%=t.getLicenseName1()%>"/><br>
                                    <img src="#" width="150" height="150">
                                    <input type="file" id="LicenseName2" name="LicenseName2" value="<%=t.getLicenseName2()%>"/><br>
                                     <img src="#" width="150" height="150">
                                    <input type="file" id="LicenseName3" name="LicenseName3" value="<%=t.getLicenseName3()%>"/><br>
                                    <img src="#" width="150" height="150">
                                    <input type="file" id="LicenseName4" name="LicenseName4" value="<%=t.getLicenseName4()%>"/><br>
                                    <img src="#" width="150" height="150">
                                    <input type="file" id="LicenseName5" name="LicenseName5" value="<%=t.getLicenseName5()%>"/><br>
                                    <img src="#" width="150" height="150">
                                   
                                </div>
                                
                               

                              
                            </li>
                        </ul>
                        <!--자격증 부분 끝-->
                        <div class="linecolor"></div>
                        
                        <ul>
                            <li>
 								<div class="career-group">
									<label>경력사항</label>

									
								
										<div>
											<input id="careerName1" name="careerName1" type="text" placeholder="<%=t.getCareerName1()%>" value="<%=t.getCareerName1()%>"/>
											<input type="date" id="careerStart1" name="careerStart1" value="<%=t.getCareerStart1()%>" min="1990-01-01" max="2018-12-31"/> ~ 
											<input type="date" id="careerEnd1" name="careerEnd1" value="<%=t.getCareerEnd1()%>" min="1990-01-01" max="2018-12-31"/>
											<br><br>
											<input id="careerName1" name="careerName2" type="text" placeholder="<%=t.getCareerName2()%>" value="<%=t.getCareerName2()%>"/>
											<input type="date" id="careerStart2" name="careerStart2" value="<%=t.getCareerStart2()%>" min="1990-01-01" max="2018-12-31"/> ~ 
											<input type="date" id="careerEnd2" name="careerEnd2" value="<%=t.getCareerEnd2()%>" min="1990-01-01" max="2018-12-31"/>
											<br><br>
											<input id="careerName1" name="careerName3" type="text" placeholder="<%=t.getCareerName3()%>" value="<%=t.getCareerName3()%>"/>
											<input type="date" id="careerStart3" name="careerStart3" value="<%=t.getCareerStart3()%>" min="1990-01-01" max="2018-12-31"/> ~ 
											<input type="date" id="careerEnd3" name="careerEnd3" value="<%=t.getCareerEnd3()%>" min="1990-01-01" max="2018-12-31"/>
											<br><br>
											<input id="careerName1" name="careerName4" type="text" placeholder="<%=t.getCareerName4()%>" value="<%=t.getCareerName4()%>"/>
											<input type="date" id="careerStart4" name="careerStart4" value="<%=t.getCareerStart4()%>" min="1990-01-01" max="2018-12-31"/> ~ 
											<input type="date" id="careerEnd4" name="careerEnd4" value="<%=t.getCareerEnd4()%>" min="1990-01-01" max="2018-12-31"/>
											<br><br>
											<input id="careerName1" name="careerName5" type="text" placeholder="<%=t.getCareerName4()%>" value="<%=t.getCareerName4()%>"/>
											<input type="date" id="careerStart5" name="careerStart5" value="<%=t.getCareerStart4()%>" min="1990-01-01" max="2018-12-31"/> ~ 
											<input type="date" id="careerEnd5" name="careerEnd5" value="<%=t.getCareerEnd4()%>" min="1990-01-01" max="2018-12-31"/>
											<br><br>
										</div>
										
								
									
								


								</div>
 


                            </li>
                          
                          <li>
                          	 <label for="comment">수업 제목</label>
                                    <textarea class="form-control" rows="1" name="trainerSubject" id="trainerSubject" value="<%=t.getTrainerSubject()%>" placeholder="<%=t.getTrainerSubject()%>"></textarea>
                          </li>
                          
                          
                            <li>

                                <div class="form-group">
                                	
                                
                                
                                
                                    <label for="comment">수업 소개 :</label>
                                    <textarea class="form-control" rows="5" name="trainerContent" id="trainerContent" value="<%=t.getTrainerContent()%>" placeholder="<%=t.getTrainerContent()%>"></textarea>
                                   
                                </div>
                            </li>
                        </ul>
                        <center>
                        <button type="submit" value="회원수정" id=""  class="btn btn-warning">수정하기 </button>
                        </center>
                    </div>
                </div>
            </form>

        </div>


    </div>
</body>

</html>