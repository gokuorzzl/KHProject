package com.healthme.trainer.model.vo;

import com.healthme.member.vo.Member;

public class SearchData {
	private Member m ;
	private Trainer t;

	
	public SearchData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SearchData(Member m, Trainer t) {
		super();
		this.m = m;
		this.t = t;
	}
	public Member getM() {
		return m;
	}
	public void setM(Member m) {
		this.m = m;
	}
	public Trainer getT() {
		return t;
	}
	public void setT(Trainer t) {
		this.t = t;
	}
	
	
	
	
}
