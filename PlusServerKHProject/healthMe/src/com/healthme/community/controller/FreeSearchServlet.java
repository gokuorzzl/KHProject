package com.healthme.community.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthme.community.model.service.BoardService;
import com.healthme.community.model.vo.BoardPageData;

/**
 * Servlet implementation class FreeSearchServlet
 */
@WebServlet(name = "FreeSearch", urlPatterns = { "/freeSearch.do" })
public class FreeSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String searchText = request.getParameter("searchText");
		int searchSelect = Integer.valueOf(request.getParameter("searchSelect"));
		
		int currentPage;
		
		if(request.getParameter("currentPage")==null) {
			currentPage=1;
		}else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		BoardPageData bpd = new BoardService().freeSearchList(currentPage, searchText,searchSelect);
		
		if(bpd!=null) {
			RequestDispatcher view = request.getRequestDispatcher("page/communityPage/boardPage.jsp");
			request.setAttribute("boardPageData", bpd);
			request.setAttribute("keyword", searchText);
			
			view.forward(request, response);
		}else {
			response.sendRedirect("/page/communityPage/boardPage.jsp");
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
