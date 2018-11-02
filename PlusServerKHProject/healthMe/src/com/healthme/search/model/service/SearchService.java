package com.healthme.search.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.healthme.common.JDBCTemplate;
import com.healthme.search.model.dao.SearchDao;
import com.healthme.search.model.vo.Keyword;
import com.healthme.search.model.vo.SearchPaging;
import com.healthme.search.model.vo.SearchResult;
import com.healthme.search.model.vo.SearchedTrainer;
import com.healthme.search.model.vo.SearchedTrainerResult;

public class SearchService {

	public SearchResult searchBar(int screenSize, String search, int currentPage) {
		
		//커넥션 생성
		Connection conn = JDBCTemplate.getConnection();
		//리턴할 결과
		SearchResult searchResult = null;
		
		//-------------- 검색어 처리 --------------//
		Keyword keyword = keywordProcess(search);
		
		//-------------- DAO를 세 번 다녀옴 --------------//
		//1. TRAINER테이블로부터 MEMBERID, PROFILEFILE, TRAINERREGION, TRAINEREVENT를 가져옴
		//위의 네가지 정보를 저장하는 SearchedTrainer 객체를 저장할 ArrayList생성

		ArrayList<SearchedTrainer> tmpTrainer = new SearchDao().searchBarTrainer(conn, keyword.getRegion(), keyword.getField());

		if(!tmpTrainer.isEmpty()) {
			
			//2. Member테이블로부터 트레이너 이름을 가져옴
			//1번에서 찾아온 트레이너 아이디와 일치하는 이름을 가져옴
			//결과를 저장할 ArrayList
			ArrayList<String> trainerName = new ArrayList<>();
			//검색된 트레이너가 여러명일 수 있으므로 쿼리문 이용을 위해 여러 번 Dao에 접근해야 함
			for(int i=0 ; i<tmpTrainer.size() ; i++) {
				//트레이너의 ID를 가지고 가서 Name을 검색해서 순서대로 리스트에 저장
				trainerName.add(new SearchDao().searchBarTrainerName(conn, tmpTrainer.get(i).getMemberId()));
			}
			
			//3. 1번 결과에서 찾아온 트레이너 아이디와 일치하는 별점의 평균을 구함
			ArrayList<Integer> trainerScore = new ArrayList<>();
			//검색된 트레이너가 여러명일 수 있으므로 쿼리문 이용을 위해 여러 번 Dao에 접근해야 함
			for(int i=0 ; i<tmpTrainer.size() ; i++) {
				//트레이너의 ID를 가지고 가서 Name을 검색해서 순서대로 리스트에 저장
				trainerScore.add(new SearchDao().searchBarTrainerScore(conn, tmpTrainer.get(i).getMemberId()));
			}
			
			//페이징처리
			SearchPaging sp = paging(screenSize, search, currentPage, tmpTrainer);
			
			//----------------- DB검색과 페이징 처리를 통해 얻은 결과로 return할 객체 생성 -----------------//
			//1. SearchResult 결과 객체의 ArrayLsit
			ArrayList<SearchedTrainerResult> trainerList = new ArrayList<>();
			//2.한 페이지에 표현할 데이터 갯수인 start부터 end까지만 데이터를 잘라서 보냄
			for(int i=sp.getStart() ; i<=sp.getEnd() ; i++) {
				SearchedTrainerResult str = new SearchedTrainerResult();
				str.setMemberId(tmpTrainer.get(i).getMemberId());
				str.setMemberName(trainerName.get(i));
				str.setProfileFile(tmpTrainer.get(i).getProfileFile());
				str.setTrainerEvent(tmpTrainer.get(i).getTrainerEvent());
				str.setTrainerRegion(tmpTrainer.get(i).getTrainerRegion());
				str.setMatchingScore(trainerScore.get(i));
				trainerList.add(str);
			}
			//3. 객체에 결과 저장
			searchResult = new SearchResult(trainerList, sp.getRecordPerPage(), sp.getPagingNavi());
		}

		JDBCTemplate.close(conn);
		
		return searchResult;
	}
	
