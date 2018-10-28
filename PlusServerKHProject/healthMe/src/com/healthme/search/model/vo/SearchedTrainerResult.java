package com.healthme.search.model.vo;

public class SearchedTrainerResult extends SearchedTrainer{

	private String memberName;
	private int matchingScore;
	public SearchedTrainerResult() {
	
	super();
		// TODO Auto-generated constructor stub
	}
	
	public SearchedTrainerResult(String memberId, String profileFile, String trainerRegion, String trainerEvent) {
		super(memberId, profileFile, trainerRegion, trainerEvent);
		// TODO Auto-generated constructor stub
	}

	public SearchedTrainerResult(String memberName, int matchingScore) {
		super();
		this.memberName = memberName;
		this.matchingScore = matchingScore;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getMatchingScore() {
		return matchingScore;
	}

	public void setMatchingScore(int matchingScore) {
		this.matchingScore = matchingScore;
	}
	
	
}
