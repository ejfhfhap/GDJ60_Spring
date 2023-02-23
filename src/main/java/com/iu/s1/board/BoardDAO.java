package com.iu.s1.board;

public interface BoardDAO extends BbsDAO{
	
	public BoardDTO getBoardDetail(BoardDTO boardDTO)throws Exception;

}
