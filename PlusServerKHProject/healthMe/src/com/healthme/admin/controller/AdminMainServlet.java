package com.healthme.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthme.admin.model.service.AdminService;
import com.healthme.admin.vo.AdminMain;

/**
 * Servlet implementation class AdminMainServlet
 * 관리자페이지 메인부분 테이블꺼 갖고올 자료들
 */
@WebServlet(name = "AdminMain", urlPatterns = { "/adminMain.do" })
public class AdminMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 이부분은 관리자 메인페이지 호출시 다 뿌려줄 값을 갖고올 것이다.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		
		
		
		AdminMain am = new AdminService().adminMainPirnt();
		
		 
		 
		if(am != null) {
			RequestDispatcher view = request.getRequestDispatcher("page/admin/adminMain.jsp");
			request.setAttribute("adminMain", am);
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
