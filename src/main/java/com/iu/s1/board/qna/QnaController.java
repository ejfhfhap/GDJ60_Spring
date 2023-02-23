package com.iu.s1.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.BoardDTO;
import com.iu.s1.util.Pager;

@Controller
public class QnaController {
	
	//detail 부분에서 매개변수 BbsDTO가 들어가면 QnaDTO에만 있는 아래 변수들의 getter도 jsp el처럼 mapper에서 자동으로 해주는지? insert 할때
	// private Integer ref;
	//	private Integer step;
	//	private Integer depth;
	// 만약 이게 가능하면 ObjectDAO Service 만들어서 member나 product에서도 사용가능?
	
	@Autowired
	private QnaService qnaService;
	
	public ModelAndView getBoardList(Pager pager) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		List<BbsDTO> list = qnaService.getBoardList(pager);
		modelAndView.addObject("list", list);
		
		//jsp경로설정하기!!!!!!!!!!!!!!!
		modelAndView.setViewName(null);
		return modelAndView;
	}
}
