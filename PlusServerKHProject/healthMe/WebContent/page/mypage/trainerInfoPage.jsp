<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ 
	page import="com.healthme.search.model.vo.*"
		 import="com.oreill.servlet.*" 
%>
<%@ page import="com.healthme.member.vo.*" 
%>


<%
	session = request.getSession(false);
	Member member = null;
	member = (Member)session.getAttribute("member");
	if(member==null){
%>
	<script>
	alert("로그인하세요");
		location.href="/index.jsp";
	</script>
<%} %>

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
    	<!-- link rel="stylesheet" href="../../css/trainerInfoPage/bootstrap.min.css"-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- 스크립트 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="../../js/myPage/category.js"></script>
    <script type="text/javascript" src="../../js/myPage/addFile.js"></script>
    <script type="text/javascript" src="../../js/myPage/enroll.js"></script>
    <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

    
    <title>헬th미:나만의 트레이너</title>
</head>

<body>


    <!--전체 공간-->
    <div id="wrapper">
        <!--로고, 메뉴가 들어가는 윗부분-->
        <!--top부분은 관리자페이지 제외한 모든 페이지 통일-->
        <div id="top">
            <div id="mobileMenu">
                
            </div>
            <div id="logo">
                <img src="../../img/%EB%A1%9C%EA%B3%A0.png">
            </div>
            <br>
            <center><div id="searchBar">
                                       헬th미 트레이너 이력서
            </div></center>
            <div id="menu">
                
            </div>
        </div>

        <!-- CONTAINER -->
