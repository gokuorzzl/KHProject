package com.healthme.admin.controller;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



/**
 * Servlet implementation class AdminMemberTrainerMailServlet
 */
@WebServlet(name = "AdminMemberTrainerMail", urlPatterns = { "/adminMemberTrainerMail.do" })
public class AdminMemberTrainerMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberTrainerMailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		request.setCharacterEncoding("utf-8");
		
		
		String to = request.getParameter("to");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		  String host     = "smtp.naver.com";
		  final String user   = "jg555";
		  final String password  = "thdwlgns1!";
		  
		  // Get the session object
		  Properties props = new Properties();
		  props.put("mail.smtp.host", host);
		  props.put("mail.smtp.auth", "true");
		  
		
		  Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			   protected PasswordAuthentication getPasswordAuthentication() {
			    return new PasswordAuthentication(user, password);
			   }
			  });
		  
		  
		// Compose the message
		  try {
		   MimeMessage message = new MimeMessage(session);
		   message.setFrom(new InternetAddress(user));
		   message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		  
		
		   
		   
		   
		   // Subject
		   message.setSubject(subject);
		   
		   // Text
		   message.setText(content);

		   // send the message
		   Transport.send(message);
		   
		   System.out.println("성공적으로 이메일 보냈다!!");
		 
		   response.sendRedirect("/page/admin/adminNormalSet.jsp");
		   
			
		   
		   
		  }catch(MessagingException e) {
			  e.printStackTrace();
			  response.sendRedirect("/page/admin/adminNormalSetMail.jsp");
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
