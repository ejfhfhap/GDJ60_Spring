package com.iu.s1.bankbook;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.util.Pager;

@Controller
@RequestMapping("/bankBook/*")
public class BankBookController {
	@Autowired
	private BankBookService bankBookService;
	
	
	@RequestMapping("/list")
	public ModelAndView getBankBookList(Pager pager) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		//System.out.println("서비스 들어가기전 " + pager.getTotalCount());
		List<BankBookDTO> bankBookDTOs = bankBookService.getBankBookList(pager);
		//System.out.println("서비스 들어가기후 " + pager.getTotalCount());
		
		modelAndView.addObject("bankBookDTOs", bankBookDTOs);
		modelAndView.addObject("pager", pager);
		modelAndView.setViewName("/bankBook/list");
		
		return modelAndView;
	}
	
	@RequestMapping("/detail")
	public ModelAndView getBankBookDetail(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		bankBookDTO = bankBookService.getBankBookDetail(bankBookDTO);
		modelAndView.addObject("bankBookDTO", bankBookDTO);
		modelAndView.setViewName("/bankBook/detail");
		//System.out.println("file name  " + bankBookDTO.getBankBookImgDTO().getFileName());
		return modelAndView;
	}
	
	@RequestMapping(value = "/add" , method = RequestMethod.GET)
	public ModelAndView setBankBookAdd() {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("/bankBook/add");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/add" , method = RequestMethod.POST)
	public ModelAndView setBankBookAdd(BankBookDTO bankBookDTO,HttpSession session, MultipartFile pic) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		System.out.println("name : " + pic.getName());
		System.out.println("oriname : " + pic.getOriginalFilename());
		System.out.println("byte : " + pic.getSize());
		System.out.println(session.getServletContext());
		
		
		int result = bankBookService.setBankBookAdd(bankBookDTO,session, pic);
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
		//int result = bankBookService.setBankBookUpdate(bankBookDTO);
		modelAndView.setViewName("redirect: ./detail?bookNumber=" + bankBookDTO.getBookNumber());
		return modelAndView;
	}
	
}
