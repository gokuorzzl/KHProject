package com.healthme.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthme.member.model.service.MemberService;
import com.healthme.member.vo.Member;

/**
 * Servlet implementation class SearchIdServlet
 */
@WebServlet(name = "SearchId", urlPatterns = { "/searchId.do" })
public class SearchIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String fmemberName = request.getParameter("memberName");
		String fmemberSocialId = request.getParameter("memberSocialId");
		String fmemberPhone = request.getParameter("memberPhone");	
		
		String memberId = new MemberService().searchId(fmemberName,fmemberSocialId,fmemberPhone);
		
		if (memberId !=null ) {
			
			RequestDispatcher view = request.getRequestDispatcher("page/loginPage/searchIdSuccess.jsp");
			
			request.setAttribute("memberId", memberId);
			
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
