package com.healthme.trainer.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.healthme.common.JDBCTemplate;
import com.healthme.member.vo.Member;
import com.healthme.trainer.model.dao.OneSearchDao;
import com.healthme.trainer.model.vo.SearchData;
import com.healthme.trainer.model.vo.Trainer;

public class OneSearchService {

	public SearchData onsSearch(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		Trainer t = new OneSearchDao().oneSearch(conn, memberId);
		Member m = new OneSearchDao().oneSearchName(conn, memberId);
		int starScore = new OneSearchDao().starSearch(conn, t);
		
		SearchData sd = new SearchData();
		
		sd.setM(m);
		sd.setT(t);
		sd.setStarScore(starScore);	
		JDBCTemplate.close(conn);
		return sd;
	}

	public ArrayList<Trainer> trainerSearch(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Trainer> trainerList = new OneSearchDao().trainerSearch(conn, memberId);
		
		JDBCTemplate.close(conn);
		return trainerList;
	}

}
