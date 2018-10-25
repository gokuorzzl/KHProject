package com.healthme.community.model.service;

import java.sql.Connection;

import com.healthme.common.JDBCTemplate;
import com.healthme.community.model.dao.WritingPageDao;

public class WritingPageService {

	public int noticeWriting(String titleText, String contentsText, String passwordText) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new WritingPageDao().noticeWriting(titleText,contentsText,passwordText,conn);
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
		int result = new WritingPageDao().QnAWriting(titleText,contentsText,passwordText,conn);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

}
