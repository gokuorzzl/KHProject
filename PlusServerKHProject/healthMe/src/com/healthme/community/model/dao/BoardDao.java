package com.healthme.community.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.healthme.common.JDBCTemplate;
import com.healthme.community.model.vo.Board;
import com.healthme.community.model.vo.Comment;

public class BoardDao {
	
	public int noticeWriting(String titleText, String contentsText, String passwordText, Connection conn, String userId) {
		PreparedStatement pstmt =null;
		int result = 0;
		String query = "insert into freeboard values(FBOARD_SEQ.nextval,?,?,?,1,null,sysdate,0,default,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, titleText);
			pstmt.setString(3, contentsText);
			pstmt.setString(4, passwordText);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int QnAWriting(String titleText, String contentsText, String passwordText, Connection conn, String userId) {
		PreparedStatement pstmt =null;
		int result = 0;
		String query = "insert into questionBoard values(QBOARD_SEQ.nextval,?,?,?,1,null,sysdate,0,default,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, titleText);
			pstmt.setString(3, contentsText);
			pstmt.setString(4, passwordText);
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
				+ "num from QUESTIONBOARD where qboardavailable='1') where num between ? and ?";
		
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
		
		String query = "select count(*) AS TOTALCOUNT FROM QUESTIONBOARD where qboardavailable='1'";
		
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
				+ "num from freeboard where freeavailable='1') where num between ? and ?";
		
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
		
		String query = "select count(*) AS TOTALCOUNT FROM freeboard where freeavailable='1' ";
		
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
					+ " AS num from QUESTIONBOARD where qboardtitle like ? and qboardavailable='1') where num between ? and ?";
		}else if(searchSelect==1) {
			query = "select * from (select QUESTIONBOARD.*"
					+ ",row_number() over(order by QBOARDNUM desc)"
					+ " AS num from QUESTIONBOARD where memberid like ? and qboardavailable='1') where num between ? and ?";
		}else if(searchSelect==2) {
			query = "select * from (select QUESTIONBOARD.*"
					+ ",row_number() over(order by QBOARDNUM desc)"
					+ " AS num from QUESTIONBOARD where qboardcontent like ? and qboardavailable='1') where num between ? and ?";
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
			query = "select count(*) AS TOTALCOUNT FROM QUESTIONBOARD where qboardtitle like ? and qboardavailable='1'";
		}else if(searchSelect==1) {
			query = "select count(*) AS TOTALCOUNT FROM QUESTIONBOARD where memberid like ? and qboardavailable='1'";
		}else if(searchSelect==2) {
			query = "select count(*) AS TOTALCOUNT FROM QUESTIONBOARD where qboardcontent like ? and qboardavailable='1'";
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
					+ " AS num from FREEBOARD where freetitle like ? and freeavailable='1') where num between ? and ?";
		}else if(searchSelect==1) {
			query = "select * from (select FREEBOARD.*"
					+ ",row_number() over(order by freeNUM desc)"
					+ " AS num from FREEBOARD where memberid like ? and freeavailable='1') where num between ? and ?";
		}else if(searchSelect==2) {
			query = "select * from (select FREEBOARD.*"
					+ ",row_number() over(order by freeNUM desc)"
					+ " AS num from FREEBOARD where freecontent like ? and freeavailable='1') where num between ? and ?";
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
			query = "select count(*) AS TOTALCOUNT FROM FREEBOARD where freetitle like ? and freeavailable='1'";
		}else if(searchSelect==1) {
			query = "select count(*) AS TOTALCOUNT FROM FREEBOARD where memberid like ? and freeavailable='1'";
		}else if(searchSelect==2) {
			query = "select count(*) AS TOTALCOUNT FROM FREEBOARD where freecontent like ? and freeavailable='1'";
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
		String query = "select * from QUESTIONBOARD where qboardnum=? and qboardavailable='1'";
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
		String query = "select * from FREEBOARD where freenum=? and freeavailable='1'";
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
		String query = "update QUESTIONBOARD set qboardhits=qboardhits+1 where qboardnum=? and qboardavailable='1'";
		
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
		String query = "update FREEBOARD set freehits=freehits+1 where freenum=? and freeavailable='1'";
		
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

	public ArrayList<Comment> qnaCommentGetCurrentPage(Connection conn, int currentPage, int recordCountPerPage, int qnaNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		//시작 게시물 계산
		int start = currentPage * recordCountPerPage - (recordCountPerPage-1);
		
		//끝 게시물 계산
		int end = currentPage * recordCountPerPage;		
		
		String query = "select * from (select qboardComment.*,"
				+"row_number() over(order by qcommentnumber desc) AS "
				+"num from qboardComment where qboardnum=? and qcommentavailable='1') where num between ? and ?";
		
		ArrayList<Comment> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, qnaNum);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Comment c = new Comment();
				c.setBoardNum(rset.getInt("qboardnum"));
				c.setMemberID(rset.getString("qmemberid"));
				c.setCommentNumber(rset.getInt("qcommentNumber"));
				c.setCommentInsertDate(rset.getDate("qcommentInsertDate"));
				c.setCommentContent(rset.getString("qcommentContent"));
				c.setCommentAvailable(rset.getInt("qcommentAvailable"));
				
				list.add(c);
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

	public String qnaCommentGetPageNavi(Connection conn, int currentPage, int recordCountPerPage,
			int naviCountPerPage, int qnaNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		// 게시물의 토탈 개수를 구해야 함
		int recordTotalCount = 0;
		
		String query = "select count(*) AS TOTALCOUNT FROM qboardComment where qboardnum = ? and qcommentavailable='1'";
		
		 try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, qnaNum);
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
			sb.append("<a href='/qnaSelect.do?currentPage="+(startNavi-1)+"&qnaNum="+qnaNum+"'> < </a>");
		}
		
		for(int i=startNavi; i<=endNavi;i++){
			if(i==currentPage){
				sb.append("<B style='font-size:20px'>"+i+"</B> &nbsp;");
			}
			else{
				sb.append("<a href='/qnaSelect.do?currentPage="+i+"&qnaNum="+qnaNum+"'>"+i+"</a> ");
			}
		}
		
		if(needNext) {
			sb.append("<a href='/qnaSelect.do?currentPage="+(endNavi+1)+"&qnaNum="+qnaNum+"'> > </a>");
		}
		
		return sb.toString();		
	}

