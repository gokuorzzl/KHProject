package com.healthme.admin.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthme.admin.model.service.AdminService;

/**
 * Servlet implementation class AdminBoardNoticeServlet
 */
@WebServlet(name = "AdminBoardNotice", urlPatterns = { "/adminBoardNotice.do" })
public class AdminBoardNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminBoardNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("공지사항 설정하는곳 왔다아아아아아아아");
		request.setCharacterEncoding("utf-8");
		
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String noticeSel = request.getParameter("noticeSel");
		
		System.out.println(title+"타이틀");
		System.out.println(content+"내용");
		System.out.println(noticeSel+"노티스셀");
		
		
		int result = new AdminService().adminBoardNotice(noticeSel,title,content);
		
		System.out.println("result의값값값"+result);
		//noticeSel  자유, 질문 으로 나눠진다.
		if(result>0) {
			if(noticeSel.equals("자유")) {
				response.sendRedirect("/adminBoardSetBoard.do");
			}else {
				response.sendRedirect("/adminBoardQAll.do");
			}
			
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
