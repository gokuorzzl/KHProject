package com.healthme.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthme.admin.model.service.AdminService;
import com.healthme.member.vo.Member;

/**
 * Servlet implementation class AdminMemberUpateSelServlet
 	관리자페이지에서 수정을 하면 수정을 선택한 곳으로 화면이 이동한다.
 */
@WebServlet(name = "AdminMemberUpateSel", urlPatterns = { "/adminMemberUpateSel.do" })
public class AdminMemberUpateSelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberUpateSelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//1. 인코딩
				request.setCharacterEncoding("utf-8");
				
				//2. view에서 전송한 데이터를 변수에  저장
				String memberId = request.getParameter("memberId");//완료
				
				//3. 비즈니스 로직 처리
				Member m = new AdminService().adminMemberUpdateSel(memberId);
				
				//4. 결과 리턴
				if(m != null) {
					RequestDispatcher view = request.getRequestDispatcher("page/admin/adminMembermodify.jsp");
					request.setAttribute("adminMembermodify", m);
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
