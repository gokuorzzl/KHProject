package com.healthme.trainer.model.vo;

import com.healthme.member.vo.Member;

public class SearchData {
	private Member m ;
	private Trainer t;
	private int starScore;

	public SearchData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SearchData(Member m, Trainer t, int starScore) {
		super();
		this.m = m;
		this.t = t;
		this.starScore = starScore;
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
	public int getStarScore() {
		return starScore;
	}
	public void setStarScore(int starScore) {
		this.starScore = starScore;
	}
}