	public SearchPaging paging(int screenSize, String search, int currentPage, ArrayList<SearchedTrainer> tmpTrainer) {
		
		//----------------- 페이징 처리 -----------------//
		//1. 같은 페이지 내 객체 갯수 처리
		int recordPerPage = 0; //한 페이지에서 표현할 갯수
		//화면 크기에 따라 한 페이지에 표현할 갯수가 달라지므로 화면 크기를 구하는 객체를 이용
		
		if(screenSize>=1024) {//데스크톱 사이즈
			recordPerPage = 6; 
		}else if(screenSize>=640){//태블릿 사이즈
			recordPerPage = 4; 
		}else {//모바일 사이즈
			recordPerPage = 2; 
		}
		
		//같은 페이지 내 시작 index계산 - List에서 가져가므로 index번호 0부터 시작
		int start = currentPage * recordPerPage - (recordPerPage);
		//같은 페이지 내 끝 index 계산 
		int end = currentPage * recordPerPage - 1;
		if(end>tmpTrainer.size()-1) {
			end = tmpTrainer.size()-1;
		}
		
		//2. 페이지 navigation처리
		int naviSetNum = 5; //한 번에 표현될 페이지 갯수(1 2 3 4 5)
		int naviTotalNum = 0; //네비게이션에 생성할 총 페이지 갯수
		
		if(tmpTrainer.size() % recordPerPage !=0) {
			//검색되어 돌아온 총 갯수 trainer.size()를 recordPerPage로 나눈 나머지가 0이 아닐경우
			//나눈 결과에 +1을 해줘서 하나의 페이지가 더 생성되게 함
			naviTotalNum = tmpTrainer.size() / recordPerPage + 1;
		} else {
			//검색되어 돌아온 총 갯수 trainer.size()를 recordPerPage로 나눈 나머지가 0일 경우
			//딱 맞아떨어지므로 추가로 페이지를 생성할 필요가 없음
			naviTotalNum = tmpTrainer.size() / recordPerPage;
		}
		
		//시작페이지 번호와 끝 페이지 번호를 만들기 전 페이지 번호 에러를 방지
		if(currentPage < 1) {//현재 페이지 번호가 최소값(1)보다 작은 경우
			currentPage = 1;
		}else if(currentPage > naviTotalNum) {//현재 페이지 번호가 최대값(전체 페이지 수)보다 큰 경우 
			currentPage = naviTotalNum;
		}
		
		//시작 페이지 번호
		int startNavi = ((currentPage - 1) / naviSetNum) * naviSetNum + 1;
		//끝 페이지 번호
		int endNavi = startNavi + naviSetNum -1;
		if(endNavi > naviTotalNum) { //계산된 페이지 번호가 총 페이지 수보다 클 경우에 마지막 페이지 번호를 맞춰줌
			endNavi = naviTotalNum;
		}
		
		//'◀ 페이지 번호 ▶'를 표시하기 위해 StringBuilder를 이용 
		StringBuilder sb = new StringBuilder();
		sb.append("<center>");
		sb.append("&nbsp&nbsp&nbsp");
		if(startNavi!=1) {//시작 페이지가 1페이지라면 ◀표시가 나오지 않도록 함
			 sb.append("<a href = '/searchInput.do?" + 
					 	"currentPage=" + (startNavi-1) + "&" +
					 	"searchInput=" + search +
					 	"'> ◀ </a>&nbsp&nbsp&nbsp");
		}
		for(int i = startNavi ; i <= endNavi ; i++) {//페이지 번호 표시
			if(i == currentPage) {//현재 페이지가 사용자의 위치페이지와 같다면 배경색 표시
				sb.append("<a href = '/searchInput.do?" + 
							"currentPage=" + i + "&" +
							"searchInput=" + search +
							"'><i style='background:#FF9B55'>" + i + "</i></a>&nbsp&nbsp&nbsp");
			}else {//사용자의 현재 위치 페이지가 아닌경우 일반 표시
				sb.append("<a href = '/searchInput.do?" + 
							"currentPage=" + i + "&" +
							"searchInput=" + search +
							"'>" + i + "</a>&nbsp&nbsp&nbsp");
			}
		}
		if(endNavi != naviTotalNum) {
			sb.append("<a href='/searchInput.do?" + 
						"currentPage=" + (endNavi+1) + "&" +
					 	"searchInput=" + search +
						"'> ▶ </a>&nbsp&nbsp&nbsp");
		}
		sb.append("</center>");
		
		SearchPaging sp = new SearchPaging(sb.toString(), recordPerPage, start, end);
		
		return sp;
		
	}
	
