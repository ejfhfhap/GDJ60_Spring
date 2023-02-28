package com.iu.s1.board.qna;

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
@RequestMapping("/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@Autowired
	private HttpSession httpSession;
	
	// 모든 jsp에 변수를 mv에 담아서공통적으로 보낼것
	@ModelAttribute("boardName")
	public String getBoardName() {
		return "qna";
	}
	
	// 매개변수로 선언된건 자동으로 모델에 담아서 보냄
	@RequestMapping(value = "/list")
	public ModelAndView getBoardList(@ModelAttribute Pager pager) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		List<BbsDTO> list = qnaService.getBoardList(pager);
		modelAndView.addObject("list", list);
		
		//jsp경로설정하기!!!!!!!!!!!!!!!
		modelAndView.setViewName("/board/list");
		return modelAndView;
	}
	
	@GetMapping("/add")
	public ModelAndView setBoardAdd()throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		
		MemberDTO memberDTO = (MemberDTO) httpSession.getAttribute("member");
		if(memberDTO == null) {
			modelAndView.setViewName("redirect: ./list");
		}else {
			modelAndView.setViewName("/board/add");
		}
		
		return modelAndView;
	}
	
	@PostMapping("/add")
	public ModelAndView setBoardAdd(QnaDTO qnaDTO,MultipartFile [] files, HttpSession session)throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		
		int result = qnaService.setBoardAdd(qnaDTO,files,session);
		String message = "등록 실패";
		if(result > 0) {
			message = "등록 성공";
		}
		modelAndView.addObject("result", message);
		modelAndView.addObject("url", "./list");
		modelAndView.setViewName("/common/result");
		return modelAndView;
	}
	
	@GetMapping("/detail")
	public ModelAndView getBoardDetail(QnaDTO qnaDTO)throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		
		BoardDTO dto = qnaService.getBoardDetail(qnaDTO);
		modelAndView.addObject("dto", dto);
		
		modelAndView.setViewName("/board/detail");
		return modelAndView;
	}
	
	@GetMapping("/reply")
	public ModelAndView setReplyAdd(BoardDTO qnaDTO)throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/board/reply");
		
		return modelAndView;
	}
	
	@PostMapping("/reply")
	public ModelAndView setReplyAdd(QnaDTO qnaDTO)throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		
		int result = qnaService.setReplyAdd(qnaDTO);
		String message = "등록 실패";
		if(result > 0) {
			message = "등록 성공";
		}
		
		modelAndView.addObject("result", message);
		modelAndView.addObject("url", "./detail?num=" + qnaDTO.getNum());
		modelAndView.setViewName("/common/result");
		return modelAndView;
	}
	
	@PostMapping("/delete")
	public ModelAndView setBoardDelete(BbsDTO bbsDTO)throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		int result = qnaService.setBoardDelete(bbsDTO);
		if(result > 0) {
			modelAndView.addObject("result", "삭제 성공");
		}else {
			modelAndView.addObject("result", "삭제 실패");
		}
		modelAndView.addObject("url", "./list");
		
		modelAndView.setViewName("/common/result");
		return modelAndView;
	}
	
	@GetMapping("/fileDown")
	public ModelAndView getFileDown(BoardFileDTO boardFileDTO)throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		
		boardFileDTO = qnaService.getBoardFileDetail(boardFileDTO);
		modelAndView.addObject("boardFile", boardFileDTO);
		
		// abstarctview를 상속받은 애를 먼저 찾아감
		modelAndView.setViewName("fileDownView");
		return modelAndView;
	}
}
