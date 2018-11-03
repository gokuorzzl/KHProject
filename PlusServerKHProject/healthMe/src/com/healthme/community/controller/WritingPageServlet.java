package com.healthme.community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthme.community.model.service.BoardService;
import com.healthme.member.vo.Member;

/**
 * Servlet implementation class WritingServlet
 */
@WebServlet(name = "WritingPage", urlPatterns = { "/writingPage.do" })
public class WritingPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WritingPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(false);
		try {
			String userId = ((Member)session.getAttribute("member")).getMemberId();
			
			int boardDivision = Integer.parseInt(request.getParameter("boardDivision"));
			String titleText = request.getParameter("titleText");
			String contentsText = request.getParameter("contentsText");
			String passwordText = request.getParameter("passwordText");
			System.out.println(titleText);
			System.out.println(contentsText);
			System.out.println(passwordText);
			if(boardDivision==0) {
				int result = new BoardService().noticeWriting(titleText,contentsText,passwordText,userId);
				if(result>0) {
					response.sendRedirect("/page/communityPage/fWritingResult.jsp?result=1");
				}else {
					response.sendRedirect("/page/communityPage/fWritingResult.jsp?result=0");
				}
			}else {
				int result = new BoardService().QnAWriting(titleText,contentsText,passwordText,userId);
				if(result>0) {
					response.sendRedirect("/page/communityPage/qWritingResult.jsp?result=1");
				}else {
					response.sendRedirect("/page/communityPage/qWritingResult.jsp?result=0");
				}
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
