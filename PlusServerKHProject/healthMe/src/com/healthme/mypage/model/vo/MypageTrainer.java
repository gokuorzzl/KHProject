package com.healthme.mypage.model.vo;

import java.util.ArrayList;

public class MypageTrainer {
	// 회원일경우 필요 정보 ; 
	// 관심 및 수업신청 트레이너정보 : 강사사진 이름 지역 종목 소개
	private String trainerId;	//매칭받은 트레이너id
	private String trainerName;	//트레이너 이름
	private String trainerRegion;		//강의 위치
	private String trainerEvent;		//운동 종목
	private String trainerSubject;		//수업 이름	(트레이너테이블에 있음)
	private char abc;			//매칭관계 a:호감리스트 / b:수업신청중 / c:수업신청완료
	private char isTraner;		//트레이너여부 확인
	
	// 트레이너관련 정보 
	private ArrayList<String> memberList;	// 수업신청서를 보낸 회원리스트
	private ArrayList<String> applyingClassSubject;	// 수업신청서 제목리스트
	private ArrayList<String> applyingClassContent;	// 수업신청서 내용리스트
	private ArrayList<String> applyingClassSendDate;	// 수업신청서 보낸 날짜리스트
	
	private String Profile;			// 트레이너의 사진위치
	private int matchingCountA;		// a-호감표시인원
	private int matchingCountB;		// b-수업신청인원 	-매칭테이블
	private int matchingCountC;		// c- 수강인원
	private int matchingScore;	// 트레이너 별점		-매칭테이블
	
	
	public MypageTrainer() {
		super();
	}


	public MypageTrainer(String trainerId, String trainerName, String trainerRegion, String trainerEvent,
			String trainerSubject, char abc, char isTraner, ArrayList<String> memberList,
			ArrayList<String> applyingClassSubject, ArrayList<String> applyingClassContent,
			ArrayList<String> applyingClassSendDate, String profile, int matchingCountA, int matchingCountB,
			int matchingCountC, int matchingScore) {
		super();
		this.trainerId = trainerId;
		this.trainerName = trainerName;
		this.trainerRegion = trainerRegion;
		this.trainerEvent = trainerEvent;
		this.trainerSubject = trainerSubject;
		this.abc = abc;
		this.isTraner = isTraner;
		this.memberList = memberList;
		this.applyingClassSubject = applyingClassSubject;
		this.applyingClassContent = applyingClassContent;
		this.applyingClassSendDate = applyingClassSendDate;
		Profile = profile;
		this.matchingCountA = matchingCountA;
		this.matchingCountB = matchingCountB;
		this.matchingCountC = matchingCountC;
		this.matchingScore = matchingScore;
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


	public ArrayList<String> getMemberList() {
		return memberList;
	}


	public void setMemberList(ArrayList<String> memberList) {
		this.memberList = memberList;
	}


	public ArrayList<String> getApplyingClassSubject() {
		return applyingClassSubject;
	}


	public void setApplyingClassSubject(ArrayList<String> applyingClassSubject) {
		this.applyingClassSubject = applyingClassSubject;
	}


	public ArrayList<String> getApplyingClassContent() {
		return applyingClassContent;
	}


	public void setApplyingClassContent(ArrayList<String> applyingClassContent) {
		this.applyingClassContent = applyingClassContent;
	}


	public ArrayList<String> getApplyingClassSendDate() {
		return applyingClassSendDate;
	}


	public void setApplyingClassSendDate(ArrayList<String> applyingClassSendDate) {
		this.applyingClassSendDate = applyingClassSendDate;
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


	public int getMatchingScore() {
		return matchingScore;
	}


	public void setMatchingScore(int matchingScore) {
		this.matchingScore = matchingScore;
	}
	
	
	
}
