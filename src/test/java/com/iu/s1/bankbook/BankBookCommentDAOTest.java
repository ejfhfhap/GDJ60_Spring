package com.iu.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;
import com.iu.s1.board.BbsDTO;
import com.iu.s1.util.Pager;

public class BankBookCommentDAOTest extends MyTestCase{

	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;
	
	@Test
	public void getBoardListTest()throws Exception {
		Pager pager = new Pager();
		pager.setBookNumber(421);
		//pager.setKind("writer");
		//pager.setSearch("석주");
		pager.makeRow();
		//int ar = bankBookCommentDAO.getTotalCount(pager);
		List<BbsDTO> ar = bankBookCommentDAO.getBoardList(pager);
		
		assertNotEquals(0, ar.size());
	}
	
}
