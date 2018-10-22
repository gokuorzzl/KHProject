package com.freeBoard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class freeBoardDao {

	//미완성
	
	
	private Connection conn=null; //데이터베이스를 접근하기 위한 객체
	//private PreparedStatement pstmt=null;
	private ResultSet res=null; //정보를 담을 수 있는 변수를 만들어 준다.
	
	//Oracle 처리부분
		public freeBoardDao() {
			//생성자를 만들었다.

			try {
				//1. Driver 등록
				Class.forName("oracle.jdbc.driver.OracleDriver");

				//2. DBMS와 연결 (Connection 사용)
				conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BBS", "1234");
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
	
		//게시판에 시간을 저장해줄 것이다.
		public String getDate() {

			String query="select sysdate from dual";
			//mysql에서는 select now();

			try {
				PreparedStatement pstmt = conn.prepareStatement(query);
				res = pstmt.executeQuery();
				if(res.next()) {
					return res.getString(1);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return ""; //데이터베이스 오류

		}
		
		
		//게시판에 마지막 번호의 글에서 +1을 해야되니 그거때문에 가져올려는 것이다.
		public int getNext() {

			String query="select freeNum from freeBoardDao order by freeNum desc";

			try {
				PreparedStatement pstmt = conn.prepareStatement(query);
				res = pstmt.executeQuery();
				if(res.next()) {
					return res.getInt(1)+1;//게시글에 다음번호를 쓰기 위해 1을 더했다.
				}
				return 1;//첫번째 게시물인 경우

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return -1; //데이터베이스 오류

		}
		
		//실제로 글을 작성하는 함수
		public int write(String freeTitle, String memberID, String freeContent) {

			String query="insert into freeBoard values (?,?,?,?,?,?)";

			try {
				PreparedStatement pstmt = conn.prepareStatement(query);

				pstmt.setInt(1, getNext());
				pstmt.setString(2, freeTitle);
				pstmt.setString(3, memberID);
				pstmt.setString(4, getDate());

				return pstmt.executeUpdate();



			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return -1; //데이터베이스 오류

		}

	
	
}
