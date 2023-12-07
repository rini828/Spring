package com.itwillbs.web;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(
//		locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"}
//		)
//=> 스프링으로 controller 외 나머지 테스트 하겠다

//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration(
//		locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"}
//		)
//=> 스프링웹(MVC)으로 Controller 테스트 하겠다

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
//		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
		locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class SampleControllerTest {

	private static final Logger logger = LoggerFactory.getLogger(SampleControllerTest.class);
	
	@Inject 
	private WebApplicationContext wac;
	
	// MockMvc : 요청,응답을 처리하는 테스트용 객체 
	private MockMvc mockMvc;
	
//	@Before : @Test 실행전에 반드시 처리해야하는 메서드
	@Before //Junit안에 있는거
	public void setUp() {
		// MockMvc 객체를 생성(준비)
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		logger.debug(" MockMvc 객체를 생성 완료! (테스트 준비) ");
	}
	
	@Test
	public void controllerTest() {
		// 서버없이 컨트롤러를 테스트
		try {
			mockMvc.perform(MockMvcRequestBuilders.get("/doA"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 결과: DEBUG: com.itwillbs.web.SampleController1 - doA() 실행
	
	
}
