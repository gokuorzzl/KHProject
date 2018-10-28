package com.healthme.trainer.model.service;

import java.sql.Connection;

import com.healthme.common.JDBCTemplate;
import com.healthme.member.model.dao.MemberDao;
import com.healthme.member.vo.Member;
import com.healthme.trainer.model.dao.TrainerDao;
import com.healthme.trainer.vo.Trainer;

public class TrainerService {
	// 수정중
  public Member selectOneMember(String memberId, String memberPw) {
	  
	  Connection conn = JDBCTemplate.getConnection();
	  
	  Trainer trainer = new TrainerDao().selectOneTrainer(memberId, conn);
	  
	  JDBCTemplate.close(conn);
	  
	  return trainer;
  }
  
  //
  public int insertTrainer(Trainer t) {
	   Connection conn = JDBCTemplate.getConnection();
	   int result = new TrainerDao().insertTrainer(conn,t);
	   
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


public boolean findOneMember(String fmemberName, String fmemberSocialId, String fmemberPhone) {
  
		  Connection conn = JDBCTemplate.getConnection();
		  
		  Member member = new MemberDao().findOneMember(fmemberName, fmemberSocialId, fmemberPhone, conn);
		  
		  JDBCTemplate.close(conn);
		  
		  if(member==null) {
			  return false;
		  } else {
			  return true;
		  }

   }
}
