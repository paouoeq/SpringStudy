package com.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

// target인 UserService의 sayEcho() 메서드 호출시 위빙되는 aspect객체 

@Aspect
public class AfterAspect {
	
	@Pointcut("execution(public String sayEcho())")
	public void xxx() {
		
	}
	
	@After("xxx()") // advice : after - sayEcho() 호출 후에 실행
	public void method2() {
		System.out.println("BeforeAspect.method2");
	}
	
	// advice + pointcut 같이 표현
	@After("execution(* callEcho(..))") // 모든 리턴타입, 0개 이상의 파라미터 // callEcho() 호출 후에 실행
	public void method3(JoinPoint point) {
		System.out.println("호출한 핵심기능 메서드명 : "+point.getSignature());
		System.out.println("BeforeAspect.method3");
	}
}
