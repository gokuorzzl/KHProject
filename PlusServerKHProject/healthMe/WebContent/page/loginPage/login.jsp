<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

  <!--인코딩 문자셋-->
    <meta charset="UTF-8">
    <!--반응형 웹을 만들기 위한 meta태그의 viewport-->
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <!--페이지 설명-->
    <meta name="subject" content="헬th미 메인페이지" />
    <!--키워드-->
    <meta name="keywords" content="www.healthme.com, 트레이너, 나만의, 맞춤" />
    <!--스타일-->
     <link rel="stylesheet" href="../../css/loginPage/login.css" />
     
    <!--네이버 로그인  -->
     <script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
 	 <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
   
    <!--구글 로그인 -->
    <meta name="google-signin-client_id" content="188338652604-hfqn3ri234pvvb00utkh6esl5vu5n180.apps.googleusercontent.com">
    
    <script src="https://apis.google.com/js/platform.js" async defer></script>
   
    
    <!--title-->
    <title>헬th미: 로그인</title> <!--로그인 첫페이지-->
    
    


</head>
<body>

 <!--전체 공간-->    
    <div id="wrapper">
        
        <!--로고, 메뉴가 들어가는 윗부분-->
        <!--top부분은 관리자페이지 제외한 모든 페이지 통일-->
        <div id="top">
            <div id="mobileMenu">
              <!--   핸드폰일 경우 메뉴 -->
            </div>
            <div id="logo">
               <!-- 로고 -->
            </div>
            <div id="searchBar">
      <!--           검색바 -->
            </div>
            <div id="menu">
              <!--   로그인, 메뉴 -->
            </div>
        </div>
        
        <!--컨텐츠가 들어가는 중간부분-->
        <!--페이지별로 달라지는 부분-->
        <div id="middle">
            <!--지역, 종목 등 선택할 수 있는 선택박스-->
           <div id="searchBox">
              <div id="logoBox">
                <img src="../../img/로고.png" alt="logo" class="logo-center";>
              </div>
            </div>
            <!--트레이너 별점 등 컨텐츠 나오는 부분-->
            <div id="contents">
                <div id="realContents">
                
                    <form action="/login.do" method="post" name="login-form">                      
                        <div class="login-container1">
                           <label for="userId"></label>
                          <input type="text" placeholder="아이디 입력해주세요" id="memberId" name="memberId" required>

                         <label for="psw"></label><br>
                         <input type="password" placeholder="비밀번호 입력해주세요" id="memberPw" name="memberPw" required><br>
                          
                         <button type="submit" class="login-button" value="로그인"><p id="login-letter">로그인</p></button>
                         
                           <!-- <input type="checkbox" checked="checked" id="loginkeep" name="remember"><label for="keep">로그인 상태 유지</label> -->
                           <br><br>
                           <div id="find-container">
                              <div id="idfind">
                                 <span class="psw1" dir="ltr"><a class="idfindhover" href="searchId.jsp">아이디 찾기</a></span>
                              </div>
                              <div id="pswfind">
                                  <span class="psw2"><a class="pswfindhover" href="searchPwd.jsp">비밀번호 찾기</a></span>
                              </div>
                           </div> 
                             <hr>
                            
                           <div id=social-container>
                             <div id="naver_id_login"></div> <br>
                             
                             <center>     
                             <div class="g-signin2" id="myP" data-onsuccess="onSignIn"></div>
                             <p id="name"></p>
                             <div id="status"></div>
                             </center>
                             
                             
                            </div>
                            
                           <!--  <a href="#" class="naver-btn">
                              <div id="naverIdLogin"></div> -->
                             <!-- <i class="login"></i> Login with NAVER -->
                             
                     <!-- 네이버아이디로로그인 버튼 노출 영역 -->

		
  <script type="text/javascript">
  	var naver_id_login = new naver_id_login("IG6PV5dvNKOxys9LQVdt", "http://127.0.0.1/page/loginPage/login.jsp");
  	var state = naver_id_login.getUniqState();
  	naver_id_login.setButton("green", 3,45);
  	naver_id_login.setDomain(".healthme.com");
  	naver_id_login.setState(state);
  /* 	naver_id_login.setPopup();  */
  	naver_id_login.init_naver_id_login();
  </script>  
           
         
 <script type="text/javascript">

  naver_id_login.get_naver_userprofile("naverSignInCallback()");
  // 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
  function naverSignInCallback() {
    alert(naver_id_login.getProfileData('email'));
    alert(naver_id_login.getProfileData('nickname'));
    alert(naver_id_login.getProfileData('age'));
  }
</script>
 
                          <!--  </a> -->
                            <br>
                            
                            <!-- 구굴 아이디 버튼  -->
                            
                            
      <script>
      function onSignIn(googleUser) {
    	  
    	
        // Useful data for your client-side scripts:
        var profile = googleUser.getBasicProfile();
        console.log("ID: " + profile.getId()); // Don't send this directly to your server!
        console.log('Full Name: ' + profile.getName());
        console.log('Given Name: ' + profile.getGivenName());
        console.log('Family Name: ' + profile.getFamilyName());
        console.log("Image URL: " + profile.getImageUrl());
        console.log("Email: " + profile.getEmail());

        // The ID token you need to pass to your backend:
        var id_token = googleUser.getAuthResponse().id_token;
        console.log("ID Token: " + id_token);
        
         var name = profile.getName();
        var email= profile.getEmail();
        
        /* window.open("/page/loginPage/googleSuccess.jsp?name="+name+",email="+email, "_blank", "width=500px, height=200px");
        
        return false; */
        
        window.location.href="/page/loginPage/googleSuccess.jsp?name="+name+"&email="+email;
        
        
      };
    </script>
    

                            
                           <!-- <a href="#" class="google-btn">
                             <i class="login"></i> Login with Google+
                           </a> -->
                         <br><br> 
                        </div>
                   </form>
                   
                        <div class="login-container2" style="background-color:#f1f1f1">
                           <div id="userR">
                           <span><a class="userR" href="/page/loginPage/privacyPolicy.jsp">회원가입</a></span>
                           </div>    
                        </div>
          
                </div>
            </div>
        </div>
        
        
        <!--회사정보가 들어가는 아랫부분-->
        <!--bottom부분은 관리자페이지 제외한 모든 페이지 통일-->
        <div id="bottom">

        </div>
    </div>
    
</body>
</html>