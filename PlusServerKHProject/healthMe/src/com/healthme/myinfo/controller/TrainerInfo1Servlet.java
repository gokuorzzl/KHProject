package com.healthme.myinfo.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthme.admin.model.service.AdminService;
import com.healthme.member.vo.Member;
import com.healthme.myinfo.model.vo.TrainerInfo;
import com.healthme.trainer.model.vo.Trainer;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class TrainerInfo1Servlet
 */
@WebServlet(name = "TrainerInfo1", urlPatterns = { "/trainerInfo1.do" })
public class TrainerInfo1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrainerInfo1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected int doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String memberId = ((Member)session.getAttribute("member")).getMemberId();
		
		// 파일이 저장될 서버의 경로. 되도록이면 getRealPath를 이용하자.
		// String savePath = "D:/Projects/workspace/projectName/WebContent/folderName";
		String savePath = request.getServletContext().getRealPath("folderName");
		
		// 파일 크기 15MB로 제한
		int sizeLimit = 1024*1024*15;
		
		
		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
		
		
		
		// MultipartRequest로 전송받은 데이터를 불러온다.
		// enctype을 "multipart/form-data"로 선언하고 submit한 데이터들은 request객체가 아닌 MultipartRequest객체로 불러와야 한다.
		
		String trainerUniv1 = multi.getParameter("trainerUniv1");
		System.out.println("1");
		System.out.println("trainerUniv1"+trainerUniv1);
		String trainerUniv2 = multi.getParameter("trainerUniv2");
	    String trainerUniv = trainerUniv1+" "+trainerUniv2;
	    System.out.println("trainerUniv1"+trainerUniv1);
	    String trainerGrad = multi.getParameter("trainerGrad");
	    System.out.println("trainerUniv1"+trainerUniv1);
		    String trainerRegion1 = multi.getParameter("trainerRegion1");
		    System.out.println("TTTTTTtrainerRegion");
		    System.out.println("trainerUniv1"+trainerUniv1);
		    String trainerRegion2 = multi.getParameter("trainerRegion2");
		    System.out.println("TTTTTTtrainerRegion");
		    String trainerRegion3 = multi.getParameter("trainerRegion3");
		    System.out.println("TTTTTTtrainerRegion@@$@$@$");
	    String trainerRegion = trainerRegion1+" "+trainerRegion2+" "+trainerRegion3;
	    String trainerSubject = multi.getParameter("trainerSubject");
	    String trainerContent = multi.getParameter("trainerContent");
	    String profileFile = multi.getParameter("profileFile");
	    String trainerGradFile = multi.getParameter("trainerGradFile");
	    String trainerCareerFile = multi.getParameter("trainerCareerFile");
	    System.out.println("trainerUniv1"+trainerUniv1);
	    String trainerLicenseFile = multi.getParameter("trainerLicenseFile");
	    	String [] trainerEventvalue = multi.getParameterValues("trainerEvent");
	    String trainerEvent = "";
		
	    
	    
	    for(int i=0;i<trainerEventvalue.length;i++) {//받아온 스트링 값+','+스트링값
	    	if(trainerEventvalue[i]!=null) {//스쿼시,야구,  이런식일때 마지막 ','를 빼기 위한 함수
	    		//이때만 뺴기1을하면된다.
	    		if((trainerEventvalue.length-i-1)!=0) {
	    			trainerEvent += trainerEventvalue[i]+",";
	    		}
	    		else {
	    			trainerEvent += trainerEventvalue[i];
	    		}
	    		continue;
	    	}
	    	
	    }	    
	    
	    
	    Date careerStart1 = Date.valueOf(multi.getParameter("careerStart1"));
	    System.out.println("careerStart1adasdas"+careerStart1);
		Date careerEnd1 = Date.valueOf(multi.getParameter("careerEnd1"));
		String careerName1 = multi.getParameter("careerName1");
	    System.out.println("careerName1"+careerName1);
	    
	    
		Date careerStart2 = Date.valueOf(multi.getParameter("careerStart2"));
		System.out.println("careerStart2"+careerStart2);
		Date careerEnd2 = Date.valueOf(multi.getParameter("careerEnd2"));
		
		
		System.out.println("careerEnd2"+careerEnd2);
		String careerName2 = multi.getParameter("careerName2");
		System.out.println("careerName2"+careerName2);
		
		
		Date careerStart3 = Date.valueOf(multi.getParameter("careerStart3"));
		System.out.println("careerStart3"+careerStart3);
		Date careerEnd3 = Date.valueOf(multi.getParameter("careerEnd3"));
		String careerName3 = multi.getParameter("careerName3");
		
		
		Date careerStart4 = Date.valueOf(multi.getParameter("careerStart4"));
		Date careerEnd4 = Date.valueOf(multi.getParameter("careerEnd4"));
		String careerName4 = multi.getParameter("careerName4");
		
		Date careerStart5 = Date.valueOf(multi.getParameter("careerStart5"));
		System.out.println("careerStart5"+careerStart5);
		Date careerEnd5 = Date.valueOf(multi.getParameter("careerEnd5"));
		System.out.println("careerEnd5"+careerEnd5);
		String careerName5 = multi.getParameter("careerName5");
		String licenseName1 = multi.getParameter("licenseName1");
		System.out.println("licenseName1"+licenseName1);
		String licenseName2 = multi.getParameter("licenseName2");
		System.out.println("licenseName2"+licenseName2);
		String licenseName3 = multi.getParameter("licenseName3");
		String licenseName4 = multi.getParameter("licenseName4");
		String licenseName5 = multi.getParameter("licenseName5");
		
		// 전송받은 데이터가 파일일 경우 getFilesystemName()으로 파일 이름을 받아올 수 있다.
		String fileName = multi.getFilesystemName("m_file");
		
		// 업로드한 파일의 전체 경로를 DB에 저장하기 위함
		String m_fileFullPath = savePath + "/" + fileName;
		
		//데이터들을 담을 그릇인 DAO 객체를 생성한다.
		TrainerInfo ti = new TrainerInfo();
