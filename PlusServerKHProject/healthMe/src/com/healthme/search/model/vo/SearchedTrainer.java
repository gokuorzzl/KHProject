package com.healthme.search.model.vo;

public class SearchedTrainer {

	private String memberId; //트레이너 아이디 -> member테이블
	private String profileFile; //트레이너 사진 -> imagecollect테이블
	private String memberName; //트레이너 이름 -> member테이블
	private String trainerScore; //트레이너 점수 -> member테이블
	private String trainerEvent; //트레이너 종목 -> member테이블
	
	public SearchedTrainer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SearchedTrainer(String memberId, String profileFile, String memberName, String trainerScore,
			String trainerEvent) {
		super();
		this.memberId = memberId;
		this.profileFile = profileFile;
		this.memberName = memberName;
		this.trainerScore = trainerScore;
		this.trainerEvent = trainerEvent;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getProfileFile() {
		return profileFile;
	}

	public void setProfileFile(String profileFile) {
		this.profileFile = profileFile;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getTrainerScore() {
		return trainerScore;
	}

	public void setTrainerScore(String trainerScore) {
		this.trainerScore = trainerScore;
	}

	public String getTrainerEvent() {
		return trainerEvent;
	}

	public void setTrainerEvent(String trainerEvent) {
		this.trainerEvent = trainerEvent;
	}
	
	
	
	
	
}
