package com.iu.s1.board;

import java.util.List;

public interface BoardDAO extends BbsDAO{
	
	public BoardDTO getBoardDetail(BoardDTO boardDTO)throws Exception;
	public int setBoardFileAdd(BoardFileDTO boardFileDTO)throws Exception;
	public List<BoardFileDTO> getBoardFileList(BbsDTO bbsDTO)throws Exception;
}
