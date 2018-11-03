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

import oracle.net.aso.e;

/**
 * Servlet implementation class MypageMainServlet
 */
@WebServlet(
		name = "MypageMain", 
		urlPatterns = { 
				"/mypageMain.do", 
				"/mypageMain1.do"
		})
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
		
		request.setCharacterEncoding("utf-8");	//받아온값을 인코딩하는 것.
		
		//ArrayList<Trainer> trainerList = (ArrayList<Trainer>)request.getAttribute("trainerList");
		
		HttpSession session = request.getSession(false);	//세션이 true이면 없을경우 새로 생성 함.
		String memberId = ((Member)session.getAttribute("member")).getMemberId(); //세션으로부터 memberId를 받아옴.
		System.out.println("세션의값값값"+session);
		System.out.println(memberId+"멤버아이디의값값마이페이지메인서블릿");
		ArrayList<Mypage> mylist = new MypageMainService().searchMemberTrainer(memberId);	//받아온 멤버id로 회원의 수강정보 가져오도록하자.
		System.out.println("mylist의 값값값값"+mylist);
		
		if(!mylist.isEmpty()) {
			RequestDispatcher view = request.getRequestDispatcher("page/mypage/mypageMain.jsp");
			request.setAttribute("mylist", mylist);
			view.forward(request, response);
		}else {
			System.out.println("에러에러에러에ㅓㄹ");
			response.sendRedirect("page/searchTrainerPage/searchError.jsp");
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
