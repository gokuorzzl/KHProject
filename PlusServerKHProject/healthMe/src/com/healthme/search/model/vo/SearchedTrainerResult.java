package com.healthme.search.model.vo;

public class SearchedTrainerResult extends SearchedTrainer{

	private String profileFile;

	public SearchedTrainerResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SearchedTrainerResult(String memberId, String memberName, String trainerScore, String trainerEvent) {
		super(memberId, memberName, trainerScore, trainerEvent);
		// TODO Auto-generated constructor stub
	}

	public String getProfileFile() {
		return profileFile;
	}

	public void setProfileFile(String profileFile) {
		this.profileFile = profileFile;
	}
	
	
	
	
}
