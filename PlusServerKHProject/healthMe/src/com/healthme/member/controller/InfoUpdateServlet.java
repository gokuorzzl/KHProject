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
 * Servlet implementation class InfoUpdateServlet
 */
@WebServlet(name = "InfoUpdate", urlPatterns = { "/infoUpdate.do" })
public class InfoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession(false);
		
		String memberId = ((Member)session.getAttribute("member")).getMemberId();
		String memberPw = request.getParameter("memberPw");
		String memberAddr = request.getParameter("memberAddr");
		String memberEmail = request.getParameter("memberEmail");
		String memberPhone = request.getParameter("memberPhone");
		
		Member m = new Member();
		m.setMemberId("memberId");
		m.setMemberPw("memberPw");
		m.setMemberAddr("memberAddr");
		m.setMemberEmail("memberEmail");
		m.setMemberPhone("memberPhone");
		
		int result = new MemberService().updateMember(m);
		
		Member member = new MemberService().selectOneMember(memberId, memberPw);
		
		session.setAttribute("member", member);
		
		if(result>0) {
			response.sendRedirect("/page/loginPage/enrollSuccess.jsp");
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
