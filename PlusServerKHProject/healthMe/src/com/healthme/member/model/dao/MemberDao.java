package com.healthme.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.healthme.common.JDBCTemplate;
import com.healthme.member.vo.Member;

public class MemberDao {
   
	public Member selectOneMember(String memberId, String memberPw, Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from member where memberId=? "
				+ "and memberPw=? ";
		
		Member member = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member = new Member();
				member.setMemberId(rset.getString("memberId"));
				member.setMemberPw(rset.getString("memberPw"));
				member.setMemberName(rset.getString("memberName"));
				member.setMemberSocialId(rset.getString("socialId"));
				member.setMemberAddr(rset.getString("memberAddr"));
				member.setMemberPhone(rset.getString("memberPhone"));
				member.setMemberEmail(rset.getString("memberEmail"));
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		return member;
		
	}
	
	public int insertMember(Connection conn, Member m) {
		
		PreparedStatement pstmt = null;

		int result = 0;
		
		String query= "insert into member values(?,?,?,?,?,?,?)";
		
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
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
 	
	public String checkId(String checkId, Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select memberId from member where memberId=?";
		
		String memberId = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, checkId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				memberId = rset.getString("memberId");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
	
		return memberId;
		
	}

	public String searchId(String fmemberName, String fmemberSocialId, String fmemberPhone, Connection conn) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select memberId from member where membername=? and membersocialId=? and memberphone=?";
		
		String memberId =null;
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, fmemberName);
			pstmt.setString(2, fmemberSocialId);
			pstmt.setString(3, fmemberPhone);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				memberId = rset.getString("memberId");
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return memberId;
	}

	public String searchPw(String fmemberId, String fmemberSocialId, String fmemberPhone, Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select memberPw from member where memberId=? and membersocialId=? and memberphone=?";
		
		String memberPw =null;
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, fmemberId);
			pstmt.setString(2, fmemberSocialId);
			pstmt.setString(3, fmemberPhone);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				memberPw = rset.getString("memberPw");
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return memberPw;
	}
	
	
	
	
	
	
	
	
	
}
