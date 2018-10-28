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

import com.healthme.search.model.vo.SearchResult;
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
		
		//3. 검색어 처리
		//replace 메소드를 이용해 실제 검색어를 제외한 특수문자 등을 모두 (공백)구분자로 변경
		search = search.replace(",", " ");
		search = search.replace("/", " ");
		search = search.replace("\"", " ");
		search = search.replace("\'", " ");
		search = search.replace("[", " ");
		search = search.replace("]", " ");
		search = search.replace("+", " ");
		search = search.replace("특별시", " ");
		search = search.replace("광역시", " ");
		search = search.replace("시", " ");
		search = search.replace("군", " ");
		search = search.replace("구", " ");
		search = search.replace("읍", " ");
		search = search.replace("면", " ");
		search = search.replace("동", " ");
		for(int i=0 ; i<10 ; i++) {//제n동일 때 n이 10을 넘는 경우는 없으므로 for문을 이용해 처리
			search = search.replace("제"+i, " ");
		}
		
		//공백 등 기타 구분자로 넘어온 검색어를 StringTokenizer를 이용해 ArrayList<String>에 저장
		StringTokenizer st = new StringTokenizer(search);
		ArrayList<String> searchList = new ArrayList<>();
		while(st.hasMoreTokens()) {
			searchList.add(st.nextToken());
		}
		
		//4. searchTrainerPage 내 페이징 처리를 위해 페이지 번호를 받아옴
		int currentPage; //현재페이지
		if(request.getParameter("currentPage")==null) {
			//페이지 정보를 요청했을 때 null인 경우 첫 페이지이므로  1페이지로 설정
			currentPage = 1;
		}else {
			//게시판에서 페이지를 이동할 때에는 이미 페이지값이 존재하므로 해당 페이지값을 저장
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		//5. 검색어를 담은 ArrayList와 현재 페이지 정보를 담은 currentPage를 Service로 전송
		SearchResult searchResult = new SearchService().searchBar(searchList, currentPage);
		
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
