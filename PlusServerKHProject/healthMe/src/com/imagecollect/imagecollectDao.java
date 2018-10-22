package com.imagecollect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//Member처럼 각자 맡은 사람들이 다 common,controller,model.dao,model.service,model.vo로나누기
public class imagecollectDao {

	private Connection conn=null; //데이터베이스를 접근하기 위한 객체
	//private PreparedStatement pstmt=null;
	private ResultSet res=null; //정보를 담을 수 있는 변수를 만들어 준다.

	//Oracle 처리부분
	public imagecollectDao() {
		
		try {
			//1. Driver 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//2. DBMS와 연결 (Connection 사용)
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","HEALTHME", "2580");
			//첫번째는 연결 정보(DB종류, 타입, IP주소, 포트 등등)
			//두번째는 연결하는 DB의 ID(아이디)
			//세번째는 연결하는 ID의 PW(비밀번호)
			//get으로 읽어오는것이므로 저장하는 것이다.conn에 저장하는 것이다.
			//System.out.println(conn);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	


	
	public int write(String profileName, String profileFile, String diplomaName, String DiplomaFile, String licenseName1, String licenseFile1) {
		String query="insert into imagecollect values (?)";
		
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setString(1, profileName);
			pstmt.setString(2, profileFile);
			pstmt.setString(3, diplomaName);
			pstmt.setString(4, DiplomaFile);
			pstmt.setString(5, licenseName1);
			pstmt.setString(6, licenseFile1);


			return pstmt.executeUpdate();



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return -1; //데이터베이스 오류

	}
	

	
	
	
}

