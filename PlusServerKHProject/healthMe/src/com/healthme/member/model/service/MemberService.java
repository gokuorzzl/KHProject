package com.healthme.member.model.service;

import java.sql.Connection;

import com.healthme.common.JDBCTemplate;
import com.healthme.member.model.dao.MemberDao;
import com.healthme.member.vo.Member;

public class MemberService {
  public Member selectOneMember(String memberId, String memberPw) {
	  
	  Connection conn = JDBCTemplate.getConnection();
	  
	  Member member = new MemberDao().selectOneMember(memberId, memberPw, conn);
	  
	  JDBCTemplate.close(conn);
	  
	  return member;
  }
  
  
  public int insertMember(Member m) {
	   Connection conn = JDBCTemplate.getConnection();
	   int result = new MemberDao().insertMember(conn,m);
	   
	   if(result>0) {
		   JDBCTemplate.commit(conn);
	   } else {
		   JDBCTemplate.rollback(conn);
	   }
	   JDBCTemplate.close(conn);
	   
	   return result;
   }
  
  public boolean checkId(String checkId) {
	  
	  Connection conn= JDBCTemplate.getConnection();
	   
	   String memberId = new MemberDao().checkId(checkId,conn);
	   
	   JDBCTemplate.close(conn);
	   
	   if(memberId==null) {
		   //null인 경우는 해당 ID를 사용하는 사용자가 없다라는 의미
		   return false; //리턴 값이 false는 해당 아이디 사용자가 없음
	   } else {
		   return true; //해당 사용자가 있으면 true
	   }
  }
}
