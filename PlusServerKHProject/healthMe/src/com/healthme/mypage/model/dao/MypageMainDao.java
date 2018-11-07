package com.healthme.mypage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.healthme.common.JDBCTemplate;
import com.healthme.mypage.model.vo.Mypage;
import com.healthme.mypage.model.vo.MypageTrainer;

public class MypageMainDao {

	// 멤버라면 n 트레이너라면 y
	public String searchMemberTrainer(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select memberTrainer from member where memberid=?";
		String result=null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getString("memberTrainer");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	// 자기자신의 id / 트레이너id / 매칭관계가 담겨 있다.
	public ArrayList<Mypage> searchMatching1(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from matching where matchingmemberid= ?";
		
		ArrayList<Mypage> list = new ArrayList<Mypage>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			Mypage m = null;
			while(rset.next()) {
				// 디비순서대로 값을 가져온다.
				m = new Mypage();
				m.setMemberId(memberId);	// 수강생
				m.setAbc(rset.getString("wishtrainercheck").charAt(0));	// 매칭관계체크
				m.setTrainerId(rset.getString("matchedmemberId"));	// 트레이너
				list.add(m);
			}
			//System.out.println("마이 다오 : searchmatching1");
			for(Mypage m1 : list) {
				int count =1;
				//System.out.println("m"+count+":"+ m1.getMemberId()+m1.getAbc()+m1.getTrainerId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	//트레이너 id와 별점을 가지고 온다.
	public ArrayList<MypageTrainer> searchMatching2(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		// 여기서 트레이너인경우는 본인이 매칭되었으므로 Where matchedMemberid = ' '로 조건을 줘야됨!! 
		String query = "select * from matching where matchedMemberid= ? and wishtrainercheck=?";
		
		ArrayList<MypageTrainer> list = new ArrayList<MypageTrainer>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);	//this memberid = trainerid
			pstmt.setString(2, "b");		// 수업신청 중 인원
			rset = pstmt.executeQuery();
			MypageTrainer m = null;
			ArrayList<String> mlist1 = new ArrayList<String>();
			ArrayList<String> mlist2 = new ArrayList<String>();
			ArrayList<String> mlist3 = new ArrayList<String>();
			ArrayList<String> mlist4 = new ArrayList<String>();
			while(rset.next()) { // 디비순서대로 값을 가져온다.
				m = new MypageTrainer();
				m.setTrainerId(rset.getString("matchedmemberId"));		// 트레이너아이디
				mlist1.add(rset.getString("matchingmemberid"));
				list.add(m);
				mlist1.add(rset.getString("MATCHINGSUBJECT"));
				mlist1.add(rset.getString("MATCHINGCONTENTS"));
				mlist1.add(rset.getString("MATCHINGDATE"));
			}
			m.setMemberList(mlist1);
			m.setApplyingClassSubject(mlist2);
			m.setApplyingClassContent(mlist3);
			m.setApplyingClassSendDate(mlist4);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
//		for(MypageTrainer m : list) {
//			System.out.println("Dao 서치: "+m.getMemberList()+"\t"+m.getApplyingClassSubject()
//					+m.getApplyingClassContent()+"\t"+m.getApplyingClassSendDate());
//		}
		return list;
	}

	// 관심 abc에 따른 트레이너의 정보(강사사진 지역 종목 강의주제 )를 가져온다.
	public Mypage searchTrainer(Connection conn, String trainerId, Mypage mypage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from trainer where memberid = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, trainerId);
			rset = pstmt.executeQuery();
			while(rset.next()) {	//가져올값이 여러개일때 사용.
				mypage.setTrainerSubject(rset.getString("trainersubject"));
				mypage.setProfile(rset.getString("profilefile"));
				mypage.setTrainerRegion(rset.getString("trainerRegion"));
				mypage.setTrainerEvent(rset.getString("trainerEvent"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		//System.out.println("마이 다오다오 searchTrainer : "+ mypage.getTrainerSubject()+
				//mypage.getProfile()+mypage.getTrainerRegion()+mypage.getTrainerEvent()+mypage.getTrainerSubject());
		return mypage;
	}

	// 트레이너가 등록한 사진을 가져온다.
	public String searchTrainerProfilefile(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from trainer where memberid = ?";
		
		String result = "";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);	//this memberid = trainerid
			rset = pstmt.executeQuery();
			while(rset.next()) {	//가져올값이 여러개일때 사용.
				result = rset.getString("profilefile");	// 트레이너가 등록한 사진을 가져온다.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		//System.out.println("마이페이지 다오다오 searchTrainerProfilefile: "+ result);
		return result;
	}

	// 트레이너를 호감으로 찍은사람의 인원을 세는 함수
	public String searchMatchingACount(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) as count from matching where matchedmemberid = ? and wishtrainercheck=?";
		
		String result ="";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);	//여기서 memberId는 = Trainerid
			pstmt.setString(2, "a");	// a = 호감리스트
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				result = rset.getString("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
//		System.out.println("my다오 CountA :" + result);
		return result;
	}

	public String searchMatchingBCount(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) as count from matching where matchedmemberid = ? and wishtrainercheck=?";
		
		String result ="";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);	//여기서 memberId는 = Trainerid
			pstmt.setString(2, "b");	// a = 호감리스트
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				result = rset.getString("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
//		System.out.println("my다오 CountB :" + result);
		return result;
	}

	public String searchMatchingCCount(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select count(*) as count from matching where matchedmemberid = ? and wishtrainercheck=?";
		
		String result ="";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);	//여기서 memberId는 = Trainerid
			pstmt.setString(2, "c");	// a = 호감리스트
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				result = rset.getString("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
//		System.out.println("my다오 CountC :" + result);
		return result;
	}

	public Mypage searchTrainerName(Connection conn, String trainerId, Mypage mypage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from member where memberid = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, trainerId);
			rset = pstmt.executeQuery();
			while(rset.next()) {	//가져올값이 여러개일때 사용.
				mypage.setTrainerName(rset.getString("membername"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		//System.out.println("마이 다오다오  : "+ mypage.getTrainerSubject());
		return mypage;
	}

	public int starSearch(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int starScore=0;
		String query = "select round(avg(matchingScore)) AS result from matching where matchedMemberId =? and (matchingScore between 0 and 5)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				starScore = rset.getInt("result"); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return starScore;

	}

	public MypageTrainer searchTrainer(Connection conn, String memberId, MypageTrainer mypageTrainer) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from trainer where memberid = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);		//여기서 memberId = trainerId
			rset = pstmt.executeQuery();
			while(rset.next()) {	//가져올값이 여러개일때 사용.
				mypageTrainer.setTrainerSubject(rset.getString("trainersubject"));
				mypageTrainer.setProfile(rset.getString("profilefile"));
				mypageTrainer.setTrainerRegion(rset.getString("trainerRegion"));
				mypageTrainer.setTrainerEvent(rset.getString("trainerEvent"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		//System.out.println("마이 다오다오 searchTrainer : "+ mypage.getTrainerSubject()+
				//mypage.getProfile()+mypage.getTrainerRegion()+mypage.getTrainerEvent()+mypage.getTrainerSubject());
		return mypageTrainer;
	}

}