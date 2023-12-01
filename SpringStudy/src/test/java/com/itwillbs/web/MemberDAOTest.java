package com.itwillbs.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.persistence.MemberDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class MemberDAOTest {
	// 테스트 전용 클래스 
	
	// 5:37 로거 객체 생성 (출력전용 객체)
	private static final Logger logger
		= LoggerFactory.getLogger(MemberDAOTest.class);
	
	// MemberDAO 객체가 필요 => memberDAOImpl 객체가 주입(DI) - 업캐스팅 약한관계
	// root-context.xml 로부터 MemberDAOImpl (의 MemberDAO)를 받음
	@Inject
	private MemberDAO mdao;
	
	
//	@Test : 테스트 실행을 위한 필수 어노테이션!!! 없으면 못한다 
	@Test 
	public void mybatis_첫쿼리구문실행_테스트() {
		System.out.println("결과 : " + mdao.getTime());
		logger.info("결과 : "+ mdao.getTime());
	}
	
	
	
}
