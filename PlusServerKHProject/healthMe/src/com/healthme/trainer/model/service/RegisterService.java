package com.healthme.trainer.model.service;

import java.sql.Connection;

import com.healthme.common.JDBCTemplate;
import com.healthme.trainer.model.dao.RegisterDao;

public class RegisterService {

	public void insertRegister(String trainerId, String trainerSubject, String userId) {
		Connection conn = JDBCTemplate.getConnection();
		
		new RegisterDao().insertRegister(conn, trainerId, trainerSubject, userId);
		
	}

}
