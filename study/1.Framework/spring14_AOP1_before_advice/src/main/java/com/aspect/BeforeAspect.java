package com.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

// target인 UserService의 sayEcho() 메서드 호출시 위빙되는 aspect객체 

@Aspect
public class BeforeAspect {
	
	@Pointcut("execution(public String sayEcho())")
	public void xxx() {
		
	}
	
	@Before("xxx()") // advice : before - sayEcho() 호출 전에 실행
	public void method2() {
		System.out.println("BeforeAspect.method2");
	}
	
	// advice + pointcut 같이 표현
	@Before("execution(* callEcho(..))") // 모든 리턴타입, 0개 이상의 파라미터
	public void method3() {
		System.out.println("BeforeAspect.method3");
	}
}
