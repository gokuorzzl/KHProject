package com.healthme.myinfo.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthme.member.vo.Member;
import com.healthme.myinfo.model.service.TrainerInfoService;
import com.healthme.myinfo.model.vo.TrainerInfo;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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
		
		//▷▶파일 입출력 구현을 위한 몇 가지 정보 기입◀◁
		//참고https://blog.naver.com/PostView.nhn?blogId=holykhd&logNo=30186579618&proxyReferer=https%3A%2F%2Fwww.google.co.kr%2F
		//▶사용자 계정명(일단 계정을 사용하지 않으니 주석처리)
		HttpSession session = request.getSession(false);
		System.out.println("세션의값은????"+session);
		try {
			String userId = ((Member)session.getAttribute("member")).getMemberId();
		
		//▶최대 업로드 파일 사이즈 지정( cos 라이브러리는 10mb가 한계이다)
		int fileSizeLimit = 5 * 1024 * 1024;
		//1 KByte*1024 == 1024Kbyte -> 1MByte
		
		//▶업로드 될 경로(인덱스의 /를 인식하게 해주려고 쓰는 문단이라 그냥 생각없이 일단 쓰고본다.
		String uploadPath = getServletContext().getRealPath("/uploadFile");
		//String uploadPath = getServletContext().getRealPath("/")+"uploadFile";//+"\\"+userId;유저아이디로 폴더만들때 이거써!!
		System.out.println("파일경로 : "+uploadPath);
		
		//▶인코딩 타입(파일 인코딩 타입) 지정
		String encType="UTF-8";
		//미리 변수에 담아놓고 한 번에 주겠다는 소리임(나중에 객체 만들 때 하나씩 써서 객체를 만들어~~)
		
		//▶위 정보를 바탕으로 파일 업로드에 사용하는 MultipartRequest 객체를 생성함(요친구를 이용해서 파일 업로드를 진행하는데 이 때 사용하는 라이브러리가 cos임)
		//라이브러리 안에 cos 추가해 줬음
		MultipartRequest multi	=	new MultipartRequest(//파일 처리를 위한 전용 객체임
										request,
										uploadPath,
										fileSizeLimit,
										encType,
										new DefaultFileRenamePolicy()
									);
		System.out.println(multi+"multi의값값값");
		//마지막에 만든 DefaultFileRenamePolicy 객체를 만들어서 넣어주면 파일이름의 중복처리를 자동으로 해준다.
		//ex_ a.bmp가 중복으로 2번 업로드를 하게 되면 파일의 이름이 자동으로 a1.bmp, a2.bmp로 변경된다.
		//업로드된 파일의 정보를 바탕으로 DB에 기록할 수 있도록 생성 ㄱㄱ
		
		//2.views에서 가져온 데이터 변수에 저장
		//view에서 변수받아올때 request가 아니고 멀티쓸거임
		String userID = multi.getParameter("memberId");
		System.out.println("멤버의아이디디디디"+userId);
		    String trainerUniv1 = multi.getParameter("trainerUniv1");
		    String trainerUniv2 = multi.getParameter("trainerUniv2");
	    String trainerUniv = trainerUniv1+" "+trainerUniv2;
	    char trainerGrad = multi.getParameter("trainerGrad").charAt(0);
		    String trainerRegion1 = multi.getParameter("trainerRegion1");
		    String trainerRegion2 = multi.getParameter("trainerRegion2");
		    String trainerRegion3 = multi.getParameter("trainerRegion3");
	    String trainerRegion = trainerRegion1+" "+trainerRegion2+" "+trainerRegion3;
	    String trainerSubject = multi.getParameter("trainerSubject");
	    String trainerContent = multi.getParameter("trainerContent");
	    String profileFile = multi.getParameter("profileFile");
	    String trainerGradFile = multi.getParameter("trainerGradFile");
	    String trainerCareerFile = multi.getParameter("trainerCareerFile");
	    String trainerLicenseFile = multi.getParameter("trainerLicenseFile");
	    	String [] trainerEventvalue = multi.getParameterValues("trainerEvent");
	    String trainerEvent = "";
	    
	    System.out.println("trainerEvent읙밧값값"+trainerEvent);
	    
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
		    System.out.println("trainerEventValue의 길이길이"+trainerEventvalue.length);
		    System.out.println("트레이너이벤트!!"+trainerEventvalue);
		    System.out.println("트레이너이벤트!!"+trainerEvent);
		    
	    Date careerStart1 = Date.valueOf(multi.getParameter("careerStart1"));
	    System.out.println("careerStart1adasdas"+careerStart1);
		Date careerEnd1 = Date.valueOf(multi.getParameter("careerEnd1"));
		String careerName1 = multi.getParameter("careerName1");
		Date careerStart2 = Date.valueOf(multi.getParameter("careerStart2"));
		Date careerEnd2 = Date.valueOf(multi.getParameter("careerEnd2"));
		String careerName2 = multi.getParameter("careerName2");
		Date careerStart3 = Date.valueOf(multi.getParameter("careerStart3"));
		Date careerEnd3 = Date.valueOf(multi.getParameter("careerEnd3"));
		String careerName3 = multi.getParameter("careerName3");
		Date careerStart4 = Date.valueOf(multi.getParameter("careerStart4"));
		Date careerEnd4 = Date.valueOf(multi.getParameter("careerEnd4"));
		String careerName4 = multi.getParameter("careerName4");
		Date careerStart5 = Date.valueOf(multi.getParameter("careerStart5"));
		Date careerEnd5 = Date.valueOf(multi.getParameter("careerEnd5"));
		String careerName5 = multi.getParameter("careerEnd5");
		String licenseName1 = multi.getParameter("licenseName1");
		String licenseName2 = multi.getParameter("licenseName2");
		String licenseName3 = multi.getParameter("licenseName3");
		String licenseName4 = multi.getParameter("licenseName4");
		String licenseName5 = multi.getParameter("licenseName5");

		System.out.println("careerStart1의값값값"+careerStart1);
		
		TrainerInfo ti = new TrainerInfo();
		ti.setMemberID(userId);
		ti.setTrainerUniv(trainerUniv);
		ti.setTrainerGrad(trainerGrad);
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
		
		System.out.println("ti의값값값"+ti);
		//3.비즈니스 로직처리
		int result =new TrainerInfoService().insertTrainerInfo(ti,userId);

		System.out.println("result의값값TrainerInfoServletd은???"+result);
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
	}catch(Exception e) {
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

/*

//▶업로드 파일의 실제 DB에 저장되는 총 경로(filePath) - 업로드되는 경로+파일이름
String fullFilePath1 = uploadPath+"\\"+profileFile;
String fullFilePath2 = uploadPath+"\\"+trainerGradFile;
System.out.println("총 경로 : " + fullFilePath1);
System.out.println("총 경로 : " + fullFilePath2);

//▶파일의 크기(length)
File file1 = new File(fullFilePath1);	
long fileSize1 = file1.length();
File file2 = new File(fullFilePath2);	
long fileSize2 = file2.length();
//▶파일 업로드 시간
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
Timestamp uploadTime = null;
uploadTime = Timestamp.valueOf(formatter.format(Calendar.getInstance().getTimeInMillis()));

System.out.println("업로드된 시간 : "+uploadTime);
//객체에 값저장
FileData fd = new FileData();
fd.setFileName(profileFile);		//파일이름
fd.setFilePath(fullFilePath1);	//파일총경로(디렉토리+파일명)
fd.setFileSize(fileSize1);		//파일 사이즈
//fd.setFileUser(userId);			//업로드 유저
fd.setUploadTime(uploadTime);	//업로드된 시간

fd.setFileName(trainerGradFile);		//파일이름
fd.setFilePath(fullFilePath2);	//파일총경로(디렉토리+파일명)
fd.setFileSize(fileSize2);		//파일 사이즈
//fd.setFileUser(userId);			//업로드 유저
fd.setUploadTime(uploadTime);	//업로드된 시간

*/