	public ArrayList<Comment> freeCommentGetCurrentPage(Connection conn, int currentPage, int recordCountPerPage,
			int freeNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		//시작 게시물 계산
		int start = currentPage * recordCountPerPage - (recordCountPerPage-1);
		
		//끝 게시물 계산
		int end = currentPage * recordCountPerPage;		
		
		String query = "select * from (select fboardComment.*,"
				+"row_number() over(order by fcommentnumber desc) AS "
				+"num from fboardComment where freenum=? and fcommentavailable='1') where num between ? and ?";
		
		ArrayList<Comment> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, freeNum);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Comment c = new Comment();
				c.setBoardNum(rset.getInt("freenum"));
				c.setMemberID(rset.getString("fmemberid"));
				c.setCommentNumber(rset.getInt("fcommentNumber"));
				c.setCommentInsertDate(rset.getDate("fcommentInsertDate"));
				c.setCommentContent(rset.getString("fcommentContent"));
				c.setCommentAvailable(rset.getInt("fcommentAvailable"));
				
				list.add(c);
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

	public String freeCommentGetPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage,
			int freeNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		// 게시물의 토탈 개수를 구해야 함
		int recordTotalCount = 0;
		
		String query = "select count(*) AS TOTALCOUNT FROM fboardComment where freenum = ? and fcommentavailable='1'";
		
