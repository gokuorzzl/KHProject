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

	public ArrayList<SearchedTrainer> searchBar(Connection connMember, Connection connImg, ArrayList<String> searchList) {
		
		//?부분에만 변화를 주어 계속 사용할 수 있는 PreparedStatement(Statement는 한 번만 를 사용해서 부하를 줄임
		PreparedStatement pstmtMember = null;
		PreparedStatement pstmtImg = null;
		//결과를 담을 rset
		ResultSet rsetMember = null;
		ResultSet rsetImg = null;
		//SearchedTrainer객체를 저장할 ArrayList<SearchedTrainer>
		ArrayList<SearchedTrainer> trainerList = new ArrayList<>(); 
		
		try {
			
			//------------ MEMBER테이블로부터 id, name, score, event를 가져옴 ---------------------//
			//쿼리문
			String queryMember = "SELECT MEMBERID, MEMBERNAME, TRAINERSCORE, TRAINEREVENT FROM MEMBER WHERE ";
			for(int i=0 ; i<searchList.size() ; i++) {//where절의 내용을 String형태로 계속 추가해줌
				if(i==searchList.size()-1) {//searchList()
					queryMember += "TRAINEREVENT = ?";
				}else {
					queryMember += "TRAINEREVENT = ? OR ";
				}
			}
			//Connection 객체를 이용해 query문을 전송할 PreparedStatement객체 생성
			pstmtMember = connMember.prepareStatement(queryMember);
			//?에 들어갈 요소 지정
			for(int i=0 ; i<searchList.size() ; i++) {
				pstmtMember.setString(i+1, "\"%" + searchList.get(i) + "%\""); 
			}
			//rsetMember에 결과 저장
			rsetMember = pstmtMember.executeQuery();
			//rset에 저장된 결과를 SearchedTrainer객체에 저장 후 ArrayList<SearchedTrainer>에 저장 
			if(rsetMember.next()) {
				//결과를 담을 SearchedTrainer객체
				SearchedTrainer trainer = new SearchedTrainer();
				trainer.setMemberId(rsetMember.getString("MEMBERID"));
				trainer.setProfileFile(null);//아이디값을 이용해 IMAGECOLLECT 테이블에서 이미지 경로를 가져올 것이므로 일단 비워둠
				trainer.setMemberName(rsetMember.getString("MEMBERNAME"));
				trainer.setTrainerScore(rsetMember.getString("TRAINERSCORE"));
				trainer.setTrainerEvent(rsetMember.getString("TRAINEREVENT"));
				trainerList.add(trainer); //ArrayList에 객체 추가 
			}
			
			//------------ IMAGECOLLECT테이블로부터 profilefile을 가져옴 ---------------------//
			//쿼리문 
			String queryImg = "SELECT PROFILEFILE FROM IMGCOLLECT WHERE MEMBERID = ?";
			pstmtImg = connImg.prepareStatement(queryImg);
			for(int i=0 ; i<trainerList.size() ; i++) { //위에서 저장한 SearchedTrainer객체의 리스트에 이미지 요소를 추가하기 위해 for문 실행
				pstmtImg.setString(i+1, trainerList.get(i).getMemberId());  //리스트의 i번째 객체의 아이디를 이용해 쿼리문의 ?부분을 채움
				rsetImg = pstmtImg.executeQuery(); //쿼리문 전송
				trainerList.get(i).setProfileFile(rsetImg.getString("PROFILEFILE")); //리스트의 i번째 객체의 이미지 부분을 채움
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rsetImg);
			JDBCTemplate.close(rsetMember);
			JDBCTemplate.close(pstmtImg);
			JDBCTemplate.close(pstmtMember);
		}
		
		return trainerList;
	}

}
