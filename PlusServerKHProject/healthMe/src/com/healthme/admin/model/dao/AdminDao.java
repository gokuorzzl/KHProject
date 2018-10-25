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

	public Admin selectOneAdmin(String adminID, String adminPwd, Connection conn) {
		//select 구문을 처리하기 위한 변수 생성
		//(PreparedStatement, ResultSet, String query)
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from admin where adminID=? and adminPw=?";
		
		Admin admin = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, adminID);
			pstmt.setString(2, adminPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				admin = new Admin();
				admin.setAdminId(rset.getString("adminID"));
				admin.setAdminPW(rset.getString("adminPwd"));
				admin.setMemberMange(rset.getString("memberMange"));
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

	public ArrayList<Member> AdminAllList(Connection conn) {
		// 여러명을 처리하기 위한 컬렉션을 사용
		
		ArrayList<Member> list = new ArrayList<Member>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from member order by active desc";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Member m = new Member();
				m.setMemberId(rset.getString("memberId"));
				m.setMemberPw(rset.getString("memberPw"));
				m.setMemberName(rset.getString("memberName"));
				m.setMemberSocialId(rset.getString("socialId"));
				m.setMemberAddr(rset.getString("memberAddr"));
				m.setMemberPhone(rset.getString("memberPhone"));
				m.setMemberEmail(rset.getString("memberEmail"));
			
				list.add(m);
				
			}
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		
		
		
		
		
		
		return list;
	}

	public int AdminInsert(Connection conn, Member m) {
		//멤버추가시 회원가입으로 넘어가서 회원가입하게끔 만들고 그후 그게 다시 정보페이지로 가서 갖고오는걸로 만들기
		
		PreparedStatement pstmt = null;
		int result=0;
		
		String query="insert into member values(?,?,?,?,?,?,?)";
		System.out.println(query);
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPw());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getMemberSocialId());
			pstmt.setString(5, m.getMemberAddr());
			pstmt.setString(6, m.getMemberPhone());
			pstmt.setString(7, m.getMemberEmail());
			
			
			result = pstmt.executeUpdate();		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		
		return result;
	}

	public int AdminUpdate(Connection conn, Member m) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;	
		
		String query = "update member set user_pwd=?, phone=?,email=?,address=?,"
				+ "hobby=? where user_id = ? ";

		try {
			pstmt = conn.prepareStatement(query);
			
			/* 멤버테이블 업데이트 하는거에 따라 값 바꿔보기
			pstmt.setString(1, m.getUserPwd());
			pstmt.setString(2, m.getPhone());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getHobby());
			pstmt.setString(6, m.getUserId());
			*/
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

}
