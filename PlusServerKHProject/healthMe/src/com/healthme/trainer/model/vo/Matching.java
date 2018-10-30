package com.healthme.trainer.model.vo;

public class Matching {
	private String matchingMemberId;
	private String wishTrainerCheck;
	private String matchedMemberId;
	private String matchingScore;
	
	
	public Matching() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Matching(String matchingMemberId, String wishTrainerCheck, String matchedMemberId, String matchingScore) {
		super();
		this.matchingMemberId = matchingMemberId;
		this.wishTrainerCheck = wishTrainerCheck;
		this.matchedMemberId = matchedMemberId;
		this.matchingScore = matchingScore;
	}
	public String getMatchingMemberId() {
		return matchingMemberId;
	}
	public void setMatchingMemberId(String matchingMemberId) {
		this.matchingMemberId = matchingMemberId;
	}
	public String getWishTrainerCheck() {
		return wishTrainerCheck;
	}
	public void setWishTrainerCheck(String wishTrainerCheck) {
		this.wishTrainerCheck = wishTrainerCheck;
	}
	public String getMatchedMemberId() {
		return matchedMemberId;
	}
	public void setMatchedMemberId(String matchedMemberId) {
		this.matchedMemberId = matchedMemberId;
	}
	public String getMatchingScore() {
		return matchingScore;
	}
	public void setMatchingScore(String matchingScore) {
		this.matchingScore = matchingScore;
	}
	
	
}
