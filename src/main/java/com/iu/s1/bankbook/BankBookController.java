package com.iu.s1.bankbook;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bankBook/*")
public class BankBookController {
	@Autowired
	private BankBookService bankBookService;
	
	@RequestMapping("/list")
	public ModelAndView getBankBookList() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		List<BankBookDTO> bankBookDTOs = bankBookService.getBankBookList();
		modelAndView.addObject("bankBookDTOs", bankBookDTOs);
		modelAndView.setViewName("/bankBook/list");
		
		
		return modelAndView;
	}
	
	@RequestMapping("/detail")
	public ModelAndView getBankBookDetail(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		bankBookDTO = bankBookService.getBankBookDetail(bankBookDTO);
		modelAndView.addObject("bankBookDTO", bankBookDTO);
		modelAndView.setViewName("/bankBook/detail");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/add" , method = RequestMethod.GET)
	public ModelAndView setBankBookAdd() {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("/bankBook/add");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/add" , method = RequestMethod.POST)
	public ModelAndView setBankBookAdd(BankBookDTO bankBookDTO,HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		request.setCharacterEncoding("UTF-8");
		System.out.println(bankBookDTO.getBookName());
		int result = bankBookService.setBankBookAdd(bankBookDTO);
		modelAndView.setViewName("redirect:./list");
		
		return modelAndView;
	}
	@RequestMapping(value = "/delete")
	public ModelAndView setBankBookDelete(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
			
		int result = bankBookService.setBankBookDelete(bankBookDTO);
		modelAndView.setViewName("redirect:./list");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView setBankBookUpdate(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		bankBookDTO = bankBookService.getBankBookDetail(bankBookDTO);
		modelAndView.addObject("bankBookDTO", bankBookDTO);
		modelAndView.setViewName("/bankBook/update");

		
		return modelAndView;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView setBankBookUpdate(BankBookDTO bankBookDTO,ModelAndView modelAndView) throws Exception{
		bankBookService.setBankBookUpdate(bankBookDTO);
		modelAndView.setViewName("redirect: ./detail?bookNumber=" + bankBookDTO.getBookNumber());
		return modelAndView;
	}
	
}
