package com.healthme.admin.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthme.admin.model.service.AdminService;
import com.healthme.trainer.model.vo.Trainer;

/**
 * Servlet implementation class AdminTrainerTUpdateSel
 * 회원수정 폼으로 이동후 수정을 하고 수정하기를 누를경우 수정완료시 All로 이동(트레이너수정후 이동하는 중간이다.)
 */
@WebServlet(name = "adminTrainerTUpdateSel", urlPatterns = { "/adminTrainerTUpdateSel.do" })
public class AdminTrainerTUpdateSel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminTrainerTUpdateSel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		
		String memberId = request.getParameter("memberId");
		String profileFile = request.getParameter("profileFile");
		String trainerGradFile= request.getParameter("trainerGradFile");
		String trainerUniv= request.getParameter("trainerUniv");
		String trainerGrad= request.getParameter("trainerGrad");
		String trainerRegion= request.getParameter("trainerRegion");
		String trainerSubject= request.getParameter("trainerSubject");
		String trainerContent= request.getParameter("trainerContent");
		String trainerEvent= request.getParameter("trainerEvent");
		String trainerCareerFile= request.getParameter("trainerCareerFile");
		//Date careerStart1
		//Date careerEnd1
		String careerName1= request.getParameter("careerName1");
		//Date careerStart2
		//Date careerEnd2
		String careerName2= request.getParameter("careerName2");
		//Date careerStart3
		//Date careerEnd3
		String careerName3= request.getParameter("careerName3");
		//Date careerStart4
		//Date careerEnd4
		String careerName4= request.getParameter("careerName4");
		//Date careerStart5
		//Date careerEnd5
		String careerName5= request.getParameter("careerName5");
		String trainerLicenseFile= request.getParameter("trainerLicenseFile");
		String licenseName1= request.getParameter("licenseName1");
		String licenseName2= request.getParameter("licenseName2");
		String licenseName3= request.getParameter("licenseName3");
		String licenseName4= request.getParameter("licenseName4");
		String licenseName5= request.getParameter("licenseName5");
		
		Trainer t = new Trainer();
		t.setMemberId(memberId);
		t.setProfileFile(profileFile);
		t.setTrainerGradFile(trainerGradFile);
		t.setTrainerUniv(trainerUniv);
		t.setTrainerGrad(trainerGrad);
		t.setTrainerRegion(trainerRegion);
		t.setTrainerSubject(trainerSubject);
		t.setTrainerContent(trainerContent);
		t.setTrainerEvent(trainerEvent);
		t.setTrainerCareerFile(trainerCareerFile);
		t.setCareerName1(careerName1);
		t.setCareerName2(careerName2);
		t.setCareerName3(careerName3);
		t.setCareerName4(careerName4);
		t.setCareerName5(careerName5);
		
		t.setTrainerLicenseFile(trainerLicenseFile);
		t.setLicenseName1(licenseName1);
		t.setLicenseName2(licenseName2);
		t.setLicenseName3(licenseName3);
		t.setLicenseName4(licenseName4);
		t.setLicenseName5(licenseName5);
		
		
		//3. 비즈니스 로직 리턴
		int result = new AdminService().adminTrainerselUpdate(t);
		System.out.println("result의값값값"+result);
		
		//결과 리턴
		if(result>0) {
			response.sendRedirect("/adminAllListT.do");
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
