package com.healthme.community.model.vo;

import java.sql.Date;

public class Comment {
	private int boardNum; //게시글 번호
    private String memberID; //게시글 아이디 
    private int commentNumber; //댓글번호
    private Date commentInsertDate; //등록날짜
    private String commentContent; //댓글 내용
	private int commentAvailable;
	private Date commentDeleteDate;
	
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Comment(int boardNum, String memberID, int commentNumber, Date commentInsertDate, String commentContent,
			int commentAvailable, Date commentDeleteDate) {
		super();
		this.boardNum = boardNum;
		this.memberID = memberID;
		this.commentNumber = commentNumber;
		this.commentInsertDate = commentInsertDate;
		this.commentContent = commentContent;
		this.commentAvailable = commentAvailable;
		this.commentDeleteDate = commentDeleteDate;
	}

	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public int getCommentNumber() {
		return commentNumber;
	}
	public void setCommentNumber(int commentNumber) {
		this.commentNumber = commentNumber;
	}
	public Date getCommentInsertDate() {
		return commentInsertDate;
	}
	public void setCommentInsertDate(Date commentInsertDate) {
		this.commentInsertDate = commentInsertDate;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public int getCommentAvailable() {
		return commentAvailable;
	}
	public void setCommentAvailable(int commentAvailable) {
		this.commentAvailable = commentAvailable;
	}
	public Date getCommentDeleteDate() {
		return commentDeleteDate;
	}
	public void setCommentDeleteDate(Date commentDeleteDate) {
		this.commentDeleteDate = commentDeleteDate;
	}
    
   
}
