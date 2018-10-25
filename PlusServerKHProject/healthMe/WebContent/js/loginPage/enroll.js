/**
 * enroll.jsp에서 적용하는 자바스크립트
 */
  
   function idCheck() {
	   var memberId  = document.getElementById("memberId").value;
	  
	   window.open("../../page/loginPage/idCheck.jsp?checkId="+memberId, "_blank", "width=400px,height=100px");
	   
	   return false;
   }

   function validate() {
	  
	   var idReg = /^[a-z0-9_]{4,12}$/;
	   var pwReg =  /^(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]|.*[0-9]).{8,24}$/;
	   var nameReg =  /^[가-힝]{2,4}$/;
	   var socialReg = /^(?:[0-9]{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[1,2][0-9]|3[0,1]))-[1-4][0-9]{6}$/;
	   var phoneReg = /^\d{2,3}-\d{3,4}-\d{4}$/;
	   var emailReg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
 	   
 	   var memberId = document.getElementById("memberId");
 	   var memberPw = document.getElementById("memberPw");
 	   var memberName = document.getElementById("memberName");
 	   var memberSocialId = document.getElementById("memberSocialId");
 	   var memberAddr = document.getElementById("memberAddr");
 	   var memberPhone = document.getElementById("memberPhone");
 	   var memberEmail = document.getElementById("memberEmail");
 	   
 	   if(!check(idReg,memberId, "아이디 형식에 맞게 입력해주세요.")) {
 		   return false;
 	   }
 	   
 	   if(!check(pwReg,memberPw, "비밀번호 형식에 맞게 입력해주세요.")) {
 		   return false;
 	   }
 	   
 	   if(join.memberPw.value != join.memberPw2.value) {
 		   alert("비밀번호가 다릅니다. 다시 확인해주세요.");
 		   join.memberPw2.value="";
 		   join.memberPw2.focus();
 		   return false;
 	   }
 	   
 	   if(!check(nameReg,memberName, "이름  한글로 입력해주세요.")) {
 		   return false;
 	   }
 	   
 	   if(!check(socialReg,memberSocialId, "주민등록번호 형식에 맞게 입력해주세요.")) {
 		   return false;
 	   }
 	   
 	   if(memberAddr.value=="") {
 		   alert("주소를 입력해주세요");
 		   memberAddr.focus();
 		   return false;
 	   }
 	   
 	   if(!check(phoneReg,memberPhone, "핸드폰 번호 형식에 맞게 입력해주세요.")) {
 		  return false;
 	   }
 	   
 	   if(!check(emailReg,memberEmail, "이메일 형식에 맞게 입력해주세요.")) {
 		   return false;
 	   }
   }
   
   function check(idReg,what,message) {
	   if(idReg.test(what.value)) {
		   return true;
	   }
	   alert(message);
	   what.value="";
	   what.focus();
	   return false;
   }
   
   function check(pwReg,what,message) {
	   if(pwReg.test(what.value)) {
		   return true;
	   }
	   alert(message);
	   what.value="";
	   what.focus();
	   return false;
   }
   
   function check(nameReg,what,message) {
	   if(nameReg.test(what.value)) {
		   return true;
	   }
	   alert(message);
	   what.value="";
	   what.focus();
	   return false;
   }
   
   function check(socialReg,what,message) {
	   if(socialReg.test(what.value)) {
		   return true;
	   }
	   alert(message);
	   what.value="";
	   what.focus();
	   return false;
   }
   
   function check(phoneReg,what,message) {
	   if(phoneReg.test(what.value)) {
		   return true;
	   }
	   alert(message);
	   what.value="";
	   what.focus();
	   return false;
   }
   
   function check(emailReg,what,message) {
	   if(emailReg.test(what.value)) {
		   return true;
	   }
	   alert(message);
	   what.value="";
	   what.focus();
	   return false;
   }
   
   

    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;

                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('memberAddr').value = fullAddr;

                // 커서를 상세주소 필드로 이동한다.
                document.getElementById('sample6_address2').focus();
            }
        }).open();
    }
    

