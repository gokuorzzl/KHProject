package com.healthme.admin.vo;

import java.sql.Date;

public class Ad {

	private String company; //회사
	private String videoLink; //영상 링크
	private int profit; //수익
	private Date postStartDate;
	private Date postEndDate;
	
	public Ad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ad(String company, String videoLink, int profit, Date postStartDate, Date postEndDate) {
		super();
		this.company = company;
		this.videoLink = videoLink;
		this.profit = profit;
		this.postStartDate = postStartDate;
		this.postEndDate = postEndDate;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getVideoLink() {
		return videoLink;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	public int getProfit() {
		return profit;
	}

	public void setProfit(int profit) {
		this.profit = profit;
	}

	public Date getPostStartDate() {
		return postStartDate;
	}

	public void setPostStartDate(Date postStartDate) {
		this.postStartDate = postStartDate;
	}

	public Date getPostEndDate() {
		return postEndDate;
	}

	public void setPostEndDate(Date postEndDate) {
		this.postEndDate = postEndDate;
	}
	
	
	
	
}
