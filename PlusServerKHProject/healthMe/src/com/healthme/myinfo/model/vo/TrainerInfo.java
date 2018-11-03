package com.healthme.myinfo.model.vo;

import java.sql.Date;

public class TrainerInfo {
	private String memberID;	//요거 Trainer.java에는 상속받아서  처리했어요~!
    private String profileFile; //프로필사진경로+이름까지
    private String trainerGradFile;//대학졸업인증파일
    private String trainerUniv;//대학교에 대한것(학교, 과)
    private char trainerGrad;//a:재학, b:졸업, c: 수료
    private String trainerRegion;//트레이너 직장 주소
    private String trainerSubject; //수업제목 = 1트레이너 = 1수업으로 제한!!
    private String trainerContent;//트레이너의 수업소개 들어가도록
    private String trainerEvent;//트레이너종목 
    private String trainerCareerFile;//경력인증파일
    private Date careerStart1;//경력 시작날짜1
	private Date careerEnd1; //경력 종료날짜1
	private String careerName1;//경력1
	private Date careerStart2;//경력 시작날짜2
	private Date careerEnd2;//경력 종료날짜2
	private String careerName2;//--경력2
	private Date careerStart3;//경력 시작날짜3
	private Date careerEnd3;//경력 종료날짜3
	private String careerName3;//경력3
	private Date careerStart4;//경력 시작날짜4
	private Date careerEnd4;//경력 종료날짜4
	private String careerName4;//경력4
	private Date careerStart5;//경력 시작날짜5
	private Date careerEnd5;//경력 종료날짜5
	private String careerName5;//트레이너 별점은 매칭테이블에서 가져올사람 알아서 처리하기
	private String trainerLicenseFile;//자격증인증파일
	private String licenseName1;//자격증1
	private String licenseName2;//자격증2
	private String licenseName3;//자격증3
	private String licenseName4;//자격증4
	private String licenseName5;//자격증5
	
