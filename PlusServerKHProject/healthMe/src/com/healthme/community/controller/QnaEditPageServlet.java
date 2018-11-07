package com.healthme.community.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthme.community.model.service.BoardService;

/**
 * Servlet implementation class QnaEditPageServlet
 */
@WebServlet(name = "QnaEditPage", urlPatterns = { "/qnaEditPage.do" })
public class QnaEditPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaEditPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
		String title = request.getParameter("titleText");
		String contents = request.getParameter("contentsText");
		int Pwd = Integer.parseInt(request.getParameter("passwordText"));
		
		int result = new BoardService().qnaupdateBoard(boardNumber, title, contents, Pwd);
		if(result>0) {
			response.sendRedirect("/qnaSelect.do?qnaNum="+boardNumber);
		}else {
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
