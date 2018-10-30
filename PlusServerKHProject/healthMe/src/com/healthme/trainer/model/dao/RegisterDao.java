package com.healthme.trainer.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {

	public void insertRegister(Connection conn, String trainerId, String trainerSubject, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query ="insert into matching values(?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, String.valueOf('b'));
			pstmt.setString(3, trainerId);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
