package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.BoardVO;

public interface BoardDAO {
	
	public void insertBoard(BoardVO vo) throws Exception;

	public List<BoardVO> getBoardListAll() throws Exception;
	
	public BoardVO getBoard(int bno) throws Exception;
	
	public int updateBoard(BoardVO vo) throws Exception;
	
	public void updateViewCnt(int bno) throws Exception;
	
	public void deleteBoard(int bno) throws Exception;
	
	
}
