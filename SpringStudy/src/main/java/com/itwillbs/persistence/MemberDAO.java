package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.MemberVO;

public interface MemberDAO {
	
	// 추상메서드로 처리동작 구현선언
	
	// 디비의 시간정보 조회 [5]
	public String getTime();
	
	// 회원가입 처리동작
	public void insertMember(MemberVO vo);
	
	// 로그인 처리동작
	public MemberVO loginMember(MemberVO vo);
	public MemberVO loginMember(String userid,String userpw);
	
	// 회원정보 조회
	public MemberVO getMember(String userid);
	
	// 회원정보 수정
	public void updateMember(MemberVO uvo);
	// 회원정보 삭제
	public int deleteMember(MemberVO dvo);
	
	
	// 회원정보 리스트 조회 java.util
	public List<MemberVO> getMemberList();

}
