package com.healthme.search.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.healthme.search.model.service.SearchService;
import com.healthme.search.model.vo.SearchResult;

/**
 * Servlet implementation class SearchInputServlet
 */
@WebServlet(name = "SearchInput", urlPatterns = { "/searchInput.do" })
public class SearchInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchInputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		
		//2. searchTrainerPage에서 보낸 데이터를 저장
		String search = request.getParameter("searchInput");
		//int screenSize = Integer.parseInt(request.getParameter("screenSize"));
		int screenSize=1024;
		
		//3. searchTrainerPage 내 페이징 처리를 위해 페이지 번호를 받아옴
		int currentPage; //현재페이지
		if(request.getParameter("currentPage")==null) {
			//페이지 정보를 요청했을 때 null인 경우 첫 페이지이므로  1페이지로 설정
			currentPage = 1;
		}else {
			//게시판에서 페이지를 이동할 때에는 이미 페이지값이 존재하므로 해당 페이지값을 저장
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		//5. 검색어를 담은 ArrayList와 현재 페이지 정보를 담은 currentPage를 Service로 전송
		SearchResult searchResult = new SearchService().searchBar(screenSize, search, currentPage);
		
		//6. 결과 처리
		if(searchResult != null) {
			//검색결과 url을 복사해서 이용할 수도 있으므로 RequestDispatcher을 사용해 url이 유지되도록 함
			RequestDispatcher view = request.getRequestDispatcher("page/searchTrainerPage/searchTrainerPage.jsp");
			request.setAttribute("searchResult", searchResult);
			request.setAttribute("searchInput", search);
			view.forward(request, response); //request와 response 객체를 view로 보냄
		}else {
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
