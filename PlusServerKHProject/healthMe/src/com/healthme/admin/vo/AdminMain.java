package com.healthme.admin.vo;

public class AdminMain {

	
	
	int memberNum;
	int tmptrainerNum;
	int trainerNum;
	int matchingNum;
	int questionNum;
	int freeNum;
	
	
	
	
	
	public AdminMain() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AdminMain(int memberNum, int tmptrainerNum, int trainerNum, int matchingNum, int questionNum, int freeNum) {
		super();
		this.memberNum = memberNum;
		this.tmptrainerNum = tmptrainerNum;
		this.trainerNum = trainerNum;
		this.matchingNum = matchingNum;
		this.questionNum = questionNum;
		this.freeNum = freeNum;
	}
	
	
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public int getTmptrainerNum() {
		return tmptrainerNum;
	}
	public void setTmptrainerNum(int tmptrainerNum) {
		this.tmptrainerNum = tmptrainerNum;
	}
	public int getTrainerNum() {
		return trainerNum;
	}
	public void setTrainerNum(int trainerNum) {
		this.trainerNum = trainerNum;
	}
	public int getMatchingNum() {
		return matchingNum;
	}
	public void setMatchingNum(int matchingNum) {
		this.matchingNum = matchingNum;
	}
	public int getQuestionNum() {
		return questionNum;
	}
	public void setQuestionNum(int questionNum) {
		this.questionNum = questionNum;
	}
	public int getFreeNum() {
		return freeNum;
	}
	public void setFreeNum(int freeNum) {
		this.freeNum = freeNum;
	}
	
	
	
	
	
}
