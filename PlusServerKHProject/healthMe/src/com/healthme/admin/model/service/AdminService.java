package com.healthme.admin.model.service;

import java.sql.Connection;

import com.healthme.admin.model.dao.AdminDao;
import com.healthme.admin.vo.Admin;
import com.healthme.common.JDBCTemplate;

public class AdminService {

	public Admin selectOneAdmin(String adminID, String adminPwd)
	{
		Connection conn = JDBCTemplate.getConnection();
		Admin admin = new AdminDao().selectOneAdmin(adminID,adminPwd,conn);
		
		JDBCTemplate.close(conn);
		
		return admin;
		
		
	}
	
	
}
