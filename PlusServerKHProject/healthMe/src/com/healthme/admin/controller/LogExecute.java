package com.healthme.admin.controller;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// AOP에서 자동적으로 실행 되는 Point의 실행 메소드
//<aop:before			method="before"				pointcut-ref="serviceLogPoint"/>
//<aop:after-returning	method="afterReturning"		pointcut-ref="serviceLogPoint"/>
//<aop:after-throwing	method="DaoError"			pointcut-ref="serviceLogPoint"/>
public class LogExecute {
	
	// *Dao*의 메소드가 실행 될때
	public void before(JoinPoint j){
		Logger logger = LoggerFactory.getLogger(j.getTarget()+"");
		logger.info("Logger 시작");
		
		Object args[] = j.getArgs();
		if(args!=null){
			// 메소드 Args를 받아온다
			logger.info("Method:\t"+j.getSignature().getName());
			
			for (int i = 0; i < args.length; i++) {
				logger.info(i+":번째:\t"+args[i]);
			}
			
			logger.info("Method:\t"+j.getSignature().getName());
		}
	}//before
	
	public void afterReturning(JoinPoint j){
		Logger logger = LoggerFactory.getLogger(j.getTarget()+"");
		logger.info("=============끝==============");
	}
	
	public void daoError(JoinPoint j){
		Logger logger = LoggerFactory.getLogger(j.getTarget()+"");
		logger.info("에러:\t"+j.getArgs());
		logger.info("에러:\t"+j.toString());
	}
	
}
