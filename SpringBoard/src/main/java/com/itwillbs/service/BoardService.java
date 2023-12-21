package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;

public interface BoardService {
	
	public void boardWrite(BoardVO vo) throws Exception;
	
	public List<BoardVO> boardListAll() throws Exception;
	
	public BoardVO getBoard(int bno) throws Exception;
	
	public int boardModify(BoardVO vo) throws Exception;
	
	public void incrementViewCnt(int bno) throws Exception;
	
	public void boardRemove(int bno) throws Exception;
	
	public List<BoardVO> boardListPage(Criteria cri) throws Exception;
	
}
