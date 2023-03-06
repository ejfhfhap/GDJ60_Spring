package com.iu.s1.bankbook;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.board.BbsDTO;
import com.iu.s1.member.MemberDTO;
import com.iu.s1.util.Pager;

@Controller
@RequestMapping("/bankBookComment/*")
public class BankBookCommentController {

	@Autowired
	private BankBookCommentService bankBookCommentService;
	@Autowired
	private HttpSession httpSession;
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public ModelAndView getBoardList(Pager pager)throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		
		List<BbsDTO> list = bankBookCommentService.getBoardList(pager);
		modelAndView.addObject("list", list);
		modelAndView.setViewName("/board/list");
		
		return modelAndView;
	}
	
	//BOOKNUMBER CONTENTS WRITER
	@PostMapping("/add")
	public ModelAndView setBoardAdd(BankBookCommentDTO bankBookCommentDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		//MemberDTO memberDTO = (MemberDTO) httpSession.getAttribute("member");
		//bankBookCommentDTO.setWriter(memberDTO.getId());
		
		bankBookCommentDTO.setWriter("dlwngud_member123");
		System.out.println(bankBookCommentDTO.getContents());
		System.out.println(bankBookCommentDTO.getWriter());
		int result = bankBookCommentService.setBoardAdd(bankBookCommentDTO);
		System.out.println(result);
		
		modelAndView.addObject("result", result);
		modelAndView.setViewName("/common/ajaxResult");
		return modelAndView;
	}
	
	@RequestMapping(value = "/getCommentList",method = RequestMethod.GET)
	public ModelAndView getCommentList(Pager pager)throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		
		pager.setPerPage(5);
		List<BbsDTO> dtos = bankBookCommentService.getBoardList(pager);
		
		modelAndView.addObject("dtos", dtos);
		modelAndView.setViewName("/common/commentResult");
		
		return modelAndView;
	}
	
	@PostMapping("/delete")
	public ModelAndView setBoardDelete(BankBookCommentDTO bankBookCommentDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		System.out.println(bankBookCommentDTO.getNum());
		int result = bankBookCommentService.setBoardDelete(bankBookCommentDTO);
		
		modelAndView.addObject("result", result);
		modelAndView.setViewName("/common/ajaxResult");
		return modelAndView;
	}
	
	@PostMapping("/update")
	public ModelAndView setBoardUpdate(BankBookCommentDTO bankBookCommentDTO)throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		
		System.out.println(bankBookCommentDTO.getNum());
		System.out.println(bankBookCommentDTO.getContents());
		int result = bankBookCommentService.setBoardUpdate(bankBookCommentDTO);
		System.out.println(result);
		
		modelAndView.addObject("result", result);
		modelAndView.setViewName("/common/ajaxResult");
		return modelAndView;
	}
}
