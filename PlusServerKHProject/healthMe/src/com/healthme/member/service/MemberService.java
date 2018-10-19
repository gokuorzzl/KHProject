package com.healthme.member.service;

import java.sql.Connection;

import com.healthme.common.JDBCTemplate;
import com.healthme.member.dao.MemberDao;
import com.healthme.member.vo.Member;

public class MemberService {
  public Member selectOneMember(String memberId, String memberPw) {
	  
	  Connection conn = JDBCTemplate.getConnection();
	  
	  Member member = new MemberDao().selectOneMember(memberId, memberPw, conn);
	  
	  JDBCTemplate.close(conn);
	  
	  return member;
  }
}