<!--  enctype="multipart/form-data" 파일 입출력용임 -->
        <div id="middle">

            <div class="linecolor"></div>
            <form method="post" id="frm-register-detail" action="/trainerInfo.do" enctype="multipart/form-data">
                <div id="contents">
                    <div id="realcontents">
                        <ul>
                            <li class=li>
                            
                               <!-- null값 주는 과정 -->
                            <input type="hidden" name="trainerUniv" value=""/>
                            <input type="hidden" name="trainerGrad" value="a"/>
                            <input type="hidden" name="trainerRegion" value=""/>
                            <input type="hidden" name="trainerSubject" value=""/>
                            <input type="hidden" name="trainerContent" value=""/>
                            <input type="hidden" name="profileFile" value=""/>
                            <input type="hidden" name="trainerGradFile" value=""/>
                            <input type="hidden" name="trainerCareerFile" value=""/>
                            <input type="hidden" name="trainerLicenseFile" value=""/>
                                                        
                            <input type="hidden" name="licenseName1" value=""/>
                            <input type="hidden" name="licenseName2" value=""/>
                            <input type="hidden" name="licenseName3" value=""/>
                            <input type="hidden" name="licenseName4" value=""/>
                            <input type="hidden" name="licenseName5" value=""/>
                            
                            <input type="hidden" name="careerName1" value=""/>
                            <input type="hidden" name="careerName2" value=""/>
                            <input type="hidden" name="careerName3" value=""/>
                            <input type="hidden" name="careerName4" value=""/>
                            <input type="hidden" name="careerName5" value=""/>
                            
                            <input type="hidden" name="careerStart1" value="2018-01-01"/>
                            <input type="hidden" name="careerStart2" value="2018-01-01"/>
                            <input type="hidden" name="careerStart3" value="2018-01-01"/>
                            <input type="hidden" name="careerStart4" value="2018-01-01"/>
                            <input type="hidden" name="careerStart5" value="2018-01-01"/>
                            
                            <input type="hidden" name="careerEnd1" value="2018-01-01"/>
                            <input type="hidden" name="careerEnd2" value="2018-01-01"/>
                            <input type="hidden" name="careerEnd3" value="2018-01-01"/>
                            <input type="hidden" name="careerEnd4" value="2018-01-01"/>
                            <input type="hidden" name="careerEnd5" value="2018-01-01"/>
                             
                            <input type="hidden" name="trainerEvent" value=""/>
                            
                            
                                <label class="firstItem">1. 프로필사진</label><br><br>
                                  <div id="picture_cover">
                                    <div>
	                                        <input type="file" id="profileFile" name="profileFile" />
                                    </div>
                                  <div id="fileletter">
                                     	   프로필 사진을 업로드 해 주세요.<br>
                                      	  수강생 분들에게 신뢰감을 높이기 위해 얼굴이 <br>
                                        	나온 사진이 필수 입니다.<br>
                                  </div>
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
                            <li class=li>
                                <label class="firstItem">2. 활동 지역</label><br><br>
                             	<input type="text" class="addr" id="sample6_postcode" name="trainerRegion1" placeholder="우편번호">
                                <input type="button" id="sample6_fpostcode" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
                                <input type="text" class="addr" id="memberAddr" name="trainerRegion2" placeholder="주소">
                                <input type="text" class="addr" id="sample6_address2" name="trainerRegion3" placeholder="상세주소">
                            </li><br>
                  
                                <label class="firstItem">3. 종목</label><br><br>
                            <li style=i>
                                <div class="checks">
                                <input type="radio" id="sport1" name="sport"/><label for="sport1">헬스 </label>&nbsp;&nbsp;
                                <input type="radio" id="sport2" name="sport" /><label for="sport2">요가</label>&nbsp;&nbsp;
                                <input type="radio" id="sport3" name="sport" /><label for="sport3">구기종목</label>&nbsp;&nbsp;
                                <input type="radio" id="sport4" name="sport" /><label for="sport4">무술</label>&nbsp;&nbsp;
                                <input type="radio" id="sport5" name="sport" /><label for="sport5">라켓</label>&nbsp;&nbsp;
                                <input type="radio" id="sport6" name="sport" /><label for="sport6">와타스포츠</label>&nbsp;&nbsp;
                                <input type="radio" id="sport7" name="sport" /><label for="sport7">유산소</label>&nbsp;&nbsp;
                                </div>
                            </li>
                           <p></p>
                            <p id="categoryline">└ 해당 카테고리의 종목 :&nbsp;&nbsp;</p>
                            
                            <li  id="sport1_sub" class="sport_tag" style="display:none">
                                <label for="weight_training">웨이트트레이닝</label>&nbsp;&nbsp;
                                <input type="checkbox" id="weight_training" name="trainerEvent" value="웨이트트레이닝"/>
                                <label for="body_making">체형교정</label>&nbsp;&nbsp;
                                <input type="checkbox" id="body_making" name="trainerEvent" value="체형교정"/>
                                <label for="spinning">스피닝</label>&nbsp;&nbsp;
                                <input type="checkbox" id="spinning" name="trainerEvent" value="스피닝"/>
                                <label for="personal_training">개인헬스</label>&nbsp;&nbsp;
                                <input type="checkbox" id="personal_training" name="trainerEvent" value="개인헬스"/>
                            </li>
                            
                            <li  id="sport2_sub" class="sport_tag" style="display:none">
                                <label for="normal_yoga">일반요가</label>&nbsp;&nbsp;
                                <input type="checkbox" id="normal_yoga" name="trainerEvent" value="일반요가"/>
                                <label for="flying_yoga">플라잉요가</label>&nbsp;&nbsp;
                                <input type="checkbox" id="flying_yoga" name="trainerEvent" value="플라잉요가"/>
                                <label for="pilates">필라테스</label>&nbsp;&nbsp;
                                <input type="checkbox" id="pilates" name="trainerEvent" value="필라테스"/>
                            </li>
                            
                            <li id="sport3_sub" class="sport_tag" style="display:none">
                                <label for="soccer">축구</label>&nbsp;&nbsp;
                                <input type="checkbox" id="soccer" name="trainerEvent" value="축구"/>
                                <label for="volleyball">배구</label>&nbsp;&nbsp;
                                <input type="checkbox" id="volleyball" name="trainerEvent" value="배구"/>
                                <label for="baseball">야구</label>&nbsp;&nbsp;
                                <input type="checkbox" id="baseball" name="trainerEvent" value="야구"/>
                                <label for="basketball">농구</label>&nbsp;&nbsp;
                                <input type="checkbox" id="basketball" name="trainerEvent" value="농구"/>
                                <label for="golf">골프</label>&nbsp;&nbsp;
                                <input type="checkbox" id="golf" name="trainerEvent" value="골프"/>     
                            </li>
                            
                            <li id="sport4_sub" class="sport_tag" style="display:none">
                                <label for="Jiujitsu">주짓수</label>&nbsp;&nbsp;
                                <input type="checkbox" id="Jiujitsu" name="trainerEvent" value="주짓수"/>
                                <label for="boxing">복싱</label>&nbsp;&nbsp;
                                <input type="checkbox" id="boxing" name="trainerEvent" value="복싱"/>
                                <label for="mma">격투기</label>&nbsp;&nbsp;
                                <input type="checkbox" id="mma" name="trainerEvent" value="격투기"/>
                                <label for="judo">유도</label>&nbsp;&nbsp;
                                <input type="checkbox" id="judo" name="trainerEvent" value="유도"/>
                                <label for="kendo">검도</label>&nbsp;&nbsp;
                                <input type="checkbox" id="kendo" name="trainerEvent" value="검도"/>
                                <label for="fencing">펜싱</label>&nbsp;&nbsp;
                                <input type="checkbox" id="fencing" name="trainerEvent" value="펜싱"/>
                            </li>
                            <li id="sport5_sub" class="sport_tag" style="display:none">
                                <label for="tennis">테니스</label>&nbsp;&nbsp;
                                <input type="checkbox" id="tennis" name="trainerEvent" value="테니스"/>
                                <label for="badminton">배드민턴</label>&nbsp;&nbsp;
                                <input type="checkbox" id="badminton" name="trainerEvent" value="배드민턴"/>
                                <label for="squash">스쿼쉬</label>&nbsp;&nbsp;
                                <input type="checkbox" id="squash" name="trainerEvent" value="스쿼쉬"/>
                            </li>
                            <li id="sport6_sub" class="sport_tag" style="display:none">
                                <label for="swim">수영</label>&nbsp;&nbsp;
                                <input type="checkbox" id="swim" name="trainerEvent" value="수영"/>
                                <label for="rowing">조정</label>&nbsp;&nbsp;
                                <input type="checkbox" id="rowing" name="trainerEvent" value="조정"/>
                                <label for="beachvolleyball">비치발리볼</label>&nbsp;&nbsp;
                                <input type="checkbox" id="beachvolleyball" name="trainerEvent" value="비치발리볼"/>
                                <label for="diving">다이빙</label>&nbsp;&nbsp;
                                <input type="checkbox" id="diving" name="trainerEvent" value="다이빙"/>
                            </li>
                            <li id="sport7_sub" class="sport_tag" style="display:none">
                                <label for="marathon">마라톤&amp;산악마라톤</label>&nbsp;&nbsp;
                                <input type="checkbox" id="marathon" name="trainerEvent" value="마라톤&산악마라톤"/>
                                <label for="climbing">등산&amp;암벽등반</label>&nbsp;&nbsp;
                                <input type="checkbox" id="climbing" name="trainerEvent" value="등산&암벽등반"/>
                            </li>
                        </ul>
                        
                        <div class="linecolor"></div>
                        
                        <ul>
                                <label class="firstItem">4. 신분/학력 인증</label>
                            <li>
                      
                                <p><br>소속된 대학이나 졸업한 대학을 인증해주세요. 없으시면 신분증인증을 해주시면 됩니다. (<font color="red">필수</font>) </p>
                                
                                <div class="checks">
                                <p><input type="radio" id="univid1" name="univid"/><label for="univid1">대학인증</label></p>
                                <p><input type="radio" id="univid2" name="univid"/><label for="univid2">대학원인증</label></p>
                                <p><input type="radio" id="univid3" name="univid"/><label for="univid3">신분증인증</label></p>
                                </div>
                                
                                <div id="SchoolMajor"><br>
                                    <input type="text" class="border" name="trainerUniv1" placeholder="학교(대학) 예)태평양대학교" />
                                    <input type="text" class="border" name="trainerUniv2" placeholder="학과 예)해저케이블학과"/>
                                    <br><br>
                                    <div class="checks">
                                    <p><input name="trainerGrad" id="trainerGrad1" type="radio" value="a" /><label for="trainerGrad1">재학</label></p>
                                    <p><input name="trainerGrad" id="trainerGrad2" type="radio" value="b"/><label for="trainerGrad2">졸업</label></p>
                                    <p><input name="trainerGrad" id="trainerGrad3" type="radio" value="c"/><label for="trainerGrad3">수료</label></p>
                                    </div>
                                
                                    <p><b>학력 인증(<font color="red">필수</font>)</b> - 학생증, 재학증명서, 졸업증명서 (파일을 업로드해주세요.)</p>
	                                <p><input type="file"   id="prove" name="trainerGradFile" /></p>
                               
                                </div>

                            </li>
                        </ul>

                        <div class="linecolor"></div>
                        
                        <ul>
                            <li class=li><br><br>
                                <label class="firstItem">5. 자격증(최대 5개) (선택)</label>

                                <!--input 추가됨-->
                                <div id="cert">
                                 
                                    <input style="float:left;" id="licenseName1" name="licenseName1" type="text" placeholder="예) GTQ 1급, 입상경력.." value="" class="input_txt01" />          
	                                    <input type="file" id="certificate" name="trainerLicenseFile" value=""/>
                                </div>
                                
                                <div id="CertAdd"></div>
                                <a onclick="addLicense();" class="addbtn" style="cursor:pointer;">추가 +</a>

                                <input type="hidden" id="fileCnt" name="fileCnt" value="1">

                                
                            </li>
                        </ul>
                        <!--자격증 부분 끝-->
                        <div class="linecolor"></div>
                        
                        <ul>
                            
 								<div class="career-group">
 								  <li class=li><br><br>
									<label class="firstItem">6. 경력사항</label>

										<div>
											<p><input type="file" id="career" name="trainerCareerFile" /></p>
											<input id="careerName1" class="careerCompany" name="careerName1" type="text" placeholder="ex)고라니GYM 근무" value=""/>
											<input type="date" id="careerStart1" class="careerStart1" name="careerStart1" value="2018-01-01" min="1990-01-01" max="2018-12-31"/> ~ 
											<input type="date" id="careerEnd1" class="careerEnd1" name="careerEnd1" value="2018-01-01" min="1990-01-01" max="2018-12-31"/>
										</div>
										<div id="CertCareer"></div>
										<a onclick="addCareer();" class="addbtn" style="cursor:pointer;">추가 +</a>
										<input type="hidden" class="careerCompany" id="careerfileCnt" name="careerfileCnt" value="1"><br><br>
								   </li>
								</div>

                    
                            	<div class="form-group"><!-- 부트스트랩임 -->
                            	   <li class=li><br><br>
									<label for="trainerSubject" class="firstItem">7. 수업제목</label>
									<input type="text" class="form-control" name="trainerSubject">
								   </li>
								</div>
                                  <br><br>
                                  <label for="comment" class="firstItem">8. 수업 소개</label>
                                <div class="form-group"><!-- 부트스트랩임 -->
                                  <li class=li>
                                    <textarea class="form-control2" rows="5" cols="50" name="trainerContent" id="trainerContent"></textarea>
                                    <!--  name있어야 벨류값 전송 가능!!!!!!! -->
                                  </li>
                                </div>

                        </ul>
                        <center>
                        <button type="submit" id="final_submit"  class="btn btn-warning"> 제출하기 </button>
                        </center>
                    </div>
                </div>
            </form>

        </div>


    </div>
</body>

</html>