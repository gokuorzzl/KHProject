package com.healthme.search.model.vo;

import java.util.ArrayList;

public class SearchResult {

	private ArrayList<SearchedTrainerResult> trainerList;
	private int recordPerPage;
	private String pageNavi;
	
	public SearchResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SearchResult(ArrayList<SearchedTrainerResult> trainerList, int recordPerPage, String pageNavi) {
		super();
		this.trainerList = trainerList;
		this.recordPerPage = recordPerPage;
		this.pageNavi = pageNavi;
	}

	public ArrayList<SearchedTrainerResult> getTrainerList() {
		return trainerList;
	}

	public void setTrainerList(ArrayList<SearchedTrainerResult> trainerList) {
		this.trainerList = trainerList;
	}

	public int getRecordPerPage() {
		return recordPerPage;
	}

	public void setRecordPerPage(int recordPerPage) {
		this.recordPerPage = recordPerPage;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	
	
	
	
	
}
