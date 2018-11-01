package com.healthme.member.vo;

import java.sql.Date;

public class Member {
	private int pkMemberNumber;
	private String memberId;
	private String memberPw;
	private String memberName;
	private int memberSocialId1;
	private int memberSocialId2;
	private String memberAddr;
	private String memberEmail;
	private String memberPhone;
	private char memberTrainer;
	private String memberClass;
	private char memberOut;
	private Date memberRegistDate;
	private Date memberOutDate;

	
	
	  public Member(int pkMemberNumber, String memberId, String memberName, String memberEmail, String memberPhone) {
	      super();
	      this.pkMemberNumber = pkMemberNumber;
	      this.memberId = memberId;
	      this.memberName = memberName;
	      this.memberEmail = memberEmail;
	      this.memberPhone = memberPhone;      
	   }

	   public Member(String memberId, String memberPw) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
	}

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(int pkMemberNumber, String memberId, String memberPw, String memberName, int memberSocialId1,
			int memberSocialId2, String memberAddr, String memberEmail, String memberPhone, char memberTrainer,
			String memberClass, char memberOut, Date memberRegistDate, Date memberOutDate) {
		super();
		this.pkMemberNumber = pkMemberNumber;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberSocialId1 = memberSocialId1;
		this.memberSocialId2 = memberSocialId2;
		this.memberAddr = memberAddr;
		this.memberEmail = memberEmail;
		this.memberPhone = memberPhone;
		this.memberTrainer = memberTrainer;
		this.memberClass = memberClass;
		this.memberOut = memberOut;
		this.memberRegistDate = memberRegistDate;
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

	public int getMemberSocialId1() {
		return memberSocialId1;
	}

	public void setMemberSocialId1(int memberSocialId1) {
		this.memberSocialId1 = memberSocialId1;
	}

	public int getMemberSocialId2() {
		return memberSocialId2;
	}

	public void setMemberSocialId2(int memberSocialId2) {
		this.memberSocialId2 = memberSocialId2;
	}

	public String getMemberAddr() {
		return memberAddr;
	}

	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
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

	public String getMemberClass() {
		return memberClass;
	}

	public void setMemberClass(String memberClass) {
		this.memberClass = memberClass;
	}

	public char getMemberOut() {
		return memberOut;
	}

	public void setMemberOut(char memberOut) {
		this.memberOut = memberOut;
	}

	public Date getMemberRegistDate() {
		return memberRegistDate;
	}

	public void setMemberRegistDate(Date memberRegistDate) {
		this.memberRegistDate = memberRegistDate;
	}

	public Date getMemberOutDate() {
		return memberOutDate;
	}

	public void setMemberOutDate(Date memberOutDate) {
		this.memberOutDate = memberOutDate;
	}
	

	
	
	


}
