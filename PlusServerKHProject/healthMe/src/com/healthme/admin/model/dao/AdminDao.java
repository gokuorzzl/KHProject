package com.healthme.admin.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.healthme.admin.vo.Admin;
import com.healthme.common.JDBCTemplate;
import com.healthme.member.vo.Member;

public class AdminDao {

	public Admin selectOneAdmin(String adminID, String adminPwd, Connection conn) {
		//select 구문을 처리하기 위한 변수 생성
		//(PreparedStatement, ResultSet, String query)
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from admin where adminID=? and adminPw=?";
		
		Admin admin = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, adminID);
			pstmt.setString(2, adminPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				admin = new Admin();
				admin.setAdminId(rset.getString("adminID"));
				admin.setAdminPW(rset.getString("adminPwd"));
				admin.setMemberMange(rset.getString("memberMange"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		return admin;
		
		
	
	}

}
