package com.healthme.community.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.healthme.common.JDBCTemplate;
import com.healthme.community.model.dao.BoardDao;
import com.healthme.community.model.vo.Board;
import com.healthme.community.model.vo.BoardPageData;
import com.healthme.community.model.vo.Comment;
import com.healthme.community.model.vo.CommentData;

public class BoardService {

	public int noticeWriting(String titleText, String contentsText, String passwordText, String userId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new BoardDao().noticeWriting(titleText,contentsText,passwordText,conn,userId);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int QnAWriting(String titleText, String contentsText, String passwordText, String userId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new BoardDao().QnAWriting(titleText,contentsText,passwordText,conn,userId);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public BoardPageData qnaBoardAllList(int currentPage) {
		Connection conn = JDBCTemplate.getConnection();
		
		// 2개값을 저장하는 변수 생성 (게시물의 개수, navi의 개수)	
		int recordCountPerPage = 10; //게시물의 개수
		int naviCountPerPage = 10; //navi의 개수
		
		
		// Service에서 DAO를 호출 (2번의 DAO를 호출)
		// 1. 현재 페이지의 게시물 리스트 요청
		// 2. 현재 페이지를 중심으로 만들어지는 navi 리스트 요청
		
		ArrayList<Board> list =new BoardDao().qnaGetCurrentPage(conn,currentPage,recordCountPerPage);
		String pageNavi = new BoardDao().qnaGetPageNavi(conn,currentPage,recordCountPerPage,naviCountPerPage);
		BoardPageData bpd = null;
		
		
		if(!list.isEmpty() && !pageNavi.isEmpty())
		{
			bpd = new BoardPageData();
			bpd.setList(list);
			bpd.setPageNavi(pageNavi);
		}
		
		JDBCTemplate.close(conn);
		
		return bpd;
	}

	public BoardPageData freeBoardAllList(int currentPage) {
		Connection conn = JDBCTemplate.getConnection();
		
		// 2개값을 저장하는 변수 생성 (게시물의 개수, navi의 개수)	
		int recordCountPerPage = 10; //게시물의 개수
		int naviCountPerPage = 10; //navi의 개수
		
		
		// Service에서 DAO를 호출 (2번의 DAO를 호출)
		// 1. 현재 페이지의 게시물 리스트 요청
		// 2. 현재 페이지를 중심으로 만들어지는 navi 리스트 요청
		
		ArrayList<Board> list =new BoardDao().freeGetCurrentPage(conn,currentPage,recordCountPerPage);
		String pageNavi = new BoardDao().freeGetPageNavi(conn,currentPage,recordCountPerPage,naviCountPerPage);
		BoardPageData bpd = null;
		
		if(!list.isEmpty() && !pageNavi.isEmpty())
		{
			bpd = new BoardPageData();
			bpd.setList(list);
			bpd.setPageNavi(pageNavi);
		}
		
		JDBCTemplate.close(conn);
		
		return bpd;
	}

	public BoardPageData qnaSearchList(int currentPage, String searchText, int searchSelect) {
		Connection conn = JDBCTemplate.getConnection();
		
		// 2개값을 저장하는 변수 생성 (게시물의 개수, navi의 개수)	
		int recordCountPerPage = 10; //게시물의 개수
		int naviCountPerPage = 10; //navi의 개수
		
		
		// Service에서 DAO를 호출 (2번의 DAO를 호출)
		// 1. 현재 페이지의 게시물 리스트 요청
		// 2. 현재 페이지를 중심으로 만들어지는 navi 리스트 요청
		ArrayList<Board> list =new BoardDao().qnaSearchGetCurrentPage(conn,currentPage,recordCountPerPage,searchText,searchSelect);
		String pageNavi = new BoardDao().qnaSearchGetPageNavi(conn,currentPage,recordCountPerPage,naviCountPerPage,searchText,searchSelect);
		BoardPageData bpd = null;
		
		if(!list.isEmpty() && !pageNavi.isEmpty())
		{
			bpd = new BoardPageData();
			bpd.setList(list);
			bpd.setPageNavi(pageNavi);
		}
		
		JDBCTemplate.close(conn);
		
		return bpd;
	}

	public BoardPageData freeSearchList(int currentPage, String searchText, int searchSelect) {
		Connection conn = JDBCTemplate.getConnection();
		
		// 2개값을 저장하는 변수 생성 (게시물의 개수, navi의 개수)	
		int recordCountPerPage = 10; //게시물의 개수
		int naviCountPerPage = 10; //navi의 개수
		
		
		// Service에서 DAO를 호출 (2번의 DAO를 호출)
		// 1. 현재 페이지의 게시물 리스트 요청
		// 2. 현재 페이지를 중심으로 만들어지는 navi 리스트 요청
		
		ArrayList<Board> list =new BoardDao().freeSearchGetCurrentPage(conn,currentPage,recordCountPerPage,searchText,searchSelect);
		String pageNavi = new BoardDao().freeSearchGetPageNavi(conn,currentPage,recordCountPerPage,naviCountPerPage,searchText,searchSelect);
		BoardPageData bpd = null;
		
		if(!list.isEmpty() && !pageNavi.isEmpty())
		{
			bpd = new BoardPageData();
			bpd.setList(list);
			bpd.setPageNavi(pageNavi);
		}
		
		JDBCTemplate.close(conn);
		
		return bpd;
	}

	public CommentData qnaSelectOneList(int qnaNum, int currentPage) {
		Connection conn = JDBCTemplate.getConnection();
		int recordCountPerPage = 10; //게시물의 개수
		int naviCountPerPage = 5; //navi의 개수
		Board b = new BoardDao().qnaSelectOneList(qnaNum,conn);
		ArrayList<Comment> list = new BoardDao().qnaCommentGetCurrentPage(conn,currentPage,recordCountPerPage,qnaNum);
		String pageNavi = new BoardDao().qnaCommentGetPageNavi(conn,currentPage,recordCountPerPage,naviCountPerPage,qnaNum);
		int result = new BoardDao().qnaHits(qnaNum,conn);
		CommentData cd = null;
		if(b!=null&&!list.isEmpty() && !pageNavi.isEmpty()){
			cd = new CommentData();
			cd.setList(list);
			cd.setPageNavi(pageNavi);
			cd.setB(b);
		}else if ((!list.isEmpty() && !pageNavi.isEmpty())||b!=null) {
			cd = new CommentData();
			cd.setList(null);
			cd.setPageNavi(null);
			cd.setB(b);
		}
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return cd;
	}

	public CommentData freeSelectOneList(int freeNum, int currentPage) {
		Connection conn = JDBCTemplate.getConnection();
		int recordCountPerPage = 10; //게시물의 개수
		int naviCountPerPage = 5; //navi의 개수
		Board b = new BoardDao().freeSelectOneList(freeNum,conn);
		ArrayList<Comment> list = new BoardDao().freeCommentGetCurrentPage(conn,currentPage,recordCountPerPage,freeNum);
		String pageNavi = new BoardDao().freeCommentGetPageNavi(conn,currentPage,recordCountPerPage,naviCountPerPage,freeNum);
		int result = new BoardDao().freeHits(freeNum,conn);
		CommentData cd = null;
		if(b!=null&&!list.isEmpty() && !pageNavi.isEmpty()){
			cd = new CommentData();
			cd.setList(list);
			cd.setPageNavi(pageNavi);
			cd.setB(b);
		}else if ((!list.isEmpty() && !pageNavi.isEmpty())||b!=null) {
			cd = new CommentData();
			cd.setList(null);
			cd.setPageNavi(null);
			cd.setB(b);
		}
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return cd;
	}

	public int qnaInsertComment(String userId, String commentText, int qnaNum) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new BoardDao().qnaInsertComment(userId,commentText,conn,qnaNum);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
		
	}

	public int freeInsertComment(String userId, String commentText, int freeNum) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new BoardDao().freeInsertComment(userId,commentText,conn,freeNum);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int freeBoardDelete(int bNum, String userId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new BoardDao().freeBoardDelete(bNum,userId,conn);
		if(result>0) {
			new BoardDao().freeBoardCommentDelete(bNum,conn);
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
		
	}

	public int qnaBoardDelete(int bNum, String userId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new BoardDao().qnaBoardDelete(bNum,userId,conn);
		if(result>0) {
			new BoardDao().qnaBoardCommentDelete(bNum,conn);
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public Board qnaOneSelect(int boardNum) {
		Connection conn = JDBCTemplate.getConnection();
		
		Board b = new BoardDao().qnaSelectOneList(boardNum,conn);
		
		JDBCTemplate.close(conn);
		return b;
	}

	public Board freeOneSelect(int boardNum) {
		Connection conn = JDBCTemplate.getConnection();
		
		Board b = new BoardDao().freeSelectOneList(boardNum,conn);
		
		JDBCTemplate.close(conn);
		return b;
	}

	public int freeupdateBoard(int boardNumber, String title, String contents, int pwd) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new BoardDao().freeupdateBoard(boardNumber,title,contents,pwd,conn);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
		
	}

	public int qnaupdateBoard(int boardNumber, String title, String contents, int pwd) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new BoardDao().qnaupdateBoard(boardNumber,title,contents,pwd,conn);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int qnaCommentDelete(int cNum) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new BoardDao().qnaCommentDelete(cNum,conn);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int freeCommentDelete(int cNum) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new BoardDao().freeCommentDelete(cNum,conn);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int qnaCommentUpdate(String commentText, int cNum) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new BoardDao().qnaCommentUpdate(commentText,cNum,conn);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int freeCommentUpdate(String commentText, int cNum) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new BoardDao().freeCommentUpdate(commentText,cNum,conn);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

}
