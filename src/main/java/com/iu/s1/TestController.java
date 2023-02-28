package com.iu.s1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.board.notice.NoticeDAO;
import com.iu.s1.board.qna.QnaDTO;

@Controller
public class TestController {
	@Autowired
	private NoticeDAO noticeDAO;
	
	
	@GetMapping("/test")
	public ModelAndView test() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		QnaDTO qnaDTO = new QnaDTO();
		int result = noticeDAO.setBoardAdd(qnaDTO);
		System.out.println(result);
		
		return modelAndView;
	}
}
