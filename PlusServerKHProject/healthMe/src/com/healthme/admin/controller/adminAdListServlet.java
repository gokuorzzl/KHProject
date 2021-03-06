package com.healthme.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthme.admin.model.service.AdminService;
import com.healthme.admin.vo.Ad;

/**
 * Servlet implementation class AdminAdListServlet
 * 광고광고
 */
@WebServlet(name = "AdminAdList", urlPatterns = { "/adminAdList.do" })
public class AdminAdListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * 광고부분이다다다다다
     * @see HttpServlet#HttpServlet()
     */
    public AdminAdListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 비즈니스 로직을 통해 전체 회원 리스트를 가져온다.
				ArrayList<Ad> adList = new AdminService().adminAdList();
		

				//2. 결과 리턴
				
				if(!adList.isEmpty())// list 목록이 있다면 (비워져 있지 않다면 이라는 의미)
				{
					
					RequestDispatcher view = request.getRequestDispatcher("page/admin/adminVisitSetAd.jsp");
					request.setAttribute("adList", adList);
					view.forward(request, response);
					System.out.println("광고리스트스리릐ㅡ");
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
