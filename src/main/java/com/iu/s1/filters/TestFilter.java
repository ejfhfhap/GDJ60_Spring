package com.iu.s1.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class TestFilter
 */
public class TestFilter implements Filter {

    /**
     * Default constructor. 
     */
    public TestFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		// 해당 필터 객체가 소멸시 실행하는 메서드
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		
		// 필터 위치는 ds 전에 위치함!!!!
		// pass the request along the filter chain
		System.out.println("TestFilter In");
		HttpServletRequest req = (HttpServletRequest)request;
		Object obj = req.getSession().getAttribute("member");
		
		req.getRequestURI(); // ip:port제외하고 옴
		
		// 다음 필터가 있으면 가고 없으면 DS로 보냄 (들어올때)
		if(obj != null) {
			chain.doFilter(request, response);
		}else {
//			HttpServletResponse res = (HttpServletResponse)response;
//			res.sendRedirect("../member/memberLogin");
			request.setAttribute("result", "권한이 없습니다");
			request.setAttribute("url", "../member/memberLogin");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			view.forward(request, response);
		}
		
		// 응답 시 실행되는 영역 (나갈때)
		System.out.println("TestFilter Out");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// filter  객체가 생성시 실행되는 메서드
		
	}

}
