<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ 
	page import="com.healthme.search.model.vo.*" 
		import = "java.util.ArrayList"
%>
<%@ page import="com.healthme.member.vo.*" 
		import="com.healthme.trainer.model.vo.*"
		import="com.healthme.mypage.model.vo.*"
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
    <link rel="stylesheet" href="../../css/mypage/myPage.css" />
    <!-- 스크립트 -->
<!--     <script src="https://code.jquery.com/jquery-3.3.1.js"
 			integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
  			crossorigin="anonymous"></script>
  			 -->
  	<!-- fa 아이콘 링크  -->
  	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <!--title-->
    <title>헬th미:나만의 트레이너</title>
</head>
<body>
<!--전체 공간-->
<%-- 		<% for(SearchedTrainerResult n : trainerList){ %>
									아이디 : <%=n.getMemberId() %><br>
									이름 : <%=n.getMemberName() %><br>
									프로필 경로 : <%=n.getProfileFile() %><br>
									종목 : <%=n.getTrainerEvent() %><br>
									별점 : <br>
									<br><br><br>
		<% } %>  --%>
    
    <div id="wrapper">
        <div id="top">
      		<jsp:include page="/page/header/header.jsp"/>
        </div>
                        	<%
	            				session = request.getSession(false);
	            				Member member = (Member)session.getAttribute("member");
	            				Trainer t = (Trainer)request.getAttribute("trainer");
	            				ArrayList<Mypage> mylist = (ArrayList<Mypage>)request.getAttribute("mylist");
                        	%>
        <!--컨텐츠가 들어가는 중간부분-->
        <!--페이지별로 달라지는 부분-->
        <div id="middle">
            <!--지역, 종목 등 선택할 수 있는 선택박스-->
            <div id="submy">
            	<div id="area01">
	                <div id="sec01">
	                    <div class="box">	                    	
                        	<div id="img01">
                        	<%  if(t!=null){%>
                        		<img src="<%=t.getProfileFile()%>" alt="userImg">                        	
                        	<%	} else{%>
                        		<img src="../../img/person_image.png" alt="userImg">
                        	<%  }%>
                        	</div>
                        	<div id="nextImg">
                            <% if(member!=null){ %>                   	
		                        <div id="p1"><p><%=member.getMemberId()%>님</p><br><p>환영합니다!</p></div>
		                        <div id="p3">
		                        	<a href="../loginPage/memberMyInfo.jsp">회원정보수정</a>
		                        </div>
		                     <% }%>
		                     <%if(t!=null){ %>
		                     	<div id="p3_1">
		                        	<a href="../loginPage/memberMyInfo.jsp">이력서수정</a>
		                        </div>
		                     <%} %>    
		                        <div id="p4"><a href="/logout.do">로그아웃</a></div>
	                        </div> 
	                       
	                    </div>
	                </div>
	                <div id="sec02">
	                    <div class="box">
	                        <div class="box1">
	                            <a href="">
	                                <img id="img02" src="../../img/icon_my_menu01.png">
	                                <p id="sec02_p1">받은수업 신청서</p>
	                                <p>0건</p>
	                            </a>
	                        </div>
	                        <div class="box2">
	                            <a href="">
	                                <img id="img03" src="../../img/icon_my_menu02.png">
	                                <p id="sec02_p2">신청한 수업</p>
	                                <p>0건</p>
	                            </a>
	                        </div>
	                        <div class="box3">
	                            <a href="">
	                                <img id="img04" src="../../img/icon_my_menu03.png">
	                                <p id="sec02_p3">관심 트레이너</p>
	                                <p>제목 : <%=mylist.get(0).getSubject() %></p>
	                                <p>0건</p>
	                            </a>
	                        </div>
	                    </div>
	                </div>
	                <div id="sec03">
		                <div class="box">
		                	<div class="box1"><p>등록 전화번호 : <%=member.getMemberPhone() %> </p1></div>
		                	<div class="box2"><p>등록 이메일 	: <%=member.getMemberEmail() %> </p></div>
		                	<div class="box3"><p>회원 등급 	:  <%=member.getMemberClass() %> </p></div>
		                </div>
	                </div>
            	</div>
            </div>
            <div id="area02">
				
				<div id="chooseBox">
					<div id="chooseABC">
						<div id="chooseA"></div>
						<div id="chooseB"></div>
						<div id="chooseC"></div>
					</div>
					<div id="contentsBox">
						<%//if(member!=null && t==null){//일반회원 %>
	                    <div id="titleSpace">
	                        <span id="title">Trainer-list</span>
	                    </div>
	                    <div id="trainerSpace">
	                        <table id="tblMember">
	                            <thead>
	                                <tr id="trainerSpaceSubTitle">
	                                    <th scope="col">강사</th>
	                                    <th scope="col">이름</th>
	                                    <th scope="col">지역</th>
	                                    <th scope="col">종목</th>
	                                    <th scope="col">소개</th>
	                                    <th scope="col">체크</th>
	                                    <th scope="col">버튼</th>
	                                </tr>
	                            </thead>
	                            <tbody>
	                                <tr class="line">
	                                    <!--a href="#"-->
	                                    <td><img src="../../img/jubin.jpg"></td>
	                                    <td>이주빈</td>
	                                    <td>강남</td>
	                                    <td>요가</td>
	                                    <td>Wanna be a supermodel?</td>
	                                    <td><input type="checkbox" name="pid" id="check"></td>
	                                    <td><input type="submit" value="컨택하기">
	                                        <!--a href="#">-CLEAR-</a></td-->
	                                </tr>
		                         </tbody>
		                    </table>
						</div>	
					    <%//} else if(t!=null) { //트레이너회원%>
					    
					    <%//} %>
					    <div id="buttons">
							<center>
		                    	<div id="trainerBtnSpace">
			                        <input type="button" class="btn btn-warning" id="chkObj" onclick="check1Btn();" value="전체선택" />
			                        <input type="button" class="btn btn-warning" id="chkObj" onclick="check2Btn();" value="전체취소" />
			                        <input type="button" class="btn btn-warning" id="btnDelete" name="btnDelete" value="선택삭제" onclick="btnDelete()" />
			                        <a href="" class="btn btn-warning"> - Roll Back - </a>
		                        </div>
							</center>
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