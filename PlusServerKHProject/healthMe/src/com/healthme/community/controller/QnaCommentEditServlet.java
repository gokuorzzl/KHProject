package com.healthme.community.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthme.community.model.service.BoardService;

/**
 * Servlet implementation class QnaCommentEditServlet
 */
@WebServlet(name = "QnaCommentEdit", urlPatterns = { "/qnaCommentEdit.do" })
public class QnaCommentEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaCommentEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String CommentText = request.getParameter("writeCommentText");
		int cNum = Integer.parseInt(request.getParameter("cNum"));
		int bNum = Integer.parseInt(request.getParameter("bNum"));
		int result = new BoardService().qnaCommentUpdate(CommentText,cNum);
		if(result>0) {
			response.sendRedirect("/qnaSelect.do?qnaNum="+bNum);
		}else {
			response.sendRedirect("/page/communityPage/qnaDeleteFail.jsp");
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
