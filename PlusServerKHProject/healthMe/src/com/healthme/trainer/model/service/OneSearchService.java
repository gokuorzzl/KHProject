package com.healthme.trainer.model.service;

import java.sql.Connection;

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
		
		SearchData sd = new SearchData();
		
		sd.setM(m);
		sd.setT(t);
		
		JDBCTemplate.close(conn);
		
		return sd;
	}

}
