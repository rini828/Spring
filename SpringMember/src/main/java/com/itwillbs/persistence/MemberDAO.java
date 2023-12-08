package com.itwillbs.persistence;

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
}
