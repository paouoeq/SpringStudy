package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dto.LoginDTO;

@Component("xxx")
public class MyHandlerInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception { 
		// Object handler에 Controller 정보가 저장됨
		// 기능 : request 이용해서 특별한 작업 수행 => 로그인 여부 확인 용도
		
		System.out.println("MyHandlerInterceptor.preHandle");
		
		// 로그인 체크 여부 확인
		HttpSession session = request.getSession();
		LoginDTO dto = (LoginDTO)session.getAttribute("login");
		if(dto==null) {
			response.sendRedirect("/app/loginForm"); // 절대경로 사용
			return false; // false시에 controller로 넘어가지 않음
		}
		
		return true; // return true로 줘야 Interceptor 거친 다음 controller로 넘어갈 수 있음
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		/* - Object handler에 Controller 정보가 저장됨
		   - ModelAndView modelAndView로 다양한 작업을 할 수 있음
		     ex) setViewName, addObject, ...
		     => view 정보를 변경하거나 model을 추가하는 등의 작업을 할 수 있다.
		     
		    - 기능 : response 및  ModelAndView 이용해서 특별한 작업 수행 
		    	   => ModelAndView 이용해 view 정보를 변경하거나 model을 추가 등의 작업 가능
		*/
		System.out.println("MyHandlerInterceptor.postHandle");
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		System.out.println("MyHandlerInterceptor.afterCompletion");
		
	}
	
}
