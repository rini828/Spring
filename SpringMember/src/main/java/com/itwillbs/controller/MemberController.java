package com.itwillbs.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.service.MemberService;

@Controller
//@RequestMapping(value = "/members/*") // 컨트롤러를 구분하는 주소 매핑 ~.me ~.bo
@RequestMapping(value = "/members/*")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	// 서비스 객체 주입
	@Inject
	private MemberService mService;
	
	
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

	// DB에 정보를 저장 => 서비스 객체 사용
	// 기존에 하던 것(강한결합) -> new MemberDAO().method() 호출;
	// 스프링: DAO랑 거리두기
		logger.debug(" 서비스 회원가입 동작을 호출 - 시작");
		mService.memberJoin(vo);
		logger.debug(" 서비스 회원가입 동작을 호출 - 끝");
		
		
	// 페이지 이동 (로그인페이지-/members/login)
		return "redirect:/members/login";
	}
	
	// http://localhost:8088/members/login
	// 로그인 - 정보 입력(GET)
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public void memberLoginGET() {
		logger.debug(" /members/login 호출 -> memberLoginGET() 실행 ");
		logger.debug(" 연결된 뷰페이지(/views/members/login.jsp) 이동 ");		
	}
	
	// 로그인 - 정보 처리(POST)	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public String memberLoginPOST(MemberVO vo,HttpSession session) {
		logger.debug(" /members/login.jsp post방식 호출 -> memberLoginPOST() 실행 ");
		
		// 전달정보 저장(파라메터-userid,userpw)
		logger.debug(" 전달정보 : "+vo);
		// 디비접근 -> 서비스접근 - 로그인 처리
		MemberVO resultVO = mService.memberLogin(vo);
		
		// 로그인 결과에 따른 페이지 이동
		if(resultVO != null) {
			// O -> /members/main 페이지 호출(리다이렉트), 세션 아이디정보 저장
			session.setAttribute("id", resultVO.getUserid());
			return "redirect:/members/main";
		}else {
			// X -> /members/login 페이지 호출(리다이렉트)		
			return "redirect:/members/login";
		}
		
		}
	}