package com.healthme.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthme.admin.model.service.AdminService;
import com.healthme.member.vo.Member;

/**
 * Servlet implementation class AdminMemberUpdateSelServlet
 * 회원수정 폼으로 이동후 수정을 하고 수정하기를 누를경우 수정완료시 All로 이동
 */
@WebServlet(name = "AdminMemberUpdateSel", urlPatterns = { "/adminMemberUpdateSel.do" })
public class AdminMemberUpdateSelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberUpdateSelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				//1. 인코딩
				request.setCharacterEncoding("utf-8");
		
				System.out.println("여기는 들어왔나욥!!");
				//2. view에서 전송한 데이터를 변수에 저장
				//아이디도 변경할수 있으므로 변경되었을경우 바꾸기 위해 따로 페이지를 띄었다.
				String memberId = request.getParameter("memberId");
				String memberPw = request.getParameter("memberPw");
				String memberName = request.getParameter("memberName");
				int memberSocialId1 = Integer.parseInt(request.getParameter("memberSocialId1"));
				int memberSocialId2 = Integer.parseInt(request.getParameter("memberSocialId2"));
				String memberAddr = request.getParameter("memberAddr");
				String memberEmail = request.getParameter("memberEmail");
				String memberPhone = request.getParameter("memberPhone");
				char memberTrainer = request.getParameter("memberTrainer").charAt(0);
				String memberClass = request.getParameter("memberClass");
				char memberOut = request.getParameter("memberOut").charAt(0);
				
				Member m = new Member();
				m.setMemberId(memberId);
				m.setMemberPw(memberPw);
				m.setMemberName(memberName);
				m.setMemberSocialId1(memberSocialId1);
				m.setMemberSocialId2(memberSocialId2);
				m.setMemberAddr(memberAddr);
				m.setMemberEmail(memberEmail);
				m.setMemberPhone(memberPhone);
				m.setMemberTrainer(memberTrainer);
				m.setMemberClass(memberClass);
				m.setMemberOut(memberOut);
				
				//3. 비즈니스 로직 처리
				int result = new AdminService().adminMemberselUpdate(m);
				System.out.println("result의값은?"+result);
				//4. 결과 리턴
				
				if(result>0) {
					response.sendRedirect("/adminAllList.do");
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
