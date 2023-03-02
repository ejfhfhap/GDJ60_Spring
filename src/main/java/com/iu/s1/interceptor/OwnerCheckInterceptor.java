package com.iu.s1.interceptor;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.s1.board.BoardDTO;
import com.iu.s1.board.notice.NoticeDAO;
import com.iu.s1.board.qna.QnaDAO;
import com.iu.s1.member.MemberDTO;

@Component
public class OwnerCheckInterceptor extends HandlerInterceptorAdapter{

	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private QnaDAO qnaDAO;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		Integer num = Integer.parseInt(request.getParameter("num"));
		
		System.out.println("URI : " +request.getRequestURI());
		System.out.println("path info : " + request.getPathInfo());
		System.out.println("servlet path : " + request.getServletPath());
		// 이거 왜 안됨??
		String[] paths = request.getRequestURI().split("/");
		
		String uri = request.getRequestURI();
		uri = request.getRequestURI().substring(1, uri.lastIndexOf("/"));
		System.out.println(uri);
		
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(num);
		if(uri.equals("notice")) {
			boardDTO = noticeDAO.getBoardDetail(boardDTO);
		}else {
			boardDTO = qnaDAO.getBoardDetail(boardDTO);
		}
		
		MemberDTO memberDTO = (MemberDTO)request.getSession().getAttribute("member");
		if(memberDTO.getId().equals(boardDTO.getWriter())) {
			return true;
		}else {
			request.setAttribute("result", "작성자만 가능합니다");
			request.setAttribute("url", "./list");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			view.forward(request, response);
			
			return false;
		}
	}
	
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println("owner check interceptor");
//		// 1. 로그인 한 사용자의 아이디
//		MemberDTO memberDTO = (MemberDTO) request.getSession().getAttribute("member");
//		
//		// 2. BoardDTO
//		Map<String, Object> map = modelAndView.getModel();
//		BoardDTO boardDTO = (BoardDTO) map.get("dto");
//		
//		//map.keySet().iterator();
//		if(memberDTO != null && memberDTO.getId().equals(boardDTO.getWriter())) {
//			
//		}else {
//			modelAndView.addObject("result", "잘못된 접근 입니다");
//			modelAndView.addObject("url", "/");
//			modelAndView.setViewName("/common/result");
//		}
//
//	}
	
	
}
