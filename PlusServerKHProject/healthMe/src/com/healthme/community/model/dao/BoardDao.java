package com.healthme.community.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.healthme.common.JDBCTemplate;
import com.healthme.community.model.vo.Board;

public class BoardDao {
	
	public int noticeWriting(String titleText, String contentsText, String passwordText, Connection conn) {
		PreparedStatement pstmt =null;
		int result = 0;
		String query = "insert into freeboard values(FBOARD_SEQ.nextval,'userId',?,?,1,null,sysdate,0,default,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, titleText);
			pstmt.setString(2, contentsText);
			pstmt.setString(3, passwordText);
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

	public int QnAWriting(String titleText, String contentsText, String passwordText, Connection conn) {
		PreparedStatement pstmt =null;
		int result = 0;
		String query = "insert into questionBoard values(QBOARD_SEQ.nextval,'userId',?,?,1,null,sysdate,0,default,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, titleText);
			pstmt.setString(2, contentsText);
			pstmt.setString(3, passwordText);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
		
	}

	public ArrayList<Board> qnaGetCurrentPage(Connection conn, int currentPage, int recordCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		//시작 게시물 계산
		int start = currentPage * recordCountPerPage - (recordCountPerPage-1);
		
		//끝 게시물 계산
		int end = currentPage * recordCountPerPage;		
		
		String query = "select * from (select questionBoard.*,"
				+ "row_number() over(order by QBOARDNUM desc) AS "
				+ "num from QUESTIONBOARD) where num between ? and ?";
		
		ArrayList<Board> list = new ArrayList<Board>();
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Board b = new Board();
				b.setNum(rset.getInt("qboardnum"));
				b.setUserId(rset.getString("memberid"));
				b.setTitle(rset.getString("qboardtitle"));
				b.setContent(rset.getString("qboardcontent"));
				b.setAvailable(rset.getInt("qboardavailable"));
				b.setInsertDate(rset.getDate("qboardinsertDate"));
				b.setHits(rset.getInt("qboardhits"));
				b.setNotice(rset.getString("qboardnotice"));
				b.setPwd(rset.getInt("qboardpwd"));
				
				list.add(b);
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public String qnaGetPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		// 게시물의 토탈 개수를 구해야 함
		int recordTotalCount = 0;
		
		String query = "select count(*) AS TOTALCOUNT FROM QUESTIONBOARD";
		
		 try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				recordTotalCount = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}		 
		 
		 int pageToTalCount = 0; 	 
		 
		 if(recordTotalCount%recordCountPerPage !=0){
			 pageToTalCount = recordTotalCount / recordCountPerPage + 1;
		 }
		 else {
			 pageToTalCount = recordTotalCount / recordCountPerPage;
		 }
		 
		 if(currentPage<1){
			 currentPage = 1;
		 }
		 else if(currentPage>pageToTalCount){
			 currentPage = pageToTalCount;
		 }
		 
		int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage+1; 
		
		int endNavi = startNavi + naviCountPerPage -1;
		
		if(endNavi > pageToTalCount){
			endNavi = pageToTalCount;
		}
			
		boolean needPrev = true;
		boolean needNext = true;
		
		if(startNavi==1) {
			needPrev = false;
		}
		if(endNavi==pageToTalCount) {
			needNext = false;
		}
		
		StringBuilder sb = new StringBuilder();
		
		if(needPrev==true){
			sb.append("<a href='/qnaPage.do?currentPage="+(startNavi-1)+"'> < </a>");
		}
		
		for(int i=startNavi; i<=endNavi;i++){
			if(i==currentPage){
				sb.append("<B style='font-size:20px'>"+i+"</B> &nbsp;");
			}
			else{
				sb.append("<a href='/qnaPage.do?currentPage="+i+"'>"+i+"</a> ");
			}
		}
		
		if(needNext) {
			sb.append("<a href='/qnaPage.do?currentPage="+(endNavi+1)+"'> > </a>");
		}
		
		return sb.toString();		
	}

