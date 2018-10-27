package com.healthme.search.model.vo;

public class SearchedTrainerResult extends SearchedTrainer{

	private String memberName;

	public SearchedTrainerResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SearchedTrainerResult(String memberId, String profileFile, String trainerRegion, String trainerEvent) {
		super(memberId, profileFile, trainerRegion, trainerEvent);
		// TODO Auto-generated constructor stub
	}

	public SearchedTrainerResult(String memberName) {
		super();
		this.memberName = memberName;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	
	
}
