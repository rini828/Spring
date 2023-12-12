package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.MemberVO;

/**
 * DAO : 데이터 처리 객체 (디비 동작(Mybatis)을 제어)
 *
 */
public interface MemberDAO {

	// 회원가입 동작 (S-memberJoin)
	// public void memberJoin();
	public void insertMember(MemberVO vo);
	
	// 로그인 동작
	public MemberVO selectLoginMember(MemberVO vo);
	
	// 회원정보 조회
	public MemberVO getMember(String userid);
	
	// 회원정보 수정
	public void updateMember(MemberVO vo);
	
	// 회원정보 삭제
	public int deleteMember(MemberVO vo);

	// 회원목록 조회
	public List<MemberVO> getMemberList();
	
}
