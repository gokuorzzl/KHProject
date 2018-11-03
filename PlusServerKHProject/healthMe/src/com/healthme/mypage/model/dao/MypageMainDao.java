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

	public ArrayList<Matching> searchMatching(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from matching where memberid= ?";
		
		ArrayList<Matching> list = new ArrayList<Matching>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			
			Matching m = null;
			while(rset.next()) {
				// 디비순서대로 값을 가져온다. 매칭 = 유저 / 
				m = new Matching();
				m.setMatchingMemberId(rset.getString("matchingMemberId"));
				m.setWishTrainerCheck(rset.getString("wishtrainercheck"));
				m.setMatchedMemberId(rset.getString("matchedmemberId"));
				m.setMatchingScore(rset.getInt("matchingscore"));
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

	public void searchABCSubject(Connection conn, String memberId, Trainer trainer) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query1 = "select trainersubject from trainer where memberid = ?";
		String query2 = "select wishtrainercheck from matching where matchingmemberid = ? and matchedmemberid = ?";
		Mypage mp = new Mypage();
		Matching mc = new Matching();
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setString(2, query2);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	// 매칭관계 a,b,c 탐색함수
	public String searchABC(Connection conn, String memberId, String trainer) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select wishtrainercheck from matching where matchingmemberid = ? and matchedmemberid = ?";
		
		String result = "";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setString(2, trainer);
			rset = pstmt.executeQuery();
			while(rset.next()) {	//가져올값이 여러개일때 사용.
				result = rset.getString("wishtrainercheck");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
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





