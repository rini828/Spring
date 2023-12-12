package com.itwillbs.service;

import java.util.List;

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
	
	// 회원정보 조회 동작
	public MemberVO memberInfo(String userid);

	// 회원정보 수정 동작
	public void memberUpdate(MemberVO vo);
	
	// 회원정보 삭제 동작
	public int memberDelete(MemberVO vo);	
	
	// 회원목록 조회 동작
	public List<MemberVO> memberList();
	
	
}
