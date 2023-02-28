package com.iu.s1.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BoardDTO;
import com.iu.s1.board.BoardFileDTO;
import com.iu.s1.member.MemberDTO;
import com.iu.s1.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	// private BbsService noticeService; 도 가능함
	@Autowired
	private HttpSession httpSession;
	
	@ModelAttribute("boardName")
	public String getBoardName() {
		return "notice";
	}
	
	@RequestMapping(value =  "/list",method = RequestMethod.GET)
	public ModelAndView getBoardList(Pager pager) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		List<BbsDTO> list = noticeService.getBoardList(pager);
		
		modelAndView.addObject("list", list);
		modelAndView.setViewName("/board/list");
		
		return modelAndView;
	}
	
	// method : get 자동
	@GetMapping("/add")
	public ModelAndView setBoardAdd()throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/board/add");
		
		MemberDTO memberDTO = (MemberDTO) httpSession.getAttribute("member");
		if(memberDTO == null || memberDTO.getRoleDTO().getRoleName() != "ADMIN") {
			modelAndView.setViewName("redirect: ./list");
		}else {
			modelAndView.setViewName("/board/add");
		}
		
		return modelAndView;
	}
	
	@PostMapping("/add")
	public ModelAndView setBoardAdd(NoticeDTO noticeDTO, MultipartFile[] files,HttpSession httpSession)throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		
		int result = noticeService.setBoardAdd(noticeDTO,files,httpSession);
		String message = "등록 실패";
		if(result > 0) {
			message = "글이 등록 되었습니다";
		}
		
		modelAndView.addObject("result", message);
		modelAndView.addObject("url", "./list");
		
		
		modelAndView.setViewName("/common/result");
		return modelAndView;
	}
	
	@GetMapping("/detail")
	public ModelAndView getBoardDetail(NoticeDTO noticeDTO)throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		
		BoardDTO boardDTO = noticeService.getBoardDetail(noticeDTO);
		modelAndView.addObject("dto", boardDTO);
		
		modelAndView.setViewName("/board/detail");
		return modelAndView;
	}
	
	@PostMapping("/delete")
	public ModelAndView setBoardDelete(NoticeDTO noticeDTO)throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		
		int result = noticeService.setBoardDelete(noticeDTO);
		if(result > 0) {
			modelAndView.addObject("result", "삭제 성공");
		}else {
			modelAndView.addObject("result", "삭세 실패");
		}
		
		modelAndView.addObject("url", "./list");
		modelAndView.setViewName("common/result");
		return modelAndView;
	}
	
	@GetMapping("/fileDown")
	public ModelAndView getFileDown(BoardFileDTO boardFileDTO)throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		
		boardFileDTO = noticeService.getBoardFileDetail(boardFileDTO);
		modelAndView.addObject("boardFile", boardFileDTO);
		modelAndView.setViewName("fileDownView");
		
		return modelAndView;
	}
}
