package com.healthme.mypage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.healthme.common.JDBCTemplate;
import com.healthme.mypage.model.vo.Mypage;
import com.healthme.mypage.model.vo.TrainerMypage;
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

	public ArrayList<Mypage> searchMatching1(Connection conn, String memberId) {
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
				m.setAbc(rset.getString("wishtrainercheck").charAt(0));	// 매칭관계체크
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
	
	//트레이너일 경우 id와 별점을 가지고 온다.
	public ArrayList<Mypage> searchMatching2(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from matching where matchingmemberid= ?";
		
		ArrayList<Mypage> list = new ArrayList<Mypage>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);	//this memberid = trainerid
			rset = pstmt.executeQuery();
			Mypage m = null;
			while(rset.next()) { // 디비순서대로 값을 가져온다.
				m = new Mypage();
				m.setTrainerId(rset.getString("matchedmemberId"));		// 트레이너아이디
				m.setMatchingScore(rset.getString("matchingscore"));	// 별점
				
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		System.out.println("마이페이지메인다오 searchMatching2 : "+
				list.get(0).getMemberId()+list.get(0).getMatchingScore());
		return list;
	}

	// 관심 abc에 따른 트레이너의 정보(강사사진 이름 지역 종목 강의주제 )를 가져온다.
	public Mypage searchTrainer(Connection conn, String trainerId, Mypage mypage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from trainer where memberid = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, trainerId);
			rset = pstmt.executeQuery();
			while(rset.next()) {	//가져올값이 여러개일때 사용.
				mypage.setTrainerSubject(rset.getString("trainersubject"));
				mypage.setProfile(rset.getString("profilefile"));
				mypage.setTrainerRegion(rset.getString("trainerRegion"));
				mypage.setTrainerEvent(rset.getString("trainerEvent"));
				mypage.setTrainerSubject(rset.getString("trainerSubject"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		System.out.println("마이 다오다오 searchTrainerSubject : "+ mypage.getTrainerSubject()+
				mypage.getProfile()+mypage.getTrainerRegion()+mypage.getTrainerEvent()+mypage.getTrainerSubject());
		return mypage;
	}

	// 트레이너가 등록한 사진을 가져온다.
	public String searchTrainerProfilefile(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from trainer where memberid = ?";
		
		String result = "";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);	//this memberid = trainerid
			rset = pstmt.executeQuery();
			while(rset.next()) {	//가져올값이 여러개일때 사용.
				result = rset.getString("profilefile");	// 트레이너가 등록한 사진을 가져온다.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		System.out.println("마이페이지 다오다오 searchTrainerProfilefile: "+ result);
		return result;
	}

	// 트레이너를 호감으로 찍은사람의 인원을 세는 함수
	public String searchMatchingACount(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) from matching where matchedmemberid = ? and wishtrainercheck=?;";

		String result ="";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);	//여기서 memberId는 = Trainerid
			pstmt.setString(2, "a");	// a = 호감리스트
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				result = rset.getString(1);
			}
			System.out.println("result = "+result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		System.out.println("마이다오다오 searchMatchingACount : "+result);
		return result;
	}

	public String searchMatchingBCount(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) from matching where matchedmemberid = ? and wishtrainercheck=?;";

		String result ="";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);	//여기서 memberId는 = Trainerid
			pstmt.setString(2, "b");	// b = 수업신청 중
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				result = rset.getString(1);
			}
			System.out.println("result = "+result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		System.out.println("마이다오다오 searchMatchingBCount : "+result);
		return result;
	}

	public String searchMatchingCCount(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) from matching where matchedmemberid = ? and wishtrainercheck=?;";

		String result ="";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);	//여기서 memberId는 = Trainerid
			pstmt.setString(2, "c");	// c = 수업 신청완료 인원
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				result = rset.getString(1);
			}
			System.out.println("result = "+result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		System.out.println("마이다오다오 searchMatchingCCount : "+result);
		return result;
	}

}





