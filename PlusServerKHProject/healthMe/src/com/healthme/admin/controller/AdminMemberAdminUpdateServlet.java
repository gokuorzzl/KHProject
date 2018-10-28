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
		
		//2. ID값은 session에서 추출, 나머지 값은 view에서 보내준 값을 추출
		HttpSession session = request.getSession(false);
		
		String adminId = ((Admin)session.getAttribute("admin")).getAdminId();
		String adminPw = request.getParameter("adminPw");
		String adminEmail = request.getParameter("adminEmail");
		String adminName = request.getParameter("adminName");
		
		Admin a = new Admin();
		a.setAdminId(adminId);
		a.setAdminPw(adminPw);
		a.setAdminEmail(adminEmail);
		a.setAdminName(adminName);
		
		//3. 비즈니스 로직
		int result = new  AdminService().adminMemberAdminUpdate(a);
		
		//세션 정보 업데이트를 위하여 정보 가져오기 및 세션에 저장된 정보 변경
		
		Admin admin = new AdminService().selectOneAdmin(adminId, adminPw);
		session.setAttribute("admin", admin);
		
		//4. 결과 리턴
		
		if(result>0) {
			response.sendRedirect("/page/admin/updateSuccess.jsp");
		}else {
			response.sendRedirect("/page/admin/updateFail.jsp");
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
