package com.iu.s1.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

// 500번대 백엔드 에러의 예외를 전문적으로 처리하는 컨트롤러
// @ControllerAdvice
public class ExceptionController {
	// ---------------------------------------
	// Nullpoint 에러가 발생했을때 여기로 옴
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView fixException() {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("message", "잘못된 메세지 입니다");
		modelAndView.setViewName("/common/error_500");
		
		return modelAndView;
	}
	// 더 넓은 exception으로 받음
	@ExceptionHandler(Exception.class)
	public ModelAndView fixException2() {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("message", "잘못된 메세지 입니다");
		modelAndView.setViewName("/common/error_500");
		
		return modelAndView;
	}
}
