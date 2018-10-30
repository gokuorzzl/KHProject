package com.healthme.search.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.healthme.common.JDBCTemplate;
import com.healthme.member.vo.Member;
import com.healthme.search.model.vo.SearchedTrainer;

public class SearchDao {

	public ArrayList<SearchedTrainer> searchBarTrainer(Connection conn, ArrayList<String> searchList) {
		
		//쿼리문 전송에 이용할 객체 생성
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		//결과 담을 리스트 생성
		ArrayList<SearchedTrainer> tmpTrainer = new ArrayList<>();

		//전송할 쿼리문 -> TRAINER테이블로부터  아이디, 프로필사진경로, 트레이너 근무지역, 종목을 가져옴
		String query = "SELECT MEMBERID, PROFILEFILE, TRAINERREGION, TRAINEREVENT FROM TRAINER WHERE "; 
		//WHERE조건을 완성하기 위해 검색어 리스트 수만큼 for문을 실행
		for(int i=0 ; i<searchList.size() ; i++) {
			if(i==searchList.size()-1) {
				query += "TRAINERREGION LIKE ? OR TRAINEREVENT LIKE ? ";
			} else {
				query += "TRAINERREGION LIKE ? OR TRAINEREVENT LIKE ? OR ";
			}
			
		}
		
		try {
			
			//커넥션을 이용해 PreparedStatement생성
			pstmt = conn.prepareStatement(query);
			
			//?에 들어갈 요소 지정
			int index=1;
			for(int i=0 ; i<searchList.size() ; i++) {				
				pstmt.setString(index, '%' + searchList.get(i) + '%');
				index++;
				pstmt.setString(index, '%' + searchList.get(i) + '%');
				index++;
			}
			
			//쿼리문 전송 및 결과 받기
			rset = pstmt.executeQuery();
			
			//결과 저장
			while(rset.next()) {
				SearchedTrainer sT = new SearchedTrainer();
				sT.setMemberId(rset.getString("MEMBERID"));
				sT.setProfileFile(rset.getString("PROFILEFILE"));
				sT.setTrainerEvent(rset.getString("TRAINEREVENT"));
				sT.setTrainerRegion(rset.getString("TRAINERREGION"));
				tmpTrainer.add(sT);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return tmpTrainer;
	}

	public String searchBarTrainerName(Connection conn, String memberId) {
		
		//쿼리문 전송에 이용할 객체 생성
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		//결과 저장할 String
		String memberName = null;
		
		//쿼리문
		String query = "SELECT MEMBERNAME FROM MEMBER WHERE MEMBERID = ?";
		
		try {
			
			//커넥션을 이용해 PreparedStatement객체 생성
			pstmt = conn.prepareStatement(query);
			
			//?에 들어갈 요소 지정
			pstmt.setString(1, memberId);
			
			//쿼리문 전송 및 결과 받기
			rset = pstmt.executeQuery();
			
			//결과는 하나이므로 있는지만 검사
			if(rset.next()) {
				memberName = rset.getString("MEMBERNAME");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return memberName;
	}

	public Integer searchBarTrainerScore(Connection conn, String memberId) {
		
		//쿼리문 전송에 이용할 객체 생성
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		//결과 저장할 String
		int matchingScore = 0;
		
		//쿼리문
		String query = "SELECT AVG(MATCHINGSCORE) AS SCOREAVG FROM MATCHING WHERE MATCHEDMEMBERID = ? ";
		
		try {
			
			//커넥션을 이용해 PreparedStatement객체 생성
			pstmt = conn.prepareStatement(query);
			
			//?에 들어갈 요소 지정
			pstmt.setString(1, memberId);
			
			//쿼리문 전송 및 결과 받기
			rset = pstmt.executeQuery();
			
			//결과가 있으면 결과값의 평균이, 없으면 0이 리턴됨
			if(rset.next()) {
				matchingScore = rset.getInt("SCOREAVG");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return matchingScore;
		
	}

	
		



}
