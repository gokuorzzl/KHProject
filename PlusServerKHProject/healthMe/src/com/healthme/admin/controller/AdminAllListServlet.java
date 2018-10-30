package com.healthme.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthme.admin.model.service.AdminService;
import com.healthme.member.vo.Member;

/**
 * Servlet implementation class AdminAllListServlet
 */
@WebServlet(name = "adminAllList", urlPatterns = { "/adminAllList.do" })
public class AdminAllListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAllListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//1. 비즈니스 로직을 통해 전체 회원 리스트를 가져온다.
		ArrayList<Member> list = new AdminService().adminAllList();
	
		System.out.println(list);
		//2. 결과 리턴
		
		if(!list.isEmpty())// list 목록이 있다면 (비워져 있지 않다면 이라는 의미)
		{
			RequestDispatcher view = request.getRequestDispatcher("page/admin/adminMemberAll.jsp");
			request.setAttribute("memberAllList", list);
			
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
