package com.iu.s1.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//HandlerInterceptorAdapter를 상속 받아야함
@Component
public class MemberCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		// DS에서 Controller 가기 전
		// return이 true라면 다음으로 진행
		System.out.println("member check interceptor");
		Object obj = request.getSession().getAttribute("member");
	//	System.out.println("Controller 진입 전 체크");
		if(obj != null) {
			return true;
		}else {
		//	System.out.println("로그인 안한 경우");
			
//			request.setAttribute("result", "권한이 충분하지 않아요");
//			request.setAttribute("url", "../member/memberLogin");
			
//		    IRV를 들리지 않아서 경로를 모두 적어줘야함!
//			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
//			view.forward(request, response);
			
			response.sendRedirect("../../../member/memberLogin");
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
