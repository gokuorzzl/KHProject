package com.healthme.community.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthme.community.model.service.BoardService;
import com.healthme.community.model.vo.CommentData;

/**
 * Servlet implementation class QnaSelectServlet
 */
@WebServlet(name = "QnaSelect", urlPatterns = { "/qnaSelect.do" })
public class QnaSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int qnaNum = Integer.parseInt(request.getParameter("qnaNum"));
		int currentPage;
		
		if(request.getParameter("currentPage")==null) {
			currentPage=1;
		}else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		CommentData cd = new BoardService().qnaSelectOneList(qnaNum,currentPage);
		if(cd!=null) {
			RequestDispatcher view = request.getRequestDispatcher("/page/communityPage/qnaReadingPage.jsp");
			request.setAttribute("selectBoard", cd);
			System.out.println(cd.getB().getUserId());
			view.forward(request, response);
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
