package com.healthme.trainer.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegisterDao {

	public void insertRegister(Connection conn, String trainerId, String trainerSubject, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query ="insert into matching values(?,?,?,?)";
		
		
	}

}
