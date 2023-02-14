package com.iu.s1.member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public List<MemberDTO> getMemberList() throws Exception{
		List<MemberDTO> memberDTOs = memberDAO.getMemberList();
		return memberDTOs;
	}
	public int setMemberJoin(MemberDTO memberDTO) throws Exception {
//		String id = String.valueOf(memberDAO.getMemberID());
//		memberDTO.setId(id);
		int result = memberDAO.setMemberJoin(memberDTO);
		result = memberDAO.setMemberRoleAdd(memberDTO);
		
		return result;
	}
	public MemberDTO getMemberLogin(MemberDTO memberDTO)throws Exception{
		memberDTO = memberDAO.getMemberLogin(memberDTO);
		return memberDTO;
	}
	public int setMemberUpdate(MemberDTO memberDTO)throws Exception{
		return memberDAO.setMemberUpdate(memberDTO);
	}
	public MemberDTO getMemberDetail(MemberDTO memberDTO)throws Exception{
		return memberDAO.getMemberDetail(memberDTO);
	}
}
