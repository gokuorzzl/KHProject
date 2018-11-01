package com.healthme.search.model.vo;

import java.util.ArrayList;

public class Keyword {
	
	private ArrayList<String> region;
	private ArrayList<String> field;
	
	public Keyword() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Keyword(ArrayList<String> region, ArrayList<String> field) {
		super();
		this.region = region;
		this.field = field;
	}

	public ArrayList<String> getRegion() {
		return region;
	}

	public void setRegion(ArrayList<String> region) {
		this.region = region;
	}

	public ArrayList<String> getField() {
		return field;
	}

	public void setField(ArrayList<String> field) {
		this.field = field;
	}
	
	
	
}
