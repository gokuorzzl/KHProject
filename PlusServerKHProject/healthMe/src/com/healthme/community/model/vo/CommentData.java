package com.healthme.community.model.vo;

import java.util.ArrayList;

public class CommentData {
	private ArrayList<Comment> list;
	private String pageNavi;
	private Board b;
	
	public CommentData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommentData(ArrayList<Comment> list, String pageNavi, Board b) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
		this.b = b;
	}
	public ArrayList<Comment> getList() {
		return list;
	}
	public void setList(ArrayList<Comment> list) {
		this.list = list;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	public Board getB() {
		return b;
	}
	public void setB(Board b) {
		this.b = b;
	}
	
	
	
	
}
