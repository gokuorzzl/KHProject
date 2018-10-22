package com.healthme.admin.vo;

public class Admin {
	private String adminId;
	private String adminPW;
	private String memberMange;
	
	
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Admin(String adminId, String adminPW, String memberMange) {
		super();
		this.adminId = adminId;
		this.adminPW = adminPW;
		this.memberMange = memberMange;
	}
	
	
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminPW() {
		return adminPW;
	}
	public void setAdminPW(String adminPW) {
		this.adminPW = adminPW;
	}
	public String getMemberMange() {
		return memberMange;
	}
	public void setMemberMange(String memberMange) {
		this.memberMange = memberMange;
	}






}
