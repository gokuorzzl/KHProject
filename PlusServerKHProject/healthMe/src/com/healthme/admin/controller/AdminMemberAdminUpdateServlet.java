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

/**
 * Servlet implementation class AdminMemberAdminUpdateServlet
 */
@WebServlet(name = "adminMemberAdminUpdate", urlPatterns = { "/adminMemberAdminUpdate.do" })
public class AdminMemberAdminUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberAdminUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		
		//2. view에서 넘겨준 데이터를 변수에 저장
		String adminPW = request.getParameter("adminPW");
		String adminId = null; //수정을 요청하는 관리자의 ID
		
		//3. 해당 글을 수정하기 위하여 작성자를 확인하여 처리 하도록 세션을 이용
		HttpSession session = request.getSession(false);
		
		try {
			adminId = ((Admin)session.getAttribute("admin")).getAdminId();
			if(adminId != null) {
				//4. 비즈니스 로직 처리
				int result = new AdminService().adminMemberAdminUpdate(adminPW,adminId);
				
				if(result>0) {
					response.sendRedirect("/page/admin/updateSuccess.jsp");
				}
				
				else {
					response.sendRedirect("/page/admin/updateFail.jsp");
					
				}
				
				
				
				
			}else {
				throw new Exception();
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
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
