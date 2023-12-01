package com.itwillbs.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

// @Repository : 스프링이 해당파일이 MemberDAO 역할을 
//			  	 수행하는 객체로 인식되게 하는 코드
@Repository
public class MemberDAOImpl implements MemberDAO {

	// 디비연결정보(자동연결,mapper접근...) 처리하는 객체가 필요해요
	// 우리는 그 객체를 주입받아서 쓸거에요
	// => root-context.xml에서 생성되어있는 객체(빈)를 주입
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public String getTime() {
		// 디비연결
		// SQL구문작성 -> mapper.XML파일
		// SQL 실행
		//sqlSession.selectOne("SQL구문의 위치정보");
		String time =
		sqlSession.selectOne("com.itwillbs.mapper.Membermapper.getTime");
		// memberMapper.xml 의 namespace 복붙 = mapper
		// 뒤에 .getTime = SQLID
		// 하면 myBatis가 알아서 찾아감
		// 해당 데이터를 리턴할수있어요
		
		System.out.println(" SQL 실행완료! ");
		System.out.println(" time : " + time );
		
		
		return time;
	}

	
}
