package com.itwillbs.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.binding.MapperMethod.ParamMap;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;

// @Repository : 스프링이 해당파일이 MemberDAO 역할을 
//			  	 수행하는 객체로 인식되게 하는 코드
@Repository
public class MemberDAOImpl implements MemberDAO {

	// 여기도 로거 객체 생성 (출력전용 객체)
	private static final Logger logger
			= LoggerFactory.getLogger(MemberDAOImpl.class);
	
	// 디비연결정보(자동연결,mapper접근...) 처리하는 객체가 필요해요
	// 우리는 그 객체를 주입받아서 쓸거에요
	// => root-context.xml에서 생성되어있는 객체(빈)를 주입
	@Inject
	private SqlSession sqlSession;
	
	// 1201 mapper 위치정보 매번 쓰기 귀찮아서 따로 빼기
	private static final String NAMESPACE="com.itwillbs.mapper.Membermapper";
	
	
	@Override
	public String getTime() {
		// 디비연결
		// SQL구문작성 -> mapper.XML파일
		// SQL 실행
		//sqlSession.selectOne("SQL구문의 위치정보");
		String time =
		sqlSession.selectOne("com.itwillbs.mapper.Membermapper.getTime");
		// 셀렉트의 리턴타입이 모두 보이드거나 없다 = 셀렉트 사용x (커서 둬보기)
		// memberMapper.xml 의 namespace 복붙 = mapper
		// 뒤에 .getTime = SQLID
		// 하면 myBatis가 알아서 찾아감
		// 해당 데이터를 리턴할수있어요
		
		System.out.println(" SQL 실행완료! ");
		System.out.println(" time : " + time );
		
		
		return time;
	}

	// 1201
	@Override
	public void insertMember(MemberVO vo) {
		logger.debug(" insertMember(MemberVO vo) 호출 - 시작 ");
		logger.debug(" mybatis가 mapper에 접근 ");
		logger.debug(" sql 구문 실행 ");
		logger.debug(" sql 구문 실행결과 발생 ");
		sqlSession.insert(NAMESPACE+".insertMember", vo);
//		sqlSession.selectOne("com.itwillbs.mapper.Membermapper.getTime");
// 		com.itwillbs.mapper.Membermapper 는 상수로 뺏으니까 .붙이기
		logger.debug(" insertMember(MemberVO vo) 호출 - 끝 ");
	}

	// 로긴1
	@Override
	public MemberVO loginMember(MemberVO vo) {
		logger.debug("loginMember(MemberVO vo) 호출");
		logger.debug(" DAO -> mapper 호출 ");
		
		MemberVO resultVO
			= sqlSession.selectOne(NAMESPACE+".loginMember", vo);
		return resultVO;
	}

	// 로긴2
	@Override
	public MemberVO loginMember(String userid, String userpw) {
		logger.debug(" loginMember(String userid, String userpw) 실행 ");
//		MemberVO vo = new MemberVO();
//		vo.setUserid(userid);
//		vo.setUserpw(userpw);
		
		// 전달된 정보가 하나의 객체(VO)저장이 불가능한경우 => JOIN
		// => 하나의 형태로 만들어서 mapper로 전달
		// Map<K,V> 컬렉션 사용
		Map<String, Object> paramMap
			= new HashMap<String, Object>();
		
		paramMap.put("userid", userid);
		paramMap.put("userpw", userpw);
		
		MemberVO resultVO
			= sqlSession.selectOne(NAMESPACE+".loginMember", paramMap);
			// => mapper로 전달가능한 객체는 1개뿐
		
		return resultVO;
	}

	
	// 회원정보
	@Override
	public MemberVO getMember(String userid) {
		logger.debug("getMember(String userid)");
		
		MemberVO resultVO
			= sqlSession.selectOne(NAMESPACE+".getMember", userid);
		return resultVO;
//	위아래 같은거 위는 수정가능 아래는 수정안함
		//		return sqlSession.selectOne(NAMESPACE+".getMember", userid);
	}


	
	@Override
	public void updateMember(MemberVO uvo) {
		logger.debug(" updateMember(MemberVO uvo) ");
		sqlSession.update(NAMESPACE+".updateMember", uvo);
	}


	@Override
	public int deleteMember(MemberVO dvo) {
		logger.debug(" deleteMember(MemberVO dvo) ");
		
		return sqlSession.delete(NAMESPACE+".deleteMember",dvo);
	}
	
	


	
	
	
}
