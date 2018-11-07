package com.healthme.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthme.admin.model.service.AdminService;
import com.healthme.admin.vo.Admin;
import com.healthme.member.model.service.MemberService;
import com.healthme.member.vo.Member;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet(name = "adminLogin", urlPatterns = { "/adminLogin.do" })
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		request.setCharacterEncoding("utf-8");
		
		String adminId = request.getParameter("adminId");
		String adminPw = request.getParameter("adminPw");
		
		
		Admin admin = new AdminService().selectOneAdmin(adminId,adminPw);
		
		if(admin!=null) {
			
			HttpSession session = request.getSession(true);
			
			System.out.println("발급된 세션 ID: "+session.getId());
			
			session.setAttribute("admin", admin);
			
			response.sendRedirect("/page/admin/adminLoginSuccess.jsp");
			
			
			
			
		} else {
			
			response.sendRedirect("/page/admin/adminLoginFail.jsp");
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
