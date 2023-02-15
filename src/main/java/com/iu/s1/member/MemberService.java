package com.iu.s1.member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.iu.s1.util.Pager;

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
	public int setMemberUpdate(MemberDTO memberDTO)throws Exception{
		return memberDAO.setMemberUpdate(memberDTO);
	}
	public MemberDTO getMemberDetail(MemberDTO memberDTO)throws Exception{
		return memberDAO.getMemberDetail(memberDTO);
	}
	
	public MemberDTO getMemberLogin(MemberDTO memberDTO)throws Exception{
		MemberDTO memberDTO2 = memberDAO.getMemberLogin(memberDTO);
		if(memberDTO2 != null && memberDTO2.getPw().equals(memberDTO.getPw())) {
			memberDTO.setPw(null);
			return memberDTO;
		}else {
			return null;
		}
	}
	public MemberDTO getMemberPage(MemberDTO memberDTO)throws Exception{
		return memberDAO.getMemberLogin(memberDTO);
	}
}
