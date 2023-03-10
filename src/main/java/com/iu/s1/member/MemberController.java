package com.iu.s1.member;

import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberDAO memberDAO;
	
	@PostMapping("/memberIdCheck")
	public ModelAndView getMemberIdCheck(MemberDTO memberDTO)throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("result", memberService.getMemberIdCheck(memberDTO));
		modelAndView.setViewName("common/ajaxResult");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/memberAgree")
	public ModelAndView setMemberAgree() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		
		modelAndView.setViewName("/member/memberAgree");
		return modelAndView;
	}
	
	@RequestMapping("/memberList")
	public ModelAndView memberList() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		List<MemberDTO> memberDTOs = memberService.getMemberList();
		
		modelAndView.setViewName("/member/memberList");
		modelAndView.addObject("memberDTOs", memberDTOs);

		
		// ----------------------- 자바로 api 가져오기 버젼차이때매 HttpHeaders 없음 아마 스프링 버젼 올려야함 다른 방법도 찾아보기 객체가 webClient로 바꼈다는 애기도 있음
		// header 담는 객체
		//HttpHeaders headers = new HttpHeaders();
		// 1번재 방법
		//headers.add("Content-Type","application/x-www-form");
		// 2번째 방법
		//headers.set헤더명(MediaType.APPLICATION_FORM_URLENCODED);
		
		//PARAMETER(POST) 담는 객체
//		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
//		params.add("파라미터명", "파라미터 값");
//		params.add("adminId", "asdfsadf5443safsaDSFd");
		
		// header, params 하나의 객체로 생성
		//HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String,String>>(params,headers);
		
		// 자바에서 요청을 보내는 객체
		// url, method, parameter, header
		
//		RestTemplate restTemplate = new RestTemplate();
//		String result = restTemplate.getForObject("https://dummyjson.com/products/1", String.class,request);
//		String result = restTemplate.postForObject("https://dummyjson.com/products/1", request, String.class);
//		System.out.println(result);
		
		
		
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
	public ModelAndView memberLoginGet(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		
//		Cookie[] cookies = request.getCookies();
//		for(Cookie cookie : cookies) {
//			System.out.println(cookie.getName());
//			System.out.println(cookie.getValue());
//			System.out.println(cookie.getDomain());
//			System.out.println(cookie.getPath());
//			System.out.println("---------------------");
//			if(cookie.getName().equals("rememberId")) {
//				modelAndView.addObject("rememberId", cookie.getValue());
//				break;
//			}
//		}
		
		modelAndView.setViewName("/member/memberLogin");
		return modelAndView;
	}
	
	@RequestMapping(value = "/memberLogin", method = RequestMethod.POST)
	public ModelAndView memberLoginPost(MemberDTO memberDTO, HttpServletRequest request,HttpServletResponse response,String remember) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
//		System.out.println(memberDTO.getId());
//		memberDTO = memberService.getMemberLogin(memberDTO);
//		
		if(remember != null && remember.equals("remember")) {
			Cookie cookie = new Cookie("rememberId", memberDTO.getId());
			cookie.setMaxAge(60*60*24*7); // 초 단위
			cookie.setPath("/");
			response.addCookie(cookie);
		}else {
			Cookie cookie = new Cookie("rememberId", "");
			cookie.setMaxAge(0);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
		
//		session table를 만들고 사용자한테 보냄
//		if(memberDTO != null) {
//			HttpSession session = request.getSession();
//			session.setAttribute("member", memberDTO);
//			
//			System.out.println("로그인 성공!!");
//			modelAndView.setViewName("redirect: ../");
//		}else {
//			modelAndView.setViewName("redirect: ../");
//		}
//		System.out.println(memberDTO.getId());
		
		modelAndView.setViewName("redirect: ../");
		return modelAndView;
	}
	

	@RequestMapping("/memberPage")
	public ModelAndView memberPage(HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		memberDTO = memberService.getMemberPage(memberDTO);
		
		modelAndView.addObject("dto", memberDTO);
		modelAndView.setViewName("member/memberPage");
		return modelAndView;
	}
	
	public MemberDTO getMemberPage(MemberDTO memberDTO)throws Exception{
		return memberDAO.getMemberLogin(memberDTO);
	}
	
	@RequestMapping(value = "/memberLogout", method = RequestMethod.GET)
	public ModelAndView getMemberLogout(HttpSession session)throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		session.invalidate();
		modelAndView.setViewName("redirect:../");
		return modelAndView;
	}
	
	@RequestMapping(value = "/member/memberUpdate", method = RequestMethod.GET)
	public ModelAndView setMemberUpdate(HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		memberDTO = memberService.getMemberPage(memberDTO);
		
		modelAndView.addObject("dto", memberDTO);
		modelAndView.setViewName("/member/memberUpdate");
		return modelAndView;
	}
	
	@RequestMapping(value = "/member/memberUpdate", method = RequestMethod.POST)
	public ModelAndView setMemberUpdate(MemberDTO memberDTO, HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		MemberDTO memberDTO2 = (MemberDTO)session.getAttribute("member");
		memberDTO.setId(memberDTO2.getId());
		
		int result = memberService.setMemberUpdate(memberDTO);

		
		modelAndView.setViewName("redirect: ../");
		return modelAndView;
	}

	
	
}
