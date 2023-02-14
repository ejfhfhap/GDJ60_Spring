package com.iu.s1.member;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public ModelAndView memberLoginPost(MemberDTO memberDTO, HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		memberDTO = memberService.getMemberLogin(memberDTO);
		memberDTO = memberService.getMemberDetail(memberDTO);
//		session table를 만들고 사용자한테 보냄
		HttpSession session = request.getSession();
		session.setAttribute("member", memberDTO);
		
		//modelAndView.addObject("member", memberDTO);
		
		if(memberDTO != null) {
			System.out.println("로그인 성공!!");
			modelAndView.setViewName("redirect: ../");
		}else {
			modelAndView.setViewName("redirect: ../");
		}
		
		return modelAndView;
	}
	

	@RequestMapping("/memberPage")
	public ModelAndView memberPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member/memberPage");
		return modelAndView;
	}
	
	@RequestMapping(value = "/memberLogout", method = RequestMethod.GET)
	public ModelAndView getMemberLogout(HttpSession session)throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		session.invalidate();
		modelAndView.setViewName("redirect:../");
		return modelAndView;
	}
	
	@RequestMapping(value = "/member/memberUpdate", method = RequestMethod.GET)
	public ModelAndView setMemberUpdate() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/member/memberUpdate");
		return modelAndView;
	}
	
	@RequestMapping(value = "/member/memberUpdate", method = RequestMethod.POST)
	public ModelAndView setMemberUpdate(MemberDTO memberDTO, HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		//System.out.println(memberDTO.getAddress());
		
		MemberDTO memberDTO2 = (MemberDTO)session.getAttribute("member");
		memberDTO.setId(memberDTO2.getId());
		
		int result = memberService.setMemberUpdate(memberDTO);
		// memberDTO = memberService.getMemberDetail(memberDTO);
		if(result>0) {
			session.setAttribute("member", memberDTO);
		}
		modelAndView.setViewName("redirect: ../");
		return modelAndView;
	}

	
	
}
