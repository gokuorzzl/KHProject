package com.healthme.community.model.vo;

import java.sql.Date;

public class FreeBoard {
	private int freeNum; //게시글 번호  freeBoard_No questionBoard_NO
	private String freeTitle; //제목
	private String freeContent; //게시글 내용
	private int freeAvailable; //삭제하지 않으면 1, 삭제한거면 0
	private Date freeDeleteDate;//삭제 날짜
	private Date freeInsertDate; //게시글 등록날짜
	private int freeHits;//조회수
	private String freeNotice;//y이면 게시글 위로 n이면 기본값
	private int freePwd;//게시글 비밀번호
	
	public FreeBoard() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FreeBoard(int freeNum, String freeTitle, String freeContent, int freeAvailable, Date freeDeleteDate,
			Date freeInsertDate, int freeHits, String freeNotice, int freePwd) {
		super();
		this.freeNum = freeNum;
		this.freeTitle = freeTitle;
		this.freeContent = freeContent;
		this.freeAvailable = freeAvailable;
		this.freeDeleteDate = freeDeleteDate;
		this.freeInsertDate = freeInsertDate;
		this.freeHits = freeHits;
		this.freeNotice = freeNotice;
		this.freePwd = freePwd;
	}

	public int getFreePwd() {
		return freePwd;
	}
	public void setFreePwd(int freePwd) {
		this.freePwd = freePwd;
	}
	public int getFreeNum() {
		return freeNum;
	}
	public void setFreeNum(int freeNum) {
		this.freeNum = freeNum;
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
	public String getFreeNotice() {
		return freeNotice;
	}
	public void setFreeNotice(String freeNotice) {
		this.freeNotice = freeNotice;
	}
}
