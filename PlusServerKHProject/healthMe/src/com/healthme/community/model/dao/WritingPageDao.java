package com.healthme.community.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.healthme.common.JDBCTemplate;

public class WritingPageDao {

	public int noticeWriting(String titleText, String contentsText, String passwordText, Connection conn) {
		PreparedStatement pstmt =null;
		int result = 0;
		String query = "insert into freeboard values(freeBoard_No.nextval,'userId',?,?,1,null,sysdate,0,default,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, titleText);
			pstmt.setString(2, contentsText);
			pstmt.setString(3, passwordText);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int QnAWriting(String titleText, String contentsText, String passwordText, Connection conn) {
		PreparedStatement pstmt =null;
		int result = 0;
		String query = "insert into questionBoard values(questionBoard_NO.nextval,'userId',?,?,1,null,sysdate,0,default,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, titleText);
			pstmt.setString(2, contentsText);
			pstmt.setString(3, passwordText);
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
