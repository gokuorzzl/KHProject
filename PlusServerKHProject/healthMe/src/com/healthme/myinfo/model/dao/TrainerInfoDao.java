package com.healthme.myinfo.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.healthme.common.JDBCTemplate;

public class TrainerInfoDao {

	public int insertTrainerInfo(String trainerContent, Connection conn) {

		PreparedStatement pstmt= null;
		int result = 0;
		String query ="insert into trainerInfo values(?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, trainerContent);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

}
