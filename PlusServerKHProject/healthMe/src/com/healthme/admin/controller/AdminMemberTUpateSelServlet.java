package com.healthme.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthme.admin.model.service.AdminService;
import com.healthme.trainer.model.vo.Trainer;

/**
 * Servlet implementation class AdminMemberTUpateSelServlet
 * 트레이너 리스트 보여준후 수정을 누를경우 값을 갖고오는 것이다.
 * 
 */
@WebServlet(name = "adminMemberTUpateSel.do", urlPatterns = { "/adminMemberTUpateSel.do" })
public class AdminMemberTUpateSelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberTUpateSelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		
		//2. view에서 전송한 데이터를 변수에 저장
		String memberId = request.getParameter("memberId");
		
		//3. 비즈니스 로직 처리
		Trainer t = new AdminService().adminTrainerTUpdateSel(memberId);
		
		System.out.println("트레이너 수정버튼클릭실행서블릿"+t);
		
		//4. 결과 리턴
		if(t != null) {
			RequestDispatcher view = request.getRequestDispatcher("page/admin/adminTrainermodify.jsp");
			request.setAttribute("adminTrainermodify", t);
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
