package com.healthme.admin.vo;

public class Admin {
	private String adminId;
	private String adminPw;
	private String adminEmail;
	private String adminName;
	
	
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Admin(String adminId, String adminPw, String adminEmail, String adminName) {
		super();
		this.adminId = adminId;
		this.adminPw = adminPw;
		this.adminEmail = adminEmail;
		this.adminName = adminName;
	}
	
	
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminPw() {
		return adminPw;
	}
	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	


}
