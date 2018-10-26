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
