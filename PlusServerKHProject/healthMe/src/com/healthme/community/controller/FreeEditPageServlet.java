package com.healthme.community.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthme.community.model.service.BoardService;

/**
 * Servlet implementation class FreeEditPageServlet
 */
@WebServlet(name = "FreeEditPage", urlPatterns = { "/freeEditPage.do" })
public class FreeEditPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeEditPageServlet() {
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
		
		int result = new BoardService().freeupdateBoard(boardNumber, title, contents, Pwd);
		if(result>0) {
			response.sendRedirect("/freeSelect.do?freeNum="+boardNumber);
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
