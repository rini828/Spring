package com.itwillbs.web;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class MyBatisTest {
	
	// 디비연결, mybatis 사용 => sqlSessionFactoryBean 객체 필요하다
	@Inject
	private SqlSessionFactory sqlFactory;
	
	@Inject
	private SqlSession sqlSession;
	
	
	@Test
	public void mybatis연결테스트() {
		System.out.println(sqlFactory);
		//SqlSession session = sqlFactory.openSession();
		//session.insert(statement);
		System.out.println(sqlSession);
	}
	
	
	
	
	

}
