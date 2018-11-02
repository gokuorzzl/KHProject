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
import com.healthme.trainer.model.vo.Trainer;

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

	//회원목록 가져오는것
	public ArrayList<Member> adminMemberAll(Connection conn) {
		// TODO Auto-generated method stub
		//여러명을 처리하기 위한 컬렉션을 사용 (ArrayList)
		
		ArrayList<Member> list = new ArrayList<Member>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from member where membertrainer='n' order by memberout asc";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Member m = new Member();
				m.setPkMemberNumber(rset.getInt("pkMemberNumber"));
				m.setMemberId(rset.getString("memberId"));
				m.setMemberPw(rset.getString("memberPw"));
				m.setMemberName(rset.getString("memberName"));
				m.setMemberSocialId1(rset.getInt("memberSocialId1"));
				m.setMemberSocialId2(rset.getInt("memberSocialId2"));
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
	
	//트레이너 목록 가져오는것
	public ArrayList<Trainer> adminMemberAllT(Connection conn) {
		// TODO Auto-generated method stub
		//여러명을 처리하기 위한 컬렉션을 사용 (ArrayList)
		ArrayList<Trainer> list = new ArrayList<Trainer>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from trainer";
		System.out.println(query);
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Trainer t = new Trainer();
				t.setMemberId(rset.getString("memberId"));
				t.setProfileFile(rset.getString("profileFile"));
				t.setTrainerGradFile(rset.getString("trainerGradFile"));
				t.setTrainerUniv(rset.getString("trainerUniv"));
				t.setTrainerGrad(rset.getString("trainerGrad"));
				t.setTrainerRegion(rset.getString("trainerRegion"));
				t.setTrainerSubject(rset.getString("trainerSubject"));
				t.setTrainerContent(rset.getString("trainerContent"));
				t.setTrainerEvent(rset.getString("trainerEvent"));
				t.setTrainerCareerFile(rset.getString("trainerCareerFile"));
				
				t.setCareerStart1(rset.getDate("careerStart1"));
				t.setCareerEnd1(rset.getDate("careerEnd1"));
				t.setCareerName1(rset.getString("careerName1"));
				
				t.setCareerStart2(rset.getDate("careerStart2"));
				t.setCareerEnd2(rset.getDate("careerEnd2"));
				t.setCareerName2(rset.getString("careerName2"));
				
				t.setCareerStart3(rset.getDate("careerStart3"));
				t.setCareerEnd3(rset.getDate("careerEnd3"));
				t.setCareerName3(rset.getString("careerName3"));
				
				t.setCareerStart4(rset.getDate("careerStart4"));
				t.setCareerEnd4(rset.getDate("careerEnd4"));
				t.setCareerName4(rset.getString("careerName4"));
				
				t.setCareerStart5(rset.getDate("careerStart5"));
				t.setCareerEnd5(rset.getDate("careerEnd5"));
				t.setCareerName5(rset.getString("careerName5"));
				
				t.setTrainerLicenseFile(rset.getString("trainerLicenseFile"));
				
				t.setLicenseName1(rset.getString("licenseName1"));
				t.setLicenseName1(rset.getString("licenseName2"));
				t.setLicenseName1(rset.getString("licenseName3"));
				t.setLicenseName1(rset.getString("licenseName4"));
				t.setLicenseName1(rset.getString("licenseName5"));
				
				list.add(t);
				
				
				
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		System.out.println(list+"AdminDao");
		
		return list;

	}

	public int adminAllSelectOneUpdate(Connection conn, int pkMemberNumber, String memberId, String memberPw,
			String memberName, String memberSocialId, String memberAddr, String memberEmail, String memberPhone,
			char memberTrainer, String memberClass, char memberOut) {
		// TODO Auto-generated method stub
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String memberTrainer1 = String.valueOf(memberTrainer);
		String memberOut1 = String.valueOf(memberOut);
		
		
		String query = "update member set pkMemberNumber=?, memberId=?, memberPw=?, memberName=?, memberSocialId=?, memberAddr=?, memberEmail=?, memberPhone=?, memberTrainer=?, memberClass=?"
				+ " where memberId=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, pkMemberNumber);
			pstmt.setString(2, memberId);
			pstmt.setString(3, memberPw);
			pstmt.setString(4, memberName);
			pstmt.setString(5, memberSocialId);
			pstmt.setString(6, memberAddr);
			pstmt.setString(7, memberEmail);
			pstmt.setString(8, memberPhone);
			pstmt.setString(9, memberTrainer1);
			pstmt.setString(10, memberClass);
			pstmt.setString(11, memberOut1);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		
		
		
		
		return result;
	}
	//관리자회원설정에서 수정누를경우 창뜨게해서 결과값 갖고오게 할 DB
	public Member adminMemberUpdateSel(Connection conn, String memberId) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member m = null;
		
		String query = "select * from member where memberId=?";
		System.out.println(memberId+"memberId는는는");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			
			rset = pstmt.executeQuery();
			
			System.out.println(rset+"rset의값");
			
			if(rset.next()) {
				m = new Member();
				m.setPkMemberNumber(rset.getInt("pkMemberNumber"));
				m.setMemberId(rset.getString("memberId"));
				m.setMemberPw(rset.getString("memberPw"));
				m.setMemberName(rset.getString("memberName"));
				m.setMemberSocialId1(rset.getInt("memberSocialId1"));
				m.setMemberSocialId2(rset.getInt("memberSocialId2"));
				m.setMemberAddr(rset.getString("memberAddr"));
				m.setMemberEmail(rset.getString("memberEmail"));
				m.setMemberPhone(rset.getString("memberPhone"));
				m.setMemberTrainer(rset.getString("memberTrainer").charAt(0));
				m.setMemberClass(rset.getString("memberClass"));
				m.setMemberOut(rset.getString("memberOut").charAt(0));
				m.setMemberRegistDate(rset.getDate("memberRegistDate"));
				m.setMemberOutDate(rset.getDate("memberOutDate"));
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			
		}
		
		
		
		
		
		return m;
	}
	
	//관리자용 정보수정 누를경우 정보 폼 띄우고 수정되는 곳
	public int adminMemberselUpdate(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query="update member set memberPw=?, memberName=?, memberSocialId1=?, memberSocialId2=?, memberAddr=?, memberEmail=?, memberPhone=?, memberTrainer=?, memberClass=?,"
				+ "memberOut=? where memberId=? ";
		
				
		
		try {
			pstmt = conn.prepareStatement(query);
			
			String memberTrainer1 = String.valueOf(m.getMemberTrainer());
			String memberOut1 = String.valueOf(m.getMemberOut());
			
			pstmt.setString(1, m.getMemberPw());
			pstmt.setString(2, m.getMemberName());
			pstmt.setInt(3, m.getMemberSocialId1());
			pstmt.setInt(4, m.getMemberSocialId2());
			pstmt.setString(5, m.getMemberAddr());
			pstmt.setString(6, m.getMemberEmail());
			pstmt.setString(7, m.getMemberPhone());
			pstmt.setString(8, memberTrainer1);
			pstmt.setString(9, m.getMemberClass());
			pstmt.setString(10, memberOut1);
			pstmt.setString(11, m.getMemberId());
			
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
		JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	//관리자페이지 회원설정에서 회원 삭제하는 것
	public int adminMemberDel(Connection conn, String memberId) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "update member set memberout='y',memberoutdate=sysdate where memberId=?";
		
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, memberId);
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			
		}
		
		
		return result;
	}

	//트레이너 수정 할경우 정보갖고오는 메소드
	public Trainer adminTrainerTUpdateSel(Connection conn, String memberId) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Trainer t = null;
		
		String query = "select * from trainer where memberId=?";
		
	
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			
			rset = pstmt.executeQuery();
			System.out.println("AdminDao까지왔어");
			if(rset.next()) {
				t = new Trainer();
				t.setMemberId(rset.getString("memberId"));
				t.setProfileFile(rset.getString("profileFile"));
				t.setTrainerGradFile(rset.getString("trainerGradFile"));
				t.setTrainerUniv(rset.getString("trainerUniv"));
				t.setTrainerGrad(rset.getString("trainerGrad"));
				t.setTrainerRegion(rset.getString("trainerRegion"));
				t.setTrainerSubject(rset.getString("trainerSubject"));
				t.setTrainerContent(rset.getString("trainerContent"));
				t.setTrainerEvent(rset.getString("trainerEvent"));
				t.setTrainerCareerFile(rset.getString("trainerCareerFile"));
				
				t.setCareerStart1(rset.getDate("careerStart1"));
				t.setCareerEnd1(rset.getDate("careerEnd1"));
				t.setCareerName1(rset.getString("careerName1"));
				
				t.setCareerStart2(rset.getDate("careerStart2"));
				t.setCareerEnd2(rset.getDate("careerEnd2"));
				t.setCareerName2(rset.getString("careerName2"));
				
				t.setCareerStart3(rset.getDate("careerStart3"));
				t.setCareerEnd3(rset.getDate("careerEnd3"));
				t.setCareerName3(rset.getString("careerName3"));
				
				t.setCareerStart4(rset.getDate("careerStart4"));
				t.setCareerEnd4(rset.getDate("careerEnd4"));
				t.setCareerName4(rset.getString("careerName4"));
				
				t.setCareerStart5(rset.getDate("careerStart5"));
				t.setCareerEnd5(rset.getDate("careerEnd5"));
				t.setCareerName5(rset.getString("careerName5"));
				
				t.setTrainerLicenseFile(rset.getString("trainerLicenseFile"));
				
				t.setLicenseName1(rset.getString("licenseName1"));
				t.setLicenseName1(rset.getString("licenseName2"));
				t.setLicenseName1(rset.getString("licenseName3"));
				t.setLicenseName1(rset.getString("licenseName4"));
				t.setLicenseName1(rset.getString("licenseName5"));
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		
		
		
		return t;
	}

	public int adminTrainerselUpdate(Connection conn, Trainer t) {
		// TODO Auto-generated method stub
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query="update trainer set profileFile=?, trainerGradFile=?, trainerUniv=?, trainerGrad=?, trainerRegion=?, trainerSubject=?, trainerContent=?,"
				+ "trainerEvent=?, trainerCareerFile=?, careerName1=?, careerName2=?, careerName3=?, careerName4=?, careerName5=?, trainerLicenseFile=?, licenseName1=?,"
				+ "licenseName2=?, licenseName3=?, licenseName=4?, licenseName5=? where memberId=? ";
		
				
		
		try {
			pstmt = conn.prepareStatement(query);
			
			//String memberTrainer1 = String.valueOf(m.getMemberTrainer());
			//String memberOut1 = String.valueOf(m.getMemberOut());
		
			
			
			pstmt.setString(1, t.getProfileFile());
			pstmt.setString(2, t.getTrainerGradFile());
			pstmt.setString(3, t.getTrainerUniv());
			pstmt.setString(4, t.getTrainerGrad());
			pstmt.setString(5, t.getTrainerRegion());
			pstmt.setString(6, t.getTrainerSubject());
			pstmt.setString(7, t.getTrainerContent());
			pstmt.setString(8, t.getTrainerEvent());
			pstmt.setString(9, t.getTrainerCareerFile());
			pstmt.setString(10, t.getCareerName1());
			pstmt.setString(11, t.getCareerName2());
			pstmt.setString(12, t.getCareerName3());
			pstmt.setString(13, t.getCareerName4());
			pstmt.setString(14, t.getCareerName5());
			pstmt.setString(15, t.getTrainerLicenseFile());
			pstmt.setString(16, t.getLicenseName1());
			pstmt.setString(17, t.getLicenseName2());
			pstmt.setString(18, t.getLicenseName3());
			pstmt.setString(19, t.getLicenseName4());
			pstmt.setString(20, t.getLicenseName5());
			pstmt.setString(21, t.getMemberId());
			
			result = pstmt.executeUpdate();
			
			System.out.println(query+"쿼리의값이야야야야야양야야야야");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
		JDBCTemplate.close(pstmt);
		}
		
		return result;
		
		
	}

	public int adminTrainerDel(Connection conn, String memberId) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "delete from trainer where memberid=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, memberId);
			
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
