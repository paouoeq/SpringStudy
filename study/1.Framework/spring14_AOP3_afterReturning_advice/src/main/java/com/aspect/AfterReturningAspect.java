package com.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

// target인 UserService의 sayEcho() 메서드 호출시 위빙되는 aspect객체 

@Aspect
public class AfterReturningAspect {
	
	@Pointcut("execution(public String sayEcho())")
	public void xxx() {
		
	}
	
	// sayEcho() 호출 후 정상적으로 리턴값을 리턴 했을 때 위빙		  // returning 속성에 sayEcho()메서드가 리턴하는 값이 저장될 변수를 지정한다.
	@AfterReturning(pointcut="xxx()", returning="obj")// returning 속성을 지정했기에, pointcut도 속성으로 지정해줘야 한다.
	public void method2(Object obj) { // xxx에는 sayEcho() 메서드가 리턴한 값이 저장됨
		System.out.println("AfterReturningAspect.method2>> " + obj);
	}
	
	// advice + pointcut 같이 표현
	@AfterReturning(pointcut="execution(* callEcho(..))", returning="yyy")
	public void method3(JoinPoint point, Object yyy) {
		System.out.println("호출한 핵심기능 메서드명 : "+point.getSignature());
		System.out.println("AfterReturningAspect.method3>> "+yyy);
	}
}
