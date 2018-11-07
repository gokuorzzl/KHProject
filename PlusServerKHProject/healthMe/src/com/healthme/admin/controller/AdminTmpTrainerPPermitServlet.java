package com.healthme.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthme.admin.model.service.AdminService;

/**
 * Servlet implementation class AdminTmpTrainerPPermitServlet
 *트레이너 허락하는 서블릿
 */
@WebServlet(name = "adminTmpTrainerPPermit", urlPatterns = { "/adminTmpTrainerPPermit.do" })
public class AdminTmpTrainerPPermitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminTmpTrainerPPermitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberId = request.getParameter("memberId");
		
		int result = new AdminService().admintmpTrainer(memberId);
		
		if(result>0) {
			response.sendRedirect("/adminTmptrainerPermit.do");
			
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
