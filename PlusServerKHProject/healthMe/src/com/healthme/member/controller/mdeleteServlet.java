package com.healthme.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthme.member.model.service.MemberService;
import com.healthme.member.vo.Member;

/**
 * Servlet implementation class mdeleteServlet
 */
@WebServlet(name = "mdelete", urlPatterns = { "/mdelete.do" })
public class mdeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mdeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		String memberId = ((Member)session.getAttribute("member")).getMemberId();
		
		int result = new MemberService().deleteMember(memberId);
		
		if(result>0) {
			session.invalidate();
			response.sendRedirect("/page/loginPage/deleteSuccess.jsp");
		} else {
			response.sendRedirect("/page/loginPage/error.jsp");
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
