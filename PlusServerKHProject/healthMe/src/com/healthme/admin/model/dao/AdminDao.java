package com.healthme.admin.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.healthme.admin.vo.Admin;
import com.healthme.common.JDBCTemplate;
import com.healthme.member.vo.Member;

public class AdminDao {

	public Admin selectOneAdmin(String adminId, String adminPw, Connection conn) {
		//select 구문을 처리하기 위한 변수 생성
		//(PreparedStatement, ResultSet, String query)
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from admin where adminId=? and adminPw=?";
		
		Admin admin = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, adminId);
			pstmt.setString(2, adminPw);
			
			rset = pstmt.executeQuery();
			
			
			System.out.println(adminId);
			System.out.println(adminPw);
			System.out.println(conn);
			
			
			if(rset.next()) {
				admin = new Admin();
				admin.setAdminId(rset.getString("adminId"));
				admin.setAdminPw(rset.getString("adminPw"));
				admin.setAdminEmail(rset.getString("adminEmail"));
				admin.setAdminName(rset.getString("adminName"));
			}

			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		return admin;
		
		
	
	}

	public int adminMemberAdminUpdate(Connection conn, Admin a) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result=0;
		
		String query = "update admin set adminpw=?, adminemail=?, adminname=? where adminid=? ";
		System.out.println("업데이트DAO"+result);
		
			try {
				pstmt = conn.prepareStatement(query);
				
				pstmt.setString(1, a.getAdminPw());
				pstmt.setString(2, a.getAdminEmail());
				pstmt.setString(3, a.getAdminName());
				pstmt.setString(4, a.getAdminId());
				
				
				
				result = pstmt.executeUpdate();
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(pstmt);
			}
		
		
		return result;
	}

	public ArrayList<Member> adminMemberAll(Connection conn) {
		// TODO Auto-generated method stub
		//여러명을 처리하기 위한 컬렉션을 사용 (ArrayList)
		
		ArrayList<Member> list = new ArrayList<Member>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from member where membertrainer='n'";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Member m = new Member();
				m.setPkMemberNumber(rset.getInt("pkMemberNumber"));
				m.setMemberId(rset.getString("memberId"));
				m.setMemberPw(rset.getString("memberPw"));
				m.setMemberName(rset.getString("memberName"));
				m.setMemberSocialId(rset.getString("memberSocialId"));
				m.setMemberAddr(rset.getString("memberAddr"));
				m.setMemberEmail(rset.getString("memberEmail"));
				m.setMemberPhone(rset.getString("memberPhone"));
				m.setMemberTrainer(rset.getString("memberTrainer").charAt(0));
				m.setMemberClass(rset.getString("memberClass"));
				m.setMemberOut(rset.getString("memberOut").charAt(0));
				m.setMemberRegistDate(rset.getDate("memberRegistDate"));
				m.setMemberOutDate(rset.getDate("memberOutDate"));
				
				list.add(m);
				
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		
		return list;
	}



}
