package com.healthme.mypage.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.healthme.common.JDBCTemplate;
import com.healthme.mypage.model.dao.MypageMainDao;
import com.healthme.mypage.model.vo.Mypage;
import com.healthme.mypage.model.vo.MypageTrainer;

public class MypageMainService {
	
	public ArrayList<Mypage> memberMypage(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		
		// 회원에 대한 기본정보를 가져온다.
		ArrayList<Mypage> mmlist = new MypageMainDao().searchMatching1(conn, memberId);
		
		// 관심 abc에 따른 트레이너의 정보(강사사진 지역 종목 강의주제 )를 가져온다.
		for(int i=0; i<mmlist.size(); i++) {
			Mypage mypage = new MypageMainDao().searchTrainer(conn, mmlist.get(i).getTrainerId(), mmlist.get(i));
			mmlist.set(i, mypage);
			//trainer name을 넘겨받음
			mmlist.set(i, (new MypageMainDao().searchTrainerName(conn, mmlist.get(i).getTrainerId(), mmlist.get(i))));
//			System.out.println("마이서비스 트레이너 이름: "+mmlist.get(i).getTrainerName());
		}
		JDBCTemplate.close(conn);
		
		return mmlist;
	}

	public ArrayList<MypageTrainer> trainerMypage(String memberId) {
		//System.out.println("마이 서비스 trainerMypage입니당");
		// 여기서 memberId = TrainerId입니다
		Connection conn = JDBCTemplate.getConnection();
		
		// 총4번 다녀옴 (1) 트레이너 이미지경로, 주제 / 2) 매칭의 별점,아이디 / 3)멤버-트레이너abc 4) 위시리스트인원 5) 수강인원
		
		// 매칭테이블에서 트레이너아이디/별점
		ArrayList<MypageTrainer> tmlist = new MypageMainDao().searchMatching2(conn, memberId);
		
		for(int i=0; i<tmlist.size(); i++) {
			MypageTrainer mypage = new MypageMainDao().searchTrainer(conn, memberId, tmlist.get(0));
			tmlist.set(0, mypage);
			
			String a = new MypageMainDao().searchMatchingACount(conn, memberId); 
//			System.out.println("마이페이지 서비스 호감리스트 카운트다아아아: "+a);
			tmlist.get(0).setMatchingCountA(Integer.parseInt(a));//숫자로바꿔서 저장
			
			String b = new MypageMainDao().searchMatchingBCount(conn, memberId);
//			System.out.println("마이페이지서비스 수업신청서 갯수: "+b);
			tmlist.get(0).setMatchingCountB(Integer.parseInt(b));//숫자로 바꿔서 저장
			
			String c = new MypageMainDao().searchMatchingCCount(conn, memberId);
//			System.out.println("마이페이지서비스 수업 수강 인원: "+c);
			tmlist.get(0).setMatchingCountC(Integer.parseInt(c));//숫자로 바꿔저장
		}
		
		JDBCTemplate.close(conn);
		return tmlist;
	}
}









