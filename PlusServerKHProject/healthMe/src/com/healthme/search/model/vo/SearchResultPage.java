package com.healthme.search.model.vo;

import java.util.ArrayList;

public class SearchResultPage {

	private ArrayList<SearchedTrainerResult> resultList;
	private String pageNavi;
	
	public SearchResultPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SearchResultPage(ArrayList<SearchedTrainerResult> resultList, String pageNavi) {
		super();
		this.resultList = resultList;
		this.pageNavi = pageNavi;
	}

	public ArrayList<SearchedTrainerResult> getResultList() {
		return resultList;
	}

	public void setResultList(ArrayList<SearchedTrainerResult> resultList) {
		this.resultList = resultList;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	
	
	
}
