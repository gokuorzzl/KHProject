package com.healthme.community.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthme.community.model.service.BoardService;
import com.healthme.member.vo.Member;

/**
 * Servlet implementation class QnaInsertCommentServket
 */
@WebServlet(name = "QnaInsertComment", urlPatterns = { "/qnaInsertComment.do" })
public class QnaInsertCommentServket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaInsertCommentServket() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		try {
			String userId = ((Member)session.getAttribute("member")).getMemberId();
			String CommentText = request.getParameter("writeCommentText");
			int qnaNum = Integer.parseInt(request.getParameter("qnaNum"));
			
			int result = new BoardService().qnaInsertComment(userId,CommentText,qnaNum);
			if(result>0) {
				response.sendRedirect("/qnaSelect.do?qnaNum="+qnaNum);
			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			response.sendRedirect("/page/communityPage/error.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
