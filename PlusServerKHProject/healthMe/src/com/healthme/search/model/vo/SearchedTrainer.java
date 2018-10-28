package com.healthme.search.model.vo;

public class SearchedTrainer {

	//SELECT MEMBERID, PROFILEFILE, TRAINERREGION, TRAINEREVENT FROM TRAINER
	private String memberId; //trainer테이블 -> 트레이너 ID
							//관리자가 증명을 확인하고 MEMBER테이블의 트레이너 여부를 'y'로 변경하고트레이너테이블에 추가해주므로
							//검색시 트레이너가 맞는지 여부를 별도로 확인할 필요는 없음ㄴ
	private String profileFile; //trainer 테이블 -> 트레이너 프로필 사진
	private String trainerRegion; //trainer 테이블 -> 지역
	private String trainerEvent; //trainer 테이블 -> 종목
	
	public SearchedTrainer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SearchedTrainer(String memberId, String profileFile, String trainerRegion, String trainerEvent) {
		super();
		this.memberId = memberId;
		this.profileFile = profileFile;
		this.trainerRegion = trainerRegion;
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
	
}
