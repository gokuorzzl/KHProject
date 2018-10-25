package com.healtme.search.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.healthme.common.JDBCTemplate;
import com.healthme.search.model.dao.SearchDao;
import com.healthme.search.model.vo.SearchedTrainer;
import com.healthme.search.model.vo.SearchedTrainerResult;

public class SearchService {

	public ArrayList<SearchedTrainerResult> searchBar(ArrayList<String> searchList, int currentPage) {
		
		//커넥션 생성
		Connection conn = JDBCTemplate.getConnection();
		//최종 결과를 저장할 ArrayList생성
		ArrayList<SearchedTrainerResult> trainerList = new ArrayList<>();
		
		//------------- Service에서 4번의 DAO호출 ----------------//
		//1. Member테이블로부터 아이디, 이름, 별점, 종목을 추출
		ArrayList<SearchedTrainer> tmpMember = new SearchDao().searchMemberInfo(conn, searchList);
		
		//2. IMAGECOLLECT테이블로부터 이미지 경로를 추출
		//tmpList 목록에 있는 ID만 전달해서 값을 가져와야 하므로 tmpList를 전송
		ArrayList<String> tmpImg = new SearchDao().searchTrainerImg(conn, tmpMember);
		
		
		//3. 현재 페이지에서 보여줄 리스트를 설정
		
		//4. 현재 페이지의 navigation bar 목록을 설정
		

//		//DAO로 전송
//		ArrayList<SearchedTrainer> trainerList = new SearchDao().searchBar(connMember, connImg, searchList);
//		//close
//		JDBCTemplate.close(connMember);
//		JDBCTemplate.close(connImg);
//		//return
		
		return trainerList;
		
	}
	
}
