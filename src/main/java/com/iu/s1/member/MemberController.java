package com.iu.s1.member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/memberList")
	public ModelAndView memberList() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		List<MemberDTO> memberDTOs = memberService.getMemberList();
		
		modelAndView.setViewName("/member/memberList");
		modelAndView.addObject("memberDTOs", memberDTOs);
		return modelAndView;
	}
	
	@RequestMapping(value = "/memberJoin", method = RequestMethod.GET)
	public ModelAndView memberJoin() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/member/memberJoin");
		return modelAndView;
	}
	
	@RequestMapping(value = "/memberJoin", method = RequestMethod.POST)
	public ModelAndView setMemberJoin(MemberDTO memberDTO) throws Exception {
//		memberDTO.setName("이주형 지나감");
//		memberDTO.setAddress("인천");
//		memberDTO.setPhone("0010");
//		memberDTO.setEmail("sdf");
//		memberDTO.setPw("이주형 지나감 pwd");
		
		ModelAndView modelAndView = new ModelAndView();
		memberService.setMemberJoin(memberDTO);
		modelAndView.setViewName("redirect: ./memberList");
		return modelAndView;
	}
	
	
	
	@RequestMapping(value = "/memberLogin")
	public ModelAndView memberLoginGet() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/member/memberLogin");
		return modelAndView;
	}
	@RequestMapping(value = "/memberLogin", method = RequestMethod.POST)
	public ModelAndView memberLoginPost() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect: ./memberList");
		return modelAndView;
	}
	

	
	
	@RequestMapping("/memberPage")
	public ModelAndView memberPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member/memberPage");
		return modelAndView;
	}
}
