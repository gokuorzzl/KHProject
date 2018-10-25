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
		
		try {
			HttpSession session = request.getSession(false);
			Member admin = (Member)session.getAttribute("member");
			
			ArrayList<Member> list =  new AdminService().adminAllList();
			
			if(!list.isEmpty()) {
				RequestDispatcher view = request.getRequestDispatcher("/page/admin/adminMemberSet.jsp");
				request.setAttribute("adminList", list);
				
				view.forward(request, response);
			
			
			}else {
				response.sendRedirect("/page/admin/error.jsp");
			}
			
			
		
		} catch (Exception e) {
			RequestDispatcher view = request.getRequestDispatcher("/page/admin/error.jsp");
			view.forward(request, response);
		
		}
		
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