	public ArrayList<Board> freeGetCurrentPage(Connection conn, int currentPage, int recordCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		//시작 게시물 계산
		int start = currentPage * recordCountPerPage - (recordCountPerPage-1);
		
		//끝 게시물 계산
		int end = currentPage * recordCountPerPage;		
		
		String query = "select * from (select freeboard.*,"
				+ "row_number() over(order by freeNUM desc) AS "
				+ "num from freeboard) where num between ? and ?";
		
		ArrayList<Board> list = new ArrayList<Board>();
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Board b = new Board();
				b.setNum(rset.getInt("freenum"));
				b.setUserId(rset.getString("memberid"));
				b.setTitle(rset.getString("freetitle"));
				b.setContent(rset.getString("freecontent"));
				b.setAvailable(rset.getInt("freeavailable"));
				b.setInsertDate(rset.getDate("freeinsertDate"));
				b.setHits(rset.getInt("freehits"));
				b.setNotice(rset.getString("freenotice"));
				b.setPwd(rset.getInt("freepwd"));
				
				list.add(b);
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public String freeGetPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		// 게시물의 토탈 개수를 구해야 함
		int recordTotalCount = 0;
		
		String query = "select count(*) AS TOTALCOUNT FROM freeboard";
		
		 try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				recordTotalCount = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}		 
		 
		 int pageToTalCount = 0; 	 
		 
		 if(recordTotalCount%recordCountPerPage !=0){
			 pageToTalCount = recordTotalCount / recordCountPerPage + 1;
		 }
		 else {
			 pageToTalCount = recordTotalCount / recordCountPerPage;
		 }
		 
		 if(currentPage<1){
			 currentPage = 1;
		 }
		 else if(currentPage>pageToTalCount){
			 currentPage = pageToTalCount;
		 }
		 
		int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage+1; 
		
		int endNavi = startNavi + naviCountPerPage -1;
		
		if(endNavi > pageToTalCount){
			endNavi = pageToTalCount;
		}
			
		boolean needPrev = true;
		boolean needNext = true;
		
		if(startNavi==1) {
			needPrev = false;
		}
		if(endNavi==pageToTalCount) {
			needNext = false;
		}
		
		StringBuilder sb = new StringBuilder();
		
		if(needPrev==true){
			sb.append("<a href='/freePage.do?currentPage="+(startNavi-1)+"'> < </a>");
		}
		
		for(int i=startNavi; i<=endNavi;i++){
			if(i==currentPage){
				sb.append("<B style='font-size:20px'>"+i+"</B> &nbsp;");
			}
			else{
				sb.append("<a href='/freePage.do?currentPage="+i+"'>"+i+"</a> ");
			}
		}
		
		if(needNext) {
			sb.append("<a href='/freePage.do?currentPage="+(endNavi+1)+"'> > </a>");
		}
		