//		ti.setMemberID(userId);
		ti.setTrainerUniv(trainerUniv);
		ti.setTrainerGrad(trainerGrad.charAt(0));
		ti.setTrainerRegion(trainerRegion);
		ti.setTrainerSubject(trainerSubject);
		ti.setTrainerContent(trainerContent);
		ti.setProfileFile(profileFile);
		ti.setTrainerGradFile(trainerGradFile);
		ti.setTrainerCareerFile(trainerCareerFile);
		ti.setTrainerLicenseFile(trainerLicenseFile);
		ti.setTrainerEvent(trainerEvent);
		ti.setCareerStart1(careerStart1);
		ti.setCareerEnd1(careerEnd1);
		ti.setCareerName1(careerName1);
		ti.setCareerStart2(careerStart2);
		ti.setCareerEnd2(careerEnd2);
		ti.setCareerName2(careerName2);
		ti.setCareerStart3(careerStart3);
		ti.setCareerEnd3(careerEnd3);
		ti.setCareerName3(careerName3);
		ti.setCareerStart4(careerStart4);
		ti.setCareerEnd4(careerEnd4);
		ti.setCareerName4(careerName4);
		ti.setCareerStart5(careerStart5);
		ti.setCareerEnd5(careerEnd5);
		ti.setCareerName5(careerName5);
		ti.setLicenseName1(licenseName1);
		ti.setLicenseName2(licenseName2);
		ti.setLicenseName3(licenseName3);
		ti.setLicenseName4(licenseName4);
		ti.setLicenseName5(licenseName5);
		
		//Service 객체 생성 (서비스가 없고 Dao에서 직접 처리한다면 Dao 객체 생성)
				 
		int result =new TrainerInfo().insertTrainerInfo(ti,memberId);
				
				
				
				//4. 결과 리턴
		if(result>0) {
			response.sendRedirect("/page/경로쓰기!/adminAll.jsp");
		}
		else {
			response.sendRedirect("/page/경로쓰기/error.jsp");
		}
		
		
		////////////////////////////////////////////////////////////
		return result;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
