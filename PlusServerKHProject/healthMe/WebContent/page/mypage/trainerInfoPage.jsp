<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">


<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<!--반응형 웹을 만들기 위한 meta태그의 viewport-->
<meta name="viewport" content="width=device-width" , initial-scale="2">


<!--스타일-->
<link rel="stylesheet" href="../css/myPage/trainerInfoPage.css" />

<!--script>
   window.onload = function() {
      var width = screen.availWidth-20;
      var height = screen.availHeigth-120;
      var body = document.getElementById("wrapper");
      body.style.width = width+"px";
      body.style.height = height+"px";
      console.log(width+","+height);
   }
</script-->


<title>Insert title here</title>
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
               <img src="../images/%EB%A1%9C%EA%B3%A0.png">
            </div>
            <div id="searchBar">
                <input type="text" name="searchInput" id="searchInput" value="지역, 종목 검색" />
            </div>
            <div id="menu">
                로그인, 메뉴
            </div>
        </div>
<!-- CONTAINER -->
<div id="container_register">
   
   <h1>기본정보 입력</h1>
   <form method="get" id="frm-register-detail" enctype="multipart/form-data">
   <div class="register_cont">
      <div class="reginput">
         <ul>
            <li>
               <label>프로필사진</label>
               <div id="picture-cover" class="picture" style="background-image: url(//taling.me/Content/Images/placeholders/profile-default.thumb.jpg)">
                  <div class="picture-overlay">
                     <i class="glyphicon glyphicon-edit"></i>                        
                        <input type="file" id="picture" name="picture"/>                        
                  </div>
               </div>
               <span class="pf_subtxt"><br>
                  프로필 사진을 업로드 해 주세요.<br>
                  수강생 분들에게 신뢰감을 높이기 위해 얼굴이 <br>
                  나온 사진이 필수 입니다.<br>
               </span>
               <div class="pf_image clearbt" style="padding-top:30px;">    
                  <ul>
                     <li><img src="/Content/Images/20.jpg"><br />스타일리쉬한 모습<br></li>
                     <li><img src="/Content/Images/profile2.jpg"><br />밝고 쾌활히 웃는<br></li>
                     <li><img src="/Content/Images/profile3.jpg"><br />무언가에 열중<br></li>
                  </ul>
               </div>
            </li>
      
         </ul>
         <ul>            
            <li>
               <label><br>별명입력<br></label>
               <input id="Description" name="Description" type="text" placeholder="튜터님의 정체성을 가장 잘 드러낼 수 있는 별명을 입력해주세요" value="" class="input_txt05" />
               
            </li>            
            <li>
               <label><br>휴대폰 번호<br></label>
               <!--select id="Phone1" name="Phone1" class="input_txt04 not">
                  <option value="010" >010</option>
                  <option value="011" >011</option>
                  <option value="019" >019</option>
                  <option value="016" >016</option>
               </select-->
               <input id="Phone" name="Phone" type="text" placeholder="010-1234-5678" value="" class="input_txt02"/>
               <!--input id="Phone3" name="Phone3" type="text" placeholder="휴대폰번호" value="" class="input_txt04"/-->
               
               <input type="hidden" id="IsPhone" value="0">
                              <a class="inputbtn" id="btn-register-phone">번호인증</a>
               <p class="regintxt01 clearbt redtxt" id="IsPhoneConfirm"><br>번호인증을 눌러 번호를 인증해주세요.</p>
               <p class="regintxt01 clearbt" id="IsPhoneConfirmed" style="display:none;"><font style="border:1px solid red;background:#ff005a;color:#fff;padding:5px;">인증완료</font></p>
                              
            </li>
         
         </ul>
         <ul>
            <li>
               <label style="padding: 0px 15px 0px 15px;">신분/학력<br>인증</label>
               <p class="regintxt05"><br>소속된 대학이나 졸업한 대학을 인증해주세요. 없으시면 신분증인증을 해주시면 됩니다(필수)<br></p>
               <p class="regintxt07 clearbt"></p>
               <p class="regintxt02"><input id="univ" name="univ" type="radio" value="1" class="innone" checked onclick="checkLayer(1);"/><label for="univ_y" class="chnon" >대학인증</label></p>
               <p class="regintxt021"><input id="univ" name="univ" type="radio" value="0" class="innone" onclick="checkLayer(2);"/><label for="univ_n" class="chnon" >대학원인증</label></p>
               <p class="regintxt021"><input id="univ" name="univ" type="radio" value="0" class="innone" onclick="checkLayer(3);"/><label for="univ_n" class="chnon" >신분증인증</label></p>
               <br>
               <div id="SchoolMajor"><br>
                  <input id="" name="SchoolMajor" type="text" placeholder="학교(대학) 예)태평양대학교" value="" class="input_txt03 clearbt"/>
                  <input id="" name="SchoolMajorS" type="text" placeholder="학과 예)해저케이블학과" value="" class="input_txt03"/>               
                  <p class="regintxt07 clearbt"></p>
                  <p class="regintxt02"><input id="AcademicStatus" name="AcademicStatus" type="radio" value="0" class="innone" checked/><label for="univ_y" class="chnon">재학</label></p>
                  <p class="regintxt02"><input id="AcademicStatus" name="AcademicStatus" type="radio" value="1" class="innone" /><label for="univ_y" class="chnon">졸업</label></p>
                  <p class="regintxt02"><input id="AcademicStatus" name="AcademicStatus" type="radio" value="2" class="innone" /><label for="univ_y" class="chnon">수료</label></p>
                   <br>
                                    <p class="regintxt04 clearbt"><b>학력 인증(<font color="red">필수</font>)</b> - 학생증, 재학증명서, 졸업증명서</p>
                  <p class="regintxt05 clearbt"><input type="file" name="School"/></p>         
                  <p class="regintxt01 clearbt redtxt" id="IsSchoolVerified">파일을 업로드해주세요.</p>
                                 
               </div>
                <br>
               <div id="SchoolMajor2" style="display:none;">
                  <input id="" name="SchoolMajor2" type="text" placeholder="학교(대학) 예)태평양대학교" value="" class="input_txt03 clearbt"/>
                  <input id="" name="SchoolMajor2S" type="text" placeholder="학과 예)해저케이블학과" value="" class="input_txt03"/>               
                  <p class="regintxt07 clearbt"></p>
                  <p class="regintxt02"><input id="AcademicStatus2" name="AcademicStatus2" type="radio" value="0" class="innone" /><label for="univ_y" class="chnon">재학</label></p>
                  <p class="regintxt02"><input id="AcademicStatus2" name="AcademicStatus2" type="radio" value="1" class="innone" /><label for="univ_y" class="chnon">졸업</label></p>
                  <p class="regintxt02"><input id="AcademicStatus2" name="AcademicStatus2" type="radio" value="2" class="innone" /><label for="univ_y" class="chnon">수료</label></p>
                   <br>
                                    <p class="regintxt04 clearbt"><b>학력 인증(<font color="red">필수</font>)</b> - 학생증, 재학증명서, 졸업증명서</p><br>
                  <p class="regintxt05 clearbt"><input type="file" name="School2"/></p>         
                  <p class="regintxt01 clearbt redtxt" id="IsSchoolVerified">파일을 업로드해주세요.<br></p>
                                 
               </div>

               <div id="Idcard" style="display:none;">
                                    <p class="regintxt04 clearbt"><b>신분 인증(<font color="red">필수</font>)</b> - 주민등록증, 운전면허증</p>
                  <p class="regintxt05 clearbt"><input type="file" name="Idcard"/></p>         
                  <p class="regintxt01 clearbt redtxt" id="IsSchoolVerified">파일을 업로드해주세요.</p>
                                 
               </div>
            </li>
            <!--<br /><br />-->
            </ul>
          <ul>
            <li>
               <label>자격증(최대 5개)<br>(선택)</label>
                
                <!--input 추가됨-->
                <input id="Cert0" name="Cert0" type="text" placeholder="예) 토플 117, HSK 6급, GTQ 1급, 입상경력.." value="" class="input_txt01"/>
               <p><input type="file" name="file0"/></p>
               <div id="CertAdd"></div>
               <a onclick="addFile();" class="addbtn">추가 +</a>
                              
               <input type="hidden" id="fileCnt" name="fileCnt" value="0">
              
                
                <script>
                  function addFile(){
                      fileCnt = document.getElementById('fileCnt').value;   
                      if(fileCnt==4){
                          alert("그만눌러라");
                          return false;
                      }else{
                         fileCnt++; 
                      }               
                     html = '';
                     html += '<input id="Cert'+fileCnt+'" name="Cert'+fileCnt+'" type="text" placeholder="예) 토플 117, HSK 6급, GTQ 1급, 입상경력.." value="" class="input_txt01 clearbt"/>';
                     html += '<p><input type="file" name="file'+fileCnt+'"/></p>';
                     
                     var div = document.createElement('div');
                       div.innerHTML = html;
                        document.getElementById('CertAdd').appendChild(div);                     
                     document.getElementById('fileCnt').value = fileCnt;
                  }
               </script>
            </li>
              </ul>
              <!--자격증 부분 끝-->
              
              
              
              
              
            
          <ul>
            <li>
                <div class="career-group">
                    <p>경력사항</p>
                    
                    
                    <form id="career_start" action="action.jsp">
                        <div >
                            <input id="career0" type="text" placeholder="ex)고라니GYM 근무" value=""/>
                            <input type="date" id="userdate_start0" name="userdate0" value="2015-10-10">
                            ~
                            <input type="date" id="userdate_finish" name="userdate" value="2015-10-10">
                            <input type="submit" value="전송">
                        </div>
                         <div id="CertCareer"></div>
                         <a onclick="addcareer();" class="addbtn">추가 +</a>
                        <input type="hidden" id="careerfileCnt" name="fileCnt" value="0">
                    </form>     
                    
                      <script>
                  function addcareer(){
                      fileCnt = document.getElementById('careerfileCnt').value;   
                      if(fileCnt==4){
                          alert("그만눌러라");
                          return false;
                      }else{
                         fileCnt++; 
                      }               
                     html = '';
                     html += '<input id="career'+fileCnt+'" name="career'+fileCnt+'" type="text" placeholder="ex)고라니GYM 근무" value=""/>';
                     html += '<input type="date" id="userdate_start'+fileCnt+'" name="userdate'+fileCnt+'" value="2015-10-10"> ~ ';
                     html += '<input type="date" id="userdate_finish'+fileCnt+'" name="userdate'+fileCnt'" value="2015-10-10">';
                     html += '<input type="submit" value="전송">';
                     
                     var div = document.createElement('div');
                       div.innerHTML = html;
                        document.getElementById("CertCareer").appendChild(div);                     
                     document.getElementById('fileCnt').value = fileCnt;
                  }
               </script>
                    
                    
                </div>
              
              
            </li>
            <li>
                <!--<br>
                <br>-->
                <div class="form-group">
                  <label for="comment">자기소개 :</label>
                  <textarea class="form-control" rows="5" id="comment"></textarea>
                </div>
            </li>
        </ul>
      </div>
   </div>
    <button type="submit" id="final_submit" class="btn btn-primary"> 제출하기 </button>
       
       
</form>
</div>
    
</div>

</body>
</html>