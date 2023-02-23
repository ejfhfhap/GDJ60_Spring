package com.iu.s1.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.board.BbsDTO;
import com.iu.s1.util.Pager;

@Controller
@RequestMapping("/bankBookComment/*")
public class BankBookCommentController {

	@Autowired
	private BankBookCommentService bankBookCommentService;
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public ModelAndView getBoardList(Pager pager)throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		
		List<BbsDTO> list = bankBookCommentService.getBoardList(pager);
		modelAndView.addObject("list", list);
		modelAndView.setViewName("/board/list");
		
		return modelAndView;
	}
}
