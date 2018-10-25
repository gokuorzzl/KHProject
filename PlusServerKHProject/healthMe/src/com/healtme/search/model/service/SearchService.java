package com.healtme.search.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.healthme.common.JDBCTemplate;
import com.healthme.search.model.dao.SearchDao;
import com.healthme.search.model.vo.SearchedTrainer;

public class SearchService {

	public ArrayList<SearchedTrainer> searchBar(ArrayList<String> searchList) {
		
		//커넥션
		Connection connMember = JDBCTemplate.getConnection();
		Connection connImg = JDBCTemplate.getConnection();
		//DAO로 전송
		ArrayList<SearchedTrainer> trainerList = new SearchDao().searchBar(connMember, connImg, searchList);
		//close
		JDBCTemplate.close(connMember);
		JDBCTemplate.close(connImg);
		//return
		return trainerList;
		
	}
	
}
