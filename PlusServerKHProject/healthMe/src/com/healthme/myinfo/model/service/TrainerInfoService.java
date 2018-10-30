package com.healthme.myinfo.model.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.healthme.common.JDBCTemplate;
import com.healthme.myinfo.model.dao.TrainerInfoDao;


public class TrainerInfoService {
	
	public int insertTrainerInfo(String trainerContent) {

		Connection conn = JDBCTemplate.getConnection();
		int result = new TrainerInfoDao().insertTrainerInfo(trainerContent,conn);
		
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
}