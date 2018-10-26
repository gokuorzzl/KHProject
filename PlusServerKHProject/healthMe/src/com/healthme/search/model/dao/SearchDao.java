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
		String query = "SELECT MEMBERID, MEMBERNAME, TRAINERSCORE, TRAINEREVENT FROM MEMBER WHERE TRAINEREVENT = ? OR TRAINERREGION = ?";
		//사용자의 검색어는 종목 또는 지역이지만 단어만으로는 어떤 범주에 속하는지 알 수 없으므로 지역, 종목 두 필드 모두에 검색어를 넣어서 SELECT
		
		try {
			
			int index = 0; //리스트 내 검색어 이용을 위한 index
			boolean check = false; //Id 중복검사를 위한 변수
								//중복되는 아이디가 있는 경우 true, 중복되는 id가 없는 경우 false
			SearchedTrainer trainer = new SearchedTrainer(); //결과를 담을 SearchedTrainer객체
			
			while(!searchList.isEmpty() && index<=searchList.size()) {//검색어 수만큼 DB 검색을 수행
				
				//Connection 객체를 이용해 query문을 전송할 PreparedStatement객체 생성
				pstmt = conn.prepareStatement(query);
				
				//?에 들어갈 요소 지정
				pstmt.setString(1, searchList.get(index)); //종목필드 검색
				pstmt.setString(2, searchList.get(index)); //지역필드 검색
				
				//rsetMember에 결과 저장
				rset = pstmt.executeQuery();
				
				//rset에 저장된 결과를 SearchedTrainer객체에 저장 후 ArrayList<SearchedTrainer>에 저장 
				if(rset.next()) {
					
					//두 번 검색하므로 겹치는 ID가 있을경우 저장하지 않음
					String memberId = rset.getString("MEMBERID"); //아이디를 먼저 저장
					
					for(int i=0 ; i<tmpMember.size() ; i++) {
						if(memberId==tmpMember.get(i).getMemberId()) {
							//새로 검색된 memberId와 tmpList내의 memberId가 같을 경우 결과를 담지 않음
							check = true;
							break;
						}
					}
					
					if(check==true) { //tmpList 내에 중복되는 ID가 존재하는 경우 저장하지 않음
						check = false; //check 초기화
						index++; //index값 증가
						continue;
					}else {
						trainer.setMemberName(rset.getString("MEMBERNAME"));
						trainer.setTrainerScore(rset.getString("TRAINERSCORE"));
						trainer.setTrainerEvent(rset.getString("TRAINEREVENT"));
						tmpMember.add(trainer); //ArrayList에 객체 추가 
						check = false; //check 초기화
						index++; //index값 증가
					}
 
				}//rset.next() if문 종료
			}//while문 종료
			
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
