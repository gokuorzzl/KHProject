package com.healthme.admin.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.healthme.admin.model.dao.AdminDao;
import com.healthme.admin.vo.Ad;
import com.healthme.admin.vo.Admin;
import com.healthme.admin.vo.AdminMain;
import com.healthme.common.JDBCTemplate;
import com.healthme.community.model.vo.Board;
import com.healthme.member.vo.Member;
import com.healthme.trainer.model.vo.Matching;
import com.healthme.trainer.model.vo.Trainer;

public class AdminService {

	public Admin selectOneAdmin(String adminId, String adminPw)//로그인 세션 갖고오는거 활동 되나보보는것
	{
		Connection conn = JDBCTemplate.getConnection();
		Admin admin = new AdminDao().selectOneAdmin(adminId,adminPw,conn);
		
		JDBCTemplate.close(conn);
		
		return admin;
		
		
	}

	public int adminMemberAdminUpdate(Admin a) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminDao().adminMemberAdminUpdate(conn,a);
		System.out.println("서비스"+result);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		
		return result;
	}

	public ArrayList<Member> adminAllList() {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Member> list = new AdminDao().adminMemberAll(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public ArrayList<Trainer> adminAllListT() {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Trainer> list = new AdminDao().adminMemberAllT(conn);
		System.out.println("adminService"+list);
		JDBCTemplate.close(conn);
		
		
		return list;
	}

	public int adminAllSelectOneUpdate(int pkMemberNumber, String memberId, String memberPw, String memberName,
			String memberSocialId, String memberAddr, String memberEmail, String memberPhone, char memberTrainer,
			String memberClass, char memberOut) {
		// TODO Auto-generated method stub
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminDao().adminAllSelectOneUpdate(conn,pkMemberNumber,memberId,memberPw,memberName,memberSocialId,memberAddr,memberEmail,memberPhone,memberTrainer,memberClass,memberOut);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		
		
		return result;
	}

	public Member adminMemberUpdateSel(String memberId) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		
		Member m = new AdminDao().adminMemberUpdateSel(conn,memberId);
		
		JDBCTemplate.close(conn);
		
		
		
		return m;
	}

	//관리자용 정보수정 누를경우 정보 폼 띄우고 수정되는 곳
	public int adminMemberselUpdate(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new AdminDao().adminMemberselUpdate(conn,m);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		
		return result;
	}
	
	//관리자 회원설정에서 회원 삭제하는 것
	public int adminMemberDel(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
				
			int result = new AdminDao().adminMemberDel(conn,memberId);
			
			if(result>0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
			JDBCTemplate.close(conn);
		
		
		return result;
	}
	//트레이너관리에서 수정버튼 클릭시 정보갖고올 메소드
	public Trainer adminTrainerTUpdateSel(String memberId) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		Trainer t = new AdminDao().adminTrainerTUpdateSel(conn,memberId);
		
		
		
		return t;
	}
	//트레이너 정보 수정후 결과값 받는것
	public int adminTrainerselUpdate(Trainer t) {
		// TODO Auto-generated method stub
		
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new AdminDao().adminTrainerselUpdate(conn,t);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		
		return result;
		
		
		
	}
	//트레이너삭제
	public int adminTrainerDel(String memberId) {
		// TODO Auto-generated method stub
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminDao().adminTrainerDel(conn,memberId);
		
		//결과 리턴
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}

	//게시판 목록 출력하는것
	public ArrayList<Board> adminAllBoard() {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Board> list = new AdminDao().adminAllBoard(conn);
		
		JDBCTemplate.close(conn);
		
		
		return list;
	}
	//게시판 글 삭제하기
	public int adminBoardDell(String userId) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminDao().adminBoardDell(conn,userId);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		
		return result;
	}
	//매칭 된 회원 목록들 가져오기
	public ArrayList<Matching> adminMatchingAll() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Matching> list = new AdminDao().adminMatchingAll(conn);
		JDBCTemplate.close(conn);
		
		
		return list;
	}

	//광고설정 리스트 보여주는 곳
	public ArrayList<Ad> adminAdList() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Ad> list = new AdminDao().adminAdList(conn);
		JDBCTemplate.close(conn);
		
		return list;
	}

	//q&a 게시글 목록 가져오기
	public ArrayList<Board> adminAllQBoard() {
		// TODO Auto-generated method stub
		
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Board> list = new AdminDao().adminAllQBoard(conn);
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	
	
	
	
	//카운트수
	public AdminMain adminmembercount() {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		
		int adminmembercount  = new AdminDao().adminmembercount(conn);
		int admintmptrainercount  = new AdminDao().admintmptrainercount(conn);
		int admintrainercount  = new AdminDao().admintrainercount(conn);
		int adminMatchingcount  = new AdminDao().adminMatchingcount(conn);
		int adminquestioncount  = new AdminDao().adminquestioncount(conn);
		int adminfreecount  = new AdminDao().adminfreecount(conn);
		
		AdminMain am = new AdminMain();
		am.setMemberNum(adminmembercount);
		am.setTmptrainerNum(admintrainercount);
		am.setTrainerNum(adminMatchingcount);
		am.setMatchingNum(adminMatchingcount);
		am.setQuestionNum(adminquestioncount);
		am.setFreeNum(adminfreecount);
		
		
		JDBCTemplate.close(conn);
		
		
		return am;
	}
	//트레이너 허락구하는 목록보여주는 곳
	public ArrayList<Trainer> adminAllListTmp() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Trainer> list = new AdminDao().adminAllListTmp(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	//일시적 트레이너 값 갖고오기
	public int admintmpTrainer(String memberId) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		System.out.println("12312312312312312312321312312312321312312312312312312");
		
		Trainer tm = new AdminDao().admintmpselOnesel(conn,memberId);//tmptrainer정보갖고오기
		//tmptrainer에서 정보 갖고온후 trainer에 가입시긴후 삭제시키기
		System.out.println("123123123123123213123123123123123123123123123");
		 System.out.println(tm+"갖고왔나요!!!!!!!멤버아이디를??!?!?!!?!?/");
		 System.out.println(tm.getMemberId()+"갖고왔나요!!!!!!!멤버아이디를??!?!?!!?!?/");
		 
		int result1 = new AdminDao().admintmpTrainerdelete(conn,memberId);//삭제 메소드
		System.out.println("삭제시킨값은 0이상이다."+result1);
		
		int result2 = new AdminDao().admintmpTrainertoTrainer(conn,tm);//가입시키는 메소드
		
		int result=0;
		if(result1>0) {
			if(result2>0) {
				result=1;
			}
		}
		

		//결과 리턴
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
		
	}

	//게시글 공지 등록하는 것
	public int adminBoardNotice(String noticeSel, String title, String content) {
		// TODO Auto-generated method stub
		
		Connection conn = JDBCTemplate.getConnection();
		int result = 0;
		System.out.println("adminService의의의의의으이ㅣ"+noticeSel);
		if(noticeSel.equals("자유")) {
			System.out.println("자유실행");
			result = new AdminDao().adminBoardnotice(conn,content,title);
				
		}else {
			System.out.println("질문실행");
			result = new AdminDao().adminBoardnoticeq(conn,content,title);
		}
		
		return result;
	}

	

	
	

	
	
	
	

	
	

	
	
	
	
}
