package com.healthme.trainer.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.healthme.common.JDBCTemplate;

public class RegisterDao {

	public int insertRegister(Connection conn, String trainerId, String trainerSubject, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query ="insert into matching values(?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, String.valueOf('b'));
			pstmt.setString(3, trainerId);
			pstmt.setInt(4, -1);
			
			result = pstmt.executeUpdate();
						
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int insertWishList(Connection conn, String trainerId, String trainerSubject, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query ="insert into matching values(?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, String.valueOf('a'));
			pstmt.setString(3, trainerId);
			pstmt.setInt(4, -1);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

}
