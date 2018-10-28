package com.healthme.trainer.vo;

import java.sql.Date;

import com.healthme.member.vo.Member;

public class Trainer extends Member {
	protected String profileFile;		//프로필사진경로 +이름
	protected String univ;	//트레이너 대학교(학교, 과)
	protected String trainerGradFile;	// 대학 졸업인증 파일
	protected char grad;	//(a:재학, b:졸업, c:수료)
	protected String gym; //직장주소
	protected String subject; // 수업제목 = 트레이너당 수업은 1개입니다.
	protected String content;	// 수업 내용
	protected String careerFile;	// 경력인증파일경로 1~5
	protected String careerStart1;	// 경력 시작날짜 1~5
	protected String careerEnd1;	// 경력 종료날짜 1~5
	protected String careerStart2;
	protected String careerEnd2;
	protected String careerStart3;
	protected String careerEnd3;
	protected String careerStart4;
	protected String careerEnd4;
	protected String careerStart5;
	protected String careerEnd5;
	protected String careerName1;
	protected String careerName2;
	protected String careerName3;
	protected String careerName4;
	protected String careerName5;
	protected String licenseFile;	// 자격인증 파일경로 1~5
	protected String licenseName1;	// 자격증1~5 이름
	protected String licenseName2;	
	protected String licenseName3;	
	protected String licenseName4;	
	protected String licenseName5;
	

	//생성자
	
	public Trainer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Trainer(int pkMemberNumber, String memberId, String memberPw, String memberName, String memberSocialId,
			String memberAddr, Date memberRegistDate, String memberClass, String memberEmail, String memberPhone,
			String memberTrainer, String memberOut, Date memberOutDate, String trainerFileName, String trainerContent,
			String trainerUniversity, String trainerEvent, String trainerRegion, String trainerScore) {
		super(pkMemberNumber, memberId, memberPw, memberName, memberSocialId, memberAddr, memberRegistDate, memberClass,
				memberEmail, memberPhone, memberTrainer, memberOut, memberOutDate, trainerFileName, trainerContent,
				trainerUniversity, trainerEvent, trainerRegion, trainerScore);
		// TODO Auto-generated constructor stub
	}
	public Trainer(String memberId, String memberPw) {
		super(memberId, memberPw);
		// TODO Auto-generated constructor stub
	}
	
	
	// getter & setter
	
	public String getProfileFile() {
		return profileFile;
	}
	public void setProfileFile(String profileFile) {
		this.profileFile = profileFile;
	}
	public String getUniv() {
		return univ;
	}
	public void setUniv(String univ) {
		this.univ = univ;
	}
	public String getTrainerGradFile() {
		return trainerGradFile;
	}
	public void setTrainerGradFile(String trainerGradFile) {
		this.trainerGradFile = trainerGradFile;
	}
	public char getGrad() {
		return grad;
	}
	public void setGrad(char grad) {
		this.grad = grad;
	}
	public String getGym() {
		return gym;
	}
	public void setGym(String gym) {
		this.gym = gym;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCareerFile() {
		return careerFile;
	}
	public void setCareerFile(String careerFile) {
		this.careerFile = careerFile;
	}
	public String getCareerStart1() {
		return careerStart1;
	}
	public void setCareerStart1(String careerStart1) {
		this.careerStart1 = careerStart1;
	}
	public String getCareerEnd1() {
		return careerEnd1;
	}
	public void setCareerEnd1(String careerEnd1) {
		this.careerEnd1 = careerEnd1;
	}
	public String getCareerStart2() {
		return careerStart2;
	}
	public void setCareerStart2(String careerStart2) {
		this.careerStart2 = careerStart2;
	}
	public String getCareerEnd2() {
		return careerEnd2;
	}
	public void setCareerEnd2(String careerEnd2) {
		this.careerEnd2 = careerEnd2;
	}
	public String getCareerStart3() {
		return careerStart3;
	}
	public void setCareerStart3(String careerStart3) {
		this.careerStart3 = careerStart3;
	}
	public String getCareerEnd3() {
		return careerEnd3;
	}
	public void setCareerEnd3(String careerEnd3) {
		this.careerEnd3 = careerEnd3;
	}
	public String getCareerStart4() {
		return careerStart4;
	}
	public void setCareerStart4(String careerStart4) {
		this.careerStart4 = careerStart4;
	}
	public String getCareerEnd4() {
		return careerEnd4;
	}
	public void setCareerEnd4(String careerEnd4) {
		this.careerEnd4 = careerEnd4;
	}
	public String getCareerStart5() {
		return careerStart5;
	}
	public void setCareerStart5(String careerStart5) {
		this.careerStart5 = careerStart5;
	}
	public String getCareerEnd5() {
		return careerEnd5;
	}
	public void setCareerEnd5(String careerEnd5) {
		this.careerEnd5 = careerEnd5;
	}
	public String getLicenseFile() {
		return licenseFile;
	}
	public void setLicenseFile(String licenseFile) {
		this.licenseFile = licenseFile;
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
	public String getCareerName1() {
		return careerName1;
	}
	public void setCareerName1(String careerName1) {
		this.careerName1 = careerName1;
	}
	public String getCareerName2() {
		return careerName2;
	}
	public void setCareerName2(String careerName2) {
		this.careerName2 = careerName2;
	}
	public String getCareerName3() {
		return careerName3;
	}
	public void setCareerName3(String careerName3) {
		this.careerName3 = careerName3;
	}
	public String getCareerName4() {
		return careerName4;
	}
	public void setCareerName4(String careerName4) {
		this.careerName4 = careerName4;
	}
	public String getCareerName5() {
		return careerName5;
	}
	public void setCareerName5(String careerName5) {
		this.careerName5 = careerName5;
	}	


}
