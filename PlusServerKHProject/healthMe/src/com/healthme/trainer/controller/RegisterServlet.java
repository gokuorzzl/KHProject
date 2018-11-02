package com.healthme.trainer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthme.member.vo.Member;
import com.healthme.trainer.model.service.RegisterService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(name = "Register", urlPatterns = { "/register.do" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String trainerId = request.getParameter("trainerId");
		String trainerSubject = request.getParameter("trainerSubject");
		
		HttpSession session = request.getSession(false);
		try {
		String userId =((Member)session.getAttribute("member")).getMemberId();
		System.out.println("servlet : "+userId);
		if(userId!=null) {
			int result = new RegisterService().insertRegister(trainerId, trainerSubject, userId);
			if(result>0) {
				response.sendRedirect("/page/mypage/");//마이페이지 부분으로 넘길 예정
			}else {
				response.sendRedirect("/page/error/error.jsp");
			}
		}
		}catch(Exception e) {
			response.sendRedirect("/page/error/error.jsp");
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
