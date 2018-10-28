package com.healthme.admin.vo;

import java.sql.Date;

public class AdminMember {
	private int pkMemberNumber; //기본키
	private String memberId; //유일한 속성 아이디
	private String memberPw; //null값이 들어가면 안된다. 비밀번호
	private String memberName; //이름이다.
	private String memberSocialId; //주민번호
	private String memberAddr; //주소
	private Date memberRegistDate; //등록날짜
	private String memberClass; //회원등급
	private String memberEmail; //이메일
	private String memberPhone; //핸드폰번호
	private char memberTrainer; //트레인지 체크여부 y,n
	private char memberOut; //탈퇴여부 y,n
	private Date memberOutDate; //탈퇴 날짜
	
	
	
	
	public AdminMember() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public AdminMember(int pkMemberNumber, String memberId, String memberPw, String memberName, String memberSocialId,
			String memberAddr, Date memberRegistDate, String memberClass, String memberEmail, String memberPhone,
			char memberTrainer, char memberOut, Date memberOutDate) {
		super();
		this.pkMemberNumber = pkMemberNumber;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberSocialId = memberSocialId;
		this.memberAddr = memberAddr;
		this.memberRegistDate = memberRegistDate;
		this.memberClass = memberClass;
		this.memberEmail = memberEmail;
		this.memberPhone = memberPhone;
		this.memberTrainer = memberTrainer;
		this.memberOut = memberOut;
		this.memberOutDate = memberOutDate;
	}
	public int getPkMemberNumber() {
		return pkMemberNumber;
	}
	public void setPkMemberNumber(int pkMemberNumber) {
		this.pkMemberNumber = pkMemberNumber;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberSocialId() {
		return memberSocialId;
	}
	public void setMemberSocialId(String memberSocialId) {
		this.memberSocialId = memberSocialId;
	}
	public String getMemberAddr() {
		return memberAddr;
	}
	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}
	public Date getMemberRegistDate() {
		return memberRegistDate;
	}
	public void setMemberRegistDate(Date memberRegistDate) {
		this.memberRegistDate = memberRegistDate;
	}
	public String getMemberClass() {
		return memberClass;
	}
	public void setMemberClass(String memberClass) {
		this.memberClass = memberClass;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public char getMemberTrainer() {
		return memberTrainer;
	}
	public void setMemberTrainer(char memberTrainer) {
		this.memberTrainer = memberTrainer;
	}
	public char getMemberOut() {
		return memberOut;
	}
	public void setMemberOut(char memberOut) {
		this.memberOut = memberOut;
	}
	public Date getMemberOutDate() {
		return memberOutDate;
	}
	public void setMemberOutDate(Date memberOutDate) {
		this.memberOutDate = memberOutDate;
	}
	
	
	
	
	
	
	
	
}