		return sb.toString();		
	}

	public ArrayList<Board> qnaSearchGetCurrentPage(Connection conn, int currentPage, int recordCountPerPage,
			String searchText, int searchSelect) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query ="";
		//시작 게시물 계산
		int start = currentPage * recordCountPerPage - (recordCountPerPage-1);
		
		//끝 게시물 계산
		int end = currentPage * recordCountPerPage;		
		if(searchSelect==0) {
			query = "select * from (select QUESTIONBOARD.*"
					+ ",row_number() over(order by QBOARDNUM desc)"
					+ " AS num from QUESTIONBOARD where qboardtitle like ?) where num between ? and ?";
		}else if(searchSelect==1) {
			query = "select * from (select QUESTIONBOARD.*"
					+ ",row_number() over(order by QBOARDNUM desc)"
					+ " AS num from QUESTIONBOARD where qboarduserid like ?) where num between ? and ?";
		}else if(searchSelect==2) {
			query = "select * from (select QUESTIONBOARD.*"
					+ ",row_number() over(order by QBOARDNUM desc)"
					+ " AS num from QUESTIONBOARD where qboardcontent like ?) where num between ? and ?";
		}
		
		ArrayList<Board> list = new ArrayList<Board>();
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchText+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Board b = new Board();
				b.setNum(rset.getInt("qboardnum"));
				b.setUserId(rset.getString("memberid"));
				b.setTitle(rset.getString("qboardtitle"));
				b.setContent(rset.getString("qboardcontent"));
				b.setAvailable(rset.getInt("qboardavailable"));
				b.setInsertDate(rset.getDate("qboardinsertDate"));
				b.setHits(rset.getInt("qboardhits"));
				b.setNotice(rset.getString("qboardnotice"));
				b.setPwd(rset.getInt("qboardpwd"));
				
				list.add(b);
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public String qnaSearchGetPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage,
			String searchText, int searchSelect) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		// 게시물의 토탈 개수를 구해야 함
		int recordTotalCount = 0;
		String query = null;
		if(searchSelect==0) {
			query = "select count(*) AS TOTALCOUNT FROM QUESTIONBOARD where qboardtitle like ?";
		}else if(searchSelect==1) {
			query = "select count(*) AS TOTALCOUNT FROM QUESTIONBOARD where qboarduserid like ?";
		}else if(searchSelect==2) {
			query = "select count(*) AS TOTALCOUNT FROM QUESTIONBOARD where qboardcontent like ?";
		}
		
		
		 try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchText+"%");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				recordTotalCount = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}		 
		 
		 int pageToTalCount = 0; 	 
		 
		 if(recordTotalCount%recordCountPerPage !=0){
			 pageToTalCount = recordTotalCount / recordCountPerPage + 1;
		 }
		 else {
			 pageToTalCount = recordTotalCount / recordCountPerPage;
		 }
		 
		 if(currentPage<1){
			 currentPage = 1;
		 }
		 else if(currentPage>pageToTalCount){
			 currentPage = pageToTalCount;
		 }
		 
		int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage+1; 
		
		int endNavi = startNavi + naviCountPerPage -1;
		
		if(endNavi > pageToTalCount){
			endNavi = pageToTalCount;
		}
			
		boolean needPrev = true;
		boolean needNext = true;
		
		if(startNavi==1) {
			needPrev = false;
		}
		if(endNavi==pageToTalCount) {
			needNext = false;
		}
		
		StringBuilder sb = new StringBuilder();
		
		if(needPrev==true){
			sb.append("<a href='/qnaSearch.do?currentPage="+(startNavi-1)+"&searchSelect="+searchSelect+
					"&searchText="+searchText+"'> < </a>");
		}
		
		for(int i=startNavi; i<=endNavi;i++){
			if(i==currentPage){
				sb.append("<B style='font-size:20px'>"+i+"</B> &nbsp;");
			}
			else{
				sb.append("<a href='/qnaSearch.do?currentPage="+i+"&searchSelect="+searchSelect+
						"&searchText="+searchText+"'>"+i+"</a> ");
			}
		}
		
		if(needNext) {
			sb.append("<a href='/qnaSearch.do?currentPage="+(endNavi+1)+"&searchSelect="+searchSelect+
					"&searchText="+searchText+"'> > </a>");
		}
		
		return sb.toString();	
	}

	public ArrayList<Board> freeSearchGetCurrentPage(Connection conn, int currentPage, int recordCountPerPage,
			String searchText, int searchSelect) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query ="";
		//시작 게시물 계산
		int start = currentPage * recordCountPerPage - (recordCountPerPage-1);
		
		//끝 게시물 계산
		int end = currentPage * recordCountPerPage;		
		if(searchSelect==0) {
			query = "select * from (select FREEBOARD.*"
					+ ",row_number() over(order by freeNUM desc)"
					+ " AS num from FREEBOARD where freetitle like ?) where num between ? and ?";
		}else if(searchSelect==1) {
			query = "select * from (select FREEBOARD.*"
					+ ",row_number() over(order by freeNUM desc)"
					+ " AS num from FREEBOARD where freeuserid like ?) where num between ? and ?";
		}else if(searchSelect==2) {
			query = "select * from (select FREEBOARD.*"
					+ ",row_number() over(order by freeNUM desc)"
					+ " AS num from FREEBOARD where freecontent like ?) where num between ? and ?";
		}
		
		ArrayList<Board> list = new ArrayList<Board>();
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchText+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Board b = new Board();
				b.setNum(rset.getInt("freenum"));
				b.setUserId(rset.getString("memberid"));
				b.setTitle(rset.getString("freetitle"));
				b.setContent(rset.getString("freecontent"));
				b.setAvailable(rset.getInt("freeavailable"));
				b.setInsertDate(rset.getDate("freeinsertDate"));
				b.setHits(rset.getInt("freehits"));
				b.setNotice(rset.getString("freenotice"));
				b.setPwd(rset.getInt("freepwd"));
				
				list.add(b);
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public String freeSearchGetPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage,
			String searchText, int searchSelect) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		// 게시물의 토탈 개수를 구해야 함
		int recordTotalCount = 0;
		String query = null;
		if(searchSelect==0) {
			query = "select count(*) AS TOTALCOUNT FROM FREEBOARD where freetitle like ?";
		}else if(searchSelect==1) {
			query = "select count(*) AS TOTALCOUNT FROM FREEBOARD where freeuserid like ?";
		}else if(searchSelect==2) {
			query = "select count(*) AS TOTALCOUNT FROM FREEBOARD where freecontent like ?";
		}
		
		
		 try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchText+"%");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				recordTotalCount = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}		 
		 
		 int pageToTalCount = 0; 	 
		 
		 if(recordTotalCount%recordCountPerPage !=0){
			 pageToTalCount = recordTotalCount / recordCountPerPage + 1;
		 }
		 else {
			 pageToTalCount = recordTotalCount / recordCountPerPage;
		 }
		 
		 if(currentPage<1){
			 currentPage = 1;
		 }
		 else if(currentPage>pageToTalCount){
			 currentPage = pageToTalCount;
		 }
		 
		int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage+1; 
		
		int endNavi = startNavi + naviCountPerPage -1;
		
		if(endNavi > pageToTalCount){
			endNavi = pageToTalCount;
		}
			
		boolean needPrev = true;
		boolean needNext = true;
		
		if(startNavi==1) {
			needPrev = false;
		}
		if(endNavi==pageToTalCount) {
			needNext = false;
		}
		
		StringBuilder sb = new StringBuilder();
		
		if(needPrev==true){
			sb.append("<a href='/freeSearch.do?currentPage="+(startNavi-1)+"&searchSelect="+searchSelect+
					"&searchText="+searchText+"'> < </a>");
		}
		
		for(int i=startNavi; i<=endNavi;i++){
			if(i==currentPage){
				sb.append("<B style='font-size:20px'>"+i+"</B> &nbsp;");
			}
			else{
				sb.append("<a href='/freeSearch.do?currentPage="+i+"&searchSelect="+searchSelect+
						"&searchText="+searchText+"'>"+i+"</a> ");
			}
		}
		
		if(needNext) {
			sb.append("<a href='/freeSearch.do?currentPage="+(endNavi+1)+"&searchSelect="+searchSelect+
					"&searchText="+searchText+"'> > </a>");
		}
		
		return sb.toString();	
	}

	public Board qnaSelectOneList(int qnaNum, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from QUESTIONBOARD where qboardnum=?";
		Board b = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, qnaNum);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b = new Board();
				b.setNum(rset.getInt("qboardnum"));
				b.setUserId(rset.getString("memberid"));
				b.setTitle(rset.getString("qboardtitle"));
				b.setContent(rset.getString("qboardcontent"));
				b.setAvailable(rset.getInt("qboardavailable"));
				b.setInsertDate(rset.getDate("qboardinsertDate"));
				b.setHits(rset.getInt("qboardhits"));
				b.setNotice(rset.getString("qboardnotice"));
				b.setPwd(rset.getInt("qboardpwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return b;
	}

	public Board freeSelectOneList(int freeNum, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from FREEBOARD where freenum=?";
		Board b = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, freeNum);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b = new Board();
				b.setNum(rset.getInt("freenum"));
				b.setUserId(rset.getString("memberid"));
				b.setTitle(rset.getString("freetitle"));
				b.setContent(rset.getString("freecontent"));
				b.setAvailable(rset.getInt("freeavailable"));
				b.setInsertDate(rset.getDate("freeinsertDate"));
				b.setHits(rset.getInt("freehits"));
				b.setNotice(rset.getString("freenotice"));
				b.setPwd(rset.getInt("freepwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return b;
	}

	public int qnaHits(int qnaNum, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update QUESTIONBOARD set qboardhits=qboardhits+1 where qboardnum=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, qnaNum);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int freeHits(int freeNum, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update FREEBOARD set freehits=freehits+1 where freenum=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, freeNum);
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
