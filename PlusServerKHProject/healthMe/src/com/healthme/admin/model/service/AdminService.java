package com.healthme.admin.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.healthme.admin.model.dao.AdminDao;
import com.healthme.admin.vo.Admin;
import com.healthme.common.JDBCTemplate;
import com.healthme.member.vo.Member;
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

	
	

	
	
	
	
}
