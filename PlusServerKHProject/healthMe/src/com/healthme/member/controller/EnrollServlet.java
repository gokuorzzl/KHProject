package com.healthme.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthme.member.model.service.MemberService;
import com.healthme.member.vo.Member;

/**
 * Servlet implementation class EnrollServlet
 */
@WebServlet(name = "Enroll", urlPatterns = { "/enroll.do" })
public class EnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		Member m = new Member();
		m.setMemberId(request.getParameter("memberId"));
		m.setMemberPw(request.getParameter("memberPw"));
		m.setMemberName(request.getParameter("memberName"));
		m.setMemberSocialId1(Integer.parseInt(request.getParameter("memberSocialId1")));
		m.setMemberSocialId2(Integer.parseInt(request.getParameter("memberSocialId2")));
		m.setMemberAddr(request.getParameter("memberAddr"));
		m.setMemberEmail(request.getParameter("memberEmail"));
		m.setMemberPhone(request.getParameter("memberPhone"));
		m.setMemberTrainer('n');
		m.setMemberClass(request.getParameter("memberClass"));
		m.setMemberOut('n');
		
			
		int result = new MemberService().insertMember(m);
		System.out.println("enrollServlet"+result);
		if (result>0) {
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
