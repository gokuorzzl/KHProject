package com.healthme.mypage.model.vo;

public class Mypage {
	// 회원일경우 필요 정보 : 
	// 관심 및 수업신청 트레이너정보 : 강사사진 이름 지역 종목 소개
	private String memberId;	//매칭신청한 회원id
	private String memberName;	//회원 이름
	
	private String trainerId;	//매칭받은 트레이너id
	private String trainerName;	//트레이너 이름
	private String trainerRegion;		//강의 위치
	private String trainerEvent;		//운동 종목
	private String trainerSubject;		//수업 이름	(트레이너테이블에 있음)
	private char abc;			//매칭관계 a:호감리스트 / b:수업신청중 / c:수업신청완료
	private char isTraner;		//트레이너여부 확인
 
	private String Profile;			// 트레이너의 사진위치
	private int matchingCountA;		// a-호감표시인원
	private int matchingCountB;		// b-수업신청인원 	-매칭테이블
	private int matchingCountC;		// c- 수업신청인원
	private String matchingScore;	// 트레이너 별점		-매칭테이블
	
	public Mypage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mypage(String memberId, String memberName, String trainerId, String trainerName, String trainerRegion,
			String trainerEvent, String trainerSubject, char abc, char isTraner, String profile, int matchingCountA,
			int matchingCountB, int matchingCountC, String matchingScore) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.trainerId = trainerId;
		this.trainerName = trainerName;
		this.trainerRegion = trainerRegion;
		this.trainerEvent = trainerEvent;
		this.trainerSubject = trainerSubject;
		this.abc = abc;
		this.isTraner = isTraner;
		Profile = profile;
		this.matchingCountA = matchingCountA;
		this.matchingCountB = matchingCountB;
		this.matchingCountC = matchingCountC;
		this.matchingScore = matchingScore;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getTrainerRegion() {
		return trainerRegion;
	}

	public void setTrainerRegion(String trainerRegion) {
		this.trainerRegion = trainerRegion;
	}

	public String getTrainerEvent() {
		return trainerEvent;
	}

	public void setTrainerEvent(String trainerEvent) {
		this.trainerEvent = trainerEvent;
	}

	public String getTrainerSubject() {
		return trainerSubject;
	}

	public void setTrainerSubject(String trainerSubject) {
		this.trainerSubject = trainerSubject;
	}

	public char getAbc() {
		return abc;
	}

	public void setAbc(char abc) {
		this.abc = abc;
	}

	public char getIsTraner() {
		return isTraner;
	}

	public void setIsTraner(char isTraner) {
		this.isTraner = isTraner;
	}

	public String getProfile() {
		return Profile;
	}

	public void setProfile(String profile) {
		Profile = profile;
	}

	public int getMatchingCountA() {
		return matchingCountA;
	}

	public void setMatchingCountA(int matchingCountA) {
		this.matchingCountA = matchingCountA;
	}

	public int getMatchingCountB() {
		return matchingCountB;
	}

	public void setMatchingCountB(int matchingCountB) {
		this.matchingCountB = matchingCountB;
	}

	public int getMatchingCountC() {
		return matchingCountC;
	}

	public void setMatchingCountC(int matchingCountC) {
		this.matchingCountC = matchingCountC;
	}

	public String getMatchingScore() {
		return matchingScore;
	}

	public void setMatchingScore(String matchingScore) {
		this.matchingScore = matchingScore;
	}
	
	
	
	
	
}
