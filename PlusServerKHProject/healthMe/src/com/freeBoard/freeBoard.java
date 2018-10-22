package com.freeBoard;

import java.sql.Date;

public class freeBoard {
	
	private int freeNum;
    private String freeTitle;
    private String freeContent;
    private int freeAvailable;
    private Date freeDeleteDate;
    private Date freeInsertDate;
    private int freeHits;
    private char freeNotice;
    
    
    
    
	@Override
	public String toString() {
		return "freeBoard [freeNum=" + freeNum + ", freeTitle=" + freeTitle + ", freeContent=" + freeContent
				+ ", freeAvailable=" + freeAvailable + ", freeDeleteDate=" + freeDeleteDate + ", freeInsertDate="
				+ freeInsertDate + ", freeHits=" + freeHits + ", freeNotice=" + freeNotice + "]";
	}
	
	
	
	
	public freeBoard() {
		super();
		// TODO Auto-generated constructor stub
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
	public char getFreeNotice() {
		return freeNotice;
	}
	public void setFreeNotice(char freeNotice) {
		this.freeNotice = freeNotice;
	}
    
    
    


}
