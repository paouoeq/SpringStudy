package com.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

// target인 UserService의 sayEcho() 메서드 호출시 위빙되는 aspect객체 

@Aspect
public class AroundAspect {
	
	@Pointcut("execution(public String sayEcho())")
	public void xxx() {
		
	}
	
	// sayEcho() 호출해서 호출전, 호출후, 정상적으로 리턴, 예외 발생시 모두 위빙된다.
	@Around(value="xxx()")
	public Object method2(ProceedingJoinPoint pjp) throws Throwable { // afterThrowing 역할
		System.out.println("@Around.method2");
		System.out.println("before advice 역할");
		Object obj = pjp.proceed(); // pjp.proceed()메서드가 sayEcho() 호출하고 리턴값은 obj에 저장
		System.out.println("after advice 역할");
		System.out.println("afterReturning advice 역할" + obj);
		return obj; // sayEcho() 호출한 곳으로 리턴. main에서 받음
	}
	
}
