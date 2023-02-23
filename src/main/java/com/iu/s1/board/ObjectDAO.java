package com.iu.s1.board;

import java.util.List;

import com.iu.s1.util.Pager;

public interface ObjectDAO {
	public List<Object> getList(Pager pager) throws Exception;
	public int setAdd(Object dto)throws Exception;
	public int setUpdate(Object dto)throws Exception;
	public int setDelete(Object dto)throws Exception;
	public int getTotalCount(Pager pager)throws Exception;
}
