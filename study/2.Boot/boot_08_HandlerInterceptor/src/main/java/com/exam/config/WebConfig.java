package com.exam.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.exam.Interceptor.MyHandlerInterceptor;

@Configuration // 설정 정보로 사용하는 빈임을 알려주는 어노테이션.
public class WebConfig implements WebMvcConfigurer {

	
	// 오른쪽클릭 -> source -> Override/~~~ -> 필요한 메서드 클릭
	
	/*
	 	<mvc:interceptors>
			<mvc:interceptor>
				<mvc:mapping path="/loginCheck/*"/>
				<ref bean="xxx"/>
			</mvc:interceptor>
	 */
	@Autowired
	MyHandlerInterceptor interceptor; // Component 사용으로 자동 주입 가능
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor).addPathPatterns("/login","/mypage"); // 인터셉터 등록 + 적용할 요청맵핑값
	}

	// <mvc:view-controller path="" view-name=""/> : Controller에서 화면만 보여주는 경우 Controller대신 다른 곳에서 구현하기
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/mypage").setViewName("main"); // mypage 요청하면 main으로 감
	}
	
}
