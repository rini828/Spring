package com.itwillbs.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itwillbs.domain.MemberVO;

// @RestController : 해당 클래스를 REST방식 데이터 처리를 수행하는 클래스선언
//                 =>  @ResponseBody 자동 적용
@RestController
@RequestMapping(value = "/sample")
public class SampleRestController {

	private static final Logger logger = LoggerFactory.getLogger(SampleRestController.class);

	// http://localhost:8088/sample/doA
	@RequestMapping(value = "/doA", method = RequestMethod.GET)
	/* @ResponseBody */
	public /* @ResponseBody */ String doA() {
		logger.debug(" doA() 호출 ");

		// 문자 데이터를 리턴
		return "ITWILL";
	}

	// http://localhost:8088/sample/doB
	@RequestMapping(value = "/doB", method = RequestMethod.GET)
	public Integer doB() {
		logger.debug(" doB() 호출 ");

		// String을 제외한 기본형타입리턴은 참조형타입으로 변경(권장)

		// 정수데이터를 의미(JSON)
		return 1000;
	}

	// http://localhost:8088/sample/doC
	@RequestMapping(value = "/doC", method = RequestMethod.GET)
	public MemberVO doC() {
		logger.debug(" doC() 호출 ");

		MemberVO vo = new MemberVO();
		vo.setUserid("admin");
		vo.setUsername("관리자");
		vo.setUserpw("1234");
		vo.setUseremail("admin@admin.com");

		// 객체를 JSON타입으로 변환
		// 자바-객체, HTTP-JSON
		// (자바 직렬화: 자바 시스템 내부의 객체를 외부에서 사용되는 데이터형태로 변환)

		return vo;
	}

	// http://localhost:8088/sample/doD
	@RequestMapping(value = "/doD", method = RequestMethod.GET)
	public List<MemberVO> doD() {
		logger.debug(" doD() 호출 ");

		List<MemberVO> memberList = new ArrayList<MemberVO>();

		for (int i = 1; i <= 10; i++) {
			MemberVO vo = new MemberVO();
			vo.setUserid("admin" + i);
			vo.setUsername("관리자" + i);
			vo.setUserpw("1234" + i);
			vo.setUseremail("admin" + i + "@admin.com");
			memberList.add(vo);
		}
		return memberList;
	}

	// http://localhost:8088/sample/doE
	@RequestMapping(value = "/doE", method = RequestMethod.GET)
	public Map<Integer,MemberVO> doE() {
		logger.debug(" doE() 호출 ");
		
		Map<Integer,MemberVO> memberMap = new HashMap<Integer,MemberVO>();

		for (int i = 1; i <= 10; i++) {
			MemberVO vo = new MemberVO();
			vo.setUserid("admin" + i);
			vo.setUsername("관리자" + i);
			vo.setUserpw("1234" + i);
			vo.setUseremail("admin" + i + "@admin.com");
			memberMap.put(i, vo);
		}
		return memberMap;
	}
	
	//  /orders/99/products
	//  /orders/99
	
	// http://localhost:8088/sample/doF/100
	
	@RequestMapping(value = "/doF/{num}",method = RequestMethod.GET)
	public Integer doF(@PathVariable("num") Integer num) {
		logger.debug("doF() 실행");
		
		return num;
	}
	
	// http://localhost:8088/sample/info
	@RequestMapping(value = "/info",method = RequestMethod.POST)
	public String doInfo(@RequestBody MemberVO vo) {
		// @RequestBody : 브라우저에 전달되는 JSON데이터를 특정 객체로 자동변환
		//                -데이터가 반드시 HTTP 바디(메서드)에 포함되어야함(GET방식 사용X)
		logger.info(" doInfo() 실행 ");
		
		logger.info(" vo :"+vo);
		
		return "OK";
	}

	
	
	
}
