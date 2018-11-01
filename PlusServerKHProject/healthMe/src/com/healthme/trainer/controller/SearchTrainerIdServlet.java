package com.healthme.trainer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthme.trainer.model.service.OneSearchService;
import com.healthme.trainer.model.vo.Trainer;

/**
 * Servlet implementation class SearchTrainerIdServlet
 */
@WebServlet(name = "SearchTrainerId", urlPatterns = { "/searchTrainerId.do" })
public class SearchTrainerIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchTrainerIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String memberId = request.getParameter("memberId");
		Trainer t = new OneSearchService().trainerSearch(memberId);
		
		if(t!=null) {
			RequestDispatcher view = request.getRequestDispatcher("/page/mypage/mypageMain.jsp");
			request.setAttribute("trainer", t);
			view.forward(request, response);
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
