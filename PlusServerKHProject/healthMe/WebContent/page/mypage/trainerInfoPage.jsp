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
            <h3>- 기본정보 입력 -</h3>
            <div class="linecolor"></div>
            <form method="get" id="frm-register-detail" action="/trainerInfo.do">
                <div id="contents">
                    <div id="realcontents">
                        <ul>
                            <li>
                                <label>프로필사진</label><br>
                                <div id="picture_cover">
                                    <div>
                                        <input type="file" id="profileFile" name="profileFile" />
                                    </div>
                                    <span>
                                        프로필 사진을 업로드 해 주세요.<br>
                                        수강생 분들에게 신뢰감을 높이기 위해 얼굴이 <br>
                                        나온 사진이 필수 입니다.<br>
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
                        
                        <ul>
                            <li>
                                <label><br>휴대폰 번호<br></label>
                                <input id="Phone" name="Phone" type="text" placeholder="010-1234-5678" value="" class="input_txt02" />
                            </li>
                        </ul>
                        
                        <div class="linecolor"></div>
                        
                        <ul id="total_sport_tag">
                            <li>
                                <label for="memberAddr">활동 지역</label><br>
                                <input type="text" id="sample6_postcode" placeholder="우편번호">
                                <input type="button" id="sample6_fpostcode" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
                                <input type="text" id="memberAddr" name="trainerRegion" placeholder="주소">
                                <input type="text" id="sample6_address2" placeholder="상세주소">
                            </li>
                            <li style=i>
                                <input type="radio" id="sport1"  /><label for="sport1">&lt;헬스&gt;</label>
                                <input type="radio" id="sport2"  /><label for="sport2">&lt;요가&gt;</label>
                                <input type="radio" id="sport3"  /><label for="sport3">&lt;구기종목&gt;</label>
                                <input type="radio" id="sport4" /><label for="sport4">&lt;무술&gt;</label>
                                <input type="radio" id="sport5"  /><label for="sport5">&lt;라켓&gt;</label>
                                <input type="radio" id="sport6"  /><label for="sport6">&lt;와타스포츠&gt;</label>
                                <input type="radio" id="sport7"  /><label for="sport7">&lt;유산소&gt;</label>
                            </li>
                            <p id="categoryline">└ 해당 카테고리의 종목 :&nbsp;&nbsp;</p>
                            
                            <li id="sport1_sub" class="sport_tag" style="display:none">
                                <label for="weight_training">웨이트트레이닝</label>
                                <input type="checkbox" id="weight_training" name="trainerEvent" value="웨이트트레이닝"/>
                                <label for="body_making">체형교정</label>
                                <input type="checkbox" id="body_making" name="trainerEvent" value="체형교정"/>
                                <label for="spinning">스피닝</label>
                                <input type="checkbox" id="spinning" name="trainerEvent" value="스피닝"/>
                                <label for="personal_training">개인헬스</label>
                                <input type="checkbox" id="personal_training" name="trainerEvent" value="개인헬스"/>
                            </li>
                            
                            <li id="sport2_sub" class="sport_tag" style="display:none">
                                <label for="normal_yoga">일반요가</label>
                                <input type="checkbox" id="normal_yoga" name="trainerEvent" value="일반요가"/>
                                <label for="flying_yoga">플라잉요가</label>
                                <input type="checkbox" id="flying_yoga" name="trainerEvent" value="플라잉요가"/>
                                <label for="pilates">필라테스</label>
                                <input type="checkbox" id="pilates" name="trainerEvent" value="필라테스"/>
                            </li>
                            
                            <li id="sport3_sub" class="sport_tag" style="display:none">
                                <label for="soccer">축구</label>
                                <input type="checkbox" id="soccer" name="trainerEvent" value="축구"/>
                                <label for="volleyball">배구</label>
                                <input type="checkbox" id="volleyball" name="trainerEvent" value="배구"/>
                                <label for="baseball">야구</label>
                                <input type="checkbox" id="baseball" name="trainerEvent" value="야구"/>
                                <label for="basketball">농구</label>
                                <input type="checkbox" id="basketball" name="trainerEvent" value="농구"/>
                                <label for="golf">골프</label>
                                <input type="checkbox" id="golf" name="trainerEvent" value="골프"/>     
                            </li>
                            
                            <li id="sport4_sub" class="sport_tag" style="display:none">
                                <label for="Jiujitsu">주짓수</label>
                                <input type="checkbox" id="Jiujitsu" name="trainerEvent" value="주짓수"/>
                                <label for="boxing">복싱</label>
                                <input type="checkbox" id="boxing" name="trainerEvent" value="복싱"/>
                                <label for="mma">격투기</label>
                                <input type="checkbox" id="mma" name="trainerEvent" value="격투기"/>
                                <label for="judo">유도</label>
                                <input type="checkbox" id="judo" name="trainerEvent" value="유도"/>
                                <label for="kendo">검도</label>
                                <input type="checkbox" id="kendo" name="trainerEvent" value="검도"/>
                                <label for="fencing">펜싱</label>
                                <input type="checkbox" id="fencing" name="trainerEvent" value="펜싱"/>
                            </li>
                            <li id="sport5_sub" class="sport_tag" style="display:none">
                                <label for="tennis">테니스</label>
                                <input type="checkbox" id="tennis" name="trainerEvent" value="테니스"/>
                                <label for="badminton">배드민턴</label>
                                <input type="checkbox" id="badminton" name="trainerEvent" value="배드민턴"/>
                                <label for="squash">스쿼쉬</label>
                                <input type="checkbox" id="squash" name="trainerEvent" value="스쿼쉬"/>
                            </li>
                            <li id="sport6_sub" class="sport_tag" style="display:none">
                                <label for="swim">수영</label>
                                <input type="checkbox" id="swim" name="trainerEvent" value="수영"/>
                                <label for="rowing">조정</label>
                                <input type="checkbox" id="rowing" name="trainerEvent" value="조정"/>
                                <label for="beachvolleyball">비치발리볼</label>
                                <input type="checkbox" id="beachvolleyball" name="trainerEvent" value="비치발리볼"/>
                                <label for="diving">다이빙</label>
                                <input type="checkbox" id="diving" name="trainerEvent" value="다이빙"/>
                            </li>
                            <li id="sport7_sub" class="sport_tag" style="display:none">
                                <label for="marathon">마라톤&amp;산악마라톤</label>
                                <input type="checkbox" id="marathon" name="trainerEvent" value="마라톤&산악마라톤"/>
                                <label for="climbing">등산&amp;암벽등반</label>
                                <input type="checkbox" id="climbing" name="trainerEvent" value="등산&암벽등반"/>
                            </li>
                        </ul>
                        
                        <div class="linecolor"></div>
                        
                        <ul>
                            <li>
                                <label>신분/학력 인증</label>
                                <p><br>소속된 대학이나 졸업한 대학을 인증해주세요. 없으시면 신분증인증을 해주시면 됩니다(필수)<br></p>
                                <p></p>
                                <p><input type="radio" value="1" checked onclick="checkLayer(1);" /><label for="univ_y">대학인증</label></p>
                                <p><input type="radio" value="0" onclick="checkLayer(2);" /><label for="univ_n">대학원인증</label></p>
                                <p><input type="radio" value="0" onclick="checkLayer(3);" /><label for="univ_n">신분증인증</label></p>
                                <br>
                                <div id="SchoolMajor"><br>
                                    <input type="text" name="trainerUniv" placeholder="학교(대학) 예)태평양대학교" />
                                    <input type="text" name="trainerUniv" placeholder="학과 예)해저케이블학과"/>
                                    <p><input name="trainerGrad" type="radio" value="0" checked /><label for="univ_y">재학</label></p>
                                    <p><input name="trainerGrad" type="radio" value="1"/><label for="univ_y">졸업</label></p>
                                    <p><input name="trainerGrad" type="radio" value="2"/><label for="univ_y">수료</label></p>
                                    <br>
                                    <p><b>학력 인증(<font color="red">필수</font>)</b> - 학생증, 재학증명서, 졸업증명서</p>
                                    <p><input type="file" name="School" /></p>
                                    <p>파일을 업로드해주세요.</p>
                                </div>

                                <div id="Idcard" style="display:none;">
                                    <p><b>신분 인증(<font color="red">필수</font>)</b> - 주민등록증, 운전면허증</p>
                                    <p><input type="file" name="trainerGradFile"/></p>
                                    <p>파일을 업로드해주세요.</p>
                                </div>
                            </li>
                        </ul>

                        <div class="linecolor"></div>
                        
                        <ul>
                            <li>
                                <label>자격증(최대 5개) (선택)</label>

                                <!--input 추가됨-->
                                <div id="cert">
                                    <input style="float:left;" id="licenseName1" name="licenseName1" type="text" placeholder="예) GTQ 1급, 입상경력.." value="" class="input_txt01" />
                                    <p><input type="file" name="trainerLicenseFile" /></p>
                                </div>
                                
                                <div id="CertAdd"></div>
                                <a onclick="addFile();" class="addbtn" style="cursor:pointer;">추가 +</a>

                                <input type="hidden" id="fileCnt" name="fileCnt" value="1">

                                <script>
                                    function addFile(){
				                      fileCnt = document.getElementById('fileCnt').value;   
				                      if(fileCnt==5){
				                          alert("그정도면 충분한것 같아요");
				                          return false;
				                      }else{
				                         fileCnt++; 
				                      }               
				                     html = '';
				                     html += '<input id="licenseName'+fileCnt+'" name="licenseName'+fileCnt+'" type="text" placeholder="예) GTQ 1급, 입상경력.." value="" class="input_txt01 clearbt"/> <br>';
				                     
				                     var div = document.createElement('div');
				                       div.innerHTML = html;
				                        document.getElementById('CertAdd').appendChild(div);                     
				                     document.getElementById('fileCnt').value = fileCnt;
				                  }
				               </script>
                            </li>
                        </ul>
                        <!--자격증 부분 끝-->
                        <div class="linecolor"></div>
                        
                        <ul>
                            <li>
 								<div class="career-group">
									<label>경력사항</label>


									<form id="career_start" action="action.jsp">
										<div>
											<input id="careerName1" name="careerName1" type="text" placeholder="ex)고라니GYM 근무" value=""/>
											<input type="date" id="careerStart1" name="careerStart1" value="2015-10-10" min="1990-01-01" max="2018-12-31"/> ~ 
											<input type="date" id="careerEnd1" name="careerEnd1" value="2015-10-10" min="1990-01-01" max="2018-12-31"/>
											<input type="submit" value="전송">
										</div>
										<div id="CertCareer"></div>
										<a onclick="addcareer();" class="addbtn" style="cursor:pointer;">추가 +</a>
										<input type="hidden" id="careerfileCnt" name="careerfileCnt" value="1">
									</form>

									<script>
										function addcareer() {
											careerfileCnt = document.getElementById('careerfileCnt').value;
											if (careerfileCnt == 5) {
												alert("그정도면 충분한것 같아요");
												return false;
											} else {
												careerfileCnt++;
											}
											html = '';
						                    html += '<input id="careerName'+careerfileCnt+'" name="careerName'+careerfileCnt+'" type="text" placeholder="ex)고라니GYM 근무" value="" />';
						                    html += '<input type="date" id="careerStart'+careerfileCnt+'" name="careerStart'+careerfileCnt+'" value="2015-10-10" min="1990-01-01" max="2018-12-31"/> ~ ';
						                    html += '<input type="date" id="careerEnd'+careerfileCnt+'" name="careerEnd'+careerfileCnt+'" value="2015-10-10" min="1990-01-01" max="2018-12-31"/>';
						                  	html += '<input type="submit" value="전송">';

											var div = document.createElement('div');
											div.innerHTML = html;
											document.getElementById("CertCareer").appendChild(div);
											document.getElementById('careerfileCnt').value = careerfileCnt;
										}
									</script>


								</div>



                            </li>
                            <li>

                                <div class="form-group">
                                    <label for="comment">수업 소개 :</label>
                                    <textarea class="form-control" rows="5" name="trainerContent" id="trainerContent"></textarea>
                                    <!--  name있어야 벨류값 전송 가능!!!!!!! -->
                                </div>
                            </li>
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