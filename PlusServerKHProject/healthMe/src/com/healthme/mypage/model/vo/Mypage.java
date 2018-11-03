package com.healthme.mypage.model.vo;

public class Mypage {
	private String trainerName;	//매칭된 트레이너 이름
	private String subject;		//수업이름
	private String abc;			//매칭관계 a:호감리스트 / b:수업신청중 / c:수업신청완료
	private String Profile;	//트레이너의 사진위치
	
	public Mypage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mypage(String trainerName, String subject, String profile) {
		super();
		this.trainerName = trainerName;
		this.subject = subject;
		Profile = profile;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAbc() {
		return abc;
	}
	public void setAbc(String abc) {
		this.abc = abc;
	}
	public String getProfile() {
		return Profile;
	}
	public void setProfile(String profile) {
		Profile = profile;
	}
	
	
}
