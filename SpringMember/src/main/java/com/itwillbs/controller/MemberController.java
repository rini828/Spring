package com.itwillbs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberVO;

@Controller
//@RequestMapping(value = "/members/*") // 컨트롤러를 구분하는 주소 매핑 ~.me ~.bo
@RequestMapping(value = "/members/*")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	// http://localhost:8088/controller/join // 이게 GET 실행
	// http://localhost:8088/controller/members/join // 주소매핑땜에 추가
	// http://localhost:8088/members/join //탐캣 경로 바꾸고나서(사진3)
	// 회원가입 (정보입력) GET:조회(입출력등등)
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public void memberJoinGET() {
		logger.debug(" /members/join 호출 -> memberJoinGET() 실행 ");
		// 연결된 뷰페이지로 이동
		logger.debug(" /views/members/join.jsp페이지로 이동");
	}
	// 회원가입 (정보처리) POST:처리 
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String memberJoinPOST(/*@ModelAttribute*/ MemberVO vo) {
		logger.debug(" memberJoinPOST() 호출 ");
		// MemberVO vo = new MemberVO();
		// vo.setUserid(request.getParamater("userid"));
		// 한글처리(인코딩 설정) => 필터
	// 전달정보 저장
		logger.debug(" vo :"+vo);

	// DB에 정보를 저장
	// 페이지 이동 (로그인페이지-/members/login)
		return "redirect:/members/login";
	}



}
