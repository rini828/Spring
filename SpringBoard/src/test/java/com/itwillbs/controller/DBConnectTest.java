package com.itwillbs.controller;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;
import com.itwillbs.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class DBConnectTest {
	
	private static final Logger logger = LoggerFactory.getLogger(DBConnectTest.class);
	// 디비연결처리 객체
	@Inject
	private SqlSession sqlSession;
	
	@Inject
	private BoardDAO bdao;
	
	//@Test
	public void 디비연결테스트() {
		logger.debug(" sqlSession : "+ sqlSession);
	}
	
	@Test
	public void 페이징처리_테스트1() throws Exception {
		logger.debug(" 페이징처리1 실행 ");
		//logger.debug(""+bdao.getBoardListPage());
		//logger.debug(" 결과수 : "+bdao.getBoardListPage().size());
		
		logger.debug("---------------------------------------------------------");
//		for(BoardVO vo :bdao.getBoardListPage(3)) {
//			logger.debug(vo.getBno()+"//"+vo.getTitle()+"//"+vo.getContent());
//		}
		Criteria cri = new Criteria();
		 // page = 1,pageSize = 10
		cri.setPage(2); // => 1페이지
		cri.setPageSize(20); // 20개씩 
		
		for(BoardVO vo :bdao.getBoardListPage(cri)) {
			logger.debug(vo.getBno()+"//"+vo.getTitle()+"//"+vo.getContent());
		}
		logger.debug("---------------------------------------------------------");
		
	}
	
	

}
