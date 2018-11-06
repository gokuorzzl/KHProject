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
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");	//받아온값을 인코딩하는 것
		
		HttpSession session = request.getSession(false);	//세션이 true이면 없을경우 새로 생성 함.
		String memberId = ((Member)session.getAttribute("member")).getMemberId(); //세션으로부터 memberId를 받아옴.
		char isTrainer = ((Member)session.getAttribute("member")).getMemberTrainer(); //트레이너인지 검사
		
		ArrayList<Mypage> mylist = null;
		if(isTrainer=='y') {	// 트레이너라면
			mylist = new MypageMainService().trainerMypage(memberId);
			//System.out.println("마이페이지 서블릿 : 트레이너=yes");
		}else {	// 일반회원이라면
			mylist = new MypageMainService().memberMypage(memberId);	//받아온 멤버id로 회원의 수강정보 가져오도록하자.
			//System.out.println("마이페이지 서블릿 : 트레이너=no");
		}	//마이페이지 정보를 가져온다.
		
		// 결과처리
		if( isTrainer=='y' && !mylist.isEmpty()) { 
			RequestDispatcher view = request.getRequestDispatcher("page/mypage/mypageMain2.jsp");
			request.setAttribute("mylist", mylist);	//이부분 체크해야됨
			view.forward(request, response);
		}else if(isTrainer=='n' && !mylist.isEmpty()) {
			RequestDispatcher view = request.getRequestDispatcher("page/mypage/mypageMain.jsp");
			request.setAttribute("mylist", mylist);	// 이부분 체크 바람
			//System.out.println("마이서블릿 회원list: "+mylist.get(0).getMemberId()+ "\n"+ mylist.get(0).getProfile());
			view.forward(request, response);
		}else {
			//System.out.println("에러러러러러럴");
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
