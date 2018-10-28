package com.healthme.trainer.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.healthme.common.JDBCTemplate;
import com.healthme.member.vo.Member;
import com.healthme.trainer.vo.Trainer;

public class TrainerDao {
   
	public Trainer selectOneTrainer(String memberId, Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from trainer where memberId=?";
		
		Trainer trainer = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, memberId);
			
			rset = pstmt.executeQuery();
			
			// 쿼리 실행된거 resultSet=rset에 있는거를 >> member객체에 담아서 준다.
			if(rset.next()) {
				trainer = new Trainer();
				trainer.setProfileFile(rset.getString("profileFile"));
				trainer.setUniv(rset.getString("trainerUniv"));
				trainer.setTrainerGradFile(rset.getString("trainerGradFile"));
				trainer.setGrad(rset.getString("trainerGrad").charAt(0));
				trainer.setGym(rset.getString("trainerRegion"));
				trainer.setSubject(rset.getString("trainerSubject"));
				trainer.setContent(rset.getString("trainerContent"));
				trainer.setTrainerEvent(rset.getString("trainerEvent"));
				trainer.setCareerFile(rset.getString("trainerCareerFile"));
				trainer.setCareerStart1(rset.getString("careerStart1"));
				trainer.setCareerStart2(rset.getString("careerStart2"));
				trainer.setCareerStart3(rset.getString("careerStart3"));
				trainer.setCareerStart4(rset.getString("careerStart4"));
				trainer.setCareerStart5(rset.getString("careerStart5"));
				trainer.setCareerEnd1(rset.getString("careerEnd1"));
				trainer.setCareerEnd2(rset.getString("careerEnd2"));
				trainer.setCareerEnd3(rset.getString("careerEnd3"));
				trainer.setCareerEnd4(rset.getString("careerEnd4"));
				trainer.setCareerEnd5(rset.getString("careerEnd5"));
				trainer.setCareerName1(rset.getString("careerName1"));
				trainer.setCareerName2(rset.getString("careerName2"));
				trainer.setCareerName3(rset.getString("careerName3"));
				trainer.setCareerName4(rset.getString("careerName4"));
				trainer.setCareerName5(rset.getString("careerName5"));
				trainer.setLicenseFile(rset.getString("trainerLicenseFile"));
				trainer.setLicenseName1(rset.getString("licenseName1"));
				trainer.setLicenseName2(rset.getString("licenseName2"));
				trainer.setLicenseName3(rset.getString("licenseName3"));
				trainer.setLicenseName4(rset.getString("licenseName4"));
				trainer.setLicenseName5(rset.getString("licenseName5"));
				// id까지 31개 열
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return trainer;		// 정보가 삽입된 trainer 객체를 리턴해준다.(반환)
		
	}
	
	public int insertTrainer(Connection conn, Trainer t) {
		
		PreparedStatement pstmt = null;

		int result = 0;
		
//		String query1= "INSERT INTO MEMBER VALUES(111, 'test41', '@test11test11', '이름11', '930419-0000000', '그들의 집', sysdate, 'Gold', \r\n" + 
//				"                    'test11@healthme.com', '010-1111-1111', 'y', 'n', null)";
//		String query= "insert into member values(?,null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String query= "insert into member(memberId) values('test41')";
		
		System.out.println(query);
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, t.getMemberId());
//			pstmt.setString(2, null);
			
			pstmt = conn.prepareStatement(query);	//쿼리를 수행문에 담고
			result = pstmt.executeUpdate();	//수행후 성공갯수를 가져온다.
			
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
	
	
	
	
	
	
	
	
}
