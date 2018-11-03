package com.healthme.mypage.model.vo;

public class Mypage {
	private String memberId;	//매칭신청한 회원id
	private String trainerId;	//매칭받은 트레이너id
	private String subject;		//수업이름	(트레이너테이블에 있음)
	private String abc;			//매칭관계 a:호감리스트 / b:수업신청중 / c:수업신청완료
	private String Profile;		//트레이너의 사진위치
	
	
	public Mypage(String memberId, String trainerId, String subject, String abc, String profile) {
		super();
		this.memberId = memberId;
		this.trainerId = trainerId;
		this.subject = subject;
		this.abc = abc;
		Profile = profile;
	}

	public Mypage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
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
