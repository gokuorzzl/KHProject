package com.healthme.community.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthme.community.model.service.BoardService;
import com.healthme.community.model.vo.Board;

/**
 * Servlet implementation class QnaOneSelectServlet
 */
@WebServlet(name = "QnaOneSelect", urlPatterns = { "/qnaOneSelect.do" })
public class QnaOneSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaOneSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		
		Board b =new BoardService().qnaOneSelect(boardNum);
		if(b!=null) {
			RequestDispatcher view = request.getRequestDispatcher("page/communityPage/editPage.jsp");
			request.setAttribute("board", b);
			request.setAttribute("boardtype", 'q');
			
			view.forward(request, response);
		}else {
			response.sendRedirect("/page/communityPage/errorPage.jsp");
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
