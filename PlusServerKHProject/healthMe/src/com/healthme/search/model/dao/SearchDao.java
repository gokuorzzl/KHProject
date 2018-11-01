package com.healthme.search.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.healthme.common.JDBCTemplate;
import com.healthme.search.model.vo.Keyword;
import com.healthme.search.model.vo.SearchedTrainer;

public class SearchDao {

	public ArrayList<SearchedTrainer> searchBarTrainer(Connection conn, ArrayList<String> region, ArrayList<String> field) {
		
		//쿼리문 전송에 이용할 객체 생성
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		//결과 담을 리스트 생성
		ArrayList<SearchedTrainer> tmpTrainer = new ArrayList<>();
		
		//전송할 쿼리문 -> TRAINER테이블로부터  아이디, 프로필사진경로, 트레이너 근무지역, 종목을 가져옴
		String query = "SELECT MEMBERID, PROFILEFILE, TRAINERREGION, TRAINEREVENT FROM TRAINER WHERE "; 
		//WHERE조건을 완성하기 위해 검색어 리스트에 맞추어 처리
		//지역검색어는 AND로 연결
		if(!region.isEmpty()) {
			for(int i=0 ; i<region.size() ; i++) {
				if(i==0) {query += "(";} //시작일 때 "("를 넣어줌
				if(i==region.size()-1) {//마지막엔 연결연산자 없이 ")"를 닫아줌
					query += "TRAINERREGION LIKE ? )"; 
				}else {
					query += "TRAINERREGION LIKE ? AND ";
				}
			}
		}
		//지역검색과 종목검색은 AND로 연결하지만 종목검색 내에서는 OR로 연결
		if(!field.isEmpty()) {
			for(int i=0 ; i<field.size() ; i++) {
				if(i==0) {query += " AND (";} //시작일 때 "AND ("를 넣어줌
				if(i==field.size()-1) {//마지막엔 연결연산자 없이 ")"를 닫아줌
					query += "TRAINEREVENT LIKE ? )"; 
				}else {
					query += "TRAINEREVENT LIKE ? OR ";
				}
			}
		}

		try {
			
			//커넥션을 이용해 PreparedStatement생성
			pstmt = conn.prepareStatement(query);
			int index=1;
			//?에 들어갈 요소 지정
			if(!region.isEmpty()) {
				for(int i=0 ; i<region.size() ; i++) {
					pstmt.setString(index, '%' + region.get(i) + '%');
					index++;
				}
			}
			if(!field.isEmpty()) {
				for(int i=0 ; i<field.size() ; i++) {
					pstmt.setString(index, '%' + field.get(i) + '%');
				}
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
		String query = "SELECT AVG(MATCHINGSCORE) AS SCOREAVG FROM MATCHING "
						+ "WHERE MATCHEDMEMBERID = ? AND (MATCHINGSCORE BETWEEN 0 AND 5)";
		
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

	public boolean checkRegion(Connection conn, String search) {
		
		//쿼리문 전송에 이용할 객체 생성
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		//결과 저장할 넘버
		int resultNum = 0;
		//결과 저장할 Boolean
		boolean checkRegion = false;
		
		//쿼리문
		String query = "SELECT COUNT(*) AS RESULTNUM FROM REGION WHERE (AREA1 LIKE ? OR AREA2 LIKE ? OR AREA3 LIKE ?)";
		
		try {
			
			//커넥션을 이용해 PreparedStatement객체 생성
			pstmt = conn.prepareStatement(query);
			
			//?에 들어갈 요소 지정
			pstmt.setString(1, search);
			pstmt.setString(2, search);
			pstmt.setString(3, search);
			
			//쿼리문 전송 및 결과 받기
			rset = pstmt.executeQuery();
			
			//결과가 있으면 지역에 관한 검색어이므로 Region인지 체크하는 값을 true로 변경해줌
			if(rset.next()) {
				resultNum = rset.getInt("RESULTNUM");
			}
			System.out.println(resultNum);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		System.out.println(checkRegion);
		return checkRegion;
	}

	
		



}
