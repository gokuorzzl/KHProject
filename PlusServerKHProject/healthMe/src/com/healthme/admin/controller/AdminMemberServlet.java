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
 * Servlet implementation class AdminMemberServlet
 */
@WebServlet(name = "AdminMember", urlPatterns = { "/adminMember.do" })
public class AdminMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	HttpSession session = request.getSession(false);
	Member admin = (Member)session.getAttribute("member");
	
	//1. 비즈니스 로직을 통해 전체 회원 리스트를 가져오는 작업
	ArrayList<Member> list = new AdminService().adminAllList();
	
	
	// 2. 결과리턴
	
	if(!list.isEmpty()) {
		RequestDispatcher view = request.getRequestDispatcher("/page/admin/adminMemberSet.jsp");
		request.setAttribute("AdminList", list);//객체명,객체
		
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
