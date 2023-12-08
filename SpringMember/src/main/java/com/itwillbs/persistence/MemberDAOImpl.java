package com.itwillbs.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);
	
	// 디비에 접근할 객체
	@Inject
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "com.itwillbs.mapper.MemberMapper";
	
	@Override
	public void insertMember(MemberVO vo) {
		logger.debug(" mapper(DB) 회원가입 처리 구문 실행 - 시작");
		// 실제 DB에서 실행할 동작을 호출
		sqlSession.insert(NAMESPACE + ".insertMember", vo);
		logger.debug(" mapper(DB) 회원가입 처리 구문 실행 - 끝");
	}

	@Override
	public MemberVO selectLoginMember(MemberVO vo) {
		logger.debug("DAO - 로그인 처리 selectLoginMemberVO vo");
		
		MemberVO resultVO
			= sqlSession.selectOne(NAMESPACE + ".loginMember", vo);
		logger.debug("결과 : "+resultVO);
		return resultVO;
	}

	
	
}