	public Keyword keywordProcess(String search) {
		
		Connection conn = JDBCTemplate.getConnection(); //DAO에 전송할 Connection생성
		Keyword kw = new Keyword(); //키워드 저장해 리턴할 객체 생성
		ArrayList<String> region = new ArrayList<>(); //지역을 저장할 ArrayList
		ArrayList<String> field = new ArrayList<>(); //종목 키워드 저장할 ArrayList
		
		//1. 가져온 문자에서 특수문자를 제외하고 토큰단위로 잘라서 ArrayList에 저장
		
		//replace 메소드를 이용해 실제 검색어를 제외한 특수문자 등을 모두 (공백)구분자로 변경
		search = search.replace(",", " ");
		search = search.replace("/", " ");
		search = search.replace("\"", " ");
		search = search.replace("\'", " ");
		search = search.replace("[", " ");
		search = search.replace("]", " ");
		search = search.replace("+", " ");
		search = search.replace("@", " ");
		search = search.replace("#", " ");
		search = search.replace("!", " ");
		search = search.replace("~", " ");
		search = search.replace("$", " ");
		search = search.replace("%", " ");
		search = search.replace("^", " ");
		search = search.replace("&", " ");
		search = search.replace("*", " ");
		search = search.replace("(", " ");
		search = search.replace(")", " ");
		search = search.replace("-", " ");
		search = search.replace("=", " ");
		search = search.replace("|", " ");
		search = search.replace("<", " ");
		search = search.replace(">", " ");
		search = search.replace("?", " ");
		search = search.replace("null", " ");

		//공백 등 기타 구분자로 넘어온 검색어를 StringTokenizer를 이용해 ArrayList<String>에 저장
		StringTokenizer st = new StringTokenizer(search);
		ArrayList<String> searchList = new ArrayList<>();
		while(st.hasMoreTokens()) {
			searchList.add(st.nextToken());
		}
		
		//2. searchList에 있는 단어 수만큼 검색어 처리를 진행
		//지역검색에 활용하기 위한 boolean변수
		boolean regionCheck = false; //기본은 false -> 지역명이 맞으면 true가 반환되도록 함
		
		//검색어 수만큼 각 검색어를 처리하기 위한 과정
		for(int i=0 ; i<searchList.size() ; i++) {
			
			//지역에 따른 검색어 처리
			//해당 검색어가 지역에 관한 검색어인지 DAO를 통해 확인
			regionCheck = new  SearchDao().checkRegion(conn, searchList.get(i));

			if(regionCheck==true) {//이 검색어는 지역과 관련된 검색어라는 의미임
				region.add(searchList.get(i));
			}else {//지역 검색어가 아니면 종목에 관한 검색어라는 의미임		
				//종목에 따른 검색어 처리
				//대분류를 검색하면 하위분류가 검색어에 포함되서 검색될 수 있도록 설정
				if(searchList.get(i).contains("헬스")) {
					field.add("헬스");
					field.add("웨이트");
					field.add("스피닝");
				}
				if(searchList.get(i).contains("요가")) {
					field.add("요가");
					field.add("플라잉");
					field.add("필라테스");
				}
				if(searchList.get(i).contains("구기")) {
					field.add("축구");
					field.add("배구");
					field.add("야구");
					field.add("농구");
					field.add("골프");
					field.add("볼링");
				}
				if(searchList.get(i).contains("무술")) {
					field.add("주짓수");
					field.add("복싱");
					field.add("격투기");
					field.add("유도");
					field.add("검도");
					field.add("펜싱");
				}
				if(searchList.get(i).contains("라켓")) {
					field.add("테니스");
					field.add("배드민턴");
					field.add("스쿼시");
				}
				if(searchList.get(i).contains("아쿠아")) {
					field.add("수영");
					field.add("조정");
					field.add("비치");
					field.add("다이빙");
					field.add("서핑");
				}
				if(searchList.get(i).contains("유산소")) {
					field.add("마라톤");
					field.add("산악마라톤");
					field.add("등산");
					field.add("암벽등반");
				}
				
			}//큰 if문 종료
			
		}//for문 종료
		
		kw.setRegion(region);
		kw.setField(field);
		
		return kw;
		
	}
	
}
