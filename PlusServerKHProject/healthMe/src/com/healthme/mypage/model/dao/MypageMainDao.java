package com.healthme.mypage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.healthme.common.JDBCTemplate;
import com.healthme.mypage.model.vo.Mypage;
import com.healthme.trainer.model.vo.Matching;
import com.healthme.trainer.model.vo.Trainer;

public class MypageMainDao {

	// 멤버라면 n 트레이너라면 y
	public String searchMemberTrainer(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select memberTrainer from member where memberid=?";
		String result=null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getString("memberTrainer");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Mypage> searchMatching(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from matching where matchingmemberid= ?";
		
		ArrayList<Mypage> list = new ArrayList<Mypage>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			Mypage m = null;
			while(rset.next()) {
				// 디비순서대로 값을 가져온다.
				m = new Mypage();
				m.setMemberId(rset.getString("matchingMemberId"));	// 수강생
				m.setAbc(rset.getString("wishtrainercheck"));	// 매칭관계체크
				m.setTrainerId(rset.getString("matchedmemberId"));	// 트레이너
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public String searchTrainerSubject(Connection conn, String trainer) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select trainersubject from trainer where memberid = ?";
		
		String result = "";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, trainer);
			rset = pstmt.executeQuery();
			while(rset.next()) {	//가져올값이 여러개일때 사용.
				result = rset.getString("trainersubject");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

}





