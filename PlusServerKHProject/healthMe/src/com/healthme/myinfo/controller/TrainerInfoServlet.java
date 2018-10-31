package com.healthme.myinfo.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthme.myinfo.model.service.TrainerInfoService;
import com.healthme.myinfo.model.vo.TrainerInfo;

/**
 * Servlet implementation class TrainerInfoServlet
 */
@WebServlet(name = "TrainerInfo", urlPatterns = { "/trainerInfo.do" })
public class TrainerInfoServlet extends HttpServlet {
	static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrainerInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		
		//2.views에서 가져온 데이터 변수에 저장
		String memberID = request.getParameter("memberId");
	    //String profileFile = request.getParameter("profileFile");
	    //String trainerGradFile = request.getParameter("trainerGradFile");
	    String trainerUniv = request.getParameter("trainerUniv");
	    char trainerGrad = request.getParameter("trainerGrad").charAt(0);
	    String trainerRegion = request.getParameter("trainerRegion");
	    String trainerContent = request.getParameter("trainerContent");
	    String trainerEvent = request.getParameter("trainerEvent");
	    /*
	    //String trainerCareerFile = request.getParameter("trainerCareerFile");
	    Date careerStart1 = Date.valueOf(request.getParameter("careerStart1"));
		Date careerEnd1 = Date.valueOf(request.getParameter("careerEnd1"));
		String careerName1 = request.getParameter("careerName1");
		Date careerStart2 = Date.valueOf(request.getParameter("careerStart2"));
		Date careerEnd2 = Date.valueOf(request.getParameter("careerEnd2"));
		String careerName2 = request.getParameter("careerName2");
		Date careerStart3 = Date.valueOf(request.getParameter("careerStart3"));
		Date careerEnd3 = Date.valueOf(request.getParameter("careerEnd3"));
		String careerName3 = request.getParameter("careerName3");
		Date careerStart4 = Date.valueOf(request.getParameter("careerStart4"));
		Date careerEnd4 = Date.valueOf(request.getParameter("careerEnd4"));
		String careerName4 = request.getParameter("careerName4");
		Date careerStart5 = Date.valueOf(request.getParameter("careerStart5"));
		Date careerEnd5 = Date.valueOf(request.getParameter("careerEnd5"));
		String careerName5 = request.getParameter("careerEnd5");
		//String trainerLicenseFile = request.getParameter("trainerLicenseFile");
		String licenseName1 = request.getParameter("licenseName1");
		String licenseName2 = request.getParameter("licenseName2");
		String licenseName3 = request.getParameter("licenseName3");
		String licenseName4 = request.getParameter("licenseName4");
		String licenseName5 = request.getParameter("licenseName5");
		*/
		TrainerInfo ti = new TrainerInfo();
		//ti.set
		ti.setMemberID(memberID);
		ti.setTrainerUniv(trainerUniv);
		ti.setTrainerContent(trainerContent);
		ti.setTrainerEvent(trainerEvent);
		
		//3.비즈니스 로직처리
		int result =new TrainerInfoService().insertTrainerInfo(ti);

		//4.결과
		if(result>0) {
			//데이터 양 많을때(보안강화, url에 서블릿 주소가 표시)
			RequestDispatcher view = request.getRequestDispatcher("/page/mypage/trainerInfoSuccess.jsp");
			request.setAttribute("result", result);
			view.forward(request, response);
		}else {
			//데이터 양 적을때(url에 경로가 그대로 표시됨)
			response.sendRedirect("/page/mypage/trainerInfoFail.jsp");
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
