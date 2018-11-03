package com.healthme.myinfo.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.healthme.common.JDBCTemplate;
import com.healthme.myinfo.model.vo.TrainerInfo;

public class TrainerInfoDao {

	public int insertTrainerInfo(TrainerInfo ti, String userId, Connection conn) {

		PreparedStatement pstmt= null;
		int result = 0;
		//(괄호)를 써줌으로써 넣고싶은 칼럼만 한정해주었다 trainer(memberid, traineruniv,trainergrad,trainerregion,trainersubject,trainercontent, profilefile,trainergradfile,trainercareerfile,trainerlicensefile,trainerevent)"
		String query ="insert into  values(?,?,?,?,?,?"
										+ ",?,?,?,?,?,?"
										+ ",?,?,?,?,?,?"
										+ ",?,?,?,?,?,?"
										+ ",?,?,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, ti.getMemberID());
			pstmt.setString(2, ti.getTrainerUniv());
			pstmt.setString(3, String.valueOf(ti.getTrainerGrad()));
			pstmt.setString(4, ti.getTrainerRegion());
			pstmt.setString(5, ti.getTrainerSubject());
			pstmt.setString(6, ti.getTrainerContent());
			
			pstmt.setString(7, ti.getProfileFile());
			pstmt.setString(8, ti.getTrainerGradFile());
			pstmt.setString(9, ti.getTrainerCareerFile());
			pstmt.setString(10, ti.getTrainerLicenseFile());
			pstmt.setString(11, ti.getTrainerEvent());
			pstmt.setDate(12, ti.getCareerStart1());
			
			pstmt.setDate(13, ti.getCareerEnd1());
			pstmt.setString(14, ti.getCareerName1());
			pstmt.setDate(15, ti.getCareerStart2());
			pstmt.setDate(16, ti.getCareerEnd2());
			pstmt.setString(17, ti.getCareerName2());
			pstmt.setDate(18, ti.getCareerStart3());
			
			pstmt.setDate(19, ti.getCareerEnd3());
			pstmt.setString(20, ti.getCareerName3());
			pstmt.setDate(21, ti.getCareerStart4());
			pstmt.setDate(22, ti.getCareerEnd4());
			pstmt.setString(23, ti.getCareerName4());
			pstmt.setDate(24, ti.getCareerStart5());
			
			pstmt.setDate(25, ti.getCareerEnd5());
			pstmt.setString(26, ti.getCareerName5());
			pstmt.setString(27, ti.getLicenseName1());
			pstmt.setString(28, ti.getLicenseName2());
			pstmt.setString(29, ti.getLicenseName3());
			pstmt.setString(30, ti.getLicenseName4());
			
			pstmt.setString(31, ti.getLicenseName5());
	
			result = pstmt.executeUpdate();
			System.out.println("trainerInfoDAO의값갑값"+result);
			System.out.println("pstmt의값값값"+pstmt);
			//System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

}
