package com.healthme.community.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthme.community.model.service.BoardService;
import com.healthme.community.model.vo.Board;
import com.healthme.community.model.vo.BoardPageData;

/**
 * Servlet implementation class FreePageServlet
 */
@WebServlet(name = "FreePage", urlPatterns = { "/freePage.do" })
public class FreePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreePageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage;
		
		
		if(request.getParameter("currentPage")==null) {
			currentPage=1;
		}else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		BoardPageData bpd = new BoardService().freeBoardAllList(currentPage);
		
		if(bpd!=null) {
			RequestDispatcher view = request.getRequestDispatcher("page/communityPage/boardPage.jsp");
			request.setAttribute("boardPageData", bpd);
			
			view.forward(request, response);
		}else {
			response.sendRedirect("/page/communityPage/fError.jsp");
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
