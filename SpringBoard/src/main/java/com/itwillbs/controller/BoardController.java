package com.itwillbs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.BoardVO;

@Controller
@RequestMapping(value = "/board/*")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	
	// 글쓰기 - GET
	// http://localhost:8088/board/regist
	@RequestMapping(value = "/regist",method = RequestMethod.GET)
	public void registGET() throws Exception{
		logger.debug("/board/regist -> registGET() 호출 ");
		logger.debug("/board/regist.jsp 뷰페이지로 이동");
	}
	
	// 글쓰기 - POST
	@RequestMapping(value = "/regist",method = RequestMethod.POST)
	public String registPOST(BoardVO vo) throws Exception{
		logger.debug("폼submit -> registPOST() 호출 ");
		// 한글 인코딩(필터)
		// 전달정보 저장
		logger.debug(" vo : "+vo);
		
		// 서비스 - DB에 글쓰기(insert) 동작 호출
		
		
		
		
		logger.debug("/board/listAll 이동");
		return "/board/listAll";
	}
	
	
	
	
	

}
