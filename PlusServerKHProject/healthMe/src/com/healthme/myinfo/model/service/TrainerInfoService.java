package com.healthme.myinfo.model.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.healthme.common.JDBCTemplate;
import com.healthme.myinfo.model.dao.TrainerInfoDao;
import com.healthme.myinfo.model.vo.TrainerInfo;

public class TrainerInfoService {
	
	public int insertTrainerInfo(TrainerInfo ti, String userId) {

		Connection conn = JDBCTemplate.getConnection();
		int result = new TrainerInfoDao().insertTrainerInfo(ti,userId, conn);
		System.out.println("TrainerInfoservice의값값값"+result);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
}