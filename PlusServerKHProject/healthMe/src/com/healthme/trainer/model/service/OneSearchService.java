package com.healthme.trainer.model.service;

import java.sql.Connection;

import com.healthme.common.JDBCTemplate;
import com.healthme.trainer.model.dao.OneSearchDao;
import com.healthme.trainer.model.vo.Trainer;

public class OneSearchService {

	public Trainer onsSearch(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		Trainer t = new OneSearchDao().oneSearch(conn, memberId);
		
		JDBCTemplate.close(conn);
		
		return t;
	}

}
