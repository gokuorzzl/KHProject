package com.healthme.admin.vo;

import java.sql.Date;

public class AdminFreeBoard {
	private int freeNum; 
	private String memberId; 
	private String freeTitle; 
	private String freeContent;
	private int freeAvailable;
	private Date freeDeleteDate;
	private Date freeInsertDate; 
	private int freeHits;
	private char freeNotice;
	private int freePwd;
	
	
	
	
	
	
	
	public AdminFreeBoard() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public AdminFreeBoard(int freeNum, String memberId, String freeTitle, String freeContent, int freeAvailable,
			Date freeDeleteDate, Date freeInsertDate, int freeHits, char freeNotice, int freePwd) {
		super();
		this.freeNum = freeNum;
		this.memberId = memberId;
		this.freeTitle = freeTitle;
		this.freeContent = freeContent;
		this.freeAvailable = freeAvailable;
		this.freeDeleteDate = freeDeleteDate;
		this.freeInsertDate = freeInsertDate;
		this.freeHits = freeHits;
		this.freeNotice = freeNotice;
		this.freePwd = freePwd;
	}
	public int getFreeNum() {
		return freeNum;
	}
	public void setFreeNum(int freeNum) {
		this.freeNum = freeNum;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getFreeTitle() {
		return freeTitle;
	}
	public void setFreeTitle(String freeTitle) {
		this.freeTitle = freeTitle;
	}
	public String getFreeContent() {
		return freeContent;
	}
	public void setFreeContent(String freeContent) {
		this.freeContent = freeContent;
	}
	public int getFreeAvailable() {
		return freeAvailable;
	}
	public void setFreeAvailable(int freeAvailable) {
		this.freeAvailable = freeAvailable;
	}
	public Date getFreeDeleteDate() {
		return freeDeleteDate;
	}
	public void setFreeDeleteDate(Date freeDeleteDate) {
		this.freeDeleteDate = freeDeleteDate;
	}
	public Date getFreeInsertDate() {
		return freeInsertDate;
	}
	public void setFreeInsertDate(Date freeInsertDate) {
		this.freeInsertDate = freeInsertDate;
	}
	public int getFreeHits() {
		return freeHits;
	}
	public void setFreeHits(int freeHits) {
		this.freeHits = freeHits;
	}
	public char getFreeNotice() {
		return freeNotice;
	}
	public void setFreeNotice(char freeNotice) {
		this.freeNotice = freeNotice;
	}
	public int getFreePwd() {
		return freePwd;
	}
	public void setFreePwd(int freePwd) {
		this.freePwd = freePwd;
	}
	
	
	
	
}
