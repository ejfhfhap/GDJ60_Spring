package com.iu.s1.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.s1.member.MemberDAO;
import com.iu.s1.member.MemberDTO;

@Component
public class AdminCheckInterceptor extends HandlerInterceptorAdapter{


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		// UPDATE DELETE ADD
		MemberDTO dto = (MemberDTO) request.getSession().getAttribute("member");
		
		if(dto != null && dto.getRoleDTO().getRoleName().equals("ADMIN")) {
			return true;
		}else {
			
			request.setAttribute("result", "해킹 시도하지 마세요");
			request.setAttribute("url", "/");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			requestDispatcher.forward(request, response);
			return false;
		}
	}
	
}
