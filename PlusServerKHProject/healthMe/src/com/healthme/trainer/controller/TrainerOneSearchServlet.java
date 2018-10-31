package com.healthme.trainer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthme.member.vo.Member;
import com.healthme.trainer.model.service.OneSearchService;
import com.healthme.trainer.model.vo.SearchData;

import sun.security.util.PropertyExpander.ExpandException;

/**
 * Servlet implementation class TrainerOneSearchServlet
 */
@WebServlet(name = "TrainerOneSearch", urlPatterns = { "/trainerOneSearch.do" })
public class TrainerOneSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrainerOneSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String memberId = request.getParameter("memberId");
		SearchData sd = new OneSearchService().onsSearch(memberId);

		try {
		if(sd!=null) {
			RequestDispatcher view = request.getRequestDispatcher("/page/trainerPage/trainerPage.jsp");
			request.setAttribute("searchData", sd);
			view.forward(request, response);
		}else {
			response.sendRedirect("/page/error/error.jsp");
		}
		}catch(Exception e) {
			response.sendRedirect("/page/error/error.jsp");
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
