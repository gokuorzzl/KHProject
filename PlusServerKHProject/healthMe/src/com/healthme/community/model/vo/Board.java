package com.healthme.community.model.vo;

import java.sql.Date;

public class Board {
	private int num; //게시글 번호  freeBoard_No questionBoard_NO
	private String userId;
	private String title; //제목
	private String content; //게시글 내용
	private int available; //삭제하지 않으면 1, 삭제한거면 0
	private Date deleteDate;
	private Date insertDate; //게시글 등록날짜
	private int hits;//조회수
	private String notice;//y이면 게시글 위로 n이면 기본값
	private int pwd;//게시글 비밀번호
	
	
	
	
	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Board(int num, String userId, String title, String content, int available, Date deleteDate, Date insertDate,
			int hits, String notice, int pwd) {
		super();
		this.num = num;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.available = available;
		this.deleteDate = deleteDate;
		this.insertDate = insertDate;
		this.hits = hits;
		this.notice = notice;
		this.pwd = pwd;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	public Date getDeleteDate() {
		return deleteDate;
	}
	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public int getPwd() {
		return pwd;
	}
	public void setPwd(int pwd) {
		this.pwd = pwd;
	}
	
	
	
	
	
	
}
