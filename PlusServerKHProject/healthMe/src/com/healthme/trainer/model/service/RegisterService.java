package com.healthme.trainer.model.service;

import java.sql.Connection;

import com.healthme.common.JDBCTemplate;
import com.healthme.trainer.model.dao.RegisterDao;

public class RegisterService {

	public int insertRegister(String trainerId, String userId) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new RegisterDao().insertRegister(conn, trainerId, userId);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int insertWishList(String trainerId, String userId) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new RegisterDao().insertWishList(conn, trainerId, userId);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;

	}

}
