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
import com.healthme.trainer.model.vo.Trainer;

/**
 * Servlet implementation class AdminTmptrainerPermitServlet
 * 트레이너 목록 보여주고 허락하는걸 할것이다.
 */
@WebServlet(name = "AdminTmptrainerPermit", urlPatterns = { "/adminTmptrainerPermit.do" })
public class AdminTmptrainerPermitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminTmptrainerPermitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ArrayList<Trainer> list = new AdminService().adminAllListTmp();
		
		if(!list.isEmpty()) {
			RequestDispatcher view = request.getRequestDispatcher("/page/admin/adminNormalsetTrainertmp.jsp");
			request.setAttribute("memberAllListTmp", list);
			
			view.forward(request, response);
			
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
