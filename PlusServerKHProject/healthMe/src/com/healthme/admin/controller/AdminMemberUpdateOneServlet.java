package com.healthme.admin.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthme.admin.model.service.AdminService;

/**
 * Servlet implementation class AdminMemberUpdateOneServlet
 */
@WebServlet(name = "AdminMemberUpdateOne", urlPatterns = { "/adminMemberUpdateOne.do" })
public class AdminMemberUpdateOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberUpdateOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//1. 인코딩
				request.setCharacterEncoding("utf-8");
				
				//2. view에서 넘겨준 데이터를 변수에 저장 /*DATe형식 추가 아직 안함 안되면 안하지모*/
				 
				
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

				 int pkMemberNumber = Integer.parseInt(request.getParameter("pkMemberNumber"));
				 String memberId = request.getParameter("memberId");
				 String memberPw = request.getParameter("memberPw");
				 String memberName = request.getParameter("memberName");
				 String memberSocialId = request.getParameter("memberSocialId");
				 String memberAddr = request.getParameter("memberAddr");
				 String memberEmail = request.getParameter("memberEmail");
				 String memberPhone = request.getParameter("memberPhone");
				 char memberTrainer = request.getParameter("memberTrainer").charAt(0);
				 String memberClass = request.getParameter("memberClass");
				 char memberOut = request.getParameter("memberOut").charAt(0);
				
				//3. 해당 글을 수정하기 위하여 작성자를 확인하여 처리 하도록 세션을 이용
					
					//4. 비즈니스 로직 처리
				 int result = new AdminService().adminAllSelectOneUpdate(pkMemberNumber,memberId,memberPw,memberName,memberSocialId,memberAddr,memberEmail,memberPhone,memberTrainer,memberClass,memberOut);
				 
				if(result>0) {
					response.sendRedirect("/page/admin/adminAll.jsp");
				}
				else {
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
