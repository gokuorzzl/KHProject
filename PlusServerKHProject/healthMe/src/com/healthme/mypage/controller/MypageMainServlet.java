package com.healthme.mypage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthme.member.vo.Member;
import com.healthme.mypage.model.service.MypageMainService;
import com.healthme.mypage.model.vo.Mypage;
import com.healthme.trainer.model.vo.Trainer;

/**
 * Servlet implementation class MypageMainServlet
 */
@WebServlet(name = "MypageMain", urlPatterns = { "/mypageMain.do" })
public class MypageMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Trainer> trainerList = (ArrayList<Trainer>)request.getAttribute("trainerList");
		System.out.println("trainerList : "+trainerList.get(0).getMemberId());
		HttpSession session = request.getSession(false);
		String memberId = ((Member)session.getAttribute("member")).getMemberId();
		
		ArrayList<Mypage> mylist = new MypageMainService().searchMemberTrainer(memberId, trainerList);
		
		System.out.println("servlets : "+mylist);
		RequestDispatcher view = request.getRequestDispatcher("page/mypage/mypageMain.jsp");
		request.setAttribute("mylist", mylist);
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
