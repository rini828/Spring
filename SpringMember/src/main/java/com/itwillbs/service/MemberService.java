package com.itwillbs.service;

import com.itwillbs.domain.MemberVO;

/**
 *  서비스 계층(비지니스로직 계층) : 사용자의 요구사항을 구현하는 단계
 *  
 *  => 컨트롤러 - DAO를 연결하는 계층(접착제)
 *  => 외부호출이 영속계층(디비)에 종속적인 상황을 막아줌
 *
 */

public interface MemberService {
	
	// 구현 하고자하는 동작을 추상 메서드로 선언
	public void memberJoin(MemberVO vo);
	
	// 로그인 처리동작
	public MemberVO memberLogin(MemberVO vo);
	
	

}
