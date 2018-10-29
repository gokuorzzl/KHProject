package com.healthme.trainer.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.healthme.common.JDBCTemplate;
import com.healthme.member.vo.Member;
import com.healthme.trainer.model.vo.Trainer;

public class OneSearchDao {

	public Trainer oneSearch(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Trainer t = null;
		String query = "select * from trainer where memberId=?"; 
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				t = new Trainer();
				t.setMemberId(rset.getString("memberid"));
				t.setProfileFile(rset.getString("profilefile"));
				t.setTrainerGradFile(rset.getString("trainergradfile"));
				t.setTrainerUniv(rset.getString("traineruniv"));
				t.setTrainerGrad(rset.getString("trainergrad"));
				t.setTraienrRegion(rset.getString("trainerregion"));
				t.setTrainerSubject(rset.getString("trainersubject"));
				t.setTrainerContent(rset.getString("trainercontent"));
				t.setTrainerEvent(rset.getString("tarinerevent"));
				t.setTrainerCareerFile(rset.getString("trainercareerfile"));
				
				t.setCareerStart1(rset.getDate("careerstart1"));
				t.setCareerEnd1(rset.getDate("careerend1"));
				t.setCareerName1(rset.getString("careername1"));
				if(rset.getString("careerStart2")!=null) {
					t.setCareerStart2(rset.getDate("careerstart2"));
					t.setCareerEnd2(rset.getDate("careerend2"));
					t.setCareerName2(rset.getString("careername2"));					
				}
				if(rset.getString("careerStart3")!=null) {
					t.setCareerStart3(rset.getDate("careerstart3"));
					t.setCareerEnd3(rset.getDate("careerend3"));
					t.setCareerName3(rset.getString("careername3"));					
				}
				if(rset.getString("careerStart4")!=null) {
					t.setCareerStart4(rset.getDate("careerstart4"));
					t.setCareerEnd4(rset.getDate("careerend4"));
					t.setCareerName4(rset.getString("careername4"));					
				}
				if(rset.getString("careerStart5")!=null) {
					t.setCareerStart5(rset.getDate("careerstart5"));
					t.setCareerEnd5(rset.getDate("careerend5"));
					t.setCareerName5(rset.getString("careername5"));					
				}
				t.setTrainerLicenseFile(rset.getString("trainerlicensefile"));
				t.setLicenseName1(rset.getString("licensename1"));
				if(rset.getString("licensename2")!=null) {
					t.setLicenseName2(rset.getString("licensename2"));					
				}
				if(rset.getString("licensename3")!=null) {
					t.setLicenseName3(rset.getString("licensename3"));					
				}
				if(rset.getString("licensename4")!=null) {
					t.setLicenseName4(rset.getString("licensename4"));					
				}
				if(rset.getString("licensename5")!=null) {
					t.setLicenseName5(rset.getString("licensename5"));					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return t;
	}

	public Member oneSearchName(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member m = null;
		String query = "select * from member where memberId=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member();
				m.setPkMemberNumber(rset.getInt("pkmembernumber"));
				m.setMemberId(rset.getString("memberid"));
				m.setMemberName(rset.getString("membername"));
				m.setMemberEmail(rset.getString("memberemail"));
				m.setMemberPhone(rset.getString("memberphone"));
			}
		} catch (SQLException e) {
			e.printStackTrace(); 
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
		
	}

}
