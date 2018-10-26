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

	public int adminMemberAdminUpdate(String adminPW, String adminId) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new AdminDao().adminMemberAdminUpdate(conn,adminPW,adminId);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		
		return result;
	}
	

	
	
	
	
}