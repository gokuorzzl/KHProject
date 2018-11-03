package com.healthme.mypage.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.healthme.common.JDBCTemplate;
import com.healthme.mypage.model.dao.MypageMainDao;
import com.healthme.mypage.model.vo.Mypage;

public class MypageMainService {
	
	public ArrayList<Mypage> searchMemberTrainer(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		String isTrainer = new MypageMainDao().searchMemberTrainer(conn, memberId); 
		//현재 회원이 트레이너인지 아닌지 ex) y=트레이너
		//일단 멤버일경우
		
		ArrayList<Mypage> mylist = new MypageMainDao().searchMatching(conn, memberId); //매칭테이블에서 회원/트레이너/매칭abc를 가져온다.
		
		if(isTrainer =="y") { //트레이너 일경우
			
		}
		else {	//멤버일 경우
			// 매칭되어있는 트레이너 리스트의 갯수에 따라 매칭관계 및 트레이너 강의주제를 가져온다.
			// 1.중복인경우 어떻게 처리할 것인가?
			for(int i=0; i<mylist.size(); i++) {
				//2. 트레이너의 강의주제를 가져온다.
				String subject = new MypageMainDao().searchTrainerSubject(conn, mylist.get(i).getTrainerId());
				mylist.get(i).setSubject(subject);
			}
		}
		JDBCTemplate.close(conn);
		return mylist;
	}
}
