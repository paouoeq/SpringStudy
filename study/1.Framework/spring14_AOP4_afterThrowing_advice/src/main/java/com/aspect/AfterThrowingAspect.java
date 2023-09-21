package com.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

// target인 UserService의 sayEcho() 메서드 호출시 위빙되는 aspect객체 

@Aspect
public class AfterThrowingAspect {
	
	@Pointcut("execution(public String sayEcho())")
	public void xxx() {
		
	}
	
	// sayEcho() 호출해서 예외가 발생했을 때만 위빙된다.
	// throwing 속성은 sayEcho()메서드에서 예외 발생시 예외를 저장할 변수 지정
	// => catch(XXExecption e)의 e와 동일
	@AfterThrowing(pointcut="xxx()", throwing="e")
	public void method2(Exception e) {
		System.out.println("AfterThrowingAspect.method2>> " + e.getMessage());
	}
	
//	// advice + pointcut 같이 표현
//	@AfterThrowing(pointcut="execution(* callEcho(..))", returning="yyy")
//	public void method3(JoinPoint point, Object yyy) {
//		System.out.println("호출한 핵심기능 메서드명 : "+point.getSignature());
//		System.out.println("AfterThrowingAspect.method3>> "+yyy);
//	}
}
