package com.healthme.myinfo.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.healthme.common.JDBCTemplate;
import com.healthme.myinfo.model.vo.TrainerInfo;

public class TrainerInfoDao {

	public int insertTrainerInfo(TrainerInfo ti, Connection conn) {

		PreparedStatement pstmt= null;
		int result = 0;
		//(memberId,traineruniv,trainercontent,trainerevent)를 써줌으로써 넣고싶은 칼럼만 한정해주었다
		String query ="insert into trainer (memberId,traineruniv,trainercontent,trainerevent) values(?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, ti.getMemberID());
			pstmt.setString(2, ti.getTrainerUniv());
			pstmt.setString(3, ti.getTrainerContent());
			pstmt.setString(4, ti.getTrainerEvent());
			
			result = pstmt.executeUpdate();

			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

}
