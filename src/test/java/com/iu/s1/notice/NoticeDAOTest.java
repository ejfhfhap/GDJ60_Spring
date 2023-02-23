package com.iu.s1.notice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;
import com.iu.s1.board.notice.NoticeDAO;
import com.iu.s1.util.Pager;

public class NoticeDAOTest extends MyTestCase{

	@Autowired
	NoticeDAO noticeDAO = new NoticeDAO();
	
	@Test
	public void test() {
		Pager pager = new Pager();
		
	}

}
