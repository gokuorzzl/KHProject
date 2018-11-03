package com.healthme.member.model.dao;

import java.sql.Connection;
import java.sql.Date;
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
				+ "and memberPw=? and memberOut='n'";
		
		Member member = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member = new Member();
				member.setPkMemberNumber(rset.getInt("pkMemberNumber"));
				member.setMemberId(rset.getString("memberId"));
				member.setMemberPw(rset.getString("memberPw"));
				member.setMemberName(rset.getString("memberName"));
				member.setMemberSocialId1(rset.getInt("memberSocialId1"));
				member.setMemberSocialId2(rset.getInt("memberSocialId2"));
				member.setMemberAddr(rset.getString("memberAddr"));
				member.setMemberEmail(rset.getString("memberEmail"));
				member.setMemberPhone(rset.getString("memberPhone"));
				member.setMemberTrainer(rset.getString("memberTrainer").charAt(0));
				member.setMemberClass(rset.getString("memberClass"));
				member.setMemberOut(rset.getString("memberOut").charAt(0));
				member.setMemberRegistDate(rset.getDate("memberRegistDate"));
				member.setMemberOutDate(rset.getDate("memberOutDate"));
				
				
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
		
		String query= "insert into member values(MEMBER_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,sysdate)";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPw());
			pstmt.setString(3, m.getMemberName());
			pstmt.setInt(4, m.getMemberSocialId1());
			pstmt.setInt(5, m.getMemberSocialId2());
			pstmt.setString(6, m.getMemberAddr());
			pstmt.setString(7, m.getMemberEmail());
			pstmt.setString(8, m.getMemberPhone());
			pstmt.setString(9, String.valueOf(m.getMemberTrainer()));
			pstmt.setString(10, m.getMemberClass());
			pstmt.setString(11, String.valueOf(m.getMemberOut()));
			
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

	public String searchId(String fmemberName, int fmemberSocialId1, int fmemberSocialId2, String fmemberPhone, Connection conn) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select memberId from member where membername=? and membersocialId1=? and membersocialId2=? and memberphone=?";
		
		String memberId =null;
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, fmemberName);
			pstmt.setInt(2, fmemberSocialId1);
			pstmt.setInt(3, fmemberSocialId2);
			pstmt.setString(4, fmemberPhone);
			
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

	public String searchPw(String fmemberId, int fmemberSocialId1, int fmemberSocialId2, String fmemberPhone, Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select memberPw from member where memberId=? and membersocialId1=? and membersocialId2=? and memberphone=?";
		
		String memberPw =null;
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, fmemberId);
			pstmt.setInt(2, fmemberSocialId1);
			pstmt.setInt(3, fmemberSocialId2);
			pstmt.setString(4, fmemberPhone);
			
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

	public int updateMember(Connection conn, Member m) {
		
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query= "update member set memberPw=?, memberAddr=?, memberEmail=?, memberPhone=?"
				+ " where memberId=? ";
		
		
		try {
			pstmt = conn.prepareStatement(query);
		
			pstmt.setString(1, m.getMemberPw());
			pstmt.setString(2, m.getMemberAddr());
			pstmt.setString(3, m.getMemberEmail());
			pstmt.setString(4, m.getMemberPhone());
			pstmt.setString(5, m.getMemberId());
			
			result = pstmt.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int deleteMember(Connection conn, String memberId) {
		   PreparedStatement pstmt = null;
	       int result = 0;
	       
	       String query = "update member set memberOut=?, memberOutDate=sysdate where memberId=?";
	    
	       
	       try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, "Y");
			pstmt.setString(2, memberId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

	       return result;
		}
	}
	
	
	

	
	
	
	

