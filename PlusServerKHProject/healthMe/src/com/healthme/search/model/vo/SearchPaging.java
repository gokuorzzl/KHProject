package com.healthme.search.model.vo;

public class SearchPaging {

	private String pagingNavi; //navigation bar 
	private int start;  // 페이지 내 목록 시작번호
	private int end; //페이지 내 목록 끝번호 
	
	public SearchPaging() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SearchPaging(String pagingNavi, int start, int end) {
		super();
		this.pagingNavi = pagingNavi;
		this.start = start;
		this.end = end;
	}

	public String getPagingNavi() {
		return pagingNavi;
	}

	public void setPagingNavi(String pagingNavi) {
		this.pagingNavi = pagingNavi;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
	
}
