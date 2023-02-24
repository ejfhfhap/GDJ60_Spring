package com.iu.s1.notice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;
import com.iu.s1.board.notice.NoticeDAO;
import com.iu.s1.board.notice.NoticeDTO;
import com.iu.s1.util.Pager;

public class NoticeDAOTest extends MyTestCase{

	@Autowired
	NoticeDAO noticeDAO = new NoticeDAO();
	
	@Test
	public void noticeAdd() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("이주형 작성");
		noticeDTO.setWriter("dkwbgyd");
		noticeDTO.setContents("Dddddddddddddddddddd");
		int result  = noticeDAO.setBoardAdd(noticeDTO);
		assertNotEquals(0, result);
	}

}
