package com.healthme.trainer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthme.trainer.model.service.TrainerService;
import com.healthme.trainer.vo.Trainer;

/**
 * Servlet implementation class EnrollServlet
 */
@WebServlet(name = "Enroll", urlPatterns = { "/enroll.do" })
public class EnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		/*
		Member m = new Member();
		m.setMemberId(request.getParameter("memberId"));
		m.setMemberPw(request.getParameter("memberPw"));
		m.setMemberName(request.getParameter("memberName"));
		m.setMemberSocialId(request.getParameter("memberSocialId"));
		m.setMemberAddr(request.getParameter("memberAddr"));
		m.setMemberPhone(request.getParameter("memberPhone"));
		m.setMemberEmail(request.getParameter("memberEmail"));
		int result = new MemberService().insertMember(m);
		if (result>0) {	response.sendRedirect("/page/loginPage/enrollSuccess.jsp");	}
		else {response.sendRedirect("/page/loginPage/error.jsp");		}
		*/
		//트레이너 객체 생성하여 객체정보를 트레이너이력서 페이지에서 등록할 때 받아오도록 함.
		Trainer t = new Trainer();
		t.setProfileFile(request.getParameter("profileFile"));
//		t.setTrainerGradFile(request.getParameter("trainerGradFile"));	//졸업인증파일
		t.setUniv(request.getParameter("univ"));	// 소속대학
		t.setGrad(request.getParameter("gard").charAt(0));	// a:재학, b:졸업, c: 수료
		t.setGym(request.getParameter("gym"));	//트레이너 gym지역
		t.setSubject(request.getParameter("subject"));	//수업 주제
		t.setContent(request.getParameter("content"));	//수업소개
		t.setTrainerEvent(request.getParameter("trainerEvent"));	//트레이너 종목
//		t.setCareerFile(request.getParameter("careerFile")); //경력인증파일
		t.setCareerStart1(request.getParameter("careerStart1")); //경력시작일
		t.setCareerEnd1(request.getParameter("careerEnd1"));	//경력종료일
		t.setCareerStart2(request.getParameter("careerStart2"));
		t.setCareerEnd2(request.getParameter("careerEnd2"));
		t.setCareerStart3(request.getParameter("careerStart3"));
		t.setCareerEnd3(request.getParameter("careerEnd3"));
		t.setCareerStart4(request.getParameter("careerStart4"));
		t.setCareerEnd4(request.getParameter("careerEnd4"));
		t.setCareerStart5(request.getParameter("careerStart5"));
		t.setCareerEnd5(request.getParameter("careerEnd5"));
		t.setLicenseFile(request.getParameter("licenseFile"));
		t.setLicenseName1(request.getParameter("licenseName1"));
		t.setLicenseName2(request.getParameter("licenseName2"));
		t.setLicenseName3(request.getParameter("licenseName3"));
		t.setLicenseName4(request.getParameter("licenseName4"));
		t.setLicenseName5(request.getParameter("licenseName5"));
		
		
		int result = new TrainerService().insertTrainer(t);
		
		if (result>0) {
			response.sendRedirect("/page/loginPage/enrollSuccess.jsp");
		} else {
			response.sendRedirect("/page/loginPage/error.jsp");
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
