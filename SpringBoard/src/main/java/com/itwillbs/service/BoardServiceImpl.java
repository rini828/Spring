package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);

	@Inject
	private BoardDAO bdao;
	
	@Override
	public void boardWrite(BoardVO vo) throws Exception {
		logger.debug(" boardWrite(BoardVO vo) ");
		bdao.insertBoard(vo);	
	}
	
	@Override
	public List<BoardVO> boardListAll() throws Exception {
		logger.debug(" S : boardListAll() ");
		return bdao.getBoardListAll();
	}

	@Override
	public BoardVO getBoard(int bno) throws Exception {
		logger.debug(" S : getBoard(int bno) ");
		return bdao.getBoard(bno);
	}

	
	
}