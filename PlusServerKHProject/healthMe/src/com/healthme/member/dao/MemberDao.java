package com.healthme.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.healthme.member.vo.Member;

public class MemberDao {
   
	public Member selectOneMember(String memberId, String memberPw, Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from member where memberId=? "
				+ "and memberPw=? and memberOut='n'";
		
		Member member = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			
			rset = pstmt.executeQuery();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
		
	}
}
