package com.healthme.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthme.admin.model.service.AdminService;

/**
 * Servlet implementation class AdminMemberDelServlet
 */
@WebServlet(name = "AdminMemberDel", urlPatterns = { "/adminMemberDel.do" })
public class AdminMemberDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberDelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 이부분은 관리자페이지에서 삭제를 누르면 삭제되는 곳입니다.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String memberId = request.getParameter("memberId");
		
		//비즈니스 로직처리
		int result = new AdminService().adminMemberDel(memberId);
		
		
		//결과 리턴
		if(result>0) {
			response.sendRedirect("/adminAllList.do");
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
