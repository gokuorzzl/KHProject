package com.healthme.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthme.admin.model.service.AdminService;
import com.healthme.trainer.model.vo.Matching;

/**
 * Servlet implementation class AdminMatchingAllServlet
 * 매칭 리스트 보여줄려는 서블릿
 */
@WebServlet(name = "AdminMatchingAll", urlPatterns = { "/adminMatchingAll.do" })
public class AdminMatchingAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMatchingAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 비즈니스 로직을 통해 전체 회원 리스트를 가져온다.
		ArrayList<Matching> list = new AdminService().adminMatchingAll();
		
		if(!list.isEmpty()) {
			RequestDispatcher view = request.getRequestDispatcher("page/admin/adminMemberMatching.jsp");
			request.setAttribute("matchingAllList", list);
			
			view.forward(request, response);
		}else {
			response.sendRedirect("/page/admin/error.jsp");
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
