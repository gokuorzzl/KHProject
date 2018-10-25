package com.healthme.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthme.admin.model.service.*;
import com.healthme.admin.vo.Admin;

/**
 * Servlet implementation class AdminAdminServlet
 */
//관리자 정보 변경
@WebServlet(name = "AdminAdmin", urlPatterns = { "/adminAdmin.do" })
public class AdminAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession(false);
		Admin a = (Admin)session.getAttribute("admin");
		
		String adminId = a.getAdminId();
		String adminPw = a.getAdminPW();
		
		Admin admin = new AdminService().updateAdmin(adminId,adminPw);
		
		if(admin != null) {
			RequestDispatcher view = request.getRequestDispatcher("page/admin/adminAdminSet.jsp");
		
			request.setAttribute("admin", admin);
			
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
