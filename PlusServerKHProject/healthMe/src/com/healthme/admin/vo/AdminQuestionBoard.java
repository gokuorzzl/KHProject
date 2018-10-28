package com.healthme.admin.vo;

import java.sql.Date;

public class AdminQuestionBoard {

	private int qboardNum; 
	private String memberId; 
	private String qboardTitle; 
	private String qboardContent;
	private int qboardAvailable;
	private Date qboardDeleteDate;
	private Date qboardInsertDate; 
	private int qboardHits;
	private char qboardNotice;
	private int qboardPwd;
	
	
	
	
	public AdminQuestionBoard() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AdminQuestionBoard(int qboardNum, String memberId, String qboardTitle, String qboardContent,
			int qboardAvailable, Date qboardDeleteDate, Date qboardInsertDate, int qboardHits, char qboardNotice,
			int qboardPwd) {
		super();
		this.qboardNum = qboardNum;
		this.memberId = memberId;
		this.qboardTitle = qboardTitle;
		this.qboardContent = qboardContent;
		this.qboardAvailable = qboardAvailable;
		this.qboardDeleteDate = qboardDeleteDate;
		this.qboardInsertDate = qboardInsertDate;
		this.qboardHits = qboardHits;
		this.qboardNotice = qboardNotice;
		this.qboardPwd = qboardPwd;
	}
	
	
	public int getQboardNum() {
		return qboardNum;
	}
	public void setQboardNum(int qboardNum) {
		this.qboardNum = qboardNum;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getQboardTitle() {
		return qboardTitle;
	}
	public void setQboardTitle(String qboardTitle) {
		this.qboardTitle = qboardTitle;
	}
	public String getQboardContent() {
		return qboardContent;
	}
	public void setQboardContent(String qboardContent) {
		this.qboardContent = qboardContent;
	}
	public int getQboardAvailable() {
		return qboardAvailable;
	}
	public void setQboardAvailable(int qboardAvailable) {
		this.qboardAvailable = qboardAvailable;
	}
	public Date getQboardDeleteDate() {
		return qboardDeleteDate;
	}
	public void setQboardDeleteDate(Date qboardDeleteDate) {
		this.qboardDeleteDate = qboardDeleteDate;
	}
	public Date getQboardInsertDate() {
		return qboardInsertDate;
	}
	public void setQboardInsertDate(Date qboardInsertDate) {
		this.qboardInsertDate = qboardInsertDate;
	}
	public int getQboardHits() {
		return qboardHits;
	}
	public void setQboardHits(int qboardHits) {
		this.qboardHits = qboardHits;
	}
	public char getQboardNotice() {
		return qboardNotice;
	}
	public void setQboardNotice(char qboardNotice) {
		this.qboardNotice = qboardNotice;
	}
	public int getQboardPwd() {
		return qboardPwd;
	}
	public void setQboardPwd(int qboardPwd) {
		this.qboardPwd = qboardPwd;
	}
	
	
	
	
	
}
