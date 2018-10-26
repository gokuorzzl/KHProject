package com.healthme.admin.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.healthme.admin.model.dao.AdminDao;
import com.healthme.admin.vo.Admin;
import com.healthme.common.JDBCTemplate;
import com.healthme.member.vo.Member;

public class AdminService {

	public Admin selectOneAdmin(String adminID, String adminPwd)//로그인 세션 갖고오는거 활동 되나보보는것
	{
		Connection conn = JDBCTemplate.getConnection();
		Admin admin = new AdminDao().selectOneAdmin(adminID,adminPwd,conn);
		
		JDBCTemplate.close(conn);
		
		return admin;
		
		
	}

	public ArrayList <Member> adminAllList() { //회원목록 전체 보기
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Member> list = new AdminDao().AdminAllList(conn);
		
		JDBCTemplate.close(conn);
		
		
		return list;
	}
	
	public int adminInsert(Member m) {//관리자에서 회원 맘대로 추가할수 있게끔 하기
		Connection conn = JDBCTemplate.getConnection();
		int result = new AdminDao().AdminInsert(conn,m);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		
		return result;
	}
	

	//관리자 정보변경
	public int updateAdmin(Admin a) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new AdminDao().updateAdmin(conn, a);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	
	
	
}
