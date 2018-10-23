package com.healthme.admin.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.healthme.admin.model.dao.AdminDao;
import com.healthme.admin.vo.Admin;
import com.healthme.common.JDBCTemplate;
import com.healthme.member.vo.Member;

public class AdminService {

	public Admin selectOneAdmin(String adminID, String adminPwd)
	{
		Connection conn = JDBCTemplate.getConnection();
		Admin admin = new AdminDao().selectOneAdmin(adminID,adminPwd,conn);
		
		JDBCTemplate.close(conn);
		
		return admin;
		
		
	}

	public ArrayList<Member> adminAllList() {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Member> list = new AdminDao().AdminAllList(conn);
		
		JDBCTemplate.close(conn);
		
		
		
		return list;
	}
	
	
}