		 try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, freeNum);
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
			sb.append("<a href='/freeSelect.do?currentPage="+(startNavi-1)+"&freeNum="+freeNum+"'> < </a>");
		}
		
		for(int i=startNavi; i<=endNavi;i++){
			if(i==currentPage){
				sb.append("<B style='font-size:20px'>"+i+"</B> &nbsp;");
			}
			else{
				sb.append("<a href='/freeSelect.do?currentPage="+i+"&freeNum="+freeNum+"'>"+i+"</a> ");
			}
		}
		
		if(needNext) {
			sb.append("<a href='/freeSelect.do?currentPage="+(endNavi+1)+"&freeNum="+freeNum+"'> > </a>");
		}
		
		return sb.toString();		
	}

	public int qnaInsertComment(String userId, String commentText, Connection conn, int qnaNum) {
		PreparedStatement pstmt =null;
		int result = 0;
		String query = "insert into qboardComment values(?,?,QCOMMENT_SEQ.nextval,sysdate,?,1,null)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, qnaNum);
			pstmt.setString(2, userId);
			pstmt.setString(3, commentText);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int freeInsertComment(String userId, String commentText, Connection conn, int freeNum) {
		PreparedStatement pstmt =null;
		int result = 0;
		String query = "insert into fboardComment values(?,?,fCOMMENT_SEQ.nextval,sysdate,?,1,null)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, freeNum);
			pstmt.setString(2, userId);
			pstmt.setString(3, commentText);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int freeBoardDelete(int bNum, String userId, Connection conn) {
		PreparedStatement pstmt =null;
		int result = 0;
		String query = "update freeBoard set freeavailable='0', freedeletedate=sysdate where freenum=? and memberid=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bNum);
			pstmt.setString(2, userId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public void freeBoardCommentDelete(int bNum, Connection conn) {
		PreparedStatement pstmt =null;
		String query = "update fboardComment set fcommentavailable='0', fcommentdeletedate=sysdate where freenum=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bNum);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
	}

	public int qnaBoardDelete(int bNum, String userId, Connection conn) {
		PreparedStatement pstmt =null;
		int result = 0;
		String query = "update questionBoard set qboardavailable='0', qboarddeletedate=sysdate where qboardnum=? and memberid=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bNum);
			pstmt.setString(2, userId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public void qnaBoardCommentDelete(int bNum, Connection conn) {
		PreparedStatement pstmt =null;
		String query = "update qboardComment set qcommentavailable='0', qcommentdeletedate=sysdate where qnanum=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bNum);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}	
	}

	public int freeupdateBoard(int boardNumber, String title, String contents, int pwd, Connection conn) {
		PreparedStatement pstmt =null;
		String query = "update freeBoard set freetitle=?, freecontent=?,freepwd=?  where freenum=?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, contents);
			pstmt.setInt(3, pwd);
			pstmt.setInt(4, boardNumber);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int qnaupdateBoard(int boardNumber, String title, String contents, int pwd, Connection conn) {
		PreparedStatement pstmt =null;
		String query = "update questionBoard set qboardtitle=?, qboardcontent=?,qboardpwd=?  where qboardnum=?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, contents);
			pstmt.setInt(3, pwd);
			pstmt.setInt(4, boardNumber);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int qnaCommentDelete(int cNum, Connection conn) {
		PreparedStatement pstmt =null;
		String query = "update qboardComment set qcommentavailable='0', qcommentdeletedate=sysdate where qcommentnumber=?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cNum);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}	
		return result;
	}

	public int freeCommentDelete(int cNum, Connection conn) {
		PreparedStatement pstmt =null;
		String query = "update fboardComment set fcommentavailable='0', fcommentdeletedate=sysdate where fcommentnumber=?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cNum);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}	
		return result;
	}

	public int qnaCommentUpdate(String commentText, int cNum, Connection conn) {
		PreparedStatement pstmt =null;
		String query = "update qboardComment set qcommentcontent=? where qcommentnumber=?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, commentText);
			pstmt.setInt(2, cNum);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}	
		return result;
	}

	public int freeCommentUpdate(String commentText, int cNum, Connection conn) {
		PreparedStatement pstmt =null;
		String query = "update fboardComment set fcommentcontent=? where fcommentnumber=?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, commentText);
			pstmt.setInt(2, cNum);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}	
		return result;
	}
	public Board topBoard(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from freeboard where freehits = (select max(freehits) from freeboard where memberid='admin')";
		
		Board b = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				b = new Board();
				b.setTitle(rset.getString("freetitle"));
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
	
}
