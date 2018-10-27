package com.healthme.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthme.member.model.service.MemberService;

/**
 * Servlet implementation class SearchPwdServlet
 */
@WebServlet(name = "SearchPwd", urlPatterns = { "/searchPwd.do" })
public class SearchPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	request.setCharacterEncoding("utf-8");
		
		String fmemberId = request.getParameter("memberId");
		String fmemberSocialId = request.getParameter("memberSocialId");
		String fmemberPhone = request.getParameter("memberPhone");	
		
		String memberPw = new MemberService().searchPw(fmemberId,fmemberSocialId,fmemberPhone);
		
		if (memberPw !=null ) {
			
			RequestDispatcher view = request.getRequestDispatcher("page/loginPage/searchPwdSuccess.jsp");
			
			request.setAttribute("memberPw", memberPw);
			
			view.forward(request, response);
			
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
