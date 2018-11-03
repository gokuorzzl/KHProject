package com.healthme.mypage.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import com.healthme.common.JDBCTemplate;
import com.healthme.mypage.model.dao.MypageMainDao;
import com.healthme.mypage.model.vo.Mypage;
import com.healthme.trainer.model.vo.Trainer;

public class MypageMainService {
	
	public ArrayList<Mypage> searchMemberTrainer(String memberId, ArrayList<Trainer> trainerList) {
		Connection conn = JDBCTemplate.getConnection();
		String isTrainer = new MypageMainDao().searchMemberTrainer(conn, memberId); 
		//현재 회원이 트레이너인지 아닌지 ex) y=트레이너
		//일단 멤버일경우
		
		ArrayList<Mypage> mylist= new ArrayList<Mypage>();
//		ArrayList<Mypage> alist= new ArrayList<Mypage>();
//		ArrayList<Mypage> blist= new ArrayList<Mypage>();
//		ArrayList<Mypage> clist= new ArrayList<Mypage>();
		if(isTrainer =="y") { //트레이너 일경우
			
		}
		else {	//멤버일 경우
			// 매칭되어있는 트레이너 리스트의 갯수에 따라 매칭관계 및 트레이너 강의주제를 가져온다.
			for(int i=0; i<trainerList.size(); i++) {
				Mypage my = new Mypage();
				//1. abc값 즉 매칭관계값을 가져온다.
				my.setAbc(new MypageMainDao().searchABC(conn, memberId, trainerList.get(i).toString()));
				//2. 트레이너의 강의주제를 가져온다.
				my.setSubject(new MypageMainDao().searchTrainerSubject(conn, trainerList.get(i).toString()));
				my.setTrainerName(trainerList.get(i).toString());
				mylist.add(my);
			}

			

			// 매칭관계값이 'b' = 신청서를 보낸상태
			// 매칭관계값이 'c' = 신청완료 상태
		}
		

		return mylist;
 		
 		
 		
	}

}
