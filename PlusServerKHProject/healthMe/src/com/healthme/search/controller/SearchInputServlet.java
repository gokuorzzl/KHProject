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

import com.healthme.search.model.vo.SearchedTrainer;
import com.healtme.search.model.service.SearchService;

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
			//StringTokenizer는  마지막에 구분자가 없으면 마지막 문자열을 반환하지 않으므로 뒤에 공백을 하나 추가해줌
		
		//3. 검색 처리
		//replace 메소드를 이용해 검색어를 모두 (공백)구분자로 변경
		search = search.replace(",", " ");
		search = search.replace("/", " ");
		search = search.replace("\"", " ");
		search = search.replace("\'", " ");
		
		//공백 등 기타 구분자로 넘어온 검색어를 StringTokenizer를 이용해 ArrayList<String>에 저장
		StringTokenizer st = new StringTokenizer(search);
		ArrayList<String> searchList = new ArrayList<>();
		while(st.hasMoreTokens()) {
			searchList.add(st.nextToken());
		}
		
		//ArrayList를 Service로 전송
		ArrayList<SearchedTrainer> trainerList = new SearchService().searchBar(searchList);
		
		//4. 결과 처리
		if(!trainerList.isEmpty()) {
			//url을 복사해서 이용할 수도 있으므로 RequestDispatcher을 사용해 url이 유지되도록 함
			RequestDispatcher view = request.getRequestDispatcher("page/searchTrainerPage/resultTrainer.jsp");
			request.setAttribute("trainerList", trainerList);
			view.forward(request, response);
			
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
