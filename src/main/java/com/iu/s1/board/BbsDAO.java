package com.iu.s1.board;

import java.util.List;

import com.iu.s1.util.Pager;

public interface BbsDAO {
	// 부모형으로 받음
	public List<BbsDTO> getBoardList(Pager pager) throws Exception;
	public int setBoardAdd(BbsDTO bbsDTO)throws Exception;
	public int setBoardUpdate(BbsDTO bbsDTO)throws Exception;
	public int setBoardDelete(BbsDTO bbsDTO)throws Exception;
	public int getTotalCount(Pager pager)throws Exception;
}
