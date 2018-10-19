package com.healthme.member.vo;

import java.sql.Date;

public class Member {
	private int pkMemberNumber;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberSocialId;
	private String memberAddr;
	private Date memberRegistDate;
	private String memberClass;
	private String memberEmail;
	private String memberPhone;
	private String memberTrainer;
	private String memberOut;
	private Date memberOutDate;
	private String trainerFileName;
	private String trainerContent;
	private String trainerUniversity;
	private String trainerEvent;
	private String trainerRegion;
	private String trainerScore;
	
	public Member(String memberId, String memberPw) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
	}

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Member(int pkMemberNumber, String memberId, String memberPw, String memberName, String memberSocialId,
			String memberAddr, Date memberRegistDate, String memberClass, String memberEmail, String memberPhone,
			String memberTrainer, String memberOut, Date memberOutDate, String trainerFileName, String trainerContent,
			String trainerUniversity, String trainerEvent, String trainerRegion, String trainerScore) {
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
		this.trainerFileName = trainerFileName;
		this.trainerContent = trainerContent;
		this.trainerUniversity = trainerUniversity;
		this.trainerEvent = trainerEvent;
		this.trainerRegion = trainerRegion;
		this.trainerScore = trainerScore;
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

	public String getMemberTrainer() {
		return memberTrainer;
	}

	public void setMemberTrainer(String memberTrainer) {
		this.memberTrainer = memberTrainer;
	}

	public String getMemberOut() {
		return memberOut;
	}

	public void setMemberOut(String memberOut) {
		this.memberOut = memberOut;
	}

	public Date getMemberOutDate() {
		return memberOutDate;
	}

	public void setMemberOutDate(Date memberOutDate) {
		this.memberOutDate = memberOutDate;
	}

	public String getTrainerFileName() {
		return trainerFileName;
	}

	public void setTrainerFileName(String trainerFileName) {
		this.trainerFileName = trainerFileName;
	}

	public String getTrainerContent() {
		return trainerContent;
	}

	public void setTrainerContent(String trainerContent) {
		this.trainerContent = trainerContent;
	}

	public String getTrainerUniversity() {
		return trainerUniversity;
	}

	public void setTrainerUniversity(String trainerUniversity) {
		this.trainerUniversity = trainerUniversity;
	}

	public String getTrainerEvent() {
		return trainerEvent;
	}

	public void setTrainerEvent(String trainerEvent) {
		this.trainerEvent = trainerEvent;
	}

	public String getTrainerRegion() {
		return trainerRegion;
	}

	public void setTrainerRegion(String trainerRegion) {
		this.trainerRegion = trainerRegion;
	}

	public String getTrainerScore() {
		return trainerScore;
	}

	public void setTrainerScore(String trainerScore) {
		this.trainerScore = trainerScore;
	}
	


}
