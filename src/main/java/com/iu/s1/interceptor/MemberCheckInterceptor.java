package com.iu.s1.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class MemberCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		// DS에서 Controller 가기 전
		// return이 true라면 다음으로 진행
		Object obj = request.getSession().getAttribute("member");
		System.out.println("Controller 진입 전 체크");
		if(obj != null) {
			return true;
		}else {
			response.sendRedirect("/");
			return false;
		}
	}

	/*
	 * @Override public void postHandle(HttpServletRequest request,
	 * HttpServletResponse response, Object handler, ModelAndView modelAndView)
	 * throws Exception { // TODO Auto-generated method stub // Controller 에서 DS로 가기
	 * 전
	 * 
	 * System.out.println("Controller에 리턴 후 ds 진입 전"); }
	 * 
	 * @Override public void afterCompletion(HttpServletRequest request,
	 * HttpServletResponse response, Object handler, Exception ex) throws Exception
	 * { // TODO Auto-generated method stub // Jsp 랜더링 후
	 * 
	 * System.out.println("JSP 랜더링이 종료 된 후"); }
	 */
	
}
