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

	public ArrayList<SearchedTrainer> searchMemberInfo(Connection conn, ArrayList<String> searchList) {
		
		//?부분에만 변화를 주어 계속 사용할 수 있는 PreparedStatement를 사용
		PreparedStatement pstmt = null;
		//결과를 담을 ResultSet
		ResultSet rset = null;
		//SearchedTrainer객체를 저장할 ArrayList<SearchedTrainer>
		ArrayList<SearchedTrainer> tmpMember = new ArrayList<>(); 
		
		//Member테이블로부터 id, name, score, event를 가져올 쿼리
		String query = "SELECT MEMBERID, MEMBERNAME, TRAINERSCORE, TRAINEREVENT FROM MEMBER WHERE "; 
		
		//searchList의 검색어만큼 쿼리문 생성 
		for(int i=0 ; i<searchList.size() ; i++) {
			query += "TRAINEREVENT LIKE ? OR TRAINERREGION LIKE ? ";
		}
		
		//사용자의 검색어는 종목 또는 지역이지만 단어만으로는 어떤 범주에 속하는지 알 수 없으므로 지역, 종목 두 필드 모두에 검색어를 넣어서 SELECT
		
		try {
			
			//Connection 객체를 이용해 query문을 전송할 PreparedStatement객체 생성
			pstmt = conn.prepareStatement(query);
			
			//?에 들어갈 요소 지정
			int index = 0; //값을 저장하기 위해 index지정
			for(int i=0 ; i<searchList.size()*2 ; i+=2) {
				//searchList의 검색어 하나당 ?가 두 개이므로 두 배만큼 for문 실행
				pstmt.setString(i, searchList.get(index));
				pstmt.setString(i+1, searchList.get(index));
				index++;//for문의 i와 별개로 searchList의 값을 가져오기 위함
			}
			
			//query문 마무리
			query += "ORDER BY TRAINERSCORE DESC";
			System.out.println(query);
			//쿼리문 전송 후 결과를 rset에 저장
			rset = pstmt.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return tmpMember;
		
	}//searchMemberInfo 메소드 종료
	
	public ArrayList<String> searchTrainerImg(Connection conn, ArrayList<SearchedTrainer> tmpMember) {
		
		//?부분에만 변화를 주어 계속 사용할 수 있는 PreparedStatement를 사용
		PreparedStatement pstmt = null;
		//결과를 담을 ResultSet
		ResultSet rset = null;
		//이미지 경로 리스트를 저장할 ArrayList<String>
		ArrayList<String> tmpImg = new ArrayList<>();
		
		//쿼리문 
		String query = "SELECT PROFILEFILE FROM IMGCOLLECT WHERE MEMBERID = ?";
		
		try {
			int index = 0; //리스트 내 검색어 이용을 위한 index
			
			while(!tmpMember.isEmpty() && index<=tmpMember.size()) {
				
				//pstmt객체 생성
				pstmt = conn.prepareStatement(query);
				
				//?에 들어갈 요소 지정
				pstmt.setString(1, tmpMember.get(index).getMemberId());
				
				//쿼리 전송 및 결과 저장
				rset = pstmt.executeQuery();
				
				//결과로 돌아온 이미지 경로를 저장
				if(rset.next()) {
					tmpImg.add(rset.getString("PROFILEFILE"));
				}
				
				//다음 아이디에 해당하는 결과를 가져오도록  index 증가
				index++;
				
			}//while문 끝
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return tmpImg;
	}//searchTrainerImg 메소드 종료


}
