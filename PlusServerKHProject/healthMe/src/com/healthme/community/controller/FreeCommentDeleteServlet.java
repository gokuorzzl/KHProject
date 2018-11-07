package com.healthme.community.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthme.community.model.service.BoardService;

/**
 * Servlet implementation class FreeCommentDeleteServlet
 */
@WebServlet(name = "FreeCommentDelete", urlPatterns = { "/freeCommentDelete.do" })
public class FreeCommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeCommentDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int cNum = Integer.parseInt(request.getParameter("cNum"));
		int bNum = Integer.parseInt(request.getParameter("bNum"));
		
		int result = new BoardService().freeCommentDelete(cNum);
		
		if(result>0) {
			response.sendRedirect("/freeSelect.do?freeNum="+bNum);
		}else {
			response.sendRedirect("/page/communityPage/freeDeleteFail.jsp");
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
