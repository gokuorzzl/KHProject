package com.healthme.community.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.jsp.tagext.PageData;

import com.healthme.common.JDBCTemplate;
import com.healthme.community.model.dao.BoardDao;
import com.healthme.community.model.vo.Board;
import com.healthme.community.model.vo.BoardPageData;

public class BoardService {

	public int noticeWriting(String titleText, String contentsText, String passwordText) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new BoardDao().noticeWriting(titleText,contentsText,passwordText,conn);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int QnAWriting(String titleText, String contentsText, String passwordText) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new BoardDao().QnAWriting(titleText,contentsText,passwordText,conn);
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
		int naviCountPerPage = 5; //navi의 개수
		
		
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
		int naviCountPerPage = 5; //navi의 개수
		
		
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
		int naviCountPerPage = 5; //navi의 개수
		
		
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
		int naviCountPerPage = 5; //navi의 개수
		
		
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

	public Board qnaSelectOneList(String qnaNum) {
		Connection conn = JDBCTemplate.getConnection();
		Board b = new BoardDao().qnaSelectOneList(qnaNum,conn);
		JDBCTemplate.close(conn);
		return b;
	}

}