	public TrainerInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TrainerInfo(String memberID, String profileFile, String trainerGradFile, String trainerUniv,
			char trainerGrad, String trainerRegion, String trainerSubject, String trainerContent, String trainerEvent,
			String trainerCareerFile, Date careerStart1, Date careerEnd1, String careerName1, Date careerStart2,
			Date careerEnd2, String careerName2, Date careerStart3, Date careerEnd3, String careerName3,
			Date careerStart4, Date careerEnd4, String careerName4, Date careerStart5, Date careerEnd5,
			String careerName5, String trainerLicenseFile, String licenseName1, String licenseName2,
			String licenseName3, String licenseName4, String licenseName5) {
		super();
		this.memberID = memberID;
		this.profileFile = profileFile;
		this.trainerGradFile = trainerGradFile;
		this.trainerUniv = trainerUniv;
		this.trainerGrad = trainerGrad;
		this.trainerRegion = trainerRegion;
		this.trainerSubject = trainerSubject;
		this.trainerContent = trainerContent;
		this.trainerEvent = trainerEvent;
		this.trainerCareerFile = trainerCareerFile;
		this.careerStart1 = careerStart1;
		this.careerEnd1 = careerEnd1;
		this.careerName1 = careerName1;
		this.careerStart2 = careerStart2;
		this.careerEnd2 = careerEnd2;
		this.careerName2 = careerName2;
		this.careerStart3 = careerStart3;
		this.careerEnd3 = careerEnd3;
		this.careerName3 = careerName3;
		this.careerStart4 = careerStart4;
		this.careerEnd4 = careerEnd4;
		this.careerName4 = careerName4;
		this.careerStart5 = careerStart5;
		this.careerEnd5 = careerEnd5;
		this.careerName5 = careerName5;
		this.trainerLicenseFile = trainerLicenseFile;
		this.licenseName1 = licenseName1;
		this.licenseName2 = licenseName2;
		this.licenseName3 = licenseName3;
		this.licenseName4 = licenseName4;
		this.licenseName5 = licenseName5;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getProfileFile() {
		return profileFile;
	}
	public void setProfileFile(String profileFile) {
		this.profileFile = profileFile;
	}
	public String getTrainerGradFile() {
		return trainerGradFile;
	}
	public void setTrainerGradFile(String trainerGradFile) {
		this.trainerGradFile = trainerGradFile;
	}
	public String getTrainerUniv() {
		return trainerUniv;
	}
	public void setTrainerUniv(String trainerUniv) {
		this.trainerUniv = trainerUniv;
	}
	public char getTrainerGrad() {
		return trainerGrad;
	}
	public void setTrainerGrad(char trainerGrad) {
		this.trainerGrad = trainerGrad;
	}
	public String getTrainerRegion() {
		return trainerRegion;
	}
	public void setTrainerRegion(String trainerRegion) {
		this.trainerRegion = trainerRegion;
	}
	public String getTrainerSubject() {
		return trainerSubject;
	}
	public void setTrainerSubject(String trainerSubject) {
		this.trainerSubject = trainerSubject;
	}
	public String getTrainerContent() {
		return trainerContent;
	}
	public void setTrainerContent(String trainerContent) {
		this.trainerContent = trainerContent;
	}
	public String getTrainerEvent() {
		return trainerEvent;
	}
	public void setTrainerEvent(String trainerEvent) {
		this.trainerEvent = trainerEvent;
	}
	public String getTrainerCareerFile() {
		return trainerCareerFile;
	}
	public void setTrainerCareerFile(String trainerCareerFile) {
		this.trainerCareerFile = trainerCareerFile;
	}
	public Date getCareerStart1() {
		return careerStart1;
	}
	public void setCareerStart1(Date careerStart1) {
		this.careerStart1 = careerStart1;
	}
	public Date getCareerEnd1() {
		return careerEnd1;
	}
	public void setCareerEnd1(Date careerEnd1) {
		this.careerEnd1 = careerEnd1;
	}
	public String getCareerName1() {
		return careerName1;
	}
	public void setCareerName1(String careerName1) {
		this.careerName1 = careerName1;
	}
	public Date getCareerStart2() {
		return careerStart2;
	}
	public void setCareerStart2(Date careerStart2) {
		this.careerStart2 = careerStart2;
	}
	public Date getCareerEnd2() {
		return careerEnd2;
	}
	public void setCareerEnd2(Date careerEnd2) {
		this.careerEnd2 = careerEnd2;
	}
	public String getCareerName2() {
		return careerName2;
	}
	public void setCareerName2(String careerName2) {
		this.careerName2 = careerName2;
	}
	public Date getCareerStart3() {
		return careerStart3;
	}
	public void setCareerStart3(Date careerStart3) {
		this.careerStart3 = careerStart3;
	}
	public Date getCareerEnd3() {
		return careerEnd3;
	}
	public void setCareerEnd3(Date careerEnd3) {
		this.careerEnd3 = careerEnd3;
	}
	public String getCareerName3() {
		return careerName3;
	}
	public void setCareerName3(String careerName3) {
		this.careerName3 = careerName3;
	}
	public Date getCareerStart4() {
		return careerStart4;
	}
	public void setCareerStart4(Date careerStart4) {
		this.careerStart4 = careerStart4;
	}
	public Date getCareerEnd4() {
		return careerEnd4;
	}
	public void setCareerEnd4(Date careerEnd4) {
		this.careerEnd4 = careerEnd4;
	}
	public String getCareerName4() {
		return careerName4;
	}
	public void setCareerName4(String careerName4) {
		this.careerName4 = careerName4;
	}
	public Date getCareerStart5() {
		return careerStart5;
	}
	public void setCareerStart5(Date careerStart5) {
		this.careerStart5 = careerStart5;
	}
	public Date getCareerEnd5() {
		return careerEnd5;
	}
	public void setCareerEnd5(Date careerEnd5) {
		this.careerEnd5 = careerEnd5;
	}
	public String getCareerName5() {
		return careerName5;
	}
	public void setCareerName5(String careerName5) {
		this.careerName5 = careerName5;
	}
	public String getTrainerLicenseFile() {
		return trainerLicenseFile;
	}
	public void setTrainerLicenseFile(String trainerLicenseFile) {
		this.trainerLicenseFile = trainerLicenseFile;
	}
	public String getLicenseName1() {
		return licenseName1;
	}
	public void setLicenseName1(String licenseName1) {
		this.licenseName1 = licenseName1;
	}
	public String getLicenseName2() {
		return licenseName2;
	}
	public void setLicenseName2(String licenseName2) {
		this.licenseName2 = licenseName2;
	}
	public String getLicenseName3() {
		return licenseName3;
	}
	public void setLicenseName3(String licenseName3) {
		this.licenseName3 = licenseName3;
	}
	public String getLicenseName4() {
		return licenseName4;
	}
	public void setLicenseName4(String licenseName4) {
		this.licenseName4 = licenseName4;
	}
	public String getLicenseName5() {
		return licenseName5;
	}
	public void setLicenseName5(String licenseName5) {
		this.licenseName5 = licenseName5;
	}
	
	
	
	
	
	
	
}
