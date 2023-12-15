package com.itwillbs.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	private static final Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);

	@Inject
	private SqlSession sqlSession;

	private static final String NAMESPACE="com.itwillbs.mapper.BoardMapper";
	
	@Override
	public void insertBoard(BoardVO vo) throws Exception {
		logger.debug(" insertBoard(BoardVO vo)");
		sqlSession.insert(NAMESPACE + ".insertBoard", vo);
	}

	@Override
	public List<BoardVO> getBoardListAll() throws Exception {
		logger.debug(" DAO : getBoardListAll() ");
		return sqlSession.selectList(NAMESPACE + ".listALL");
	}

	@Override
	public BoardVO getBoard(int bno) throws Exception {
		logger.debug(" DAO : getBoard(int bno) ");
		return sqlSession.selectOne(NAMESPACE + ".getBoard",bno);
	}

	
	


}
