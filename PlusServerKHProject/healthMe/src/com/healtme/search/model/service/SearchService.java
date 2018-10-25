package com.healtme.search.model.service;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.util.ArrayList;

import com.healthme.common.JDBCTemplate;
import com.healthme.search.model.dao.SearchDao;
import com.healthme.search.model.vo.SearchResultPage;
import com.healthme.search.model.vo.SearchedTrainer;
import com.healthme.search.model.vo.SearchedTrainerResult;

public class SearchService {

	public SearchResultPage searchBar(ArrayList<String> searchList, int currentPage) {
		
		//커넥션 생성
		Connection conn = JDBCTemplate.getConnection();
		//리턴할 결과
		SearchResultPage resultPage = null;
		
		//------------- Service에서 2번의 DAO호출 ----------------//
		//1. Member테이블로부터 아이디, 이름, 별점, 종목을 추출
		ArrayList<SearchedTrainer> tmpMember = new SearchDao().searchMemberInfo(conn, searchList);
		
		if(!tmpMember.isEmpty()) {
			//2. IMAGECOLLECT테이블로부터 이미지 경로를 추출
			//tmpList 목록에 있는 ID만 전달해서 값을 가져와야 하므로 tmpList를 전송
			ArrayList<String> tmpImg = new SearchDao().searchTrainerImg(conn, tmpMember);

			
			//------------- 페이징 처리----------------//
			//1. 같은 페이지 내 객체 갯수 처리
			int recordPerPage = 0; //한 페이지에서 표현할 갯수
			//화면 크기에 따라 한 페이지에 표현할 갯수가 달라지므로 화면 크기를 구하는 객체를 이용
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			
			if(screenSize.width>=1024) {//데스크톱 사이즈
				recordPerPage = 6; 
			}else if(screenSize.width>=640){//태블릿 사이즈
				recordPerPage = 4; 
			}else {// 사이즈
				recordPerPage = 2; 
			}
			
			//같은 페이지 내 시작 index계산 - List에서 가져가므로 index번호 0부터 시작
			int start = currentPage * recordPerPage - (recordPerPage);
			//같은 페이지 내 끝 index 계산 
			int end = currentPage * recordPerPage -1;
			
			//2. 페이지 navigation처리
			int naviSetNum = 5; //한 번에 표현될 페이지 갯수(1 2 3 4 5)
			int naviTotalNum = 0; //네비게이션에 생성할 총 페이지 갯수
			
			if(tmpMember.size() % recordPerPage !=0) {
				//검색되어 돌아온 총 갯수 tmpMember.size()를 recordPerPage로 나눈 나머지가 0이 아닐경우
				//나눈 결과에 +1을 해줘서 하나의 페이지가 더 생성되게 함
				naviTotalNum = tmpMember.size() / recordPerPage + 1;
			} else {
				//검색되어 돌아온 총 갯수 tmpMember.size()를 recordPerPage로 나눈 나머지가 0일 경우
				//딱 맞아떨어지므로 추가로 페이지를 생성할 필요가 없음
				naviTotalNum = tmpMember.size() / recordPerPage;
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
			if(startNavi==1) {//시작 페이지가 1페이지라면 ◀표시가 나오지 않도록 함
				 sb.append("<a href = '/searchedTrainer.do?currentPage=" + (startNavi-1) + "'> ◀ </a>");
			}
			for(int i = startNavi ; i <= endNavi ; i++) {//페이지 번호 표시
				if(i == currentPage) {//현재 페이지가 사용자의 위치페이지와 같다면 배경색 표시
					sb.append("<a href = '/searchedTrainer.do?currentPage=" + i + "'><div style='background:#FF9B55'>" + i + "</div></a>");
				}else {//사용자의 현재 위치 페이지가 아닌경우 일반 표시
					sb.append("<a href = '/searchedTrainer.do?currentPage=" + i + "'>" + i + "</a>");
				}
			}
			if(endNavi == naviTotalNum) {
				sb.append("<a href='/searchedTrainer.do?currentPage=" + (endNavi+1) + "'> ▶ </a>");
			}
			
			//------------- DB검색과 페이징 처리를 통해 얻은 결과로 return할 객체 생성 ----------------//
			//1. 검색되어 돌아온 ArrayList<SearchedTrainer> tmpMember와 ArrayList<String> tmpImg를 이용
			//페이지당 표현할 갯수만큼 결과 객체(SearchedTrainerResult)리스트에 저장
			ArrayList<SearchedTrainerResult> resultList = new ArrayList<>();
			SearchedTrainerResult trainer = new SearchedTrainerResult();
			for(int i=start ; i <= (end>tmpMember.size() ? tmpMember.size()+1 : end) ; i++) {
				//페이지 번호로 시작번호와 끝 번호가 결정되어있고 그 만큼 객체를 저장
				//이 때, 전체 검색결과(tmpMember)보다 end가 큰 경우를 고려하여 for문 반복 횟수를 결정함
				trainer.setMemberId(tmpMember.get(i).getMemberId());
				trainer.setMemberName(tmpMember.get(i).getMemberName());
				trainer.setTrainerEvent(tmpMember.get(i).getTrainerEvent());
				trainer.setTrainerScore(tmpMember.get(i).getTrainerScore());
				trainer.setProfileFile(tmpImg.get(i)); 
					//tmpMember에 저장된 순서대로 DB를 검색했으므로 동일한 인물의 사진인지 검사할 필요 없음
				resultList.add(trainer);
			}
			
			//2. 리턴할 SearchResultPage에 저장
			if(!resultList.isEmpty() && sb!=null) {
				resultPage = new SearchResultPage(resultList, sb.toString());
			}
		}//if(!tmpMember.isEmpty())문 종료
		
		//Connection 닫기
		JDBCTemplate.close(conn);
		
		return resultPage;
		
	}
	
}
