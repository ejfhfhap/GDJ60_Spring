package com.iu.s1.member;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;

public class MemberDAOTest extends MyTestCase{
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Test
	public void setMemberJoinTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setName("이주형12");
		memberDTO.setAddress("테스트912");
		memberDTO.setEmail("dfdsf");
		memberDTO.setId("123");
		memberDTO.setPhone("010");
		memberDTO.setPw("pw");
		int result = memberDAO.setMemberJoin(memberDTO);
		assertEquals(1, result);
	}
}
