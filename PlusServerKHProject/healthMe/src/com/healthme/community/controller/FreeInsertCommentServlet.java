package com.healthme.community.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthme.community.model.service.BoardService;
import com.healthme.member.vo.Member;

/**
 * Servlet implementation class FreeInsertCommentServlet
 */
@WebServlet(name = "FreeInsertComment", urlPatterns = { "/freeInsertComment.do" })
public class FreeInsertCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeInsertCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		try {
			String userId = ((Member)session.getAttribute("member")).getMemberId();
			String CommentText = request.getParameter("writeCommentText");
			int freeNum = Integer.parseInt(request.getParameter("freeNum"));
			
			int result = new BoardService().freeInsertComment(userId,CommentText,freeNum);
			if(result>0) {
				response.sendRedirect("/freeSelect.do?freeNum="+freeNum);
			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			response.sendRedirect("/page/communityPage/error.jsp");
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
